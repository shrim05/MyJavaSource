package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	    sql.append("TO_CHAR(MEM_MEMORIALDAY,'YYYY-MM-DD') MEM_MEMORIALDAY,    MEM_MILEAGE,    MEM_DELETE     ");
	    sql.append("FROM                                                                                     ");
	    sql.append("MEMBER                                                                                   ");
	    sql.append("WHERE MEM_ID = ?                                                                         ");
	    
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		)
		{	
			pstmt.setString(1, member.getMem_id());
//			pstmt.setString(2, mv.getMem_pass());
			rs = pstmt.executeQuery();	
			if(rs.next()) {
				mv = new MemberVO();
				mv.setMem_id(rs.getString(1));
				mv.setMem_pass(rs.getString(2));
				mv.setMem_name(rs.getString(3));
				mv.setMem_hp(rs.getString(4));
				//reflection 이 후 작성
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVO mv) {
		// TODO Auto-generated method stub
		return 0;
	}

}
