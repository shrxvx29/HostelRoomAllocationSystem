package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hostel.util.DBConnection;

public class DashboardDAO {

    // Total Students

    public int getStudentCount() {

        return getCount(
                "SELECT COUNT(*) FROM students");
    }

    // Total Rooms

    public int getRoomCount() {

        return getCount(
                "SELECT COUNT(*) FROM rooms");
    }

    // Available Rooms

    public int getAvailableRoomCount() {

        return getCount(
                "SELECT COUNT(*) FROM rooms WHERE status='Available'");
    }

    // Full Rooms

    public int getFullRoomCount() {

        return getCount(
                "SELECT COUNT(*) FROM rooms WHERE status='Full'");
    }

    // Active Allocations

    public int getActiveAllocationCount() {

        return getCount(
                "SELECT COUNT(*) FROM allocations WHERE status='Active'");
    }

    // Common Method

    private int getCount(String query) {

        int count = 0;

        try {

            Connection con =
                    DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                count = rs.getInt(1);
            }

            con.close();

        } catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }
}