package business.trip;

import java.util.List;
import java.util.ListIterator;

import business.engine.Path;
import business.island.Site;

public class Excursion {
	
	private int id;
	
	private List<Site> sites;
	private List<Path> paths;
	
	public Excursion() {
		
	}

	public Excursion(int id, List<Site> site, List<Path> paths) {
		this.id = id;
		this.sites = site;
		this.paths = paths;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Site> getSite() {
		return sites;
	}

	public void setSite(List<Site> site) {
		this.sites = site;
	}

	public List<Path> getPaths() {
		return paths;
	}

	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}
	
	@Override
	public String toString() {
		String res = "Hotel\n";
		ListIterator<Path> pathsIter = paths.listIterator();
		ListIterator<Site> sitesIter = sites.listIterator();
		
		while(pathsIter.hasNext() && sitesIter.hasNext()) {
			res += pathsIter.next();
			res += sitesIter.next() + "\n";
		}
		
		if(pathsIter.hasNext()) {
			res += pathsIter.next();
		}
		res += "Hotel\n";

		return res;
	}
}