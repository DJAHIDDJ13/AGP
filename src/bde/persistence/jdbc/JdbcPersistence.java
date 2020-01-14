package bde.persistence.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetMetaData;

import bde.dao.Persistence;

public class JdbcPersistence implements Persistence{

	@Override
	public void dataInit() {
		System.err.println("Please don't forget to create tables manually by importing creation.sql in your database !");
		
	}
	
	public static void SelectTableTest() {
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String selectAddressQuery = "SELECT * FROM hotel";

	     try {
	  	  preparedStatement = JdbcConnection.getConnection().prepareStatement(selectAddressQuery);
		  result = preparedStatement.executeQuery();
	     } catch (SQLException e) {
	    	 System.err.println("Anomalie lors de l'execution de la requête");  
	     }

	     System.out.println("parcours des données retournées");
	       try {
	          ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
	          int nbCols = rsmd.getColumnCount();
	          boolean encore = result.next();

	          while (encore) {

	             for (int i = 1; i <= nbCols; i++)
	                System.out.print(result.getString(i) + " ");
	             System.out.println();
	             encore = result.next();
	          }

	          result.close();
	       } catch (SQLException e) {
	    	   System.err.println(e.getMessage());
	       }
	}
	
	private static ResultSet request(String tableName) {
		
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String selectAddressQuery = "SELECT * FROM "+tableName;

	     try {
	  	  preparedStatement = JdbcConnection.getConnection().prepareStatement(selectAddressQuery);
		  result = preparedStatement.executeQuery();
	     } catch (SQLException e) { 
	    	 System.err.println("Anomalie lors de l'execution de la requête");  
	     }

	     return result;
	}
}