package kr.or.ddit.servlet02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.servlet02.service.ImageListService;

@WebServlet("/imageForm.do")
public class ImageFormServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Model2 구조
//		1.요청 받기
//		2.요청 분석 (request - line, header, body)
//		3.요청 정보 생성 --> layerd architecture 적용 (책임의 분리를 위해)
//		//3. (model 구성 책임 분리 후 ) service객체와의 의존관계 형성 -> 로직 선택
		ImageListService service = new ImageListService();
		String[] images = service.getImageList();
//			1) raw data 확보
//			2) data 가공해서 information 으로 생성(logic)
//		4.Scope를 통해 information 공유
		request.setAttribute("images", images);
//		5.정보 전달할 view 선택
//		6.view 이동 
		String viewName = "/WEB-INF/views/imageForm.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(viewName);
		rd.forward(request, response);
	}
}
