package business.transport;

import business.island.Position;

public class Station {
	private int id;
	private String name; 
	private Position position;
	
	public Station() {
		
	}
	
	public Station(int id, Position position) {
		this.id = id;
		this.setPosition(position);
	}
	public Station(int id, String name, Position position) {
		this.id = id;
		this.name = name;
		this.setPosition(position);
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
	
	public float distanceFrom(Station v) {
		return 1; // TODO: Heversine formula
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}