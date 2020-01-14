package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.island.ActivitySite;
import business.island.HistoricSite;
import  business.island.Hotel;
import business.island.Site;
@ManagedBean
@SessionScoped

public class SearchBean implements Serializable 
{

	private static final long serialVersionUID = -426721429642192283L;
	
	private String gamme;

	private List<Hotel> hotels;

	private List<Site> sites;

	private String searchQuery;
	
	private int siteType;
	
	public SearchBean()
	{
	
	}

	public String findHotelsByRating()
	{
		Hotel h1 = new Hotel();
		Hotel h2 = new Hotel();
		Hotel h3 = new Hotel();
		Hotel h4 = new Hotel();
		Hotel h5 = new Hotel();
		
		h1.setName("premier   hotel");
		h2.setName("deuxieme  hotel");
		h3.setName("troisieme hotel");
		h4.setName("quatrieme hotel");
		h5.setName("cinquieme hotel");
		
		List<Hotel> hotels = new ArrayList<Hotel>(Arrays.asList(
					h1,h2,h3,h4,h5
				));
		
		//call Core.getHotelsByRating()
		
		this.setHotels(hotels);
		return "hotelResult";
	}
	
	public String findSites()
	{
		Site h1 = new ActivitySite();
		Site h2 = new HistoricSite();
		Site h3 = new ActivitySite();
		Site h4 = new HistoricSite();
		Site h5 = new ActivitySite();
		
		h1.setName("premier   site");
		h1.setId(1);
		h2.setName("deuxieme  site");
		h2.setId(2);
		h3.setName("troisieme site");
		h3.setId(3);
		h4.setName("quatrieme site");
		h4.setId(4);
		h5.setName("cinquieme site");
		h5.setId(5);
		
		
		List<Site> sites = new ArrayList<Site>(Arrays.asList(
					h1,h2,h3,h4,h5
				));
		
		//call Core.getHotelsByRating()
		
		this.setSites(sites);
		
		return "sitesResult";
	}
	
	public String getGamme() {
		return gamme;
	}

	public void setGamme(String gamme) {
		this.gamme = gamme;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public int getSiteType() {
		return siteType;
	}

	public void setSiteType(int siteType) {
		this.siteType = siteType;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
}
