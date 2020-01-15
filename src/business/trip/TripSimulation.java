package business.trip;

import java.io.IOException;
import java.util.List;

import bde.lucene.core.LuceneBuilder;
import bde.lucene.persistence.LuceneConstants;
import bde.lucene.persistence.LucenePersistence;
import bde.persistence.jdbc.Persistance;

public class TripSimulation {
	
	private Persistance persister;
	
	private LucenePersistence lucene; 
	
	private LuceneBuilder builder;
	
	public TripSimulation() {
		
		builder = new LuceneBuilder(LuceneConstants.DATA_FILE);
		try {
			builder.createFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lucene = new LucenePersistence(LuceneConstants.INDEX_FILE, LuceneConstants.DATA_FILE);
		
		try {
			lucene.createIndex();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		persister = new Persistance();
	}
	
	public List<String> getHotelsNamesByRating(String rating){
		return persister.getHotelNamesByRating(rating);
	}
	
	public List<String> fetchSites(String siteType, String key){
		return persister.fetchSites(siteType, key);
	}
	
	public Trip generateTrip() {
		Trip trip = null;
		
		return trip;
	}
}