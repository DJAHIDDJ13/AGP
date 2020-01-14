package bde.iterator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetMetaData;

import bde.persistence.jdbc.JdbcConnection;

public class OperatorSQL implements Iterator{

	private ResultSet head;
	
	private String query;
	
	public OperatorSQL(String query) {
		this.query = query;
	}
	
	@Override
	public void init() {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = JdbcConnection.getConnection().prepareStatement(query);
			head = preparedStatement.executeQuery();	
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public ResultSet getHead() {
		return head;
	}

	public void setHead(ResultSet head) {
		this.head = head;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public boolean next() {
		try {
			return head.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void add(Node node) {
		
	}

	@Override
	public int getColumnCount() {
		try {
			ResultSetMetaData rsmd = (ResultSetMetaData) head.getMetaData();
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}	
}
