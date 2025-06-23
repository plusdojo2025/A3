package dto;

public class SikijoDTO {

	
	private int sikijoId;
	private String jmNumber;
	private String name;
	private String address;
	private String image;
	private String sikijoPrice;
	
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSikijoPrice() {
		return sikijoPrice;
	}
	public void setSikijoPrice(String sikijoPrice) {
		this.sikijoPrice = sikijoPrice;
	}
}
