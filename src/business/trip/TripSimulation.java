package business.trip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
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
	
	private Transport simulationTransport;
	
	private PathFinding pathFinding;
	
	public TripSimulation() {

	}
	
	public void init() {
		simulationTransport = persister.getTransport();
		pathFinding = new PathFinding(simulationTransport);
	}
	
	public List<String> getHotelsNamesByRating(String rating){
		return persister.getHotelNamesByRating(rating);
	}
	
	public List<String> fetchSites(String siteType, String key){
		return persister.fetchSites(siteType, key);
	}
	
	public List<Trip> generateTrips(int n, String keyWords, float budget, int duration, int intensity) {
		List<Trip> trips = new ArrayList<Trip>();
		Hotel hotel = persister.getHotelById(1);
		LinkedList<Site> sites = new LinkedList<Site>(persister.getAllSites());
		
		List<Excursion> excursions = pathFinding.getExcursions(hotel, sites);
		Trip trip = new Trip(hotel, excursions);

/*
		List<Hotel> hotels = hotelsToVisit(intensity, budget, duration, n);
		for(Hotel hotel: hotels) {
			List<Site> bdSites = persister.getSitesByKeyWord(null, keyWords);
			float budgetLeft = budget - hotel.getPricePerDay() * duration;
			Collections.sort(bdSites, new SiteComparator(hotel));
			LinkedList<Site> sites = sitesToVisit(budgetLeft, bdSites);
			
			List<Excursion> excursions = pathFinding.getExcursions(hotel, sites);
			Trip trip = new Trip(hotel, excursions);
			trips.add(trip);
		}
*/
		trips.add(trip);
		return trips;
	}
	
	public List<Hotel> hotelsToVisit(float intensity, float budget, int duration, int k){
		List<Hotel> bdHotels = persister.getAllHotels();
		
		float hotelPercentage = TripConstants.HOTEL_RANGE_PERCENTAGE - intensity;
		
		float hotelPrice = (budget * hotelPercentage) / 100;
		
		Collections.sort(bdHotels, new HotelCmparator(hotelPrice/duration));
		
		return bdHotels.subList(0, k);
	}
	
	public LinkedList<Site> sitesToVisit(float budgetLeft, List<Site> sortedSiteList){
		float curBudget = 0;
		LinkedList<Site> sites = new LinkedList<Site>();
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
	
	public void generateFilesIndex() {
				
		lucene.deletIndexFile();
		try {
			builder.createFiles();
			lucene.createIndex();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Persistance getPersister() {
		return persister;
	}

	public void setPersister(Persistance persister) {
		this.persister = persister;
	}

	public LucenePersistence getLucene() {
		return lucene;
	}

	public void setLucene(LucenePersistence lucene) {
		this.lucene = lucene;
	}

	public LuceneBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(LuceneBuilder builder) {
		this.builder = builder;
	}

	public Transport getSimulationTransport() {
		return simulationTransport;
	}

	public void setSimulationTransport(Transport simulationTransport) {
		this.simulationTransport = simulationTransport;
	}

	public PathFinding getPathFinding() {
		return pathFinding;
	}

	public void setPathFinding(PathFinding pathFinding) {
		this.pathFinding = pathFinding;
	}
	
}