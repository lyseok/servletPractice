package basic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 *   이 예제는 배포 서술자(DD, Deployment Descriptor - web.xml)를 이용해서
 *   실행할 servlet을 설정하여 처리하는 예제이다.
 */

// servlet 클래스는 HttpServlet 클래스를 상속해서 작성한다.

public class ServletTest01 extends HttpServlet {
	
	/*
	 
		http://localhost:80/webTest/servletTest01.do
		http 		=> 프로토콜
		localhost 	=> 도메인명 또는 IP주소
		80 			=> 포트번호
		/webTest	=> 컨텍스트 PATH(보통 프로젝트 이름으로 지정)
		/servletTest01.do => 서블릿 요청 URL 패턴
		
	*/
	
	// 이 서블릿 영역에서는 대부분 service() 메서드 또는 doGet()메서드,
	// doPost()메서드를 재정의해서 작성한다.
	
	// doGet()메서드나  doPost()메서드는 service()메서드를 통해서 자동으로 호출된다.
	// 이 메서드의 매개변수로 HttpServletRequest객체와 HttpServletResponse객체가 사용된다.
	// - HttpServletRequest 객체  => 서비스 요청에 관련된 정보 및 메서드를 관리하는 객체
	// - HttpServletResponse 객체 => 서비스 응답에 관련된 정보 및 메서드를 관리하는 객체
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// doGet()메서드 ==> GET방식의 요청을 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		// 처리한 내용을 응답으로 보내기 위해서 PrintWriter객체를 생성한다.
		// (Response객체를 이용해서)
		PrintWriter out = resp.getWriter();
		
		// 처리한 내용을 HTML형식으로 출력한다.
		// 방법1) append() 메서드 이용하기
		out.append("<html>")
			.append("<head>")
			.append("<meta charset='utf-8'>")
			.append("<title>첫번째 서블릿 연습</title>")
			.append("</head>")
			.append("<body>")
			.append("<h2 style='text-align:center;'>"
					+ "안녕하세요. 첫번째 Servlet프로그램입니다</h2>")
			.append("</body>")
			.append("</html>");
		
	}
	
	// doPost()메서드 ==> POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPost(req, resp);
	}
}
