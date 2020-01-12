package business.island;

import business.transport.Station;

public class Historic extends Site{

	public Historic() {
		
	}
	
	public Historic(int id, String name, Place place, Station station) {
		super(id, name, place, station);
	}
	
	@Override
	public boolean isHistoricSite() {
		return true;
	}

	@Override
	public boolean isActivitySite() {
		return false;
	}
}