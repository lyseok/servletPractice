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
 * Servlet implementation class CookieAdd
 */
@WebServlet("/cookieAdd.do")
public class CookieAdd extends HttpServlet {
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
		Cookie 저장하는 방법
		
		1. Cookie 객체를 생성한다
		    ‘쿠키이름’과 ‘쿠키값’을 문자열로 지정하여 생성한다.    
		    형식) Cookie cookie변수 = new Cookie(”쿠키이름”, “ 쿠키값’);    
		    - ‘쿠키값’으로 한글이 사용될 경우 URLEncode.encode()메서드로 인코딩 후 지정한다.
		    - 하나의 쿠키는 4KB(4096 byte)까지 저장 가능하다
		    - 하나의 도메인 당 20개 (총 300개)까지 저장가능하다		
	*/
		Cookie nameCookie = new Cookie("name", "유재석");
		Cookie ageCookie = new Cookie("age", 20 + "");
		Cookie genderCookie = new Cookie("gender", "Male");
		
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);;
		response.addCookie(genderCookie);
		
		out.println("<html><dead><meta charset='utf-8'><title>Cookie 연습</title></head>");
		out.println("<body>");
		
		out.println("<h3>Cookie 데이터가 저장되었습니다</h3>");
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
