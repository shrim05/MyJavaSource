package kr.or.ddit.alba.service;

import java.util.List;

import kr.or.ddit.enums.ServiceResult;
import kr.or.ddit.vo.AlbaVO;
import kr.or.ddit.vo.LicAlbaVO;
import kr.or.ddit.vo.PagingInfoVO;

public interface IAlbaService {
	public ServiceResult createAlba(AlbaVO alba);
	public AlbaVO retrieveAlba(String al_id);
	public int retrieveAlbaCount(PagingInfoVO<AlbaVO> pagingVO);
	public List<AlbaVO> retrieveAlbaList(PagingInfoVO<AlbaVO> pagingVO);
	public ServiceResult modifyAlba(AlbaVO alba);
	public ServiceResult removeAlba(String al_id);
	
	public LicAlbaVO retrieveLicense(LicAlbaVO licAlba);
}
