package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
	이 예제는 애너테이션(@Webservlet)을 이용하여 servlet을 등록하여 처리한 예제
	애너테이션(@WebServlet)은 Servlet버전 3.0이상에서만 사용할 수 있다
	
	@WebServlet 애너테이션의 속성들
	1. name : 서블릿의 이름을 설정한다 (기본값 : 빈문자열(""))
	2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다 (기본값 : 빈배열({}))
		예) urlPatterns="/url1"또는 urlPatterns={"/url1"} ==> 패턴이 1개일 경우
		예) urlPatterns={"/url1", "/url2", ...} ==> 패턴이 여러개일 경우
	3. value: urlPatterns와 동일한 기능을 한다.
	4. description : 주석(설명글)을 설정한다
 */

@WebServlet(
		urlPatterns = {"/servletTest02.do", "/servletTest02.ddit"},
		description = "애너테이션을 이용한 서블릿 등록 연습"
)

public class ServletTest02 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		// 방법 2) 
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>두번째 Servlet 연습</title></head>");
		out.println("<body>");
		
		out.println("<h2 style='text-align:center; color:red;'>");
		out.println("두번재 Servlet입니다<br>");
		out.println("이 서블릿의 Context Path'" + req.getContextPath()
				+ "'입니다</h2>");
		
		out.println("</body></html>");
		
	}
	
	// doPost()메서드 ==> POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		super.doPost(req, resp);
	}
}
