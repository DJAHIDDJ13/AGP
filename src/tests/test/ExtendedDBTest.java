package tests.test;

import bde.api.ExtendedDB;
import bde.iterator.Iterator;

public class ExtendedDBTest {

	public static void main(String[] args) {
		
		String table = "site";
		String cle = "id_site";
		String dataDir = "src/luceneSRC/data/";
		
		ExtendedDB bde = new ExtendedDB(table, cle, dataDir);
		
		bde.createIndexDir();
		
		System.out.println("\nQUERY : ");
		String query = "baie OR culture";
		Iterator iterator = bde.luceneQuery(query);
		
		System.out.println("\n-------- Lucene Iterator result --------");
		try {
			while(iterator.next()) {
				System.out.println("ID : " + iterator.getString(0) + ", Pertinance : " + iterator.getString(1));		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n-------- SQL JDBC Iterator result --------");
		
		query = "SELECT * FROM site WHERE type_site = 'historic'";
		iterator = bde.SQLQuery(query);
		
		try {
			while(iterator.next()) {
				for(int i = 1; i <= iterator.getColumnCount(); i++) {
					System.out.print(iterator.getString(i) + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n-------- Plan 1 Nested Loop join Iterator result --------");
		
		//query = "SELECT * FROM site WHERE type_site = 'historic' with baie OR culture";
		query = "SELECT type_site FROM site WHERE type_site = 'historic' with baie OR culture";
		iterator = bde.MixedQuery(query);
		
		long startTime = System.nanoTime();
		try {
			while(iterator.next()) {
				for(int i = 1; i < iterator.getColumnCount(); i++) {
					System.out.print(iterator.getString(i) + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long stopTime = System.nanoTime();
		
		System.out.println("the time for the first plane is : " + (stopTime-startTime));
		
		System.out.println("\n-------- Plan 2 Indexed join Iterator result --------");
		iterator = bde.MixedIndexedQuery(query);
		
		startTime = System.nanoTime();
		try {
			while(iterator.next()) {
				for(int i = 1; i < iterator.getColumnCount(); i++) {
					System.out.print(iterator.getString(i) + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		stopTime = System.nanoTime();

		System.out.println("the time for the first plane is : " + (stopTime-startTime));
		
		bde.close();
	}
}