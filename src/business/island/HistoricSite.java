package business.island;

import business.transport.Station;

public class HistoricSite extends Site{

	public HistoricSite() {
		
	}
	
	public HistoricSite(int id, String name, Position place, Station station, float price) {
		super(id, name, place, station, 10 * price);
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