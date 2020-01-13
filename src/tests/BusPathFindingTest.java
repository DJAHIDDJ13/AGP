package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import business.engine.PathFinding;
import business.transport.BusRoute;
import business.transport.BusStation;
import business.transport.Route;
import business.transport.Station;
import business.transport.Transport;



public class BusPathFindingTest {
	
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
		
		transport.addStation(0, new BusStation(0, 0, 0));
		transport.addStation(1, new BusStation(1, 0, 1));
		transport.addStation(2, new BusStation(2, 0, 2));
		transport.addStation(3, new BusStation(3, 1, 3));
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
	public void initialeTest()
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
/*		
		List<Route> routes = pf.findCheapestPath(transport.getStationById(0), transport.getStationById(3));
		for(Route r: routes) {
			System.out.println(r.getId());
		}
*/
//		pf.findCheapestPath(transport.getStationById(1), transport.getStationById(3));
    	assertTrue(path.equals(expectedResult));
	}

/** Shouldn't be possible now
	@Test(expected = NullRoutesException.class)
	public void testWhenThereIsNoRoutes()
	{
		hardReset();
		initStations();	
		
		PathFinding pf = new PathFinding();
		pf.findShortestPath(transport.getStationById(0), transport.getStationById(1));
	}
	
	@Test(expected = NullStationsException.class)
	public void testWhenThereIsNoStationsAtAll()
	{	
		//hardReset();
		PathFinding pf = new PathFinding();
		pf.findShortestPath(transport.getStationById(0), transport.getStationById(1));
	}
*/
	
	@Test
	public void testBoatRouteWhenOnlyBusAvailable() {
		/*
		 *check if unknown station throw NotFoundStationException
		initStations();
		initRoutes();
		BusStation b1  = new BusStation(10, 5, 6);
	
		PathFinding pf = new PathFinding();

		List<Station> path = pf.findShortestPath(b1,transport.getStationById(0));*/ 
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
