package com.hostel.model;

public class Room {
	private int roomId;
	private String roomNumber;
	private int floorNo;
	private String roomType;
	private int capacity;
	private int occupiedBeds;
	private String status;
	
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getFloorNo() {
		return floorNo;
	}
	public void setFloorNo(int floorNo) {
		this.floorNo = floorNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getOccupiedBeds() {
		return occupiedBeds;
	}
	public void setOccupiedBeds(int occupiedBeds) {
		this.occupiedBeds = occupiedBeds;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
