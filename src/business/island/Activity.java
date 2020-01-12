package business.island;

import business.transport.Station;

public class Activity extends Site{

	public Activity() {
		
	}
	
	public Activity(int id, String name, Place place, Station station) {
		super(id, name, place, station);
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