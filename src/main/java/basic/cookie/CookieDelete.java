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
 * Servlet implementation class CookieDelete
 */
@WebServlet("/cookieDelete.do")
public class CookieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		/*
			1. 쿠키 데이터의 삭제는 쿠키의 유지시간을 ‘0’으로 설정하는 방법을 사용한다
		*/
		// 예) 쿠키이름이 'gender'인 쿠키 삭제하기
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'>"
				+ "<title>쿠키 삭제 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>쿠키 삭제하기</h3>");
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h4>저장된 쿠키가 하나도 없습니다</h4>");
		} else {
			// 쿠키 배열에서 해당 쿠키 정보 가져오기
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName(); // 쿠키 이름 가져오기
				if("gender".equals(name)) { 	// 쿠키 이름이 'gender'(삭제할 쿠키이름)을 찾는다
					// 찾는 쿠키의 '유지시간'을 '0'으로 설정한 후 다시 저장한다
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		out.println("<hr>");
		
		out.println("<a href='" + request.getContextPath() 
		+ "/basic/cookie/cookieTest01.jsp'>시작 문서로 가기 </a>");
		
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
