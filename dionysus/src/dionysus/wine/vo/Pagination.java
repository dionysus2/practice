package dionysus.wine.vo;

import lombok.Data;

@Data
public class Pagination {
	private int pageNo;				//	사용자가 요청한 페이징번호
	private int startPaging;			//	하단영역에 보여져야 하는 첫번째 페이징 번호
	private int lastPaging;			//	하단영역에 보여져야 하는 마지막 페이징 번호
	private int startRow;			//	뷰되는 페이지의 첫번째 게시글 번호
	private int lastRow;			//	뷰되는 페이지의 마지막 게시글 번호
	private int prev;				//	이전페이징
	private int next;				//	다음페이징
}
