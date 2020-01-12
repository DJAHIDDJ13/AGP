package business.island;

import java.util.HashMap;

public class Island {
	
	private int id;
	
	private String name;
	
	private HashMap<Integer, Hotel> islandHotels;
	private HashMap<Integer, Site> islandSites;
	
	public Island() {
		
	}

	public Island(int id, String name) {
		this.id = id;
		this.name = name;
		this.islandHotels = new HashMap<Integer, Hotel>();
		this.islandSites = new HashMap<Integer, Site>();
	}
	
	public Island(int id, String name, HashMap<Integer, Hotel> islandHotels, HashMap<Integer, Site> islandSites) {
		this.id = id;
		this.name = name;
		this.islandHotels = islandHotels;
		this.islandSites = islandSites;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<Integer, Hotel> getIslandHotels() {
		return islandHotels;
	}

	public void setIslandHotels(HashMap<Integer, Hotel> islandHotels) {
		this.islandHotels = islandHotels;
	}

	public HashMap<Integer, Site> getIslandSites() {
		return islandSites;
	}

	public void setIslandSites(HashMap<Integer, Site> islandSites) {
		this.islandSites = islandSites;
	}
}