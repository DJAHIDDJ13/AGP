package bde.persistence.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtility {
	
	public static ResultSet request(String query) {
			
		PreparedStatement preparedStatement = null;
		ResultSet result = null;	
	
		try {
			preparedStatement = JdbcConnection.getConnection().prepareStatement(query);
	  	    result = preparedStatement.executeQuery();
	        }catch (SQLException e) { 
	        	e.printStackTrace();
	        }
	
	     return result;
	}
	

	
	
	
	

}

