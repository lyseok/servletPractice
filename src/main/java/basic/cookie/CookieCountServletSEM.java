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
@WebServlet("/cookieCountServletSEM.do")
public class CookieCountServletSEM extends HttpServlet {
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
		int count = 0;
		
		if(cookieArr != null) {
			for(Cookie cookie : cookieArr) {
				if("count".equals(cookie.getName())){ // 쿠키 이름 찾기
					count = Integer.parseInt(cookie.getValue()); // 쿠키값 구하기
				}
			}
		}
		
		count++;
		
		// 증가도니 count값을 '쿠키값'으로 갖는 Cookie객체를 생성
		Cookie countCookie = new Cookie("count", count + "");
		response.addCookie(countCookie);
		
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie Count 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>어서오세요. 당신은" + count + "번째 방문입니다</h3>");
		out.println("<br><br><br><br>");
		out.println("<a href='" + request.getContextPath() + "/cookieCountServletSEM.do'>"
				+ " 카운트 증가하기</a>&nbsp;&nbsp;&nbsp;");
		
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
