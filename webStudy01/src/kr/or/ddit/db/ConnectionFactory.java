package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

/**
 * Factory Object[Method] Pattern
 *
 */
public class ConnectionFactory { 
	static String url;
	static String user;
	static String password;
	static BasicDataSource dataSource;
	static int initialSize;
	static int maxWait;
	static int maxTotal;
	static { //static-> 생성 순서. 드라이버 먼저 로딩되어야함. 그리고 한번만 로드하면 되기때문에
		ResourceBundle  bundle = ResourceBundle.getBundle("kr.or.ddit.db.dbInfo"); //qualified name(컨텍스트패스 이후)
		///webStudy01/res/kr/or/ddit/db/dbInfo.properties -> 컨택스트 패스이후. 확장자필요없음. /는 . 으로 표현
//		try {
//			Class.forName(driveClassName);
			
			
//		} catch (ClassNotFoundException e1) {
//			throw new RuntimeException(e1);
//		} // 클래스 메모리에 로딩 (인스턴스 객체 생성 안하고 클래스만 사용하겠다는 의미)
		String driveClassName =bundle.getString("driverClassName");
		url = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
		initialSize = Integer.parseInt(bundle.getString("initialSize"));
		maxWait = Integer.parseInt(bundle.getString("maxWait"));
		maxTotal = Integer.parseInt(bundle.getString("maxTotal"));
		
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driveClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		//미리 만들어놓을 접속객체 수
		dataSource.setInitialSize(initialSize);
		//사용 가능 풀링객체 없을 시 기다리게 하는 시간
		dataSource.setMaxWaitMillis(maxWait);
		//추가로 생성할 수 있는 한도
		dataSource.setMaxTotal(maxTotal);
	}
	public static Connection getConnection() throws SQLException{
//		Connection conn =  DriverManager.getConnection(url, user, password);
		Connection conn = dataSource.getConnection();
		return conn;
	}
}
