package basic.session.service;

import basic.vo.MemberVO;

public interface IMemberService {
	/***
	 *  회원ID와 PassWord가 저장된 MemberVO객체를 인수값으로 받아서
	 *  해당 회원을 검색하여 반환하는 메서드
	 * @param memVO 회원ID와 패스워드가 저장된 MemberVO객체
	 * @return 검색된 회원 정보가 저장된 MemberVO객체
	 */
	public MemberVO getLoginMember(MemberVO memVO);
}
