package kr.or.ddit.wrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

public class PartWrapper {
	private Part origin;

	public PartWrapper(Part origin) {
		super();
		this.origin = origin;
	}
	
	public String getHeader(String name) {
		return origin.getHeader(name);
	}
	
	public String getContentType() {
		return origin.getContentType();
	}
	public InputStream getInputStream() throws IOException {
		return origin.getInputStream();
	}
	
	public long getSize() {
		return origin.getSize();
	}
	
	public byte[] getBytes() throws IOException{
		 try(
    	  InputStream is = getInputStream();
		  ByteArrayOutputStream bos= new ByteArrayOutputStream();
    	  ){
    		  IOUtils.copy(is, bos);
    		  return bos.toByteArray();
    	  }
	}
	public String getFileName(){
		String header = origin.getHeader("Content-Disposition");
		int firstIdx = header.indexOf("filename");
		int secondIdx = header.indexOf("=",firstIdx);
		String originalFilename = header.substring(secondIdx+1).replace('"', ' ').trim();
		return originalFilename;
	}
	
	public void delete() throws IOException {
		origin.delete();
	}
}
