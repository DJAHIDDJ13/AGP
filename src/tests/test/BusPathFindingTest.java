package tests.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import business.engine.Path;
import business.engine.PathEntry;
import business.engine.PathFinding;
import business.island.ActivitySite;
import business.island.Hotel;
import business.island.Position;
import business.island.Site;
import business.transport.BusRoute;
import business.transport.Station;
import business.transport.Transport;
import business.trip.Excursion;
import tests.mock.PathFindingMock;


public class BusPathFindingTest {
	
	private static PathFinding pf;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Transport transport = new PathFindingMock().getTransport();
		pf = new PathFinding(transport);
	}
	
	@Test
	public void testCheapestPathResult() {
		Transport transport = pf.getTransport();
		
		Path routes = pf.findCheapestPath(transport.getStationById(0), transport.getStationById(3));
		assertNotNull(routes);
    	
		List<PathEntry> expectedResult = new ArrayList<PathEntry>(
				Arrays.asList(PathEntry.getEntry(transport.getStationById(0), transport.getRouteById(1)),
							  PathEntry.getEntry(transport.getStationById(1), transport.getRouteById(1)),
							  PathEntry.getEntry(transport.getStationById(2), transport.getRouteById(1)),
							  PathEntry.getEntry(transport.getStationById(3), transport.getRouteById(1))));

		assertTrue(expectedResult.equals(routes.getPath()));
	}
	
	@Test
	public void testWhenStationIsNonAccessible()
	{
		Transport transport = pf.getTransport();
		transport.addRoute(1, new BusRoute(1, 1, 2, new ArrayList<Station>(
				   Arrays.asList(transport.getStationById(3),
			 					 transport.getStationById(2)))));
	
		PathFinding pf = new PathFinding(transport);

		Path path = pf.findCheapestPath(transport.getStationById(0), transport.getStationById(1)); 
    	assertNull(path);	
	}

	@Test
	public void testPathIsOrientationSensitive() 
	{
		Transport transport = pf.getTransport();
		transport.addRoute(1, new BusRoute(1, 1, 4, new ArrayList<Station>(
				   Arrays.asList(transport.getStationById(3),
			 					 transport.getStationById(2),
			 					 transport.getStationById(1),
			 					 transport.getStationById(0)))));
		
		PathFinding pf = new PathFinding(transport);

		Path path = pf.findCheapestPath(transport.getStationById(1),
				                        transport.getStationById(0));
    	assertNotNull(path);
    	
    	path = pf.findCheapestPath(transport.getStationById(0),
    							   transport.getStationById(1));
    	assertNull(path);
	}

	@Test
	public void testExcursionCreation() {
		Transport transport = pf.getTransport();
		Hotel hotel = new Hotel(1, 1, "Hotel", 1, "Beach", new Position(0, 0), transport.getStationById(0));

		Site site1 = new ActivitySite(1, "Site1", new Position(0, 2), transport.getStationById(2));
		Site site2 = new ActivitySite(2, "Site2", new Position(1, 3), transport.getStationById(3));
		Site site3 = new ActivitySite(3, "Site3", new Position(0, 1), transport.getStationById(1));
		site1.setDuration(3600);
		site2.setDuration(3600);
		site3.setDuration(3600);
		
		LinkedList<Site> sites = new LinkedList<Site>(Arrays.asList(site1, site2, site3));

		PathFinding pf = new PathFinding(transport);
		
		ArrayList<Excursion> e = pf.getExcursions(hotel, sites);
		System.out.print(e);
		assertNotNull(e);
	}
}