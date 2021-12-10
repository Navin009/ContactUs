package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContactUsDao {
    boolean result = false;

    public boolean insertContactUs(String name, String email, String message) {
        try {
            String sql = "INSERT INTO feedback VALUES(?,?,?)";
            Connection connection = DBConnection.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, message);
            
            int res = preparedStatement.executeUpdate();
            
            if (res > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
