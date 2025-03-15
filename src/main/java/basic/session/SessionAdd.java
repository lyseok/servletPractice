package basic.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SessionAdd
 */
@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		/*
		## Session 저장하는 방법

		1. Session객체를 생성하거나 현재 세션 정보를 가져온다		    
	    형식1) Request객체.getSession(); 또는 Request객체.getSession(true);		    
	    - 현재 세션이 존재하면 현재 세션을 반환하고, 존재하지 않으면 새로운 세션을 생성한다.		    
	    형식2) Request객체.getSession(false);		    
	    - 현재 세션이 존재하면 현재 세션을 반환하고, 존재하지 않으면 새로운 세션을 생성하지 않고 null을 반환한다		
	    */
		
		HttpSession session = request.getSession();
		
		/*
		2. setAttribute()메서드를 이용하여 session에 데이터를 저장한다    
	    형식) Session객체.setAttiribute(”key값”, 데이터)	    
	    - ‘key값’은 문자열, ‘데이터’는 자바의 모든 자료를 지정할 수 있다.
		*/
		session.setAttribute("testSession", "연습용 세션");
		session.setAttribute("userName", "유재석");
		session.setAttribute("age", 50);
		
		out.println("<html><head><meta charset='utf-8'><title>Session연습</title></head>");
		out.println("<body>");

		out.println("<h3>Session 데이터가 저장되었습니다</h3>");
		out.println("<br><br><br>");
		out.println("<a href='" + request.getContextPath() + 
				"/basic/session/sessionTest.jsp'>시작문서로 이동</a>");
		
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
