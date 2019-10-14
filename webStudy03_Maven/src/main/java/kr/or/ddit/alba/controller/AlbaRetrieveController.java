package kr.or.ddit.alba.controller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.alba.service.AlbaServiceImpl;
import kr.or.ddit.alba.service.IAlbaService;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicAlbaVO;
import kr.or.ddit.vo.PagingInfoVO;

@CommandHandler
public class AlbaRetrieveController{
	IAlbaService service = new AlbaServiceImpl();
	
	@URIMapping("/alba/licenseImage.do")
	public String licenseImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String al_id = req.getParameter("al_id");
		String lic_code = req.getParameter("lic_code");
		if(StringUtils.isBlank(al_id)||StringUtils.isBlank(lic_code)){
			resp.sendError(400);
			return null;
		}
		LicAlbaVO licAlba = new LicAlbaVO();
		licAlba.setAl_id(al_id);
		licAlba.setLic_code(lic_code);
		LicAlbaVO license = service.retrieveLicense(licAlba);
		resp.setContentType("application/octet-stream");
		byte[] imageData = license.getLic_image();
		if(imageData==null){
			try(
				FileInputStream fis = new FileInputStream(req.getServletContext().getRealPath("/images/noImage.png"));
			){		
				int size = fis.available();
				imageData = new byte[size];
				IOUtils.read(fis, imageData);
			}
		}
		try(
			OutputStream os = resp.getOutputStream();
			ByteArrayInputStream is = new ByteArrayInputStream(imageData);
		){
			IOUtils.copy(is, os);
		}
		return null;
	}
	
	@URIMapping("/alba/albaList.do")
	public String list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageParam = req.getParameter("page");
		String searchType = req.getParameter("searchType");
		String searchWord = req.getParameter("searchWord");
		int currentPage = 1;
		if(StringUtils.isNotBlank(pageParam) && StringUtils.isNumeric(pageParam)) {
			currentPage = Integer.parseInt(pageParam);
		}
		
		PagingInfoVO<AlbaVO> pagingVO = new PagingInfoVO<AlbaVO>(7, 3);
		Map<String, Object> searchMap = new HashMap<>();
		searchMap.put("searchType", searchType);
		searchMap.put("searchWord", searchWord);
		pagingVO.setSearchMap(searchMap);
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = service.retrieveAlbaCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		
		List<AlbaVO> albaList = service.retrieveAlbaList(pagingVO);
		pagingVO.setDataList(albaList);
		
		req.setAttribute("pagingVO", pagingVO);
		
		String view = "alba/albaList";
		return view;
	}
	
	@URIMapping("/alba/albaView.do")
	public String view(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String who = req.getParameter("who");
		int sc = 0;
		if(StringUtils.isBlank(who)) {
			sc = HttpServletResponse.SC_BAD_REQUEST;
		}else {
			AlbaVO alba = service.retrieveAlba(who);
			req.setAttribute("alba", alba);
			if(alba==null) {
				sc = HttpServletResponse.SC_NOT_FOUND;
			}
		}
		String view = null;
		if(sc!=0) {
			resp.sendError(sc);
		}else {
			view = "alba/albaView";
		}
		return view;
	}
}
