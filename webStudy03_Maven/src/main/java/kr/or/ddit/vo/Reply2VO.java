package kr.or.ddit.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Reply2VO implements Serializable{
	private Integer rep_no;
	private Integer bo_no;
	private String rep_content;
	private String rep_writer;
	private String rep_date;
	private String rep_ip;
	private String rep_pass;
	
	public Reply2VO(Integer bo_no) {
		super();
		this.bo_no = bo_no;
	}
}
