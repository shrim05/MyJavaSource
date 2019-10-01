package kr.or.ddit.enums;

public enum OsType {
	LINUX("리눅스"), WINDOWS("윈도우"), OTHER("기타OS");
	
	OsType(String name){
		this.name = name;
	}
	private String name;
	public String getName() {
		return name;
	}
	public static OsType searchOS(String userAgent) {
		OsType result = OTHER;
		for(OsType temp : values()) {
			if(userAgent.toUpperCase().contains(temp.name())) {
				result = temp;
				break;
			}
		}
		return result;
		
	}
}
