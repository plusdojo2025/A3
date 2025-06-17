package dto;

public class SikijoDTO {

	
	private int sikijoId;
	private String jmNumber;
	private String name;
	private String address;
	private String image;
	
	//ゲッターセッター
	public int getSikijoId() {
		return sikijoId;
	}
	public void setSikijoId(int sikijoId) {
		this.sikijoId = sikijoId;
	}
	public String getSikijoJmNumber() {
		return jmNumber;
	}
	public void setSikijoJmNumber(String jmNumber) {
		this.jmNumber = jmNumber;
	}
	public String getSikijoName() {
		return name;
	}
	public void setSikijoName(String sikijoName) {
		this.name = sikijoName;
	}
	public String getSikijoAddress() {
		return address;
	}
	public void setSikijoAddress(String sikijoAddress) {
		this.address = sikijoAddress;
	}
	public String getSikijoImage() {
		return image;
	}
	public void setSikijoImage(String sikijoImage) {
		this.image = sikijoImage;
	}
}
