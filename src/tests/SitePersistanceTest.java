package tests;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;

import bde.persistence.jdbc.SitePersistance;
import business.island.Site;

public class SitePersistanceTest {
	
	public static void main(String[] args) {
		

		HashMap<Integer, Site> sites = SitePersistance.getIslandSites(1); 
		for (Entry<Integer, Site> c : sites.entrySet()) {
			System.out.println(c.getValue().getName());
		}
	}

}
