package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class ContactUsDao {
    boolean result = false;

    public boolean insertContactUs(String name, String email, String message) {
    	String timeStamp = new Date().toString();

    	try {
            String sql = "INSERT INTO feedback(name,email,message,time_stamp) VALUES(?,?,?,?)";
            Connection connection = DBConnection.getConnection();
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, message);
            preparedStatement.setString(4, timeStamp);
            
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
