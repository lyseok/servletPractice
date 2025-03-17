package basic.lprod.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import basic.lprod.LprodVO;
import basic.lprod.dao.LprodDaoImpl;
import basic.lprod.service.ILprodService;
import basic.lprod.service.LprodServiceImpl;

/**
 * Servlet implementation class LprodListSem
 */
@WebServlet("/lprodListSem.do")
public class LprodListSem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new Gson();
		ILprodService service = LprodServiceImpl.getInstance(LprodDaoImpl.getInstance());
		
		List<LprodVO> list = service.getAllLprod();
		
		String json = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		
		out.print(json);
		
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
