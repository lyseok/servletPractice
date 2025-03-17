package basic.lprod.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import basic.lprod.LprodVO;
import basic.lprod.dao.LprodDaoImpl;
import basic.lprod.service.ILprodService;
import basic.lprod.service.LprodServiceImpl;

/**
 * Servlet implementation class LprodList2
 */
@WebServlet("/lprodList2.do")
public class LprodList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ILprodService service = LprodServiceImpl.getInstance(LprodDaoImpl.getInstance());
		
		List<LprodVO> list = service.getAllLprod();
		
		request.setAttribute("list", list);
		
		request
			.getRequestDispatcher("/basic/lprod/lprod2.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
