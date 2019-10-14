package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * JavaBean 규약, 자바빈 규약에 따라 정의된 재사용 가능한 자바 객체.
 * 1. 값을 저장할 프로퍼티 정의
 * 2. 프로퍼티를 캡슐화
 * 3. 캡슐화된 프로퍼티에 접근할 인터페이스를 정의.
 * 		getter/setter : get[set]변수명(첫문자대문자, 카멜표기법)
 * 4. 객체의 상태를 비교할 수 있는 방법 제공. 
 * 5. 객체의 상태를 확인할 수 있는 방법 제공.
 * 6. 직렬화 가능.
 */
@Data
@EqualsAndHashCode(of="al_id")
@ToString(exclude= {"al_spec"})
public class AlbaVO implements Serializable {
	private String al_id;
	private String al_name;
	private Integer al_age;
	private String al_address;
	private String al_hp;
	private String al_spec;
	private String al_desc;
	private String gr_code;
	private String al_career;
	private String al_gen;
	private String al_btype;
	private String al_mail;
	
	// 요청 파라미터 바인드용
	private String[] lic_codes;
	
	// 데이터베이스 조회용
	private String gr_name;
	private List<LicAlbaVO> licenseList;
	
	private String[] deleteLic_codes;
	
}
