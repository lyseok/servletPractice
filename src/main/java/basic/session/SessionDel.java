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
 * Servlet implementation class SessionDel
 */
@WebServlet("/sessionDel.do")
public class SessionDel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// Session 삭제하기
		// 1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		// 2. Session 데이터를 삭제하기
		// 1) 개별적인 세션 데이터 삭제하기 -> Session객체의 removeAttribute()메서드 활용
		// 	  형식) Session객체.removeAttribute(”삭제할 key값”);

//		session.removeAttribute("testSession");
		session.invalidate();
		
		out.println("<html><head><meta charset='utf-8'><title>Session연습</title></head>");
		out.println("<body>");

		out.println("<h3>Session 데이터 삭제하기</h3>");
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
