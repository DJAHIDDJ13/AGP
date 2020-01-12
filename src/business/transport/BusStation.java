package business.transport;

import business.island.Place;

public class BusStation extends Station{
	
	public BusStation() {
		super();
	}
	
	public BusStation(int id, Place place) {
		super(id, place);
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
