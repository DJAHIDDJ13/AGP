package business.transport;

import business.island.Position;

public class BoatStation extends Station{

	public BoatStation() {
		super();
	}
	
	public BoatStation(int id, Position position) {
		super(id, position);
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