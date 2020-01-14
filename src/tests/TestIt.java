package tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.sun.faces.mgbean.ManagedBeanInfo.MapEntry;

import bde.persistence.jdbc.IslandPersistance;
import business.island.Hotel;
import business.island.Island;
import business.island.Site;
import business.transport.Station;

public class TestIt {
	
		public static void main(String[] args) {
			
			List<Island> islands = new IslandPersistance().getAllIsland(); 
			for (Island island : islands) {
				
			    System.out.println( island.getIslandHotels().size());
				//for ( Entry<Integer, Hotel> entry :  island.getIslandHotels().entrySet()) {
				//}
				
			}
	
		}
}
