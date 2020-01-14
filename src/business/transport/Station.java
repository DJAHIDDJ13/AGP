package business.transport;

import business.island.Position;

public class Station {
	private int id;
	private float latitude;
	private float longitude;
	private Position position;
	
	public Station() {
		
	}
	
	public Station(int id, Position position) {
		this.id = id;
		this.setPosition(position);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public float distanceFrom(Station v) {
		return 1; // TODO: Heversine formula
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}