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
		int l = 100;
		float score1 = (l * a.getPertinance()) / a.getStation().distanceFrom(hotel.getStation());
		float score2 = (l * b.getPertinance()) / b.getStation().distanceFrom(hotel.getStation());
		
		return score1 > score2 ? 1: -1;
    }
}