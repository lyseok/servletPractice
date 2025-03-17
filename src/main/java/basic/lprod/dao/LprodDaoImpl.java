package basic.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import basic.lprod.LprodVO;
import utill.MyBatisUtil;



public class LprodDaoImpl implements ILprodDao {

	private static ILprodDao instance;
	
	private LprodDaoImpl() {}
	
	public static ILprodDao getInstance () {
		if(instance == null) instance = new LprodDaoImpl();
		return instance;
	}
	
	@Override
	public List<LprodVO> getAllLprod() {
		SqlSession session = null;
		List<LprodVO> list = null;
				
		try {
			session = MyBatisUtil.getSqlSession();
			list = session.selectList("lprod.getLprod");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return list;
	}

}
