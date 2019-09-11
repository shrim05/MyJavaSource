package kr.or.ddit.servlet03;

import java.io.File;

import javax.servlet.ServletContext;
/**
 * (Object)Adapter /Wrapper pattern
 * 그 외 class adapter 패턴있음
 *
 */
public class FileWrapper {
	
	public FileWrapper(File resource, ServletContext application) {
		this(resource, application, false);
	}
	public FileWrapper(File resource, ServletContext application, boolean wildcard) {
		super();
		this.resource = resource;
		this.application = application;
		contextRealPath =  application.getRealPath("");
		displayname = resource.getName();
		if(wildcard) displayname = "..";
		String absolutePath = resource.getAbsolutePath();
		id = absolutePath.substring(contextRealPath.length()-1);
		id = id.replace(File.separatorChar,'/');
	}

	private ServletContext application;
	private File resource;
	private String contextRealPath;
	private String displayname; //li 태그 innerText용 
	private String id;	//li 태그 id(서버사이드 경로)
	
	public File getResource() {
		return resource;
	}
	public String getDisplayname() {
		return displayname;
	}
	public String getId() {
		return id;
	}
	
	
}
