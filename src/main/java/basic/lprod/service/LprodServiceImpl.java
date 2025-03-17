package basic.lprod.service;

import java.util.List;

import basic.lprod.LprodVO;
import basic.lprod.dao.ILprodDao;

public class LprodServiceImpl implements ILprodService {
	private static ILprodService instance;
	private ILprodDao dao;
	
	private LprodServiceImpl(ILprodDao dao) {
		this.dao = dao;
	}
	
	public static ILprodService getInstance(ILprodDao dao) {
		if(instance == null) instance = new LprodServiceImpl(dao);
		return instance;
	}
	
	@Override
	public List<LprodVO> getAllLprod() {
		return dao.getAllLprod();
	}

}
