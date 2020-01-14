package bde.persistence.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import business.island.ActivitySite;
import business.island.HistoricSite;
import business.island.Site;

public class SitePersistance {
	

	
	public static Site getSite(int siteId){
		Site site = null; 
		ResultSet resultSet = JdbcUtility.request("select * from  site where id_site=" + siteId);
		try {
			if(resultSet.next() == false)
				return null;
			
			if(resultSet.getString("type_site").equals("historic")) {
				// Historic(int id, String name, Place place, Station station) {
				site = new HistoricSite(siteId, resultSet.getString("name_site"), null, null); 
			}
			else{
				site = new ActivitySite(siteId, resultSet.getString("name_site"), null, null); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return site; 
	}
	
	public static HashMap<Integer, Site> getIslandSites(int islandId) {
		
		HashMap<Integer, Site> sites = new HashMap<Integer, Site>();
		
		ResultSet resultSet = JdbcUtility.request("select * from  site where id_island=" + islandId);
		try {
			while(resultSet.next() == true) {
				Site site = getSite(resultSet.getInt("id_site")); 
				sites.put(site.getId(), site); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return sites; 
		
	}

}
