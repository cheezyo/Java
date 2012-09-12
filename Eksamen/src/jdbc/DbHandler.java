package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;


public class DbHandler{
	
	private ConnectToDB db;
	private Connection con;
	private CallableStatement call_statement;
	
	public DbHandler(String username, String password) {
	        db = new ConnectToDB(username, password);
	        con = db.getConnection();
	}
	
	// CREATE 
	public String createUser(Foo obj){
	  String call = "{call new_foobar(?, ?)}";
	
	  try {
	    call_statement = con.prepareCall(call);
	
	    call_statement.setString(1, obj.getBar());
	    call_statement.setString(2, obj.getFooBar());
	
	    call_statement.execute();
	
	    return "Success, a new foobar was created.\n";      
	  } catch (SQLException e) {
	    e.printStackTrace();
	    return "Something went wrong. No user was created.\n";
	  }
	}
	
	// UPDATE 
	public String update(int pk, Foo obj){
	       String call = "{call update_foobar(?, ?, ?)}";
	       try {
	              call_statement = con.prepareCall(call);
	
	              call_statement.setInt(1, pk);
	              call_statement.setString(2, obj.getBar());
	              call_statement.setString(3, obj.getFooBar());
	
	              call_statement.execute();
	
	              return "User [" + pk + "] was updated.\n";
	        } catch (SQLException e) {
	              e.printStackTrace();
	        return "Something went wrong. User was not updated.\n";
	  }
	}
	
	// DELETE 
	public String deleteProduct(int pk){
	  String call = "{call delete_foobar(?)}";
	  try {
	    call_statement = con.prepareCall(call);
	
	    call_statement.setInt(1, pk);
	
	    call_statement.execute();
	    return "Product [" + pk + "] was deleted.\n";
	  } catch (SQLException e) {
	    e.printStackTrace();
	    return "Something went wrong. The product was not deleted.";
	  }
	}
}