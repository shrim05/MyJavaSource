package kr.or.ddit.vo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import kr.or.ddit.wrapper.PartWrapper;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class Attatch2VO implements Serializable{
	
	
	public Attatch2VO(PartWrapper partWrapper) {
		this.partWrapper = partWrapper;
		att_filename = partWrapper.getFileName();
		att_mime = partWrapper.getContentType();
		att_fileszie = partWrapper.getSize();
		att_fancysize = FileUtils.byteCountToDisplaySize(att_fileszie);
		att_savename = UUID.randomUUID().toString();
		
	}
	
	private Integer att_no;
	private Integer bo_no;
	private String att_filename;
	private String att_savename;
	private String att_mime;
	private Long att_fileszie;
	private String att_fancysize;
	private Integer att_downcount;
	
	private PartWrapper partWrapper;
	
	public void saveFile(File saveFolder) throws IOException {
		try(
				InputStream is = 	partWrapper.getInputStream();
		) {
			FileUtils.copyInputStreamToFile(is, new File(saveFolder,att_savename));
		}
	
	}
	
	
}
