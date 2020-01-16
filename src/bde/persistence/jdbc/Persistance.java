package bde.persistence.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bde.iterator.NestedLoopJoin;
import bde.iterator.OperatorSQL;
import business.island.ActivitySite;
import business.island.HistoricSite;
import business.island.Hotel;
import business.island.Island;
import business.island.Position;
import business.island.Site;
import business.transport.BoatRoute;
import business.transport.BusRoute;
import business.transport.Route;
import business.transport.Station;
import business.transport.Transport;

public class Persistance{
	
	public Persistance() {
	}
	
	public void dataInit() {
		System.err.println("Please don't forget to create tables manually by importing creation.sql in your database !");
		
	}
	
	public Transport getTransport() {
		HashMap<Integer, Station> stations = getAllStations();
		HashMap<Integer, Route> routes = getAllRoutes();

		Transport transport = new Transport(stations, routes);
		
		return transport;
	}
	
	public List<Island> getAllIsland() {
		List<Island> islands = new ArrayList<Island>();
		
		OperatorSQL sqlIterator = new OperatorSQL();
		sqlIterator.setQuery("select id_island from  island");
		sqlIterator.init();
		
		try {
			while(sqlIterator.next()) {
				int islandId = sqlIterator.getInt("id_island"); 
				Island island = getIslandById(islandId); 
				islands.add(island);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return islands;  
	}
	
	public Island getIslandById(int islandId) {
		Island island = null;
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select * from  island where id_island=" + islandId);
		sqlIterator.init();
		
		try {		
			if(!sqlIterator.next()) {
					return null;
			}
			
			HashMap<Integer, Hotel> hotels = getHotelsByIslandId(islandId); 
			HashMap<Integer, Site> sites = getSitesByIslandId(islandId); 
			island = new Island(islandId, sqlIterator.getString("name_island"),hotels, sites); 
				
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return island; 
	}
	
	public Hotel getHotelById(int hotelId) {		
		Hotel hotel = null; 
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select * from  hotel where id_hotel=" + hotelId);
		try {
			if(!sqlIterator.next()) {
				return null;
			}
			
			Position position = getPositionById(sqlIterator.getInt("id_position")); 
			Station station = getStationById(sqlIterator.getInt("id_station")); 
			hotel = new Hotel(hotelId, sqlIterator.getFloat("price_hotel"), sqlIterator.getString("name_hotel"), sqlIterator.getInt("stars"), sqlIterator.getString("beach"), position, station); 

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return hotel; 
	}
	
	public List<Hotel> getAllHotels() {		
		List<Hotel> hotels = new ArrayList<Hotel>();
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select id_hotel from hotel");
		sqlIterator.init();
		
		try {
			while(sqlIterator.next()) {
				int hotelId = sqlIterator.getInt("id_hotel"); 
				Hotel hotel = getHotelById(hotelId); 
				hotels.add(hotel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return hotels; 
	}
	
	public HashMap<Integer, Hotel> getHotelsByIslandId(int islandId){
		HashMap<Integer, Hotel> hotels = new HashMap<Integer, Hotel>();
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select id_hotel from  hotel where id_island=" + islandId);
		sqlIterator.init();
		
		try {
			while(sqlIterator.next()) { 
				Hotel hotel = getHotelById(sqlIterator.getInt("id_hotel")); 
				hotels.put(hotel.getId(), hotel); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		
		return hotels; 
	}
	
	public List<String> getHotelNamesByRating(String ranting) {
		List<String> hotels = new ArrayList<String>();
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		String sqlQuery = "Select * from hotel where stars="+ranting;
		sqlIterator.setQuery(sqlQuery);
		sqlIterator.init();
		
		try {
			while(sqlIterator.next()) {
				hotels.add(sqlIterator.getString("name_hotel"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hotels;
	}
	
	public HashMap<Integer, Route> getAllRoutes(){
		HashMap<Integer, Route> routes = new HashMap<Integer, Route>(); 
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select id_line from line");
		sqlIterator.init();
		
		try {
			while(sqlIterator.next()) {
				Route route = getRouteById(sqlIterator.getInt("id_line")); 
				routes.put(route.getId(), route); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return routes; 
	}
	
	public HashMap<Integer, Station> getAllStations(){
		HashMap<Integer, Station> stations = new HashMap<Integer, Station>(); 
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select id_station from station");
		sqlIterator.init();
		
		try {
			while(sqlIterator.next()) {
				Station station = getStationById(sqlIterator.getInt("id_station")); 
				stations.put(station.getId(), station); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return stations; 
	}
	
	public Route getRouteById(int routeId){
		Route route = null; 
	
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select * from  line where id_line= " + routeId);
		sqlIterator.init();
		
		try {	
			if(!sqlIterator.next()) {
				return null;
			}
		
			List<Station> stations = getStationsByRooteId(routeId);  
			
			if(sqlIterator.getString("type").equals("bus")) {
				route = new BusRoute(routeId, sqlIterator.getFloat("price"), stations);
			}
			else {
				route = new BoatRoute(routeId, sqlIterator.getFloat("price"), stations);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return route; 
	}
	
	public List<Station> getStationsByRooteId(int routeId){
		List<Station> stations = new ArrayList<Station>();
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select id_station from s_belongs_to_l  where id_line=" + routeId + " order by station_order asc");
		sqlIterator.init();
		
		try {
			while(sqlIterator.next()) {
				Station station = getStationById(sqlIterator.getInt("id_station")); 
				stations.add(station); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return stations; 
	}
	
	
	public HashMap<Integer, Site> getSitesByIslandId(int islandId) {
		HashMap<Integer, Site> sites = new HashMap<Integer, Site>();
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select * from  site where id_island=" + islandId);
		try {
			while(sqlIterator.next() == true) {
				Site site = getSiteById(sqlIterator.getInt("id_site")); 
				sites.put(site.getId(), site); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return sites; 
	}
	
	public Site getSiteById(int siteId){
		Site site = null;
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select * from  site where id_site=" + siteId);
		try {
			if(!sqlIterator.next()) {
				return null;
			}
			
			Position position = getPositionById(sqlIterator.getInt("id_position")); 
			Station station = getStationById(sqlIterator.getInt("id_station")); 
			
			if(sqlIterator.getString("type_site").equals("historic")) {
				site = new HistoricSite(siteId, sqlIterator.getString("name_site"), position, station); 
			}
			else{
				site = new ActivitySite(siteId, sqlIterator.getString("name_site"), position, station); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return site; 
	}
	
	public List<String> fetchSites(String siteType, String key){
		List<String> result = new ArrayList<String>();
		
		NestedLoopJoin mixedIterator = new NestedLoopJoin();
		
		String query = (siteType.isEmpty()) ? 
					   "select name_site from site with " + key :
					   "select name_site from site where type_site = '" + siteType + "' with " + key;
		
		mixedIterator.setQuery(query);
		mixedIterator.init();
		
		while(mixedIterator.next()) {
			try {
				result.add(mixedIterator.getString(2));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return result;
	}
	
	public List<Site> getSitesByKeyWord(String siteType, String key){
		List<Site> result = new ArrayList<Site>();
		
		String query = (siteType == null || siteType.isEmpty()) ? 
					   "select name_site from site with " + key :
					   "select name_site from site where type_site = '" + siteType + "' with " + key;
		
		NestedLoopJoin mixedIterator = new NestedLoopJoin();
		
		mixedIterator.setQuery(query);
		mixedIterator.init();
		
		while(mixedIterator.next()) {
			try {
				Site site = getSiteById(Integer.parseInt(mixedIterator.getString(1)));
				site.setPertinance(Float.parseFloat(mixedIterator.getString(2)));
				result.add(site);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public Station getStationById(int stationId){
		Station station = null; 
		String query = "select * from station where id_station="+ stationId;

		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery(query);
		sqlIterator.init();
		
		try {
			if(!sqlIterator.next()) {
				return null;
			}
			
			int idPosition = sqlIterator.getInt("id_position");
			String stationName = sqlIterator.getString("name_station");
			
			Position position = getPositionById(idPosition);
			
			station = new Station(stationId,stationName ,position); 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return station; 
	}

	public Position getPositionById(int positionId){
		Position position = null; 
		
		OperatorSQL sqlIterator = new OperatorSQL();
		
		sqlIterator.setQuery("select * from  coordinate where id_position=" + positionId);
		sqlIterator.init();
		
		try {
			if(sqlIterator.next())
				position = new Position(sqlIterator.getFloat("latitude"), sqlIterator.getFloat("longitude"));  
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return position; 
	}
}