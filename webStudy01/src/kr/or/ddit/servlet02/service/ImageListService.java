package kr.or.ddit.servlet02.service;

import java.io.File;

public class ImageListService {
//	ServletContext temp =  getServletContext();
//	File imgFolder = new File(temp.getInitParameter("fileAddr"));
	File imgFolder = new File("d:/contents");
	String[] images = imgFolder.list((dir, name)->{return name.endsWith(".jpg")||name.endsWith(".gif");
	});
	public String[] getImageList() {
		return images;
	}
}
