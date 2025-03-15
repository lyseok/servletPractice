package basic.reqNresp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Servlet implementation class RedirectTest
 */
@WebServlet("/redirectTest.do")
public class RedirectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Request.setAttribute() 메서드와 getAttribute()메서드를 이용해서 자료를 넘길 수 없다
//		request.setAttribute("tel", "010-0000-9999");
		
		// Redirect 형식으로 이동하기 -> Response객체의 sendRedirect() 메서드를 이용한다
//		response.sendRedirect(request.getContextPath() + "/redirectTarget.do");
		
		// '문서1'에서 '문서2'로 데이터 보내기
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 클라이언트가 보내온 데이터를 받는다
		String userName = request.getParameter("username");
		
		// 전송할 데이터를 redirect의 URL주소 뒤에 붙여서 전송한다
		response.sendRedirect(request.getContextPath() + "/redirectTarget.do?name=" 
				+ URLEncoder.encode(userName, "utf-8") + "&tel=010-0000-1111");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
