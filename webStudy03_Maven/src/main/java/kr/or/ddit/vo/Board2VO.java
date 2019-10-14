package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.wrapper.PartWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(of="bo_no")
@NoArgsConstructor
@Data
public class Board2VO implements Serializable{
	private Integer rnum;
	private Integer level; //계층 구조상에서 글의 깊이 1:원글, >1 : 답글
	private Integer bo_no;
	private String board_type;
	private String board_name;
	private String bo_title;
	private String bo_writer;
	private String bo_date;
	private String bo_content;
	private String bo_pass;
	private String bo_ip;
	private Integer bo_hit;
	private Integer bo_like;
	private Integer bo_parent;
	
	private List<Reply2VO> replyList;
	private List<Attatch2VO> attatchList;
	private PartWrapper[] bo_file;
	private Integer[] delAttatches;
	
	public void setBo_file(PartWrapper[] bo_file) {
		this.bo_file = bo_file;
		if(bo_file==null || bo_file.length==0) return;
		attatchList = new ArrayList<>();
		for(PartWrapper tmp : bo_file) {
			attatchList.add(new Attatch2VO(tmp));
		}
	}
	
	
	public Board2VO(Integer bo_no) {
		super();
		this.bo_no = bo_no;
	}
	
	public Board2VO(Integer bo_no, String bo_pass) {
		super();
		this.bo_no = bo_no;
		this.bo_pass = bo_pass;
	}

	private Integer attNoStart;
}
