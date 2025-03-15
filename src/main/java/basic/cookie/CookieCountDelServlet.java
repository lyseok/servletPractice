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
@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie 읽기</title></head>");
		out.println("<body>");
		
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h4>저장된 쿠키가 하나도 없습니다</h4>");
		} else {
			for(Cookie cookie : cookieArr) {

				if("count".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					out.println("<h3>count가 초기화 되었습니다</h3>");
				}
			}
		}
		
		out.println("<a href='" + request.getContextPath() 
		+ "/basic/cookie/cookiePractice01.jsp'>시작 문서로 가기 </a>");
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
