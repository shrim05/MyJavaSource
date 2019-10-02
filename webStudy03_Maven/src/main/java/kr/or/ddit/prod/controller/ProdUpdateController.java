package kr.or.ddit.prod.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.HttpMethod;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;

@CommandHandler
public class ProdUpdateController {
	IProdService service = new ProdServiceImpl();
	@URIMapping("/prod/prodUpdate.do")
	public String updateForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String prod_id = req.getParameter("prod_id");
		if(StringUtils.isBlank(prod_id)) {
			resp.sendError(400);
			return null;
		}
		ProdVO pv = service.retrieveProd(prod_id);
		req.setAttribute("prod", pv);
		return "prod/prodForm";
	}
	@URIMapping(value="/prod/prodUpdate.do", method=HttpMethod.POST)
	public String update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		ProdVO pv = new ProdVO();
		req.setAttribute("prod", pv);
		Map queryString = req.getParameterMap();
		String viewName = "prod/prodForm";
		String message = null;
		try {
			BeanUtils.populate(pv, queryString);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		Part part = req.getPart("prod_image");
		long size = part.getSize();
		if(size>0) {
			//1.저장위치
			String saveFolderUrl = "/prodImages";
			String saveFolderPath = req.getServletContext().getRealPath(saveFolderUrl);
			File saveFolder = new File(saveFolderPath);
			if(!saveFolder.exists()) saveFolder.mkdirs();
//				2.저장명
			String savename = UUID.randomUUID().toString();
			try(
					InputStream is = part.getInputStream();
					){
				FileUtils.copyInputStreamToFile(is, new File(saveFolder,savename));
			}
			pv.setProd_img(savename);
		}
		Map<String, String> errors = new HashMap<String, String>();
		req.setAttribute("errors", errors);
		Boolean valid = validate(pv,errors);
		if(valid) {
			ServiceResult result = service.modifyProd(pv);
			switch(result) {
			case OK:
				message="수정성공";
				viewName="redirect:/prod/prodView.do?prod_id="+pv.getProd_id();
				break;
			case FAILED:
				message="서버오류";
				viewName="prod/prodForm";
				break;
			}
		}else {
			viewName = "prod/prodForm";
		}
		req.setAttribute("message", message);
		return viewName;
	}
	
	public static boolean validate(ProdVO prod, Map<String, String> errors) {
		boolean valid = true;
	    if (StringUtils.isBlank(prod.getProd_id())) {
	         valid = false;
	         errors.put("prod_id", "상품코드 누락");
	      }
	      if (StringUtils.isBlank(prod.getProd_name())) {
	         valid = false;
	         errors.put("prod_name", "상품명 누락");
	      }
	      if (StringUtils.isBlank(prod.getProd_lgu())) {
	         valid = false;
	         errors.put("prod_lgu", "분류코드 누락");
	      }
	      if (StringUtils.isBlank(prod.getProd_buyer())) {
	         valid = false;
	         errors.put("prod_buyer", "거래처코드 누락");
	      }
	      if (prod.getProd_cost()<=0) {
	         valid = false;
	         errors.put("prod_cost", "구매가 누락");
	      }
	      if (prod.getProd_price()<=0) {
	         valid = false;
	         errors.put("prod_price", "판매가 누락");
	      }
	      if (prod.getProd_sale()<=0) {
	         valid = false;
	         errors.put("prod_sale", "세일가 누락");
	      }
	      if (StringUtils.isBlank(prod.getProd_outline())) {
	         valid = false;
	         errors.put("prod_outline", "OUTLINE 누락");
	      }
//	      if (StringUtils.isBlank(prod.getProd_img())) {
//	         valid = false;
//	         errors.put("prod_img", "이미지경로? 누락");
//	      }
	      if (prod.getProd_totalstock()<=0) {
	         valid = false;
	         errors.put("prod_totalstock", "상품재고 누락");
	      }
	      if (prod.getProd_properstock()<=0) {
	         valid = false;
	         errors.put("prod_properstock", "적정재고 누락");
	      }

	      return valid;
	}
	
}
