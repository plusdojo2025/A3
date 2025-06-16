package dto;

public class SikijoDTO {

	
	private int sikijoId;
	private String sikijoName;
	private String jmNumber;
	private String comment;
	
	//ゲッターセッター
	public int getSikijoId() {
		return sikijoId;
	}
	public void setSikijoId(int sikijoId) {
		this.sikijoId = sikijoId;
	}
	public String getSikijoName() {
		return sikijoName;
	}
	public void setSikijoName(String sikijoName) {
		this.sikijoName = sikijoName;
	}
	public String getJmNumber() {
		return jmNumber;
	}
	public void setJmNumber(String jmNumber) {
		this.jmNumber = jmNumber;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
