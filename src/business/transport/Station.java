package business.transport;

import business.island.Place;

public abstract class Station {

	private int id;
	
	private Place place;

	public Station() {
		
	}
	
	public Station(int id, Place place) {
		this.id = id;
		this.place = place;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public abstract boolean isBusStation();
	public abstract boolean isBoatStation();
}