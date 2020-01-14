package tests;

import bde.api.APIFacade;
import bde.iterator.Iterator;

public class BDEClient {

	public static void main(String[] args) {
		
		String table = "site";
		String cle = "id_site";
		String dataDir = "src/luceneSRC/data/";
		
		APIFacade clientFacadeAPI = new APIFacade(table, cle, dataDir);
		
		clientFacadeAPI.createIndexDir();
		
		String query = "baie OR culture";
		Iterator iterator = clientFacadeAPI.luceneQuery(query);
		
		try {
			while(iterator.next()) {
				System.out.println("ID : " + iterator.getString(0) + ", Pertinance : " + iterator.getString(1));		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------\n");
		
		query = "SELECT * FROM site WHERE type_site = 'historic'";
		iterator = clientFacadeAPI.SQLQuery(query);
		
		try {
			while(iterator.next()) {
				for(int i = 1; i <= iterator.getColumnCount(); i++) {
					System.out.print(iterator.getString(i) + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------\n");
		
		//query = "SELECT * FROM site WHERE type_site = 'historic' with baie OR culture";
		query = "SELECT type_site FROM site WHERE type_site = 'historic' with baie OR culture";
		iterator = clientFacadeAPI.MixedQuery(query);
		
		try {
			while(iterator.next()) {
				for(int i = 1; i < iterator.getColumnCount(); i++) {
					System.out.print(iterator.getString(i) + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------\n");
		
		//query = "SELECT * FROM site WHERE type_site = 'historic' with baie OR culture";
		query = "SELECT type_site FROM site WHERE type_site = 'historic' with baie OR culture";
		iterator = clientFacadeAPI.MixedIndexedQuery(query);
		
		try {
			while(iterator.next()) {
				for(int i = 1; i < iterator.getColumnCount(); i++) {
					System.out.print(iterator.getString(i) + " ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		clientFacadeAPI.close();
	}
}