package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import business.engine.Path;
import business.engine.PathEntry;
import business.engine.PathFinding;
import business.island.ActivitySite;
import business.island.Hotel;
import business.island.Position;
import business.island.Site;
import business.transport.BusRoute;
import business.transport.Route;
import business.transport.Station;
import business.transport.Transport;
import business.trip.Excursion;



public class BusPathFindingTest {
	
	Transport transport;
	List<Station> stations;
	List<Route> routes;
	
	public void initTransport() {
		transport = new Transport();
	}
 	
	public void initStations()
	{
		// TODO: The id shouldn't be in the Station constructor ??
		
		transport.addStation(0, new Station(0, new Position(0, 0)));
		transport.addStation(1, new Station(1, new Position(0, 1)));
		transport.addStation(2, new Station(2, new Position(0, 2)));
		transport.addStation(3, new Station(3, new Position(1, 3)));
	}

	private void initRoutes() {
		transport.addRoute(1, new BusRoute(1, 1, 4, new ArrayList<Station>(
				   Arrays.asList(transport.getStationById(0),
			 					 transport.getStationById(1),
			 					 transport.getStationById(2),
			 					 transport.getStationById(3)))));
		
		transport.addRoute(2, new BusRoute(2, 1, 4, new ArrayList<Station>(
				   Arrays.asList(transport.getStationById(3),
			 					 transport.getStationById(2),
			 					 transport.getStationById(1),
			 					 transport.getStationById(0)))));
	}
	
	@Test
	public void testCheapestPathResult()
	{
		initTransport();
		initStations();
		initRoutes();
		PathFinding pf = new PathFinding(transport);
		
		Path routes = pf.findCheapestPath(transport.getStationById(0), transport.getStationById(3));
		//System.out.print(routes);
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
		initTransport();
		initStations();
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
		initTransport();
		initStations();
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
		initTransport();
		initStations();
		initRoutes();
		Hotel hotel = new Hotel(1, 1, "Hotel", 1, "Beach", new Position(0, 0), transport.getStationById(0));

		Site site1 = new ActivitySite(1, "Site1", new Position(0, 2), transport.getStationById(2));
		Site site2 = new ActivitySite(2, "Site2", new Position(1, 3), transport.getStationById(3));
		Site site3 = new ActivitySite(3, "Site3", new Position(0, 1), transport.getStationById(1));

		LinkedList<Site> sites = new LinkedList<Site>(Arrays.asList(site1, site2, site3));

		PathFinding pf = new PathFinding(transport);
		
		ArrayList<Excursion> e = pf.getExcursions(hotel, sites);
		System.out.print(e);
	}
	
}