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

public class Persistance{
	
	private OperatorSQL sqlIterator;
	private NestedLoopJoin mixedIterator;
	
	public Persistance() {
		sqlIterator = new OperatorSQL();
		mixedIterator = new NestedLoopJoin();
	}
	
	public void dataInit() {
		System.err.println("Please don't forget to create tables manually by importing creation.sql in your database !");
		
	}
	
	public List<Island> getAllIsland() {
		List<Island> islands = new ArrayList<Island>();
		
		sqlIterator.setQuery("select id_island from  island " );
		sqlIterator.init();
		
		try {
			while(sqlIterator.next()) {
				int islandId = sqlIterator.getInt("id_island"); 
				Island island = getIslandById(islandId); 
				islands.add(island);
			}
			return islands; 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null; 
	}
	
	public Island getIslandById(int islandId) {
		sqlIterator.setQuery("select * from  island where id_island=" + islandId);
		sqlIterator.init();
		
		try {		
			if(!sqlIterator.next()) {
					return null;
			}
			
			HashMap<Integer, Hotel> hotels = getHotelsByIslandId(islandId); 
			HashMap<Integer, Site> sites = getSitesByIslandId(islandId); 
			return new Island(islandId, sqlIterator.getString("name_island"),hotels, sites ); 
				
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return null; 
	}
	
	public Hotel getHotelById(int hotelId) {		
		Hotel hotel = null; 
		
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
	
	
	public HashMap<Integer, Hotel> getHotelsByIslandId(int islandId){
		HashMap<Integer, Hotel> hotels = new HashMap<Integer, Hotel>();
		
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
	
	public Station getStationById(int stationId){
		Station station = null; 
		
		sqlIterator.setQuery("select * from  station where id_station=" + stationId);
		sqlIterator.init();
		
		try {
			if(!sqlIterator.next()) {
				return null;
			}
			
			int idPosition = sqlIterator.getInt("id_position"); 
			Position position = getPositionById(idPosition); 
			station = new Station(stationId, sqlIterator.getString("name_station"),position); 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return station; 
	}

	public Position getPositionById(int positionId){
		Position position = null; 
		
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