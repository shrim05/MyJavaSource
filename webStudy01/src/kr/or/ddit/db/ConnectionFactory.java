package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Factory Object[Method] Pattern
 *
 */
public class ConnectionFactory { 
	static { //static-> 생성 순서. 드라이버 먼저 로딩되어야함. 그리고 한번만 로드하면 되기때문에
		ResourceBundle  bundle = ResourceBundle.getBundle("kr.or.ddit.db.dbInfo"); //qualified name(컨텍스트패스 이후)
		///webStudy01/res/kr/or/ddit/db/dbInfo.properties -> 컨택스트 패스이후. 확장자필요없음. /는 . 으로 표현
		try {
			String driveClassName =bundle.getString("driverClassName");
			Class.forName(driveClassName);
			url = bundle.getString("url");
			user = bundle.getString("user");
			password = bundle.getString("password");
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException(e1);
		} // 클래스 메모리에 로딩 (인스턴스 객체 생성 안하고 클래스만 사용하겠다는 의미)
	}
	static String url;
	static String user;
	static String password;
	public static Connection getConnection() throws SQLException{
		Connection conn =  DriverManager.getConnection(url, user, password);
		return conn;
	}
}
