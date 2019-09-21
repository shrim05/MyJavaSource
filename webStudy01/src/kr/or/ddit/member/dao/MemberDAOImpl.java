package kr.or.ddit.member.dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements IMemberDAO{
	
	private static MemberDAOImpl instance;
	
	private MemberDAOImpl() {
		
	}
	//상태의 차이가 없을 때만 싱글턴 패턴 사용
	public static MemberDAOImpl getInstance() {
		if(instance==null) {
			instance = new MemberDAOImpl();
		}
		return instance;
	}
	
	@Override
	public MemberVO selectMember(MemberVO member){
		ResultSet rs =null;
		MemberVO mv = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT                                                                                   ");
	    sql.append("MEM_ID,     MEM_PASS,    MEM_NAME,    MEM_REGNO1,                                        ");
	    sql.append("MEM_REGNO2,    TO_CHAR(MEM_BIR,'YYYY-MM-DD') MEM_BIR,    MEM_ZIP,    MEM_ADD1,           ");
	    sql.append("MEM_ADD2,    MEM_HOMETEL,    MEM_COMTEL,    MEM_HP,                                      ");
	    sql.append("MEM_MAIL,    MEM_JOB,    MEM_LIKE,    MEM_MEMORIAL,                                      ");
	    sql.append("TO_CHAR(MEM_MEMORIALDAY,'YYYY-MM-DD') MEM_MEMORIALDAY,    to_char(MEM_MILEAGE) MEM_MILEAGE,    MEM_DELETE     ");
	    sql.append("FROM                                                                                     ");
	    sql.append("MEMBER                                                                                   ");
	    sql.append("WHERE MEM_ID = ?  AND MEM_DELETE IS NULL                                                 ");
	    
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		)
		{	
			pstmt.setString(1, member.getMem_id());
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				mv = new MemberVO();
				Class<MemberVO> voType = MemberVO.class;
				Field[] fds = voType.getDeclaredFields();
				for(Field tmp : fds) {
					String name = tmp.getName();
					try {
						PropertyDescriptor pd = new PropertyDescriptor(name, voType);
						Method getter = pd.getReadMethod();
						Method setter = pd.getWriteMethod();
						Method rsGetter = rs.getClass().getDeclaredMethod("getString",String.class);
						setter.invoke(mv, rsGetter.invoke(rs, name));
					} catch (IntrospectionException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						e.printStackTrace();
					}
				}
				
				
//				mv.setMem_id(rs.getString("mem_id"));
//				mv.setMem_pass(rs.getString("mem_pass"));
//				mv.setMem_name(rs.getString("mem_name"));
//				mv.setMem_regno1(rs.getString("mem_regno1"));
//				mv.setMem_regno2(rs.getString("mem_regno2"));
//				mv.setMem_bir(rs.getString("mem_bir"));
//				mv.setMem_zip(rs.getString("mem_zip"));
//				mv.setMem_add1(rs.getString("mem_add1"));
//				mv.setMem_add2(rs.getString("mem_add2"));
//				mv.setMem_hometel(rs.getString("mem_hometel"));
//				mv.setMem_comtel(rs.getString("mem_comtel"));
//				mv.setMem_hp(rs.getString("mem_hp"));
//				mv.setMem_mail(rs.getString("mem_mail"));
//				mv.setMem_job(rs.getString("mem_job"));
//				mv.setMem_like(rs.getString("mem_like"));
//				mv.setMem_memorial(rs.getString("mem_memorial"));
//				mv.setMem_memorialday(rs.getString("mem_memorialday"));
//				mv.setMem_mileage(rs.getInt("mem_mileage"));
//				mv.setMem_delete(rs.getString("mem_delete"));
//				
			}
			return mv;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(rs!=null)
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int insertMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberVO> selectMemberList() {
		ResultSet rs =null;
		List<MemberVO> lmv = new ArrayList<MemberVO>();
		StringBuffer sql = new StringBuffer();
//		sql.append("select * from member where mem_delete is null");
		sql.append("SELECT                                                                                   ");
	    sql.append("MEM_ID,    MEM_NAME,                                          ");
	    sql.append("MEM_ADD1,           ");
	    sql.append("MEM_ADD2,   MEM_HP,                                      ");
	    sql.append("MEM_MAIL,                                         ");
	    sql.append("    MEM_MILEAGE     ");
	    sql.append("FROM                                                                                     ");
	    sql.append("MEMBER                                                                                   ");
	    sql.append("WHERE MEM_DELETE IS NULL                              				                     ");
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		)
		{	
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO mv = new MemberVO();
//				Class<MemberVO> voType = MemberVO.class;
//				Field[] fds = voType.getDeclaredFields();
//				for(Field tmp : fds) {
//					String name = tmp.getName();
//					try {
//						PropertyDescriptor pd = new PropertyDescriptor(name, voType);
//						Method getter = pd.getReadMethod();
//						Method setter = pd.getWriteMethod();
//						Method rsGetter = rs.getClass().getDeclaredMethod("getString",String.class);
//						setter.invoke(mv, rsGetter.invoke(rs, name));
//					} catch (IntrospectionException e) {
//						e.printStackTrace();
//					} catch (IllegalAccessException e) {
//						e.printStackTrace();
//					} catch (IllegalArgumentException e) {
//						e.printStackTrace();
//					} catch (InvocationTargetException e) {
//						e.printStackTrace();
//					} catch (SecurityException e) {
//						e.printStackTrace();
//					} catch (NoSuchMethodException e) {
//						e.printStackTrace();
//					}
//				}
				mv.setMem_id(rs.getString("mem_id"));
				mv.setMem_name(rs.getString("mem_name"));
				mv.setMem_add1(rs.getString("mem_add1"));
				mv.setMem_add2(rs.getString("mem_add2"));
				mv.setMem_hp(rs.getString("mem_hp"));
				mv.setMem_mail(rs.getString("mem_mail"));
				mv.setMem_mileage(rs.getInt("mem_mileage"));
				lmv.add(mv);
			}
			return lmv;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				if(rs!=null)
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public int updateMember(MemberVO mv) {
		int result = 0;
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE member     ");
	    sql.append("SET               ");
	    sql.append("mem_name        =?,");
	    sql.append("mem_bir         =?,");
	    sql.append("mem_zip         =?,");
	    sql.append("mem_add1        =?,");
	    sql.append("mem_add2        =?,");
	    sql.append("mem_hometel     =?,");
	    sql.append("mem_comtel      =?,");
	    sql.append("mem_hp          =?,");
	    sql.append("mem_mail        =?,");
	    sql.append("mem_job         =?,");
	    sql.append("mem_like        =?,");
	    sql.append("mem_memorial    =?," );
	    sql.append("mem_memorialday =?," );
	    sql.append("mem_mileage     =?" );
	    sql.append("WHERE			");
		sql.append("mem_id =		?"); 
		sql.append("AND mem_pass =		?"); 
		
		try (Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int a=1;
			pstmt.setString(a++, mv.getMem_name());
			pstmt.setString(a++, mv.getMem_bir());
			pstmt.setString(a++, mv.getMem_zip());
			pstmt.setString(a++, mv.getMem_add1());
			pstmt.setString(a++, mv.getMem_add2());
			pstmt.setString(a++, mv.getMem_hometel());
			pstmt.setString(a++, mv.getMem_comtel());
			pstmt.setString(a++, mv.getMem_hp());
			pstmt.setString(a++, mv.getMem_mail());
			pstmt.setString(a++, mv.getMem_job());
			pstmt.setString(a++, mv.getMem_like());
			pstmt.setString(a++, mv.getMem_memorial());
			pstmt.setString(a++, mv.getMem_memorialday());
			pstmt.setInt(a++, mv.getMem_mileage());
			pstmt.setString(a++, mv.getMem_id());
			pstmt.setString(a++, mv.getMem_pass());
			result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteMember(MemberVO mv) {
		int result =0;
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE MEMBER SET MEM_DELETE = 'Y' WHERE MEM_ID=? ");
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				pstmt.setString(1, mv.getMem_id());
				result = pstmt.executeUpdate();
				return result;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}

}
