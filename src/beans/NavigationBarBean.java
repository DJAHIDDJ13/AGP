package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;	

@ManagedBean
@RequestScoped
public class NavigationBarBean implements Serializable {

	private static final long serialVersionUID = 8985285697726725203L;

	public String search()
	{
		return "search";
	}
	
	public String generateOffers()
	{
		return "offers";
	}
	
	public String homePage()
	{
		return "home";
	}
	
	public String panelPage() {
		return "panel";
	}
}
