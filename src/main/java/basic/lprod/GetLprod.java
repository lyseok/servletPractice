package basic.lprod;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utill.MyBatisUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class GetLprod
 */
@WebServlet("/getLprod.do")
public class GetLprod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession session = null;
		List<LprodVO> list = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			list = session.selectList("lprod.getLprod");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
//		System.out.println("test:"+list);
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		out.print(json);
		
		response.flushBuffer();
	}

}
