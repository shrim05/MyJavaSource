package kr.or.ddit.servlet02.service;

import java.net.URL;

public class ImageFolderService {
	public static void main(String[] args) {
//		String[] files = class.getResource("/images");
		temp temp = new temp(); 
		URL url = temp.getFiles();
		System.out.println(url);
	}
	
}

class temp{
public URL getFiles() {
	URL files = getClass().getResource("/images");
	return files;
}
}