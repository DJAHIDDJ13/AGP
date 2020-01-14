package business.transport;

import business.island.Position;

public class BusStation extends Station{
	
	public BusStation() {
		super();
	}
	
	public BusStation(int id, Position position) {
		super(id, position);
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
