package dionysus.wine.query;

public interface BasicInfoQuery {
	public String insert="INSERT INTO BASIC_INFO(BASIC_INFO_ID, BASIC_INFO_USERNAME, BASIC_INFO_PWD, BASIC_INFO_EMAIL)VALUES(BASIC_INFO_SEQ.NEXTVAL, ?, ?, ?)";
	public String login= "SELECT COUNT(*)FROM BASIC_INFO WHERE BASIC_INFO_USERNAME=? AND BASIC_INFO_PWD=?";
	public String basicInfoUsernameCheck="SELECT COUNT(*)FROM BASIC_INFO WHERE BASIC_INFO_USERNAME=?";
}
