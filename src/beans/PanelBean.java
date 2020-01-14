package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import business.island.Hotel;


@ManagedBean
@SessionScoped
public class PanelBean implements Serializable  {

	private static final long serialVersionUID = -7783611276059752951L;

	private List<Integer> sites = new ArrayList<Integer>();
	private Hotel hotel;
	
	public List<Integer> getSites() {
		return sites;
	}
	public void setSites(List<Integer> sites) {
		this.sites = sites;
	}
	
	public Hotel getHotel() {
		return hotel;
	}
	
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}	
	
	public void addSite(int id) {
		if(!sites.contains(id))
			sites.add(id);
	}
	

}
