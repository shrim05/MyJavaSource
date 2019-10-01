package kr.or.ddit.homework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IImageService {
	public void copy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public void move(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
