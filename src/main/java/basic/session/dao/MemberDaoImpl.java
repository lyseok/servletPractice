package basic.session.dao;

import org.apache.ibatis.session.SqlSession;

import basic.vo.MemberVO;
import utill.MyBatisUtil;

public class MemberDaoImpl implements IMemberDao {
	private static IMemberDao instance;
	
	private MemberDaoImpl() {}
	
	public static IMemberDao getInstance() {
		if(instance == null) instance = new MemberDaoImpl();
		return instance;
	}

	@Override
	public MemberVO getLoginMember(MemberVO memVO) {
		SqlSession session = null;
		MemberVO loginMember = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			
			loginMember = session.selectOne("member.getLoginMember", memVO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return loginMember;
	}

}
