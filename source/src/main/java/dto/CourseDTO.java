package dto;

public class CourseDTO {

	
	private int courseId; //コースID
	private String courseName; //コース名
	private int jmNumber; //和洋とかのやつ
	private String comment; //コース詳細
	private String option1; 
	private String option2;
	private String option3;
	
	
	//以下ゲッターセッター
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
	public int getJmNumber() {
		return jmNumber;
	}
	public void setJmNumber(int jmNumber) {
		this.jmNumber = jmNumber;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	
	
}
