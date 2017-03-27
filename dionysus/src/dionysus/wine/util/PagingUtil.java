package dionysus.wine.util;

import dionysus.wine.vo.Pagination;

public class PagingUtil {				//	매개변수: 사용자 요청페이징 번호, 게시글의 총 개수
										//			  DAO에서 가져온 count값을 넣으면 됩니다. 
	public static Pagination getPagination(int pageNo, int cntOfRow) {
		int pageRow = 20;									//	게시판 한페이지에 뿌려져야 하는 게시글 개수
		int pagingSize = 5;									//	게시판 하단영역 페이징사이즈
		int countOfPaging = (cntOfRow-1)/pageRow + 1;		//	하단영역 페이징 개수
		int groupNo = (pageNo-1)/pagingSize + 1; 			//	하단영역 페이징 사이즈에 따른 그룹
		int startRow = (pageNo-1)*pageRow +1;				//	뷰되는 페이지의 첫번째 게시글 번호 
		int lastRow = pageNo*pageRow;						//	뷰되는 페이지의 마지막 게시글 번호
		if(lastRow<startRow)								
			lastRow = cntOfRow;
		int startPaging = (groupNo-1)*pagingSize+1;			//	하단영역 첫번째 페이징 번호
		int lastPaging = groupNo*pagingSize;				//	하단영역 마지막 페이징 번호
		if(lastPaging>countOfPaging)							
			lastPaging = countOfPaging;
		int prev = startPaging - 1;							//	이전버튼 클릭시 넘어가는 페이징 번호
		if(prev<1) prev = -1;
		int next = lastPaging + 1;							//	다음버튼 클릭시 넘어가는 페이징 번호
		if(next>countOfPaging) next=-1;
		Pagination pagination = new Pagination();
		pagination.setLastPaging(lastPaging);
		pagination.setLastRow(lastRow);
		pagination.setNext(next);
		pagination.setPageNo(pageNo);
		pagination.setPrev(prev);
		pagination.setStartPaging(startPaging);
		pagination.setStartRow(startRow);
		return pagination;
	}
}
