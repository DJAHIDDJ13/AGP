package business.transport;

//import business.island.Place;

public class BoatStation extends Station{

	public BoatStation() {
		super();
	}
	
	public BoatStation(int id, float lat, float lng) {
		super(id, lat, lng);
	}
	
	@Override
	public boolean isBusStation() {
		return false;
	}

	@Override
	public boolean isBoatStation() {
		return true;
	}
}