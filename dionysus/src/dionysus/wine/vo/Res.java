package dionysus.wine.vo;

import lombok.Data;

@Data
public class Res {
	private int resId;
	private String resBrn;
	private String resLocation;
	private String resTel;
	private String resAccountNo;
	private String resProfilePicture;
	private String resActivated;
	private String resName;
	private int basicInfoId;
	public Res(String basicInfoUsername, String basicInfoPwd, String basicInfoEmail) {
		super();
		this.basicInfoUsername = basicInfoUsername;
		this.basicInfoPwd = basicInfoPwd;
		this.basicInfoEmail = basicInfoEmail;
	}
}
