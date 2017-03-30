package dionysus.wine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WineReview {
	private int wineReviewId;
    private String wineReviewContent;
    private int wineReviewRatings;
    private int customerId;
    private int wineInfoId;
	public WineReview(String wineReviewContent, int wineReviewRatings) {
		super();
		this.wineReviewContent = wineReviewContent;
		this.wineReviewRatings = wineReviewRatings;
	}
}
