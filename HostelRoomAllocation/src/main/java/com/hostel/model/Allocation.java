package com.hostel.model;

public class Allocation {
	private int allocationId;
	private int studentId;
	private int roomId;
	private java.sql.Date allocationDate;
	private String status;
	private String studentName;
	private String roomNumber;
	
	
	public int getAllocationId() {
		return allocationId;
	}
	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public java.sql.Date getAllocationDate() {
		return allocationDate;
	}
	public void setAllocationDate(java.sql.Date allocationDate) {
		this.allocationDate = allocationDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
}
