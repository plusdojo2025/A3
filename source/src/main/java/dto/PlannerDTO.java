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
	private String image;
	
	//ゲッターセッター(ゲトリタ、セトディス)
	public int getPlannerId() { //??????????
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
	public String getPlannerGender() {
		return gender ;
	}
	public void setPlannerGender(String plannerGender) {
		this.gender = plannerGender;
	}
	public String getPlannerPhone() {
		return phone ;
	}
	public void setPlannerPhone(String plannerPhone) {
		this.phone = plannerPhone;
	}
	public String getPlannerSikiAdd() {
		return sikiAdd ;
	}
	public void setPlannerSikiAdd(String plannerSikiAdd) {
		this.sikiAdd = plannerSikiAdd;
	}
	public String getPlannerStrongFild() {
		return strongFild ;
	}
	public void setPlannerStrongFild(String plannerStrongFild) {
		this.strongFild = plannerStrongFild;
	}
	public String getPlannerImage() {
		return image ;
	}
	public void setPlannerImage(String plannerImage) {
		this.image = plannerImage;
	}
}
