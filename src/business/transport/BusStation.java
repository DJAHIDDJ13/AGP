package business.transport;

//import business.island.Place;

public class BusStation extends Station{
	
	public BusStation() {
		super();
	}
	
	public BusStation(int id, float lat, float lng) {
		super(id, lat, lng);
	}
	
	@Override
	public boolean isBusStation() {
		return true;
	}

	@Override
	public boolean isBoatStation() {
		return false;
	}
}
