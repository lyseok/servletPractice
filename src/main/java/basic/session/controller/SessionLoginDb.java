package basic.session.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import basic.session.dao.MemberDaoImpl;
import basic.session.service.IMemberService;
import basic.session.service.MemberServiceImpl;
import basic.vo.MemberVO;

/**
 * Servlet implementation class SessionLoginDb
 */
@WebServlet("/sessionLoginDb.do")
public class SessionLoginDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("id");
		String userPass = request.getParameter("pw");
		
		// 사용자가 보내온 데이터를 VO에 저장한다
		MemberVO vo = new MemberVO();
		vo.setMem_id(userId);
		vo.setMem_pass(userPass);
		
		// Service 객체 생성
		IMemberService service = MemberServiceImpl.getInstance(MemberDaoImpl.getInstance());
		
		// ID와 패스워드가 저장된 MemberVO객체를 이용해서 DB에서 해당 회원을 검색한다.
		MemberVO loginMember = service.getLoginMember(vo);
		
		HttpSession session = request.getSession();
		
		// 로그인 성공 여부 검사
		if(loginMember != null) {
			session.setAttribute("LOGINMEMBER", loginMember);
		}
		
		response.sendRedirect(request.getContextPath() + "/basic/session/sessionLoginDb.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
