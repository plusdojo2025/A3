package dto;

import java.io.Serializable;

public class ApplyDTO implements Serializable {
	private int applyId;
	private int userId;
	private int plannerId;
	private int sikijoId;
	private int courseId;
	private int optionId;
	
	
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getPlannerId() {
		return plannerId;
	}
	public void setPlannerId(int plannerId) {
		this.plannerId = plannerId;
	}
	
	public int getSikijoId() {
		return sikijoId;
	}
	public void setSikijoId(int sikijoId) {
		this.sikijoId = sikijoId;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public int getOptionId() {
		return optionId;
	}
	public void setOptioneId(int optionId) {
		this.optionId = optionId;
	}	
	
}
