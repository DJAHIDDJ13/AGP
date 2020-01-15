package business.trip;

import java.util.List;

import bde.lucene.core.LuceneBuilder;
import bde.lucene.persistence.LucenePersistence;
import bde.persistence.jdbc.Persistance;

public class TripSimulation {
	
	private Persistance persister;
	
	private LucenePersistence lucene; 
	
	private LuceneBuilder builder;
	
	public TripSimulation() {
				
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

}