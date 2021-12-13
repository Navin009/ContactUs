package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Request;

public class RequestDao {
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String EMAIL = "email";
	private static final String MESSAGE = "message";
	private static final String ARCHIVED = "archived";

	public List<Request> getAllActiveRequests() {
		Connection connection = DBConnection.getConnection();
		List<Request> requests = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM feedback WHERE archived = 0");

			while (resultSet.next()) {
				Request request = new Request();
				request.setId(resultSet.getInt(ID));
				request.setName(resultSet.getString(NAME));
				request.setEmail(resultSet.getString(EMAIL));
				request.setMessage(resultSet.getString(MESSAGE));
				request.setArchived(resultSet.getBoolean(ARCHIVED));

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
			ResultSet resultSet = statement.executeQuery("SELECT * FROM feedback WHERE archived = 1");

			while (resultSet.next()) {
				Request request = new Request();
				request.setId(resultSet.getInt(ID));
				request.setName(resultSet.getString(NAME));
				request.setEmail(resultSet.getString(EMAIL));
				request.setMessage(resultSet.getString(MESSAGE));
				request.setArchived(resultSet.getBoolean(ARCHIVED));

				requests.add(request);
			}

			return requests;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateRequest(int id, String status) {
		Connection connection = DBConnection.getConnection();

		try {
			Statement statement = connection.createStatement();

			if (status.equals("active")) {
				int result = statement.executeUpdate("UPDATE feedback SET archived = " + 1 + " WHERE id = " + id);

				if (result == 1) {
					return true;
				} else {
					return false;
				}
			} else {
				int result = statement.executeUpdate("UPDATE feedback SET archived = " + 0 + " WHERE id = " + id);

				if (result == 1) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
