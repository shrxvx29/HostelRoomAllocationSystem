
package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hostel.model.Allocation;
import com.hostel.util.DBConnection;

public class AllocationDAO {

    // Allocate Room

    public boolean allocateRoom(Allocation allocation) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            // Check Duplicate Allocation

            String checkStudent =
                    "SELECT * FROM allocations WHERE student_id=? AND status='Active'";

            PreparedStatement ps1 =
                    con.prepareStatement(checkStudent);

            ps1.setInt(1, allocation.getStudentId());

            ResultSet rs1 =
                    ps1.executeQuery();

            if(rs1.next()) {

                System.out.println(
                        "Student already allocated");

                return false;
            }

            // Check Room Capacity

            String roomCheck =
                    "SELECT capacity,occupied_beds FROM rooms WHERE room_id=?";

            PreparedStatement ps2 =
                    con.prepareStatement(roomCheck);

            ps2.setInt(1, allocation.getRoomId());

            ResultSet rs2 =
                    ps2.executeQuery();

            if(rs2.next()) {

                int capacity =
                        rs2.getInt("capacity");

                int occupiedBeds =
                        rs2.getInt("occupied_beds");

                if(occupiedBeds >= capacity) {

                    System.out.println(
                            "Room Full");

                    return false;
                }
            }

            // Insert Allocation

            String query =
                    "INSERT INTO allocations(student_id,room_id,allocation_date,status) VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, allocation.getStudentId());
            ps.setInt(2, allocation.getRoomId());
            ps.setDate(3, allocation.getAllocationDate());
            ps.setString(4, allocation.getStatus());

            int rows =
                    ps.executeUpdate();

            if(rows > 0) {

                // Increase Occupied Beds

                String updateRoom =
                        "UPDATE rooms SET occupied_beds=occupied_beds+1 WHERE room_id=?";

                PreparedStatement ps3 =
                        con.prepareStatement(updateRoom);

                ps3.setInt(1,
                        allocation.getRoomId());

                ps3.executeUpdate();

                // Update Room Status

                String roomStatus =
                        """
                        UPDATE rooms
                        SET status =
                        CASE
                            WHEN occupied_beds >= capacity THEN 'Full'
                            ELSE 'Available'
                        END
                        WHERE room_id=?
                        """;

                PreparedStatement ps4 =
                        con.prepareStatement(roomStatus);

                ps4.setInt(1,
                        allocation.getRoomId());

                ps4.executeUpdate();

                status = true;
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }

    // Get All Allocations

    public List<Allocation> getAllAllocations() {

        List<Allocation> allocations =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM allocations";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Allocation allocation =
                        new Allocation();

                allocation.setAllocationId(
                        rs.getInt("allocation_id"));

                allocation.setStudentId(
                        rs.getInt("student_id"));

                allocation.setRoomId(
                        rs.getInt("room_id"));

                allocation.setAllocationDate(
                        rs.getDate("allocation_date"));

                allocation.setStatus(
                        rs.getString("status"));

                allocations.add(allocation);
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return allocations;
    }

    // Allocation Details With Names

    public List<Allocation> getAllocationDetails() {

        List<Allocation> allocations =
                new ArrayList<>();

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    """
                    SELECT a.*,
                           s.student_name,
                           r.room_number
                    FROM allocations a
                    JOIN students s
                    ON a.student_id = s.student_id
                    JOIN rooms r
                    ON a.room_id = r.room_id
                    """;

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                Allocation allocation =
                        new Allocation();

                allocation.setAllocationId(
                        rs.getInt("allocation_id"));

                allocation.setStudentId(
                        rs.getInt("student_id"));

                allocation.setRoomId(
                        rs.getInt("room_id"));

                allocation.setAllocationDate(
                        rs.getDate("allocation_date"));

                allocation.setStatus(
                        rs.getString("status"));

                allocation.setStudentName(
                        rs.getString("student_name"));

                allocation.setRoomNumber(
                        rs.getString("room_number"));

                allocations.add(allocation);
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return allocations;
    }

    // Vacate Room

    public boolean vacateRoom(int allocationId) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String getRoom =
                    "SELECT room_id FROM allocations WHERE allocation_id=?";

            PreparedStatement ps1 =
                    con.prepareStatement(getRoom);

            ps1.setInt(1,
                    allocationId);

            ResultSet rs =
                    ps1.executeQuery();

            int roomId = 0;

            if(rs.next()) {

                roomId =
                        rs.getInt("room_id");
            }

            String updateAllocation =
                    "UPDATE allocations SET status='Vacated' WHERE allocation_id=?";

            PreparedStatement ps2 =
                    con.prepareStatement(updateAllocation);

            ps2.setInt(1,
                    allocationId);

            int rows =
                    ps2.executeUpdate();

            if(rows > 0) {

                String updateRoom =
                        "UPDATE rooms SET occupied_beds=occupied_beds-1 WHERE room_id=?";

                PreparedStatement ps3 =
                        con.prepareStatement(updateRoom);

                ps3.setInt(1,
                        roomId);

                ps3.executeUpdate();

                String roomStatus =
                        "UPDATE rooms SET status='Available' WHERE room_id=?";

                PreparedStatement ps4 =
                        con.prepareStatement(roomStatus);

                ps4.setInt(1,
                        roomId);

                ps4.executeUpdate();

                status = true;
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }
}

