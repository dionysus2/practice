package dionysus.wine.vo;

import lombok.Data;

@Data
public class ResReview {
	   private int resReviewId;
	   private String resReviewContent;
	   private int resReviewRatings;
	   private int resInfoId;
	   private int customerId;

}
