package business.island;

import business.transport.Station;

public class ActivitySite extends Site{

	public ActivitySite() {
		
	}
	
	public ActivitySite(int id, String name, Position place, Station station, float price) {
		super(id, name, place, station, 10 * price);
	}
	
	@Override
	public boolean isHistoricSite() {
		return false;
	}

	@Override
	public boolean isActivitySite() {
		return true;
	}
}