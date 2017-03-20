package dionysus.wine.dao;

public interface ResInfoDAO {
	/* 
	 * 	- 레스토랑 정보 페이지별 리스트 조회				리턴						매개변수
	 * 		1. 레스토랑 정보 페이지별 리스트 조회		ArrayList<ResInfo>			Connection, 게시글, 게시글
	 * 		2. 레스토랑 정보 count조회						int						Connection		
	 * 	- 레스토랑 정보 업주별 조회
	 * 		3. 레스토랑 정보 업주별 조회					ResInfo					Connection, 레스토랑 회원번호
	 * 	- 레스토랑 정보 추가
	 * 		4. 레스토랑 정보 추가							int						Connection, ResInfo
	 * 	- 레스토랑 정보 삭제
	 * 		5. 레스토랑 정보 삭제							int						Connection, 레스토랑 회원번호
	 * 	- 레스토랑 정보 수정
	 * 		6. 레스토랑 정보 수정							int						Connection, ResInfo
	 * */
}
