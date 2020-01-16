package business.trip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import bde.lucene.core.LuceneBuilder;
import bde.lucene.persistence.LucenePersistence;
import bde.persistence.jdbc.Persistance;
import business.engine.PathFinding;
import business.island.Hotel;
import business.island.Site;
import business.transport.Transport;

public class TripSimulation {
	
	private Persistance persister;
	
	private LucenePersistence lucene; 
	
	private LuceneBuilder builder;
	
	private Transport transport;
	private PathFinding pathFinding;
	
	public TripSimulation() {
		transport = persister.getTransport();
		pathFinding = new PathFinding(transport);
	}
	
	public List<String> getHotelsNamesByRating(String rating){
		return persister.getHotelNamesByRating(rating);
	}
	
	public List<String> fetchSites(String siteType, String key){
		return persister.fetchSites(siteType, key);
	}
	
	public Trip generateTrips(int n, String keyWords, float budget, int duration, int intensity) {
		Trip trip = null;
		List<Hotel> hotels = hotelsToVisit(intensity, budget, duration, n);
		for(Hotel hotel: hotels) {
			List<Site> sites = sitesToVisitByHotel(hotel, budget, duration, keyWords);
		}
		return trip;
	}
		
	public List<Site> sitesToVisitByHotel(Hotel hotel, float budget, int duration, String keyWords) {
		List<Site> bdSites = persister.getSitesByKeyWord(null, keyWords);
		float leftBudget = budget - hotel.getPricePerDay() * duration;
		Collections.sort(bdSites, new SiteComparator(hotel));
		
		return sitesToVisit(leftBudget, bdSites);
	}
	
	public List<Hotel> hotelsToVisit(float intensity, float budget, int duration, int k){
		List<Hotel> bdHotels = persister.getAllHotels();
		
		float hotelPercentage = TripConstants.HOTEL_RANGE_PERCENTAGE - intensity;
		
		float hotelPrice = (budget * hotelPercentage) / 100;
		
		Collections.sort(bdHotels, new HotelCmparator(hotelPrice/duration));
		
		return bdHotels.subList(0, k);
	}
	
	public List<Site> sitesToVisit(float budgetLeft, List<Site> sortedSiteList){
		float curBudget = 0;
		List<Site> sites = new ArrayList<Site>();
		ListIterator<Site> siteIter = sortedSiteList.listIterator();
		while(curBudget < budgetLeft) {
			if(siteIter.hasNext()) {
				sites.add(siteIter.next());
			} else {
				break;
			}
		}
		return sites;
	}

	public LuceneBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(LuceneBuilder builder) {
		this.builder = builder;
	}

	public LucenePersistence getLucene() {
		return lucene;
	}

	public void setLucene(LucenePersistence lucene) {
		this.lucene = lucene;
	}
	
	public Persistance getPersister() {
		return persister;
	}

	public void setPersister(Persistance persister) {
		this.persister = persister;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public PathFinding getPathFinding() {
		return pathFinding;
	}

	public void setPathFinding(PathFinding pathFinding) {
		this.pathFinding = pathFinding;
	}
}