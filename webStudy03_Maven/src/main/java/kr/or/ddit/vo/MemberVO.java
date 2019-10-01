package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 마이페이지 조회 시 , 그동안 구매한 상품 기록을 함께 조회
 *
 */
@Data
public class MemberVO implements Serializable {
	
	
	
	public MemberVO() {
		super();
	}
	public MemberVO(String mem_id, String mem_pass) {
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
	}

	private String mem_id;
	private String mem_pass;
	private String mem_name;
	
	private transient String mem_regno1;  //직렬화 제외
	private transient String mem_regno2;  //직렬화 제외 (transient)
	private String mem_bir;
	private String mem_zip;
	private String mem_add1;
	private String mem_add2;
	private String mem_hometel;
	private String mem_comtel;
	private String mem_hp;
	private String mem_mail;
	private String mem_job;
	private String mem_like;
	private String mem_memorial;
	private String mem_memorialday;
	private Integer mem_mileage;
	private String mem_delete;
	private List<ProdVO> prodList;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mem_id == null) ? 0 : mem_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (mem_id == null) {
			if (other.mem_id != null)
				return false;
		} else if (!mem_id.equals(other.mem_id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass + ", mem_name=" + mem_name + ", mem_add1="
				+ mem_add1 + ", mem_add2=" + mem_add2 + "]";
	}
	
	
}
