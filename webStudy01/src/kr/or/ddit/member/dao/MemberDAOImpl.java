package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements IMemberDAO{

	@Override
	public MemberVO selectMember(MemberVO member){
		ResultSet rs =null;
		MemberVO mv = null;
		String sql ="select mem_id, mem_pass, "
				+ "mem_name, mem_hp, mem_mail "
				+ "from member where mem_id=?"; 
				
		try(
			Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
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
				mv.setMem_mail(rs.getString(5));
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

}
