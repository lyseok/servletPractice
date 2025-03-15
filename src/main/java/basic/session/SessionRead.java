package basic.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Servlet implementation class SessionRead
 */
@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 1. Session객체를 생성하거나 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		out.println("<html><head><meta charset='utf-8'><title>Session연습</title></head>");
		out.println("<body>");

		out.println("<h3>Session 데이터를 각각 1개 단위로 구하기</h3>");
		// 2. 세션 객체의 getAttribute()메서드를 이용하여 세션 데이터를 구한다.
		// 형식) Session객체.getAttribute(”key값”);
		String testSession = (String)session.getAttribute("testSession");
		
		if(testSession==null) {
			out.println("<h4>키 값이 'testSession'인 세션 데이터가 없습니다");
		} else {
			out.println("<h4>키 값이 'testSession'인 세션 데이터 : " + testSession +"</h4>");
		}
		
		out.println("<br><br><br>");
		
		out.println("<h3>전체 세션 데이터 확인하기</h3>");
		// Session객체의 전체 세션 key값을 가져오는 getAttributeNames() 메서드를 이용한다 
		Enumeration<String> sessionKeys = session.getAttributeNames();
		
		out.println("<ol>");
		int cnt = 0;
		while(sessionKeys.hasMoreElements()) {
			cnt++;
			String key = sessionKeys.nextElement();
			out.println("<li>" + key + ":" + session.getAttribute(key) + "</li>");
		}
		if(cnt == 0) {
			out.println("<li>세션 데이터가 하나도 없습니다</li>");
		}
		out.println("</ol>");
		
		out.println("<br><br><br>");
		
		// 세션ID => 세션을 구분하기 위한 고유한 값
		out.println("세션 : "+ session.getId() + "<br><br>");
		
		// 생성 시간 => 1970년 1월 1일부터 경과한 시간(ms 단위)
		out.println("세션 생성 시간 : " + session.getCreationTime() + "<br><br>");
		
		// 가장 최근에 세션에 접근한 시간 => 1970년 1월 1일부터 경과한 시간(ms 단위)
		out.println("세션 최근 접근 시간 : " + session.getLastAccessedTime() + "<br><br>");
		
		// 세션 유효 시간
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br><br>");
		
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
