package inventar;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class DBHandler {

	private CallableStatement call_statement;
	private Connection con;
	
	
	public DBHandler(String bruker, String password){
		String call = "{call slett_inventar(?)}";
		try {
			call_statement = con.prepareCall(call);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String deleteInvetntar(int regNr){
		
		String melding ="";
		try{
			
			
			call_statement.setInt(1, regNr);
			call_statement.execute();
			melding = call_statement.getString(2);
			
		}catch(Exception e){
			melding = e.getMessage();
		}
		return melding;
		
		
	}
}
