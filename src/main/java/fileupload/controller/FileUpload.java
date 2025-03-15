package fileupload.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import basic.vo.FileInfoVO;
import fileupload.dao.FileInfoDaoImpl;
import fileupload.service.FileInfoServiceImpl;
import fileupload.service.IFileInfoService;

// Get방식의 요청은 File Upload Form으로 이동하고
// Post방식의 요청은 업로드한 파일을 처리하는 서블릿

/*
	- Servlet 3.0 이상에서 파일 업로드를 처리하려면
	  서블릿에 @MultipartConfig 애너테이션을 설정해야 한다.
	- ## @MultipartConfig 애너테이션에서 사용할 변수들

		1. location
		    - 업로드한 파일이 임시적으로 저장될 경로 지정 (기본값 : “” ⇒ 시스템의 임시폴더)
		2. fileSizeThreshold
		    - 이 속성에 지정한 값보다 큰 파일이 전송되면 location에 지정한 
		      임시 디렉토리에 저장한다. (단위: byte, 기본값: 0 (무조건 임시 디렉토리 사용))
		3. maxFileSize
		    - 1개 파일의 최대 크기 (단위 : byte, 기본값: -1L (무제한))
		4. maxRequestSize
		    - 서버로 전송되는 Request데이터 전체의 최대 크기 
		    (단위: byte, 기본값: -1L (무제한)) → (모든 파일 크기 + formData)
*/


@WebServlet("/fileUpload.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10,
		maxFileSize = 1024 * 1024 * 30,
		maxRequestSize = 1024 * 1024 * 100
		)

public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// GET방식 요청 => 단순히 file을 업로드하는 Form을 보여주는 페이지로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
			.getRequestDispatcher("/basic/fileupload/fileUploadForm.jsp")
			.forward(request, response);
		
	}

	// POST방식 요청 => Upload된 파일에 대한 처리를 한 후 파일 목록을 보여주는 페이지로 이동한다
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 업로드된 파일들이 저장될 폴더 설정
		String uploadPath = "d:/d_other/uploadFiles";
		
		// 지정한 폴더가 없으면 새로 생성한다
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdir();
		}
		// -------------------------------------------
		// 파일이 아닌 일반 데이터 받기 ==> request객체의 getParameter()메서드나 getParameterValue()메서드 이용
		String userName = request.getParameter("username");
		System.out.println("일반 파라미터 데이터 userName = " + userName);
		
		// -------------------------------------------
		// 수신 받은 파일 데이터 처리하기
		
		// 업로드한 파일이 여러개 일 경우
		List<FileInfoVO> fileList = new ArrayList<FileInfoVO>();
		
		/*
			- serlvet 3.0 이상에서 새롭게 추가된 ## Upload용 메서드

			1. Request객체.getParts()
			    - 전체 Part객체를  Collection 객체에 담아서 반환한다
			2. Request객체.getPart(”이름”)
			    - 지정된 ‘이름’을 가진 개별 Part객체를 반환한다
			    ’이름’ → form태그 안의 입력 요소의 name속성값으로 구별한다
			
		*/
		
		// 전체 Part 객체의 개수만큼 반복 처리한다
		for(Part part : request.getParts()) {
			// Upload한 파일명 찾기
			String fileName = extractFileName(part);
			
			// 찾은 파일명이 빈문자열("")이면 이것은 파일이 아닌 일반 파라미터라는 의미이다
			if(!"".equals(fileName)) {
				// 1개의 파일 정보를 저장할 VO객체 생성
				FileInfoVO vo = new FileInfoVO();
				
				// Upload한 파일 정보들을 VO객체에 저장한다
				vo.setFile_writer(userName);
				vo.setOrigin_file_name(fileName);
				
				// part객체.getSize()메서드 => upload된 파일의 크기를 반환한다(단위: byte, 자료형:long)
				vo.setFile_size((long)Math.ceil(part.getSize() / 1024.0));
				
				// 실제 저장되는 파일 이름이 중복되는 것을 방지하기 위해서 UUID를 이용하여 저장할 파일명을 만든다
				String saveFileName = UUID.randomUUID().toString() + "_" + fileName;
				vo.setSave_file_name(saveFileName);
				
				// upload한 파일을 지정할 폴더에 저장한다
				try {
					// Part객체.write()메서드 => Upload한 파일을 저장하는 메서드
					// 매개변수 값으로 '저장할폴더명/저장할파일명'과 같이 지정하여 넣어준다
					part.write(uploadPath + File.separator + saveFileName); // 파일 저장
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// upload된 파일 정보를 List에 추가한다
				fileList.add(vo);
			} // if END
			
		} // for END
		IFileInfoService service = FileInfoServiceImpl.getInstance(FileInfoDaoImpl.getInstance());
		
		for(FileInfoVO fvo : fileList) {
			service.insertFileInfo(fvo);
		}
		
		// 저장이 완료된 후에는 파일 목록을 보여준다
		
		response.sendRedirect(request.getContextPath() + "/fileList.do");
		
		
	} // doPost() END
	
	/*
		-------------------------------asekljfhakcjsehf23234sdgs -> Part를 구분하는 구분선

			content-disposition : form-data; name=”username” → 파라미터명
															→ 빈줄
			hong gil dong								 	→ 파라미터 값
	*/
	
	// Part구조 안에서 ‘파일명’을 찾는 메서드
	private String extractFileName(Part part) {
		String fileName = "";	// 찾은 파일며잉 저장될 변수 ( 반환값 변수 )
		
		String dispositionValue = part.getHeader("content-disposition");
		String[] items = dispositionValue.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {
				fileName = item.substring(item.indexOf("=") + 2, item.length() - 1);
			}
		}
		
		return fileName;
	}
}
