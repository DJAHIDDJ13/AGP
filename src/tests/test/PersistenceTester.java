package tests.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import bde.lucene.persistence.LucenePersistence;
import bde.persistence.jdbc.Persistance;
import business.island.Hotel;
import business.island.Site;
import tests.mock.PersistenceMock;

public class PersistenceTester {

	private static Persistance persister;
	private static LucenePersistence lucene;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lucene = new PersistenceMock().getLucene();
		
		lucene.createIndex();
		
		persister = new Persistance();
	}
	
	@Test
	public void testPersisteSites() {
		List<Site> sites = persister.getAllSites();
		
		assertTrue(sites.size() > 0);
	}
	
	@Test
	public void testPersisteHotels() {
		List<Hotel> hotels = persister.getAllHotels();
		
		assertTrue(hotels.size() > 0);		
	}
	
	@Test
	public void testPersisteSitesByKey() {
		List<Site> sites = persister.getSitesByKeyWord("Activity", "plage");
		
		for(Site site : sites) {
			String type =  (site.isActivitySite()) ? "Activity" : "Historic";
			System.out.println("ID : " + site.getId() + ", Type : " + type + ", Name : " + site.getName()
							  + ", Pertinance : " + site.getPertinance());
		}
		
		assertTrue(sites.size() > 0);		
	}
	
    @AfterClass
	public static void afterTesting() {
		lucene.deletIndexFile();
	}
}