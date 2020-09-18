package model;

import java.time.LocalDate;
import java.util.Date;

public class EducationData {
	private String id;
	private String eduType;
	private String uni_Board;
	private String registNum;
	private int marks;
	private LocalDate  year;
	private String userId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEduType() {
		return eduType;
	}
	public void setEduType(String eduType) {
		this.eduType = eduType;
	}
	public String getUni_Board() {
		return uni_Board;
	}
	public void setUni_Board(String uni_Board) {
		this.uni_Board = uni_Board;
	}
	public String getRegistNum() {
		return registNum;
	}
	public void setRegistNum(String registNum) {
		this.registNum = registNum;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public LocalDate getYear() {
		return year;
	}
	public void setYear(LocalDate year) {
		this.year = year;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
	
	
}
