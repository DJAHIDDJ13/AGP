package bde.persistence.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.ResultSetMetaData;

import business.island.Island;
import dao.IslandPersistence;

public class JdbcPersistence implements IslandPersistence 
{

	@Override
	public void dataInit() 
	{
		System.err.println("Please don't forget to create tables manually by importing creation.sql in your database !");
		
	}

	@Override
	public int persist(Island island) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void SelectTableTest() 
	{
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String selectAddressQuery = "SELECT * FROM hotel";

	     try 
	     {
	  	  preparedStatement = JdbcConnection.getConnection().prepareStatement(selectAddressQuery);
		  result = preparedStatement.executeQuery();
	     } catch (SQLException e) 
	     { System.err.println("Anomalie lors de l'execution de la requête");  }

	     //parcours des données retournées
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
	       };
	}
	
	public static ResultSet SelectTable(String tableName) 
	{
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		String selectAddressQuery = "SELECT * FROM "+tableName;

	     try 
	     {
	  	  preparedStatement = JdbcConnection.getConnection().prepareStatement(selectAddressQuery);
		  result = preparedStatement.executeQuery();
	     } catch (SQLException e) 
	     { System.err.println("Anomalie lors de l'execution de la requête");  }

	     return result;
	}
	
	 public static void main(String[] args)
	 {
	        System.out.println("Hello World !");
	        SelectTable("island");
	        System.out.println("Goodbye World !");
	 
	 }
	
	
}
