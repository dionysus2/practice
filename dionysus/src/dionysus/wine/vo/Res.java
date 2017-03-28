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
	public Res(int resId, String resBrn, String resLocation,String resTel, String resAccountNo, 
			String resProfilePicture,String resActivated ,String resName,int basicInfoId) {
		super();
		this.resId = resId;
		this.resBrn = resBrn;
		this.resTel = resTel;
		this.resAccountNo = resAccountNo;
		this.resProfilePicture = resProfilePicture;
		this.resActivated = resActivated;
		this.resName = resName;
		this.basicInfoId = basicInfoId;		
	}
	 public Res(String resLocation, String resTel, String resAccountNo, String resProfilePictiure, String resName,int resId){
		 	this.resLocation = resLocation;
			this.resTel = resTel;
			this.resAccountNo = resAccountNo;
			this.resProfilePicture = resProfilePictiure;
			this.resName = resName;
			this.resId = resId;
	 }

}
