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
 * Servlet implementation class CookieCountServlet
 */
@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		int cnt = 1;
		Cookie[] cookieArr = request.getCookies();
		if(cookieArr != null) {
			for(Cookie cookie : cookieArr) {
				if(!"count".equals(cookie.getName())) {
					Cookie count = new Cookie("count", "1");
					response.addCookie(count);
				} else if("count".equals(cookie.getName())) {
					int count = Integer.parseInt(cookie.getValue());	
					count++;
					cookie.setValue(count+"");
					cnt = count;
					response.addCookie(cookie);
				} 
			}
		}
		out.println("<html><head><meta charset='utf-8'><title>Cookie 읽기</title></head>");
		out.println("<body>");
		
		out.println("<h3>어서오세요. 당신은" + cnt + "번째 방문입니다<br>");
		
		out.println("<a href='" + request.getContextPath() + "/cookieCountServlet.do'>Cookie Count 증가 하기</a><br>");
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
