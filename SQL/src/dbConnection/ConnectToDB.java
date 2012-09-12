package dbConnection;

import java.sql.*;
import java.sql.SQLException;

public class ConnectToDB {
	private Connection con;
	
	public ConnectToDB (String bruker, String passord){
		String url = "jdbc:mysql://mysql.nith.no/" + bruker;
		try {
			con =  DriverManager.getConnection(url, bruker, passord);
			System.out.println("ConnectToDB: Kontakt!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean closeConnection(){
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(NullPointerException e){
		
		}
		return false;
	}
	
	public Connection getConnection(){
		return con;
	}

}
