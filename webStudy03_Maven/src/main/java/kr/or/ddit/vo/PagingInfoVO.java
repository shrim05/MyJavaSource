package kr.or.ddit.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(exclude="pagingHTML")
public class PagingInfoVO<T> {
	private int totalRecord;
	private int totalPage;
	private int screenSize  = 10;
	private int blockSize   = 5;
	private int currentPage = 1;
	private int startRow;
	private int endRow;
	private int startPage;
	private int endPage;
	private String pagingHTML;
	private List<T> dataList; 
	
	public PagingInfoVO(int screenSize, int blockSize) {
		super();
		this.screenSize = screenSize;
		this.blockSize = blockSize;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		totalPage = (int)Math.ceil((totalRecord/(double)screenSize));
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		endRow = currentPage * screenSize;
		startRow = endRow - (screenSize -1);
		endPage = blockSize * ((currentPage + (blockSize-1))/blockSize);
		startPage = endPage - (blockSize-1);
	}

	public String getPagingHTML() {
		StringBuffer html = new StringBuffer();
		html.append("<nav aria-label='...'>");
		html.append("<ul class='pagination'>");
		String disabled = startPage<blockSize?"disabled":"";
		html.append("<li class='page-item "+disabled+"'>");
		html.append("<a class='page-link' data-page='"+(startPage-blockSize)+"' href='#' tabindex='-1' aria-disabled='true'>Previous</a></li>");
	    endPage= endPage <totalPage ? endPage : totalPage;
		for (int page = startPage; page <=endPage ; page++) {
			String active = currentPage==page?"active":"";
			html.append("<li class='page-item'"+active+"><a class='page-link'data-page='"+page+"' href='#'>"+page);
			if(currentPage==page) {
				html.append("<span class='sr-only'>(current)</span>");
			}
			html.append("</a></li>");
		}
		disabled = endPage>=totalPage?"disabled":"";
		html.append("<li class='page-item "+disabled+"'><a class='page-link' data-page='"+(endPage+1)+"' href='#'>Next</a></li></ul></nav>");
		this.pagingHTML = html.toString();
		return pagingHTML;
	}
	
}
