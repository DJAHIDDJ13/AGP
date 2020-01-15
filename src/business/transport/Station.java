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
		this.name = String.valueOf(id);
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
	
	public float distanceFrom(Station v) {
		double lon1 = position.getLongitude();
		double lat1 = position.getLatitude();
		double lon2 = v.getPosition().getLongitude();
		double lat2 = v.getPosition().getLatitude();
		
	    double R = 6372.8; // In kilometers
		
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * 
        		   Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        
        return (float) (R * c);
	}



	public void setName(String name) {
		this.name = name;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return name;
	}
}