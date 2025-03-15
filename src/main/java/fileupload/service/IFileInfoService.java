package fileupload.service;

import java.util.List;

import basic.vo.FileInfoVO;

public interface IFileInfoService {
	/***
	 * FileInfoVO객체에 저장된 데이터를 DB에 insert하는 메서드
	 * 
	 * @param vo insert할 파일 정보가 저장된 FileInfoVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int insertFileInfo(FileInfoVO vo);
	
	/***
	 * DB에 저장된 파일 정보 전체를 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 파일 정보 목록이 저장된 List 객체
	 */
	public List<FileInfoVO> getAllFileInfo();
	
	/***
	 * 파일 번호를 매개변수로 받아서 해당 파일 정보를 VO에 담아서 반환하는 메서드
	 * 
	 * @param fileNo 검색할 파일번호
	 * @return 검색된 파일 정보가 저장된 FileInfoVO객체
	 */
	public FileInfoVO getFileInfo(int fileNo);
	
	/***
	 * 파일 번호를 매개변수로 받아서 해당 파일을 DB에서 삭제하는 메서드
	 * @param fileNo 삭제할 파일 번호
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteFileInfo(int fileNo);
}
