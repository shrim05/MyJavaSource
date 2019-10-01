package kr.or.ddit.vo;

import java.io.Serializable;

/**
 * java bean 규약
 * vo(Value Object) /dto (data Transfer object) / javaBean/ model
 * 1. 값을 담을 property 정의
 * 2. 정해진 규칙에 따라 사용할 수 있도록 property 캡슐화
 * 3. 캡슐화된 프로퍼티에 접근할 수 있는 인터페이스 정의 (getter/setter)
 * 		get[set]프로퍼티명(initcal capitalize) 
 * 4. 객체의 상태를 비교할 수 있는 방법 제공 (equals 재정의) ex)pk가 동일하다면 그 내용을 비교해서 동일 여부를 확인 할 수 있는 방법이 필요함.
 * 5. 객체의 상태를 확인할 수 있는 방법 제공 (toString 재정의)
 * 6. 객체의 상태를 직렬화 할 수 있도록
 * 직렬화/역직렬화:
 * 직렬화 : 객체를 전송이나 저장을 목적으로 바이트집합의 형태로 변환하는 작업
 * 역직렬화 : (바이트 집합의 형태로) 저장되어있거나 전송된 데이터를 다시 원래의 상태로 복원하는 작업 
 */
public class DataBasePropertyVO implements Serializable{
	
	private String property_name;     
	private String property_value;  
	private String description;
	
	public String getProperty_name() {
		return property_name;
	}
	public void setProperty_name(String property_name) {
		this.property_name = property_name;
	}
	public String getProperty_value() {
		return property_value;
	}
	public void setProperty_value(String property_value) {
		this.property_value = property_value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((property_name == null) ? 0 : property_name.hashCode());
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
		DataBasePropertyVO other = (DataBasePropertyVO) obj;
		if (property_name == null) {
			if (other.property_name != null)
				return false;
		} else if (!property_name.equals(other.property_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DataBasePropertyVO [property_name=" + property_name + ", property_value=" + property_value
				+ ", description=" + description + "]";
	}
	
	
	
}
