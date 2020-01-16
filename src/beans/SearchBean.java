package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.trip.TripSimulation;
import spring.SpringIoC;

@ManagedBean
@SessionScoped
public class SearchBean implements Serializable {

	private static final long serialVersionUID = -426721429642192283L;
	
	private String rating;

	private List<String> hotelsName;

	private List<String> sitesName;

	private String searchQuery;

	private String siteType;
	
	private TripSimulation trip = (TripSimulation) SpringIoC.getBean("tripSimulation");
	
	public SearchBean() {
		trip.init();
	}

	public String findHotelsByRating() {		
		List<String> hotelsName =  trip.getHotelsNamesByRating(rating);	
		this.setHotelsName(hotelsName);
		return "hotelResult";
	}
	
	
	public String findSitesNames() {	
		List<String> sitesNames = trip.fetchSites(siteType, searchQuery);
		this.setSitesName(sitesNames);
		return "sitesResult";
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public List<String> getHotelsName() {
		return hotelsName;
	}

	public void setHotelsName(List<String> hotelsName) {
		this.hotelsName = hotelsName;
	}

	public List<String> getSitesName() {
		return sitesName;
	}

	public void setSitesName(List<String> sitesName) {
		this.sitesName = sitesName;
	}

	public void setRating(String r) {
		this.rating = r;
	}

	public String getRating() {
		return rating;
	}

}
