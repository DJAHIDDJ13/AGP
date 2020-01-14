package business.trip;

import java.util.List;
import business.island.Site;

public class Excursion {
	
	private int id;
	
	private List<Site> site;
	
	public Excursion() {
		
	}

	public Excursion(int id, List<Site> site) {
		this.id = id;
		this.site = site;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Site> getSite() {
		return site;
	}

	public void setSite(List<Site> site) {
		this.site = site;
	}
}