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
		file = resource.isFile();
		directory = resource.isDirectory();
	}

	private ServletContext application;
	private File resource;
	private String contextRealPath;
	private String displayname; //li 태그 innerText용 
	private String id;	//li 태그 id(서버사이드 경로)
	private boolean file;
	private boolean directory;
	
	
	public boolean isFile() {
		return file;
	}
	public void setFile(boolean file) {
		this.file = file;
	}
	public boolean isDirectory() {
		return directory;
	}
	public void setDirectory(boolean directory) {
		this.directory = directory;
	}
	public File getResource() {
		return resource;
	}
	public String getDisplayname() {
		return displayname;
	}
	public String getId() {
		return id;
	}
	public ServletContext getApplication() {
		return application;
	}
	public void setApplication(ServletContext application) {
		this.application = application;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
