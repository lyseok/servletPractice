package fileupload.service;

import java.util.List;

import basic.vo.FileInfoVO;
import fileupload.dao.IFileInfoDao;

public class FileInfoServiceImpl implements IFileInfoService {
	private IFileInfoDao dao;
	private static IFileInfoService instance;
	
	private FileInfoServiceImpl(IFileInfoDao dao) {
		this.dao = dao;
	}
	
	public static IFileInfoService getInstance(IFileInfoDao dao) {
		if(instance == null) instance = new FileInfoServiceImpl(dao);
		return instance;
	}
	
	@Override
	public int insertFileInfo(FileInfoVO vo) {
		return dao.insertFileInfo(vo);
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		return dao.getAllFileInfo();
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		return dao.getFileInfo(fileNo);
	}

	@Override
	public int deleteFileInfo(int fileNo) {
		return dao.deleteFileInfo(fileNo);
	}

}
