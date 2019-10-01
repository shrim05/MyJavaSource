package kr.or.ddit.servlet04.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyDAOImpl implements IDataBasePropertyDAO{

	@Override
	public List<DataBasePropertyVO> selectDataBasePropertyList(Map<String, Object> dataMap) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd=null;
		
	try{
		List<DataBasePropertyVO> list = new ArrayList<>();
		dataMap.put("list",list);

	 	//드라이버를 직접 다루면 종속성의 문제가 생기기때문에, 이를 다룰 수 있는 인터페이스를 사용. java sql 에 있는 driver manager 사용
	 	
	 	conn =ConnectionFactory.getConnection();
		stmt = conn.createStatement();
	 	StringBuffer sql = new StringBuffer();
	 	sql.append("select property_name, property_value, description from database_properties");
	 	rs = stmt.executeQuery(sql.toString());
	 	rsmd = rs.getMetaData();
	 	int colCnt = rsmd.getColumnCount();
	 	String[] headers = new String[colCnt];
	 	dataMap.put("headers",headers);
	 	for(int idx=1; idx<=colCnt;idx++){
	 		headers[idx-1]= rsmd.getColumnName(idx);
	 	}
	 	while(rs.next()){
	 		DataBasePropertyVO dv = new DataBasePropertyVO(); 
	 		dv.setProperty_name(rs.getString(1));
	 		dv.setProperty_value(rs.getString("property_value"));
	 		dv.setDescription(rs.getString("DESCRIPTION"));
	 		list.add(dv);
			}
	 	return list;
		}catch(SQLException e){
			throw new RuntimeException(e); //예외 발생 시 원본예외버리면 안됨
		}finally{
			try{
		 	//close 시 생성된 역순으로 정리
	 		if(rs!=null)rs.close();
	 		if(stmt!=null)stmt.close();
	 		if(conn!=null)conn.close();
	 		
			}catch(SQLException e){
				throw new RuntimeException(e);
			}
		}
	}
}
