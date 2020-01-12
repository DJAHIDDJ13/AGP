package business.island;

import business.transport.Station;

public abstract class Site {
	
	private int id;
	
	private String name;
	
	private Place place;
	
	private Station station;
	
	public Site() {
		
	}
	
	public Site(int id, String name, Place place, Station station) {
		this.id = id;
		this.name = name;
		this.place = place;
		this.station = station;
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

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public abstract boolean isHistoricSite();
	public abstract boolean isActivitySite();
}
