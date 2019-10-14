package kr.or.ddit.vo;

import java.util.Base64;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of={"al_id", "lic_code"})
@ToString(exclude="lic_image")
public class LicAlbaVO {
	private String al_id;
	private String lic_code;
	private String lic_name;
	private byte[] lic_image;	
	public String getLic_imageBase64(){
		if(lic_image==null) return null;
		return Base64.getEncoder().encodeToString(lic_image);
	}
}
