package com.hostel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hostel.util.DBConnection;

public class AdminDAO {

    public boolean login(String username,
                         String password) {

        boolean status = false;

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM admin WHERE username=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {
                status = true;
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
}