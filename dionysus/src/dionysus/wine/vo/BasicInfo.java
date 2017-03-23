package dionysus.wine.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BasicInfo {
	private String basicInfoId;
	private String basicInfoUsername;
	private String basicInfoPwd;
	private String basicInfoEmail;
	public BasicInfo(String basicInfoUsername, String basicInfoPwd, String basicInfoEmail) {
		super();
		this.basicInfoUsername = basicInfoUsername;
		this.basicInfoPwd = basicInfoPwd;
		this.basicInfoEmail = basicInfoEmail;
	}
}
