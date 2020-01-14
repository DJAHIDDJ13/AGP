package business.island;

import business.transport.Station;

public class HistoricSite extends Site{

	public HistoricSite() {
		
	}
	
	public HistoricSite(int id, String name, Position place, Station station) {
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