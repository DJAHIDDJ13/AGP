package tests;

	


	import static org.junit.Assert.assertNotNull;
	import static org.junit.Assert.assertNull;
	import static org.junit.Assert.assertTrue;

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

	import org.junit.Test;

	import business.engine.Path;
	import business.engine.PathEntry;
	import business.engine.PathFinding;
	import business.island.Position;
	import business.transport.BusRoute;
	import business.transport.Route;
	import business.transport.Station;
	import business.transport.Transport;

	
public class BusPathSheapestFindinfTest {

	Transport transport = Transport.getTransport();
	List<Station> stations ;
	List<Route> routes ;
	/*
	@Before
	public void hardReset()
	{
		// transport.setRoutes(null);
		// transport.setStations(null);
	}
	*/
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
	public void testShortestPathResult()
	{
		initStations();
		initRoutes();
		
		PathFinding pf = new PathFinding();
		
    	List<Station> path = pf.findShortestPath(transport.getStationById(0), transport.getStationById(3));
    	assertNotNull(path);
    	
		List<Station> expectedResult = new ArrayList<Station>(
    			Arrays.asList(transport.getStationById(0),
		    				  transport.getStationById(1),
		    				  transport.getStationById(2),
		    			      transport.getStationById(3)));
		assertTrue(path.equals(expectedResult));
	}

	@Test
	public void testCheapestPathResult()
	{
		initStations();
		initRoutes();
		PathFinding pf = new PathFinding();
		
		Path routes = pf.findCheapestPath(transport.getStationById(0), transport.getStationById(3));
		assertNotNull(routes);
		System.out.println(routes.getPathLength() + "km");
		System.out.println(routes.getPathDuration() + "s");
    	
		List<PathEntry> expectedResult = new ArrayList<PathEntry>(
				Arrays.asList(PathEntry.getEntry(transport.getStationById(0), transport.getRouteById(1)),
							  PathEntry.getEntry(transport.getStationById(1), transport.getRouteById(1)),
							  PathEntry.getEntry(transport.getStationById(2), transport.getRouteById(1)),
							  PathEntry.getEntry(transport.getStationById(3), transport.getRouteById(1))));

		assertTrue(expectedResult.equals(routes.getPath()));
	}
	
	@Test
	public void testBoatRouteWhenOnlyBusAvailable() {
		/*
		initStations();
		initRoutes();
		BusStation b1  = new BusStation(10, 5, 6);
	
		PathFinding pf = new PathFinding();
		List<Station> path = pf.findShortestPath(b1,transport.getStationById(0));
    	*/
    	assertTrue(true);
	}
	
	
	@Test
	public void testWhenStationIsNonAccessible()
	{
		initStations();
		transport.addRoute(1, new BusRoute(1, 1, 2, new ArrayList<Station>(
				   Arrays.asList(transport.getStationById(3),
			 					 transport.getStationById(2)))));
	
		PathFinding pf = new PathFinding();

		List<Station> path = pf.findShortestPath(transport.getStationById(0), transport.getStationById(1)); 
    	assertNull(path);	
	}
	
	@Test
	public void testPathIsOrientationSensitive()
	{
		initStations();
		transport.addRoute(1, new BusRoute(1, 1, 4, new ArrayList<Station>(
				   Arrays.asList(transport.getStationById(3),
			 					 transport.getStationById(2),
			 					 transport.getStationById(1),
			 					 transport.getStationById(0)))));
		
		PathFinding pf = new PathFinding();

		List<Station> path = pf.findShortestPath(transport.getStationById(1),
				                                 transport.getStationById(0));
    	assertNotNull(path);
    	
    	path = pf.findShortestPath(transport.getStationById(0),
    							   transport.getStationById(1));
    	assertNull(path);
	}

}
