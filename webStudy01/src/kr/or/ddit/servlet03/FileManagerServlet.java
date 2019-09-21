package kr.or.ddit.servlet03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.commons.lang3.StringUtils;

import com.sun.javafx.binding.StringFormatter;

import kr.or.ddit.enums.CommandType;
import kr.or.ddit.utils.MarshallingUtils;

@WebServlet("/serverFileManager")
public class FileManagerServlet extends HttpServlet{
	private ServletContext application;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		application = getServletContext();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String leftSrc = req.getParameter("leftSrc");
		String rightTarget = req.getParameter("rightTarget");
		if(leftSrc==null) {
			leftSrc="";
		}
		if(rightTarget==null) {
			rightTarget="";
		}
		String realPathLeft = application.getRealPath(leftSrc);
		String realPathRight = application.getRealPath(rightTarget);
		File folderLeft = new File(realPathLeft);
		File folderRight = new File(realPathRight);
		int status = 200;
		String message = null;
		Map<String, FileWrapper[]> jsonMap = new HashMap<>();
		try {
			List<FileWrapper> leftFiles = traversing(folderLeft);
			List<FileWrapper> rightFiles = traversing(folderRight);
			FileWrapper[] leftArray = new FileWrapper[leftFiles.size()];
			FileWrapper[] rightArray = new FileWrapper[rightFiles.size()];
			jsonMap.put("leftFiles",leftFiles.toArray(leftArray));
			jsonMap.put("rightFiles",rightFiles.toArray(rightArray));
			req.setAttribute("leftFiles", leftFiles);
			req.setAttribute("rightFiles", rightFiles);
		}catch(FileNotFoundException | IllegalArgumentException  e) { //멀티캐치 구문
			if(e instanceof FileNotFoundException) {
				status = HttpServletResponse.SC_NOT_FOUND;
			}else {
				status = HttpServletResponse.SC_BAD_REQUEST;
			}
			message = e.getMessage();
		}
		if(status==200) {
			String accept = req.getHeader("Accept");
			if(accept.contains("json")) {
				resp.setContentType("application/json");
				String json = new MarshallingUtils().marshalling(jsonMap);
				try(
					PrintWriter out = resp.getWriter();
				){
					out.print(json);
				}
			}else {
				req.setCharacterEncoding("UTF-8");
				String viewName = "/WEB-INF/views/serverFileManager.jsp";
				req.getRequestDispatcher(viewName).include(req,resp);
			}
		}else {
			resp.sendError(status, message);
		}
	}
	
	private List<FileWrapper> traversing(File folder) throws FileNotFoundException, MalformedURLException {
		if(!folder.exists()) {
			throw new FileNotFoundException(folder.getName()+"폴더가 존재하지 않습니다");
		}
		if(folder.isFile()) {
			throw new IllegalArgumentException(folder.getName() + "는 디렉토리가 아님");
		}
		File[] files = folder.listFiles();
		List<FileWrapper> result = new ArrayList<FileWrapper>();
		URL root = application.getResource("");
		URL current = folder.toURL();
		if(!root.equals(current)) {
			File parent = folder.getParentFile();
			result.add(new FileWrapper(parent, application,true));
		}
		for(File file: files) {
			result.add(new FileWrapper(file, application));
		}
		return result;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String srcFile = req.getParameter("srcFile");
		String command = req.getParameter("command");
		String leftSrc = req.getParameter("leftSrc");
		String rightTarget =  req.getParameter("rightTarget");
		int status =200;
		if(StringUtils.isBlank(srcFile) || StringUtils.isBlank(command)
				||StringUtils.isBlank(leftSrc)||StringUtils.isBlank(rightTarget)) {
			status = HttpServletResponse.SC_BAD_REQUEST;
			resp.sendError(status);
		}else {
			File srcFile2 = new File(application.getRealPath(srcFile));
			if(!srcFile2.exists()) {
				status = HttpServletResponse.SC_NOT_FOUND;
				resp.sendError(status);
			}else {
				try {
					CommandType commandType = CommandType.valueOf(command);
					if(status==200) {
						File targetFile = new File(application.getRealPath(rightTarget));
						commandType.commandProcess(srcFile2, targetFile);
					}
				}catch(IllegalArgumentException e) {
					status = HttpServletResponse.SC_BAD_REQUEST;
					resp.sendError(status);
				}
			}
			if(status==200) {
//				doGet(req,resp);
//				String viewName = req.getContextPath()+"/serverFileManager?leftSrc="+leftSrc+"&rightTarget="+rightTarget;
//				String viewName = String.format( req.getContextPath()+"/serverFileManager?leftSrc=%s&rightTarget=%s", leftSrc,rightTarget);
//				req.getRequestDispatcher(viewName).include(req,resp);
				doGet(req, resp);
			}else {
				resp.sendError(status);
			}
		}
	}
	
}
