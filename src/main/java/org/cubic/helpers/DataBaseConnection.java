package org.cubic.helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

		
		public static Connection createConnection () {
			try {
				
			Class.forName ("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ce ) {
			System.out.println("Cannot find the driver");
		}
			Connection conn =null;
			try {
				 conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/ban_database","root","pokharaC3trb98k");
				
			}catch(SQLException sqe) {
				System.out.println("could not create connection");
				sqe.printStackTrace();
			}
			return conn;

	}

}

