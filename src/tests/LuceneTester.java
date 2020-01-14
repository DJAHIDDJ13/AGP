package tests;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;

import bde.iterator.OperatorLucene;
import bde.lucene.persistence.LucenePersistence;

public class LuceneTester {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		String indexDir = "src/luceneSRC/index/";
		String dataDir = "src/luceneSRC/data/";
		
		LucenePersistence lucene = new LucenePersistence(indexDir, dataDir);
		
		lucene.createIndex();
		OperatorLucene luceneResult = new OperatorLucene("hello AND NOT by");
		luceneResult.init();
		
		if(luceneResult != null) {
			do {
				try {
					System.out.println("id: " + luceneResult.getString(0) + ",score: "+ luceneResult.getString(1));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}while(luceneResult.next());
		}
		
		lucene.deletIndexFile();
	}
}