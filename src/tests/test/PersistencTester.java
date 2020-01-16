package tests.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import bde.persistence.jdbc.Persistance;
import business.island.Hotel;
import business.island.Site;

public class PersistencTester {

	private static Persistance persister;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
		List<Site> sites = persister.getSitesByKeyWord("", "");
		
		assertTrue(sites.size() > 0);		
	}
}
