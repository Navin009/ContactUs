package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RequestDao {
    public List<Request> getAllActiveRequests() {
        Connection connection = DBConnection.getConnection();
        List<Request> requests = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM feedback WHERE active = 0");
            while (resultSet.next()) {
                Request request = new Request();
                request.setId(resultSet.getInt("id"));
                request.setName(resultSet.getString("name"));
                request.setEmail(resultSet.getString("email"));
                request.setMessage(resultSet.getString("message"));
                request.setArchived(resultSet.getBoolean("archived"));

                requests.add(request);
            }

            return requests;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Request> getAllArchiveRequests() {
        Connection connection = DBConnection.getConnection();

        List<Request> requests = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM feedback WHERE active = 1");
            while (resultSet.next()) {
                Request request = new Request();
                request.setId(resultSet.getInt("id"));
                request.setName(resultSet.getString("name"));
                request.setEmail(resultSet.getString("email"));
                request.setMessage(resultSet.getString("message"));
                request.setArchived(resultSet.getBoolean("archived"));

                requests.add(request);
            }

            return requests;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
