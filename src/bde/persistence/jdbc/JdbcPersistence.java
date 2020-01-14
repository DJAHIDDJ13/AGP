package bde.persistence.jdbc;

import bde.dao.Persistence;

public class JdbcPersistence implements Persistence{

	@Override
	public void dataInit() {
		System.err.println("Please don't forget to create tables manually by importing creation.sql in your database !");
		
	}
	
}