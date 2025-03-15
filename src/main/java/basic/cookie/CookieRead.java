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
 * Servlet implementation class CookieRead
 */
@WebServlet("/cookieRead.do")
public class CookieRead extends HttpServlet {
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
			## 저장된 Cookie 읽어오기	
				1. 전체 쿠키 정보를 Request객체를 통해서 가져온다				    
				    가져온 Cookie정보들은 배열에 저장되어 반환된다	    
	    			- 형식) Cookie[] 쿠키배열변수 = request객체.getCookies();
		*/
		
		Cookie[] cookieArr = request.getCookies();
		
		out.println("<html><head><meta charset='utf-8'><title>Cookie 읽기</title></head>");
		out.println("<body>");
		
		out.println("<h3>저장된 Cookie 확인하기</h3>");
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<h4>저장된 쿠키가 하나도 없습니다</h4>");
		} else {
			// 2. 쿠키 배열에서 해당 쿠키 정보를 구해온다
			for(Cookie cookie : cookieArr) {
				String name = cookie.getName();		// '쿠키이름' 구하기
				String value = cookie.getValue();	// '쿠키값' 구하기
				
				out.println("쿠키이름 : " + name + "<br>");
				out.println("쿠키 값 : " + value + "<br><hr>");
			}
		}
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
