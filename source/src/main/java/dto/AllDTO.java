package dto;

import java.io.Serializable;
import java.util.List;

public class AllDTO implements Serializable {
	
	//userテーブルのデータ-----------------------
	private int userId;
	private String id;
	private String pw;
	private String fName;
	private String lName;
	private String kfName;
	private String klName;
	private String birthday;
	private String gender;
	private String zipcode;
	private String address;
	private String email;
	private String phone;
	
	//sikijoテーブルのデータ-----------------------
	private int sikijoId;
	private String jmNumber;
	private String sName;
	private String sAddress;
	private String sImage;
	private String sPrice;
	//上記の３つの名前、他とかぶるからsを頭に付けたよ
	
	//courseテーブルのデータ-----------------------
	private int courseId;
	private String courseName;
	private String intro;
	private String cPrice;
	
	//optionテーブルのデータ-----------------------		 
	private int optionId;
	private String optionName;
	private String optionPrice;
	 private List<String> optionNames;
	
	//plannerテーブルのデータ-----------------------
	private int plannerId;
	private String pId;
	private String pPassword;
	private String pName;
	private String pGender;
	private String pPhone;
	private String sikiAdd;
	private String strongFild;
	private String pImage;
	//ほかと被るので、プランナーのやつにはpを頭に付けてみた
	
	//applyテーブルのデータ-----------------------
	private int applyId	;
	private String remarks;
	
	//scテーブルのデータ------------------------
	private int scId;
	
	//spテーブルのデータ------------------------
	private int spId;

	
	//☆以下、全てのセッターゲッター
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getkfName() {
		return kfName;
	}
	public void setkfName(String kfName) {
		this.kfName = kfName;
	}
	
	public String getklName() {
		return klName;
	}
	public void setklName(String klName) {
		this.klName = klName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSikijoId() {
		return sikijoId;
	}

	public void setSikijoId(int sikijoId) {
		this.sikijoId = sikijoId;
	}

	public String getJmNumber() {
		return jmNumber;
	}

	public void setJmNumber(String jmNumber) {
		this.jmNumber = jmNumber;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsImage() {
		return sImage;
	}

	public void setsImage(String sImage) {
		this.sImage = sImage;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getcPrice() {
		return cPrice;
	}

	public void setcPrice(String cPrice) {
		this.cPrice = cPrice;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	
	public String getOptionPrice() {
		return optionPrice;
	}

	public void setOptionPrice(String optionPrice) {
		this.optionPrice = optionPrice;
	}
	
	public List<String> getOptionNames() {
        return optionNames;
    }

    public void setOptionNames(List<String> optionNames) {
        this.optionNames = optionNames;
    }
	
	public int getPlannerId() {
		return plannerId;
	}

	public void setPlannerId(int plannerId) {
		this.plannerId = plannerId;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpPassword() {
		return pPassword;
	}

	public void setpPassword(String pPassword) {
		this.pPassword = pPassword;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpGender() {
		return pGender;
	}

	public void setpGender(String pGender) {
		this.pGender = pGender;
	}

	public String getpPhone() {
		return pPhone;
	}

	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}

	public String getSikiAdd() {
		return sikiAdd;
	}

	public void setSikiAdd(String sikiAdd) {
		this.sikiAdd = sikiAdd;
	}

	public String getsPrice() {
		return sPrice;
	}

	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}

	public String getStrongFild() {
		return strongFild;
	}

	public void setStrongFild(String strongFild) {
		this.strongFild = strongFild;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public int getApplyId() {
		return applyId;
	}

	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getScId() {
		return scId;
	}

	public void setScId(int scId) {
		this.scId = scId;
	}

	public int getSpId() {
		return spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public String getKfName() {
		return kfName;
	}

	public void setKfName(String kfName) {
		this.kfName = kfName;
	}

	public String getKlName() {
		return klName;
	}

	public void setKlName(String klName) {
		this.klName = klName;
	}


	
	
		
		
		
		
		

}
