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
import java.net.URLEncoder;

import basic.vo.FileInfoVO;
import fileupload.dao.FileInfoDaoImpl;
import fileupload.service.FileInfoServiceImpl;
import fileupload.service.IFileInfoService;

/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/fileDownload.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘엉노 파일 번호를 구한다
		int fileNo = Integer.parseInt(request.getParameter("fileno"));
		
		// DB에서 파일 번호에 해당하는 파일 정보를 가져온다
		IFileInfoService service = FileInfoServiceImpl.getInstance(FileInfoDaoImpl.getInstance());
		FileInfoVO vo = service.getFileInfo(fileNo);
		
		// 업로드된 파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 지정한 폴더가 없으면 새로 생성한다
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdir();
		}
		
		response.setCharacterEncoding("utf-8");
		
		// 다운 받을 파일의 정보를 갖는 File객체 생성 => 파일에 저장된 폴더와 실제 저장된 파일명을 지정하여 생성한다
		File downFile = new File(f, vo.getSave_file_name());
		
		if(downFile.exists()) { // download할 파일이 있으면
			// content 타입 설정
			response.setContentType("application/octet-stream; charset=utf-8");
			
			// response 객체의 Header에 content-disposition 속성을 설정한다
			String headerKey = "content-disposition";
			
			// content-dispsition 속성에는 다운로드 할 때 클라이언트에 저장될 파일 이름을 지정해서 설정한다.
			String headerValue = "attachment; filename*=UTF-8''" + 
							URLEncoder
								.encode(vo.getOrigin_file_name(), "utf-8")
								.replaceFirst("\\+", "%20");
			response.setHeader(headerKey, headerValue);
			
			// 실제 디스크에서 파일을 읽어서 전송한다
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				// 출력용 스트림 객체 생성 => response객체 이용
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				bin = new BufferedInputStream(new FileInputStream(downFile));
				
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
			
		} else {
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + vo.getOrigin_file_name() + "파일이 존재하지 않습니다</h3>");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
