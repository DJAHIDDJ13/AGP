package business.trip;

import java.util.Comparator;

import business.island.Hotel;
import business.island.Site;

class SiteComparator implements Comparator<Site> {
	private Hotel hotel;
	
	public SiteComparator(Hotel hotel) {
		this.hotel = hotel;
	}
    
	public int compare(Site a, Site b) {
		float value1 = a.getStation().distanceFrom(hotel.getStation());
		float value2 = b.getStation().distanceFrom(hotel.getStation());
		
		return value1 < value2 ? 1 : -1;
    }
}