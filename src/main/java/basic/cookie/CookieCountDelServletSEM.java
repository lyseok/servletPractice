package basic.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class CookieCountDelServlet
 */
@WebServlet("/cookieCountDelServletSEM.do")
public class CookieCountDelServletSEM extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookieArr = request.getCookies();
		
		if(cookieArr != null) {
			for(Cookie cookie : cookieArr) {
				if("count".equals(cookie.getName())) { // 'count'라는 쿠키 이름 찾기
					cookie.setMaxAge(0); // 유지시간을 0으로 셋팅
					response.addCookie(cookie); // 쿠키 덮어쓰기
				}
			}
		}
		
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie Count 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>Count가 초기화 되었습니다.</h3>");
		out.println("<br><br><br><br>");

		out.println("<a href='" + request.getContextPath() + "/basic/cookie/cookieTest02SEM.jsp'>"
				+ " 시작문서로 이동하기</a>&nbsp;&nbsp;&nbsp;");
		
		
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
