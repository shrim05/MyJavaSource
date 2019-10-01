package kr.or.ddit.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *	쿠키생성과 쿠키확보를 지원하는 유틸리티 
 *
 */
public class CookieUtil {
	private Map<String, Cookie> cookieMap;

	private HttpServletRequest req;
	//DI패턴(dependency Injection) : setter, constructor(필수요소일때)
	public CookieUtil(HttpServletRequest req) {
		super();
		this.req = req;
		cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = req.getCookies();
		if(cookies!=null) {
			for(Cookie tmp : cookies) {
				cookieMap.put(tmp.getName(), tmp);
			}
		}//if end
	}
	
	public Map<String, Cookie> getCookieMap() {
		return cookieMap;
	}
	
	public Cookie getCookie(String name) {
		return cookieMap.get(name); 
	}
	
	public String getCookieValue(String name) throws UnsupportedEncodingException {
		Cookie cookie = getCookie(name);
		//커스텀exception 사용가능
		if(cookie==null) return null;
		String value = cookie.getValue();
		return URLDecoder.decode(value, charset);
	}
	
	private static String charset= "UTF-8";
	public static void setCharset(String charset) {
		CookieUtil.charset=charset;
	}
	

	/**
	 * 쿠키 생성
	 * @param name
	 * @param value 쿠키값, encoding UTF-8
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static Cookie createCookie(String name, String value) throws UnsupportedEncodingException {
		value = URLEncoder.encode(value,charset);
		Cookie cookie = new Cookie(name,value);
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, int maxAge) throws UnsupportedEncodingException{
		Cookie cookie = createCookie(name, value);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	
	public static enum TextType{
		PATH, DOMAIN
	}
	
	public static Cookie createCookie(String name, String value, String text, TextType pathOrDomain) throws UnsupportedEncodingException{
		Cookie cookie = createCookie(name, value);
		if(TextType.PATH.equals(pathOrDomain)) {
			cookie.setPath(text);
		}else if(TextType.DOMAIN.equals(pathOrDomain)){
			cookie.setDomain(text);
		}
		return cookie;
	}

	public static Cookie createCookie(String name, String value, String text, TextType pathOrDomain, int maxAge) throws UnsupportedEncodingException{
		Cookie cookie = createCookie(name, value,text,pathOrDomain);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, String path, String domain) throws UnsupportedEncodingException{
		Cookie cookie = createCookie(name, value);
		cookie.setPath(path);
		cookie.setDomain(domain);
		return cookie;
	}
	
	public static Cookie createCookie(String name, String value, String path, String domain, int maxAge) throws UnsupportedEncodingException{
		Cookie cookie = createCookie(name, value,path,domain);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	
}
