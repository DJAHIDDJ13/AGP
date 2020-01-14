package bde.persistence.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import bde.dao.Persistence;
import business.island.ActivitySite;
import business.island.HistoricSite;
import business.island.Hotel;
import business.island.Island;
import business.island.Position;
import business.island.Site;
import business.transport.Station;

public class IslandPersistance implements Persistence{
	
	public void dataInit() {
		System.err.println("Please don't forget to create tables manually by importing creation.sql in your database !");
		
	}
	
	public List<Island> getAllIsland() {
		List<Island> islands = new ArrayList<Island>(); 
		ResultSet resultSet = request("select id_island from  island " );
		
		try {
			while(resultSet.next() == true) {
				int islandId = resultSet.getInt("id_island"); 
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
		ResultSet resultSet = request("select * from  island where id_island=" + islandId);
		 
			try {
				
				if(resultSet.next() == false)
					return null;
				HashMap<Integer, Hotel> hotels = getHotelsByIslandId(islandId); 
				HashMap<Integer, Site> sites = getSitesByIslandId(islandId); 
				return new Island(islandId, resultSet.getString("name_island"),hotels, sites ); 
				
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		
		return null; 
	}
	
	public HashMap<Integer, Hotel> getHotelsByIslandId(int islandId){
		
		HashMap<Integer, Hotel> hotels = new HashMap<Integer, Hotel>(); 
		ResultSet resultSet = request("select * from  hotel where id_island=" + islandId);
		
		try {
			while(resultSet.next() == true) { 
				Position position = getPositionById(resultSet.getInt("id_position")); 
				Station station = getStationById(resultSet.getInt("id_station")); 
				Hotel hotel = new Hotel(resultSet.getInt("id_hotel"), resultSet.getFloat("price_hotel"), resultSet.getString("name_hotel"), resultSet.getInt("stars"), resultSet.getString("beach"), position, station);
				hotels.put(hotel.getId(), hotel); 
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		
		return hotels; 
	}
	
	
	
	public Hotel getHotel(int hotelId) {
		
		Hotel hotel = null; 
		ResultSet resultSet = request("select * from  hotel where id_hotel=" + hotelId);
		try {
			if(resultSet.next() == false)
				return null;
			
			Position position = getPositionById(resultSet.getInt("id_position")); 
			Station station = getStationById(resultSet.getInt("id_station")); 
			hotel = new Hotel(hotelId, resultSet.getFloat("price_hotel"), resultSet.getString("name_hotel"), resultSet.getInt("stars"), resultSet.getString("beach"), position, station); 

			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return hotel; 
	}
	/*
	public Route getRooteById(int lineId){
		
		Route roote = null; 
		ResultSet resultSet = request("select * from  line where id_line=" + lineId);
		try {
			if(resultSet.next() == false)
				return null;
			
			Position position = getPositionById(resultSet.getInt("id_position")); 
			Station station = getStationById(resultSet.getInt("id_station")); 
			
			if(resultSet.getString("type_site").equals("historic")) {
				// Historic(int id, String name, Place place, Station station) {
				site = new HistoricSite(siteId, resultSet.getString("name_site"), position, station); 
			}
			else{
				site = new ActivitySite(siteId, resultSet.getString("name_site"), position, station); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return site; 
		
	}
	*/
	
	public List<Station> getStationsByRooteId(int routeId){
		
		List<Station> stations = new ArrayList<Station>();
		
		ResultSet resultSet = request("select id_station from s_belongs_to_l  where id_line=" + routeId);
		try {
			while(resultSet.next() == true) {
				Station station = getStationById(resultSet.getInt("id_station")); 
				stations.add(station); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return stations; 
	}
	
	
	public HashMap<Integer, Site> getSitesByIslandId(int islandId) {
		
		HashMap<Integer, Site> sites = new HashMap<Integer, Site>();
		
		ResultSet resultSet = request("select * from  site where id_island=" + islandId);
		try {
			while(resultSet.next() == true) {
				Site site = getSiteById(resultSet.getInt("id_site")); 
				sites.put(site.getId(), site); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return sites; 
	}
	
	public Site getSiteById(int siteId){
		
		Site site = null; 
		ResultSet resultSet = request("select * from  site where id_site=" + siteId);
		try {
			if(resultSet.next() == false)
				return null;
			
			Position position = getPositionById(resultSet.getInt("id_position")); 
			Station station = getStationById(resultSet.getInt("id_station")); 
			
			if(resultSet.getString("type_site").equals("historic")) {
				// Historic(int id, String name, Place place, Station station) {
				site = new HistoricSite(siteId, resultSet.getString("name_site"), position, station); 
			}
			else{
				site = new ActivitySite(siteId, resultSet.getString("name_site"), position, station); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return site; 
	}
	
	public Station getStationById(int stationId){
		Station station = null; 
		ResultSet resultSet = request("select * from  station where id_station=" + stationId);
		try {
			if(resultSet.next() == false)
				return null;
			int idPosition = resultSet.getInt("id_position"); 
			Position position = getPositionById(idPosition); 
			station = new Station(stationId, resultSet.getString("name_station"),position); 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return station; 
	}

	public Position getPositionById(int positionId){
		Position position = null; 
		ResultSet resultSet = request("select * from  coordinate where id_position=" + positionId);
		try {
			if(resultSet.next() == true)
				position = new Position(resultSet.getFloat("latitude"), resultSet.getFloat("longitude"));  
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return position; 
	}
	
	private ResultSet request(String query) {
		
		PreparedStatement preparedStatement = null;
		ResultSet result = null;	
	
		try {
			preparedStatement = JdbcConnection.getConnection().prepareStatement(query);
	  	    result = preparedStatement.executeQuery();
	        }catch (SQLException e) { 
	        	e.printStackTrace();
	        }
	
	     return result;
	}
}