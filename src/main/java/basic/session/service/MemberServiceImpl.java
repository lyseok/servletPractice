package basic.session.service;

import basic.session.dao.IMemberDao;
import basic.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;
	private static IMemberService instance;
	
	private MemberServiceImpl(IMemberDao dao) {
		this.dao = dao;
	}
	
	public static IMemberService getInstance(IMemberDao dao) {
		if(instance == null) instance = new MemberServiceImpl(dao);
		return instance;
	}

	@Override
	public MemberVO getLoginMember(MemberVO memVO) {
		return dao.getLoginMember(memVO);
	}

}
