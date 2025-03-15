package fileupload.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

import basic.vo.FileInfoVO;
import fileupload.dao.FileInfoDaoImpl;
import fileupload.service.FileInfoServiceImpl;
import fileupload.service.IFileInfoService;

/**
 * Servlet implementation class FileDelete
 */
@WebServlet("/fileDelete.do")
public class FileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int fileNo = Integer.parseInt(request.getParameter("fileno"));
		
		// DB에서 파일 번호에 해당하는 파일 정보를 가져온다
		IFileInfoService service = FileInfoServiceImpl.getInstance(FileInfoDaoImpl.getInstance());
		FileInfoVO vo = service.getFileInfo(fileNo);
		
		// 업로드된 파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		File f = new File(uploadPath);
		
		if(!f.exists()) {
			f.mkdir();
		}
		
		if(1 == service.deleteFileInfo(fileNo)) {
			File df = new File(f, vo.getSave_file_name());
			if( df.delete() ) {
				System.out.println("파일 삭제 성공");
			} else {
				System.out.println("파일 삭제 실패");
			}
			response.sendRedirect(request.getContextPath() + "/fileList.do");
		} else {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + vo.getOrigin_file_name() + "파일삭제 실패</h3>");
		}
				
		
	}

}
