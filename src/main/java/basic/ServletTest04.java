package basic;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/servletTest04.do")
public class ServletTest04 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// # Servlet이나 JSP의 환경에 관련된 정보 구하기
		// ServletContext 인터페이스 타입의 객체를 이용해서 얻을 수 있다
		ServletContext context = this.getServletContext();
		
		// Servlet이 속하는 웹 서버의 종류 구하기
		String serverInfo = context.getServerInfo();
		
		// Servlet의 버전 구하기
		int majorVer = context.getMajorVersion();
		int minorVer = context.getMinorVersion();
		
		// 서블릿 이름 구하기
		String servletName = this.getServletName();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'>"
				+ "<title>웹 서버 정보</title></head>");
		out.println("<body>");
		
		out.printf("웹 서버의 종류 : %s<br><br>", serverInfo);
		out.printf("Servlet Name : %s<br><br>", servletName);
		out.printf("Servlet 버전 : (%d.%d)", majorVer, minorVer);
		
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
