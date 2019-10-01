package kr.or.ddit.mvc.annotation;

/**
 * @URIMapping 에 설정된 정보를 가진 객체
 * 
 */
public class URIMappingCondition {
	private String uri;
	private HttpMethod method;
	
	
	public URIMappingCondition(String uri, HttpMethod method) {
		super();
		this.uri = uri;
		this.method = method;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		URIMappingCondition other = (URIMappingCondition) obj;
		if (method != other.method)
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}


	public String getUri() {
		return uri;
	}


	public HttpMethod getMethod() {
		return method;
	}


	@Override
	public String toString() {
		return "URIMappingCondition [uri=" + uri + ", method=" + method + "]";
	}
	
	
}
