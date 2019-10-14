package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.HttpMethod;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.Attatch2VO;
import kr.or.ddit.wrapper.MultipartRequestWrapper;
import kr.or.ddit.wrapper.PartWrapper;

@CommandHandler
public class AttatchAndImageController {
	IBoardService service = new BoardServiceImpl();
	File savedFolder = new File("d:/saveFiles");
	
	@URIMapping("/board/download.do")
	public String download(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String what = req.getParameter("what");
		if(StringUtils.isBlank(what)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		Attatch2VO attr = service.downloadAttatch(Integer.parseInt(what));
		if(attr!=null) {
			File downloadFile = new File(savedFolder,attr.getAtt_savename());
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Length",attr.getAtt_fileszie()+"");
			String filename = attr.getAtt_filename();
			//os, browser에 따라 인코딩방식이다름
//			filename = URLEncoder.encode(filename, "UTF-8");
			//호환성상관없이 범용적으로 사용하는 방법1.(바이트로 쪼갠 후 전송)
			filename = new String(filename.getBytes(),"ISO-8859-1");
			//inline(바로실행), attatchment (다운로드)
			resp.setHeader("Content-Disposition", "attatchment;filename=\""+filename+"\"");
			try(
					OutputStream os = resp.getOutputStream();
			){
				FileUtils.copyFile(downloadFile, os);
			}
		}
		return null;
	}
	
	@URIMapping(value="/board/imageUpload.do", method=HttpMethod.POST)
	public String upload(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(req instanceof MultipartRequestWrapper) {
			PartWrapper uploadFile = ((MultipartRequestWrapper) req).getPartWrapper("upload");
			String saveFolderURL = "/boardImages";
			String saveFolderPath = req.getServletContext().getRealPath(saveFolderURL);
			File saveFolder = new File(saveFolderPath);
			if(saveFolder.exists()) saveFolder.mkdirs();
			String savename = UUID.randomUUID().toString();
			try(
					InputStream is = uploadFile.getInputStream();
			){
				FileUtils.copyInputStreamToFile(is, new File(saveFolder, savename));
			}
			String saveURL = req.getContextPath()+saveFolderURL+"/"+savename;
			Map<String, Object> messageMap = new HashMap<String, Object>();
			messageMap.put("fileName", uploadFile.getFileName());
			messageMap.put("uploaded", 1);
			messageMap.put("url", saveURL );
			resp.setContentType("application/json;charset=UTF-8"); 
			ObjectMapper mapper = new ObjectMapper();
			try(
					PrintWriter out = resp.getWriter();
			){
				mapper.writeValue(out, messageMap);
			}
		}
		return null;
	}
}
