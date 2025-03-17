package fileupload.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import basic.vo.FileInfoVO;
import fileupload.dao.FileInfoDaoImpl;
import fileupload.service.FileInfoServiceImpl;
import fileupload.service.IFileInfoService;

// DB에 저장된 파일 목록을 가져와서 View로 보내는Servlet
@WebServlet("/fileList.do")
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Service 객체 생성
		IFileInfoService service = FileInfoServiceImpl.getInstance(FileInfoDaoImpl.getInstance());
		
		// DB에 저장된 파일 목록 전체를 구해서 List에 저장
		List<FileInfoVO> fileList = service.getAllFileInfo();
		
		// 전체 목록이 저장된 List를 Request객체의 setAttribute()를 이용해서 저장한다
		request.setAttribute("fileList", fileList);
		
		// forward 방식으로 view 페이지로 이동
		request
			.getRequestDispatcher("/basic/fileupload/fileList.jsp")
			.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
