import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.cubic.helpers.DataBaseConnection;

public class MainApplication {

	public static void main(String[] args) {
		System.out.println("First test run");
		DataBaseConnection.createConnection();
		Connection c = DataBaseConnection.createConnection();
		
		String insertSql = "insert into customers(first_name,last_name,phone,email,address,gender,dob)\n" + 
				"values('Tribhuvan', 'Bastola', 3016054621,'tbbastola@gmail.com', '19063 Stedwick MD,20886','M',' 1995-03-25');";
		Statement stnt = null;
		try {
			 stnt = c.createStatement();
			stnt.executeUpdate(insertSql);
		}catch (Exception e) {
			e.printStackTrace();
		}

String selectSql = "select first_name,last_name,phone from customer";
try {
	ResultSet rs =stnt.executeQuery(selectSql);
	while (rs.next ()) {
		String firstName =rs.getString ("first_name");
		String lastName =rs.getString ("last_name");
		int phone = rs.getInt("phone");
		String email =rs.getString("email");
		System.out.println("Name :" +firstName+" " + lastName+"phone: " +phone + "email:"+ email);
		
	}
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	try {
		c.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	String updateSql ="update customers set first_name= 'Tribhuvan' where first_name = 'lok'";
	try {
		stnt.executeUpdate(updateSql);
		c.close();
	}catch (Exception e) {
		
	}
	
	}

}
//finally

