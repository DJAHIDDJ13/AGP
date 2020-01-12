package business.transport;

import business.island.Place;

public class BoatStation extends Station{

	public BoatStation() {
		super();
	}
	
	public BoatStation(int id, Place place) {
		super(id, place);
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