package fileupload.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import basic.vo.FileInfoVO;
import fileupload.dao.FileInfoDaoImpl;
import fileupload.service.FileInfoServiceImpl;
import fileupload.service.IFileInfoService;

/**
 * Servlet implementation class ImageView
 */
@WebServlet("/imageView.do")
public class ImageView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파일 번호 받기
		int fileno = Integer.parseInt(request.getParameter("fileno"));
		
		IFileInfoService service = FileInfoServiceImpl.getInstance(FileInfoDaoImpl.getInstance());
		
		FileInfoVO vo = service.getFileInfo(fileno);
		
		// 업로드된 파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 지정한 폴더가 없으면 새로 생성한다
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdir();
		}
		
		File imgFile = new File(f, vo.getSave_file_name());
		
		// 실제 디스크에서 파일을 읽어서 전송한다
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			// 출력용 스트림 객체 생성 => response객체 이용
			bout = new BufferedOutputStream(response.getOutputStream());
			
			// 파일 입력용 스트림 객체 생성
			bin = new BufferedInputStream(new FileInputStream(imgFile));
			
			byte[] temp = new byte[1024];
			int len = 0;
			
			// byte 배열을 이용하여 파일 내용을 읽어서 출력용 스트림으로 출력한다
			while((len=bin.read(temp)) > 0) {
				bout.write(temp, 0, len);
			}
			bout.flush();
			
		} catch (Exception e) {
			System.out.println("입출력 오류 : " + e.getMessage());
		} finally {
			if(bin != null) try { bin.close(); } catch (IOException e) {}
			if(bout != null) try { bout.close(); } catch (IOException e) {}
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
