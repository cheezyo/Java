package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import pojo.Days;

import dbConnection.ConnectToDB;

public class dbHandler {

	private ConnectToDB db;
	private Connection con;
	private ResultSet rs;
	private ResultSetMetaData rsmd;

	public dbHandler(String user, String password) {
		db = new ConnectToDB(user, password);
		con = db.getConnection();

	}

	public void close() {
		db.closeConnection();
	}

	public ArrayList<String> getMetaData(String table) {
		ArrayList<String> metaData = new ArrayList<String>();
		try {
			rsmd = getAll(table).getMetaData();
			int rows = rsmd.getColumnCount();
			
			for(int i = 0; i < rows; i++){
				metaData.add(rsmd.getColumnName(i+1));
			}
			
			return metaData;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ResultSet getAll(String table) {
		Statement stmt;
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			String sql = "Select * from " + table;
			rs = stmt.executeQuery(sql);
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		

		return null;
	}

	public ArrayList<Days> getTable(String table) {

		try {
			Statement stmt = con
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

			String sql = "Select * from " + table;
			rs = stmt.executeQuery(sql);

			ArrayList<Days> bookList = new ArrayList<Days>();

			while (rs.next()) {
				Days b = new Days(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));

				bookList.add(b);
			}
			return bookList;

		} catch (SQLException e) {
			System.out.println("Klarte ikke hente books");
			e.printStackTrace();
		}

		return null;

	}
	public void insert(){
		try {
			Statement stmt = con.createStatement();
			String sql = ("Insert into diary Values ( 2,5, 5, 5, 5, 5, 5, 5)");
			stmt.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(String column, String value, int row){
		try {
			row++;
			column.toLowerCase();
			value.toLowerCase();
			Statement stmt = con.createStatement();
			String sql = "Update diary Set " +  column + " = " + "'" + value + "'" + " Where id = " + "'" + row + "'";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int row){
		try {
			Statement stmt = con.createStatement();
			row++;
			String sql = "Delete from diary where id = " + "'" + row + "'";
			stmt.executeUpdate(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
