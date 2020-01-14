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
		OperatorLucene luceneResult = new OperatorLucene("hello OR by");
		luceneResult.init();
		
		if(luceneResult.getHead() != null) {
			do {
				System.out.println("id: " + luceneResult.getHead().getData()[0] + ",score: "+ luceneResult.getHead().getData()[1]);
			}while(luceneResult.next());
		}
		
		lucene.deletIndexFile();
	}
}
