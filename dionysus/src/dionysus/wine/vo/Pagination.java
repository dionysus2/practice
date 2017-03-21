package dionysus.wine.vo;

import lombok.Data;

@Data
public class Pagination {
	private int pageNo;
	private int startPage;
	private int lastPage;
	private int startRow;
	private int lastRow;
	private int prev;
	private int next;
}
