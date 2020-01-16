package tests.mock;

import java.util.ArrayList;
import java.util.Arrays;

import business.island.Position;
import business.transport.BusRoute;
import business.transport.Station;
import business.transport.Transport;

public class PathFindingMock {
	Transport transport;

	public PathFindingMock() {
		transport = new Transport();
		
		initlizeStations();
		initlizeRoutes();
	}
	
	private void initlizeStations() {
		transport.addStation(0, new Station(0, new Position(0, 0)));
		transport.addStation(1, new Station(1, new Position(0, (float)0.1)));
		transport.addStation(2, new Station(2, new Position(0, (float)0.2)));
		transport.addStation(3, new Station(3, new Position((float)0.1, (float)0.3)));
	}
	
	private void initlizeRoutes() {		
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
	
	public Transport getTransport() {
		return transport;
	}
}
