package dionysus.wine.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WineInfo {
	private int wineInfoId; 				// 와인정보 기본키(아이디)
	private String wineInfoName; 			// 와인정보 이름
	private String wineInfoProfilePicture; 	// 와인정보 대표이미지
	private int wineInfoPrice; 				// 와인정보 가격
	private String wineInfoCapacity; 		// 와인정보 용량
	private String wineInfoCountry; 		// 와인정보 생산국가
	private String wineInfoRegion; 			// 와인정보 생산지
	private String wineInfoWinery; 			// 와인정보 제조사
	private String wineInfoImporter; 		// 와인정보 수입사
	private String wineInfoVintage; 		// 와인정보 빈티지
	private String wineInfoGrapes; 			// 와인정보 품종
	private String wineInfoABV; 			// 와인정보 알코올 도수
	private String wineInfoType; 			// 와인정보 종류
	private String wineInfoClassification; 	// 와인정보 등급
	private String wineInfoFlavors; 		// 와인정보 향
	private String wineInfoSweetness; 		// 와인정보 당도
	private String wineInfoAcidity; 		// 와인정보 산도
	private String wineInfoBody; 			// 와인정보 바디
	private int wineSellerId; 				// 와인업주 테이블 외래키

	public WineInfo(String wineInfoName, String wineInfoProfilePicture, int wineInfoPrice, String wineInfoCapacity,
			String wineInfoCountry, String wineInfoRegion, String wineInfoWinery, String wineInfoImporter,
			String wineInfoVintage, String wineInfoGrapes, String wineInfoABV, String wineInfoType,
			String wineInfoClassification, String wineInfoFlavors, String wineInfoSweetness, String wineInfoAcidity,
			String wineInfoBody, int wineSellerId) {
		super();
		this.wineInfoName = wineInfoName;
		this.wineInfoProfilePicture = wineInfoProfilePicture;
		this.wineInfoPrice = wineInfoPrice;
		this.wineInfoCapacity = wineInfoCapacity;
		this.wineInfoCountry = wineInfoCountry;
		this.wineInfoRegion = wineInfoRegion;
		this.wineInfoWinery = wineInfoWinery;
		this.wineInfoImporter = wineInfoImporter;
		this.wineInfoVintage = wineInfoVintage;
		this.wineInfoGrapes = wineInfoGrapes;
		this.wineInfoABV = wineInfoABV;
		this.wineInfoType = wineInfoType;
		this.wineInfoClassification = wineInfoClassification;
		this.wineInfoFlavors = wineInfoFlavors;
		this.wineInfoSweetness = wineInfoSweetness;
		this.wineInfoAcidity = wineInfoAcidity;
		this.wineInfoBody = wineInfoBody;
		this.wineSellerId = wineSellerId;
	}
}
