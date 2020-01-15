package bde.dao;

import java.util.HashMap;
import java.util.List;

import business.island.Hotel;
import business.island.Island;
import business.island.Position;
import business.island.Site;
import business.transport.Route;
import business.transport.Station;

/**
 * General DAO interface for persistence APIs.
 */
public interface IslandPersistence {
	
	void dataInit();
	
	public List<Island> getAllIsland() ;
	 
	public Island getIslandById(int islandId) ;
	
	public Hotel getHotelById(int hotelId);
	
	public HashMap<Integer, Hotel> getHotelsByIslandId(int islandId);
	
	public List<String> getHotelNamesByRating(String ranting);
	
	public HashMap<Integer, Route> getAllRoutes();
	
	public HashMap<Integer, Station> getAllStations();

	public Route getRouteById(int routeId);
	
	public List<Station> getStationsByRooteId(int routeId);
	
	public HashMap<Integer, Site> getSitesByIslandId(int islandId) ;

	public Site getSiteById(int siteId);
	
	public Station getStationById(int stationId);

	public Position getPositionById(int positionId);
	
	public List<String> fetchSites(String siteType, String key);
	
}
