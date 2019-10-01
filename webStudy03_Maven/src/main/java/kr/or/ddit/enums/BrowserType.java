package kr.or.ddit.enums;

public enum BrowserType {
	CHROME("크롬"), FIREFOX("파이어폭스"), MSIE("익스플로러"), OTHER("기타브라우저");
	
	private String name;
	
	BrowserType(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static BrowserType searchBrowser(String userAgent) {
		BrowserType result = OTHER;
		for(BrowserType temp : values())
			if(userAgent.toUpperCase().contains(temp.name())) {
				result = temp;
			}
		return result;
	}
}
