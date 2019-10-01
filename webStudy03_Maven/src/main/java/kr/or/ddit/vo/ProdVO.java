package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 상품 한건에 대해 해당 거래처에 대한 상세정보까지 조회
 * Data mapper를 이용해서 여러개의 테이블로부터 데이터를 조회하는 방법
 * 1.메인테이블 선정. 테이블간의 관계성 파악
 *  1:1 , 1:N
 * 2.모델링. 테이블간의 관계성을 Domain Layer에 반영
 *  1:1 -> Has a
 *  1:N -> Has many
 * 3.직접 조인 쿼리 작성 -> resultType 대신 resultMap으로 수동 바인드
 * 	has a -> association
 * 	has many -> collection	
 *
 */
@Getter
@Setter
@EqualsAndHashCode(of= {"prod_id","prod_name"})
@ToString
public class ProdVO implements Serializable{
	private String prod_id;
	private String prod_name;
	private String prod_lgu;
	private String lprod_nm;
	private String prod_buyer;
	private Integer prod_cost;
	private Integer prod_price;
	private Integer prod_sale;
	private String prod_outline;
	private String prod_detail;
	private String prod_img;
	private String buyer_name;
	private Integer prod_totalstock;
	private String prod_insdate;
	private Integer prod_properstock;
	private String prod_size;
	private String prod_color;
	private String prod_delivery;
	private String prod_unit;
	private Integer prod_qtyin;
	private Integer prod_qtysale;
	private Integer prod_mileage;
	private BuyerVO buyer; //ProdVO has a BuyerVO (1:1) 
	private List<MemberVO> memberList; // ProdVO has many MemberVO (1:N)
}
