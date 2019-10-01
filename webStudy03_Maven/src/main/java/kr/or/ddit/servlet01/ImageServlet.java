package kr.or.ddit.servlet01;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.utils.CookieUtil;
import kr.or.ddit.utils.CookieUtil.TextType;



public class ImageServlet extends HttpServlet{
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
//		folder = config.getInitParameter("imgFolderPath");
		folder = getServletContext().getInitParameter("fileAddr");
	
	}
	
	String folder;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//MIME text : main_type/sub_type: charset=encoding
		//MIME : 전송 데이터의 형태나 특성을 표현하는 문자
		//Multipurpose Internet Mail Extension 
		resp.setContentType("image/jpeg");
		String imageName = req.getParameter("image");
		
		int status = 200;
		if(imageName==null || imageName.trim().length()==0) {
			status = HttpServletResponse.SC_BAD_REQUEST;
			return;
		}
		File imgFile = new File(folder, imageName);
		if(!imgFile.exists()) {
			status = HttpServletResponse.SC_NOT_FOUND;
		}
		if(status==200) {
			Cookie imageCookie = CookieUtil.createCookie("imageCookie", imageName, req.getContextPath(), TextType.PATH ,60*60*24*7);
			resp.addCookie(imageCookie);
			
			byte[] buffer = new byte[1024];
			try(
			FileInputStream fis = new FileInputStream(imgFile);
			OutputStream os = resp.getOutputStream();
			) {
				int cnt = -1;
				//	Stream copy
				while((cnt = fis.read(buffer))!=-1){
					os.write(buffer, 0, cnt);
				}//while end
			}//try end
		}else {
			resp.sendError(status);
		}
		
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
	{
		doPost(req,resp);
	}
}