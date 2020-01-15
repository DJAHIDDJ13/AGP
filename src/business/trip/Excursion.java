package business.trip;

import java.util.List;

import business.engine.Path;
import business.island.Site;

public class Excursion {
	
	private int id;
	
	private List<Site> site;
	private List<Path> paths;
	
	public Excursion() {
		
	}

	public Excursion(int id, List<Site> site, List<Path> paths) {
		this.id = id;
		this.site = site;
		this.paths = paths;
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

	public List<Path> getPaths() {
		return paths;
	}

	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}
}