package org.example.ch5;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class UserDao {

    public void create(User user) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = ConnectionManager.getConnection();
            String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getName());
            pstmt.setString(4, user.getEmail());

            pstmt.executeUpdate();
        }finally {
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        }
    }

    public User findById(String userId) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        User user = null;
        try{
            conn = ConnectionManager.getConnection();
            String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            if(rs.next())
                user = new User(rs.getString("userId"),
                                rs.getString("password"),
                                rs.getString("name"),
                                rs.getString("email")
                                );
        }finally {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        }

        return user;
    }
}
