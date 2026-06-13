package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hostel.model.Room;
import com.hostel.util.DBConnection;

public class RoomDAO {
	public boolean addRoom(Room room) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	                "INSERT INTO rooms(room_number,floor_no,room_type,capacity,occupied_beds,status) VALUES(?,?,?,?,?,?)";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setString(1, room.getRoomNumber());
	        ps.setInt(2, room.getFloorNo());
	        ps.setString(3, room.getRoomType());
	        ps.setInt(4, room.getCapacity());
	        ps.setInt(5, room.getOccupiedBeds());
	        ps.setString(6, room.getStatus());

	        int rows = ps.executeUpdate();

	        if(rows > 0) {
	            status = true;
	        }

	        con.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	public List<Room> getAllRooms() {

	    List<Room> rooms = new ArrayList<>();

	    try {

	        Connection con = DBConnection.getConnection();

	        String query = "SELECT * FROM rooms";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {

	            Room room = new Room();

	            room.setRoomId(
	                    rs.getInt("room_id"));

	            room.setRoomNumber(
	                    rs.getString("room_number"));

	            room.setFloorNo(
	                    rs.getInt("floor_no"));

	            room.setRoomType(
	                    rs.getString("room_type"));

	            room.setCapacity(
	                    rs.getInt("capacity"));

	            room.setOccupiedBeds(
	                    rs.getInt("occupied_beds"));

	            room.setStatus(
	                    rs.getString("status"));

	            rooms.add(room);
	        }

	        con.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return rooms;
	}
	public boolean updateRoom(Room room) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	                "UPDATE rooms SET room_number=?, floor_no=?, room_type=?, capacity=?, occupied_beds=?, status=? WHERE room_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setString(1, room.getRoomNumber());
	        ps.setInt(2, room.getFloorNo());
	        ps.setString(3, room.getRoomType());
	        ps.setInt(4, room.getCapacity());
	        ps.setInt(5, room.getOccupiedBeds());
	        ps.setString(6, room.getStatus());
	        ps.setInt(7, room.getRoomId());

	        int rows = ps.executeUpdate();

	        if(rows > 0) {
	            status = true;
	        }

	        con.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	public boolean deleteRoom(int roomId) {

	    boolean status = false;

	    try {

	        Connection con = DBConnection.getConnection();

	        String query =
	                "DELETE FROM rooms WHERE room_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setInt(1, roomId);

	        int rows = ps.executeUpdate();

	        if(rows > 0) {
	            status = true;
	        }

	        con.close();

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return status;
	}
	
	public Room getRoomById(int roomId) {

	    Room room = null;

	    try {

	        Connection con =
	                DBConnection.getConnection();

	        String query =
	                "SELECT * FROM rooms WHERE room_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setInt(1, roomId);

	        ResultSet rs =
	                ps.executeQuery();

	        if(rs.next()) {

	            room = new Room();

	            room.setRoomId(
	                    rs.getInt("room_id"));

	            room.setRoomNumber(
	                    rs.getString("room_number"));

	            room.setFloorNo(
	                    rs.getInt("floor_no"));

	            room.setRoomType(
	                    rs.getString("room_type"));

	            room.setCapacity(
	                    rs.getInt("capacity"));

	            room.setOccupiedBeds(
	                    rs.getInt("occupied_beds"));

	            room.setStatus(
	                    rs.getString("status"));
	        }

	        con.close();

	    } catch(Exception e) {

	        e.printStackTrace();
	    }

	    return room;
	}
}
