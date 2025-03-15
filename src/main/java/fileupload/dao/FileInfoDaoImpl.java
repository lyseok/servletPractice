package fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import basic.vo.FileInfoVO;
import utill.MyBatisUtil;

public class FileInfoDaoImpl implements IFileInfoDao {
	private static IFileInfoDao instance;
	
	private FileInfoDaoImpl() {}

	public static IFileInfoDao getInstance() {
		if(instance == null) instance = new FileInfoDaoImpl();
		return instance;
	}
	
	@Override
	public int insertFileInfo(FileInfoVO vo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.insert("fileinfo.insertFileInfo", vo);
			
			if(cnt > 0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		SqlSession session = null;
		List<FileInfoVO> list = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			list = session.selectList("fileinfo.getAllFileInfo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		SqlSession session = null;
		FileInfoVO vo = null;
		
		try {
			session = MyBatisUtil.getSqlSession();
			vo = session.selectOne("fileinfo.getFileInfo", fileNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return vo;
	}

	@Override
	public int deleteFileInfo(int fileNo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MyBatisUtil.getSqlSession();
			cnt = session.delete("fileinfo.deleteFileInfo", fileNo);
			
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return cnt;
	}

}
