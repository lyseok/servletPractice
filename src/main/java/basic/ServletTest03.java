package basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servletTest03.do")
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println(this.getServletName() + "에서 init()메서드 호출");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service()메서드 시작");
		
		// GET방식과 POST방식을 구별해서 맞는 메서드 호출하기
		// 방법1) ==> 부모 클래스 HttpServlet의 service()메서드로 위임하기
//		super.service(req, resp);
		
		// 방법2) ==> 클라이언트의 전송 방식을 직접 구분해서 맞는 메서드 호출하기
		String method = request.getMethod();
		System.out.println("method : " + method);
		
		if("GET".equals(method)) {
			this.doGet(request, response);
		} else if("POST".equals(method)) {
			this.doPost(request, response);
		} else {
			System.out.println("전송 방식 오류");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메서드 시작");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'></head>"
				+ "<body><h2 style='color:red;'>doGet()메서드를 처리한 결과입니다.</h2>"
				+ "</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메서드 시작.");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'></head>"
				+ "<body><h2 style='color:blue;'>doPost()메서드를 처리한 결과입니다.</h2>"
				+ "</body></html>");
	}
	@Override
	public void destroy() {
		System.out.println("destroy()메서드 호출");
	}

}
