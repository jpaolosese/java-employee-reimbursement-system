package com.revature.dao;

import com.revature.model.User;
import com.revature.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // use for login
    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String un = rs.getString("username");
            String pw = rs.getString("password");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            String role = rs.getString("role");

            User user = new User(un, pw, firstName, lastName, email, age, role);
            return user;
        }

        return null;
    }

    // use to register
    public void addUser(User user) throws SQLException {
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement ps
                = con.prepareStatement("INSERT INTO users (username, password, first_name, last_name, email, age, role)"
        + " VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getFirstName());
        ps.setString(4, user.getLastName());
        ps.setString(5, user.getEmail());
        ps.setInt(6, user.getAge());
        ps.setString(7, user.getRole());

        int recordInserted = ps.executeUpdate();
    }
}
