package dionysus.wine.vo;

import java.sql.Date;
import lombok.Data;

@Data
public class ResAuthorization {
	private int resId;
	private Date resAuthorizationDate;
	private String resAuthorizated;

}
