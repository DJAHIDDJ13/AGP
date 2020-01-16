package tests.test;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bde.api.ExtendedDB;
import bde.iterator.Iterator;

public class ExtendedDBTest {

	private static ExtendedDB bde;
	
	private final static String table = "site";
	private final static String key = "id_site";
	private final static String dataDir = "src/luceneSRC/data/";
	
	private final static String luceneQuery = "baie OR culture";
	private final static String sqlQuery = "SELECT id_site, type_site FROM site WHERE type_site = 'historic'";
	
	private final static String mixedQuery = "SELECT type_site FROM site WHERE type_site = 'historic' with baie OR culture";

	private static long plan1Duration = 0;
	private static long plan2Duration = 0;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bde = new ExtendedDB(table, key, dataDir);
		bde.createIndexDir();
	}
	
	@Test
	public void testSQLOperator() {
		System.out.println("\n-------- SQL JDBC Iterator result --------");
		
		Iterator iterator = bde.SQLQuery(sqlQuery);
		
		int sum = 0;
		try {
			while(iterator.next()) {
				sum++;
				for(int i = 1; i <= iterator.getColumnCount(); i++) {
					System.out.print(iterator.getString(i) + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		assertTrue(sum > 0);
	}
	
	@Test
	public void testLuceneOperator() {
		
		Iterator iterator = bde.luceneQuery(luceneQuery);
		
		System.out.println("\n-------- Lucene Iterator result --------");
		int i = 0;
		try {
			while(iterator.next()) {
				i++;
				System.out.println("ID : " + iterator.getString(0) + ", Pertinance : " + iterator.getString(1));		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(i > 0);
	}

	@Test
	public void testPlaneNestedLoopJoin() {
		
		Iterator iterator = bde.MixedQuery(mixedQuery);
		
		System.out.println("\n-------- Plan 1 Nested Loop join Iterator result --------");
		
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
		
		 plan1Duration = stopTime-startTime;
		 
		 assertTrue(plan1Duration > 0);
	}

	@Test
	public void testPlaneIndexedJoin() {
		
		Iterator iterator = bde.MixedIndexedQuery(mixedQuery);
		
		System.out.println("\n-------- Plan 2 Indexed join Iterator result --------");
		
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

		plan2Duration = stopTime-startTime;	
		
		assertTrue(plan2Duration > 0);
	}
	
	@Test
	public void testPlaneCompare() {
		assertTrue(plan2Duration > plan1Duration);
	}	
	
    @AfterClass
	public static void afterTesting() {
		bde.close();
	}
}