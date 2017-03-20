package dionysus.wine.vo;

import lombok.Data;

@Data
public class WineReview {
	private int wineReviewId;
    private String wineReviewContent;
    private int wineReviewRatings;
    private int customerId;
    private int wineInfoId;

}
