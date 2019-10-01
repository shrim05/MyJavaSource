package kr.or.ddit.enums;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public enum CommandType {
	COPY((src, targetFolder)->{
		File target = new File(targetFolder, src.getName());
		if(src.equals(target)) {
			return;
		}
		FileUtils.copyFile(src, target);
	}), 
	MOVE((src, targetFolder)->{
		File target = new File(targetFolder, src.getName());
		if(target.exists()) {
			return;
		}
		FileUtils.moveFile(src, target);
	}), 
	DELETE((src, targetFolder)->{
		FileUtils.forceDelete(src);
	});
	@FunctionalInterface
	public static interface CommandProcessor{
		public void process(File src, File targetFolder) throws IOException;
	}
	private CommandProcessor processor;
	
	private CommandType(CommandProcessor processor) {
		this.processor = processor;
	}
	
	public void commandProcess(File src, File targetFolder) throws IOException{
		processor.process(src, targetFolder);
		
	}
	
}
