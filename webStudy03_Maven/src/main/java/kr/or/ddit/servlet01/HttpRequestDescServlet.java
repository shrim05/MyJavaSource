package kr.or.ddit.servlet01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * HTTP request 패키징 방식
 * 	1. Request Line : URL Method Protocol/ver
 * 		<사용 메소드: getRequestURI or URL , getMethod, getProtocol>
 * 	     ** Method : 현재 요청의 목적, 요청 패키징 방식
 * 		1)GET(Read) 	: 일반적으로 클라이언트의 요청은 기본 Get방식
 * 		2)POST(Create) 	: 서버상에 새로운 리소스 생성
 * 		 				** Request Body 영역 생성
 * 		3)PUT(Update) 	: 서버상의 데이터를 갱신
 * 		4)DELETE(delete):서버상의 리소스 삭제
 *   	그외) Header, Option(사용가능 메소드확인), Trace(디버깅), Connect(연결), Patch(put과 유사)
 * 	2. Request Header : 전송 데이터(와 클라이언트)에 대한 부가정보(meta data)
 * 					 : 일반적으로 요청의 모든 정보는 문자열의 형태로 전달됨
 * 					** 문자열 데이터에 특수문자가 포함된 경우 : RFC2396 규약에 따라 % 인코딩(URL인코딩) 방식으로 인코딩되어 전달됨.
 *  
 * 	<사용메소드: String value = getHeader(headerName),  Enumeration(:collection view) getHeaderNames>  
 * 	3. Requset(Message/Content) Body : method 가 post 인 경우 사용. 
 * 									: 서버로 전송할 컨텐츠가 포함됨.
 * 	**요청 파라미터를 확보하는 방법
 * 	method GET : Request Line을 통해 리소스 전달됨 (쿼리스트링)
 * 	형식) URL?  section1   &  section2	&	section3 ...
 * 			(name=value)   (name=value)		(name=value)
 * 	ex) gugudan?minDan=2&maxDan=4
 * 
 * 	method POST : Request Body 를 통해 전달됨
 * 	
 * 	parameterMap을 통해 모든 요청 파라미터를 확보함
 * 	<사용메소드:
 * 	String getParameter(name), String[] getParameterValues(name)
 * 	Map<String, String[]> getParameterMap(), getParameterNames()
 * 	>
 * 
 * 	**특수문자가 포함된 파라미터 처리방법 (%인코딩되어있는 파라미터) 
 * 		1. POST : setCharacterEncoding - body영역의 decoding 방식
 *  	2. GET	: (body가 없고, 라인에 모든 데이터가 들어감 -> 라인에 접근하는 개체는 서버 -> 서버설정 필요)
 *  			server.xml(톰캣의 경우)에 http connector 의 설정변경
 *  			1)URIEncoding (인코딩방식을 하드코딩으로 고정하므로 유연성이 떨어짐)
 *  			2)useBodyEncodingForURI (setCharacterEncoding을 get에서도 사용 가능하게 함)
 * 
 * 	*** HttpServletRequest : http 프로토콜에 따라 패키징된 요청에 대한 정보를 캡슐화한 객체(middleware==tomcat에 의해 수행됨).
 * 							클라이언트와 요청에 대한 모든 정보가 포함됨
 * 
 * 
 */
@WebServlet("/httpRequest")
public class HttpRequestDescServlet extends HttpServlet{
	
	@Override
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//request line
		String requestURI = req.getRequestURI();
		String requestMethod = req.getMethod();
		String requestProtocol = req.getProtocol();
		System.out.println(requestURI);
		System.out.println(requestMethod);
		System.out.println(requestProtocol);
		
		//request header
		Enumeration<String> en = req.getHeaderNames();
		while (en.hasMoreElements()) {
			String headerName = (String) en.nextElement();
			String headerValue = req.getHeader(headerName);
			System.out.printf("%s : %s \n", headerName, headerValue);
		}
		//request body : POST
		//body는 메서드가 POST 일때만 생성
		InputStream is = req.getInputStream();
		//요청 파라미터를 확보하는 방법
		//get : line을 통해 전달
		//post : body를 통해 전달
		//파라미터명 == 입력 태그의 name 속성
		//파라미터는 특별한 설정이 없는 한 문자열로 전송됨
		String value = req.getParameter("");
		//하나의 파라미터명으로 여러개의 값이 전송될 때 사용
		String[] values = req.getParameterValues("");
		//key : 파라미터명, value: 파리미터 값
		Map<String, String[]> pMap = req.getParameterMap();
		//파라미터 값을 몰라도 메서드를 통해 키값을 가져올 수 있음
		Enumeration<String> names = req.getParameterNames();
		
	}
	
}
