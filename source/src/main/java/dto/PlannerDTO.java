package dto;

public class PlannerDTO {

	private int plannerId;
	private String id;
	private String password;
	private String plannerName;
	private String gender;
	private String phone;
	private String sikiAdd;
	private String strongFild;
	private String img;
	
	
	//ゲッターセッター(ゲトリタ、セトディス)
	public int getPlannerId() {
		return plannerId;
	}
	public void setPlannerId(int plannerId) {
		this.plannerId = plannerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPlannerName() {
		return plannerName;
	}
	public void setPlannerName(String plannerName) {
		this.plannerName = plannerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSikiAdd() {
		return sikiAdd;
	}
	public void setSikiAdd(String sikiAdd) {
		this.sikiAdd = sikiAdd;
	}
	public String getStrongFild() {
		return strongFild;
	}
	public void setStrongFild(String strongFild) {
		this.strongFild = strongFild;
	}
	public String getImage() {
		return img;
	}
	public void setImage(String img) {
		this.img = img;
	}
	
	
}