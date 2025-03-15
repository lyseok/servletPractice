package basic.reqNresp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ForwardTest
 */
@WebServlet("/forwardTest.do")
public class ForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 	이동시키는 페이지(문서1)에서 이동되는 페이지(문서2)로 데이터를 보내는 방법
		 * 	-> '문서1'에서 Request객체의 setAttribute()메서드를 이용하여 데이터를 셋팅하고 보내고 
		 * 	   '문서2'에서 Request객체의 getAttribute()메서드를 이용하여 데이터를 읽어온다.
		 * 	-> 보낼때 형식) request객체.setAttribute("key값", 저장할데이터);
		 * 			-> 'key값'은 문자열, '저장할데이터' java의 모든 자료형을 지정할 수 있다.
		 * 	-> 받을때 형식) request객체.getAttibute("key값");
		 */
		request.setAttribute("tel", "010-1111-2222");
		
		// forward 방식으로 이동하기
		// -> Request객체.getRequestDispatcher()메서드에 '이동할 서블릿이나 JSP'를 지정해
		//    주는데 전체 URI경로 중에서 ContextPath이후의 경로를 지정해 준다.
		
		RequestDispatcher rd = request.getRequestDispatcher("/forwardTarget.do");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
