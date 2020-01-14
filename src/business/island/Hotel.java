package business.island;

import business.transport.Station;

public class Hotel {
	
	private int id;
	private int star;
	
	private float pricePerDay;
	
	private String name;
	private String beach;
	
	private Place place;
	
	private Station station;
	
	public Hotel() {
		
	}
	
	public Hotel(int id, float pricePerDay, String name, int star, String beach, Place place, Station station) {
		this.id = id;
		this.pricePerDay = pricePerDay;
		this.name = name;
		this.star = star; 
		this.beach = beach;
		this.place = place;
		this.station = station;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
	public String getBeach() {
		return beach;
	}

	public void setBeach(String beach) {
		this.beach = beach;
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
}
