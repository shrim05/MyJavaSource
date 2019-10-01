package kr.or.ddit.servlet04.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.servlet04.dao.DataBasePropertyDAOImpl;
import kr.or.ddit.servlet04.dao.IDataBasePropertyDAO;
import kr.or.ddit.vo.DataBasePropertyVO;

public class DataBasePropertyServiceImpl implements IDataBasePropertyService {
	IDataBasePropertyDAO dao = new DataBasePropertyDAOImpl();
	
	@Override
	public void readAndLoggingDataBaseProperty(Map<String, Object> dataMap) {
		List<DataBasePropertyVO> list = dao.selectDataBasePropertyList(dataMap);
		for (DataBasePropertyVO vo : list) {
			System.out.printf("%s : %s [%s]\n",vo.getProperty_name(),vo.getProperty_value(),vo.getDescription());
		}
		
	}
	
}
