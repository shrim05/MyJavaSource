package kr.or.ddit.servlet04.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.DataBasePropertyVO;

public interface IDataBasePropertyDAO {
	public List<DataBasePropertyVO> selectDataBasePropertyList(Map<String, Object> dataMap);
}
