package dionysus.wine.vo;

import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class ResAuthorization {
	private int resId;
	private Date resAuthorizationDate;
	private String resAuthorizated;

	public ResAuthorization(int resId, Date resAuthorizationDate){
		this.resId = resId;
		this.resAuthorizationDate = resAuthorizationDate;
	}
}
