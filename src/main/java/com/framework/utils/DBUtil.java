package com.framework.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DBUtil {
	
	private DBUtil() {}	
	
	public static final Logger log = LogManager.getLogger(DBUtil.class);

	public static Connection getConnection(String host, String username, String password, String driverClass)
			throws SQLException, ClassNotFoundException {
		Class.forName(driverClass);
		return DriverManager.getConnection(host, username, password);
	}

	public static void executeWithNoResultSetUpdate(String host, String username, String password, String driverClass,
			String query) {

		try (Connection connection = getConnection(host, username, password, driverClass);
				Statement stmt = connection.createStatement();) {

			stmt.executeUpdate(query);

		} catch (ClassNotFoundException | SQLException e) {
			log.error(e.getMessage());
		}

	}

	public String executeWithResultSet(String host, String username, String password, String driverClass,
			String query) {
		ResultSet rs = null;
		String quertOutput = null;
		try (Connection connection = getConnection(host, username, password, driverClass);
				Statement stmt = connection.createStatement();) {

			rs = stmt.executeQuery(query);
			
			rs.getStatement();

			while (rs.next()) {
					
				 quertOutput = rs.getString(1);
				
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource(rs);
		}
		return quertOutput;

	}

	private static void closeResource(AutoCloseable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

	}

}
