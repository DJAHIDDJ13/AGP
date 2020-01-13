package tests;

import java.io.IOException;

import org.apache.lucene.queryparser.classic.ParseException;

import bde.lucene.persistence.LucenePersistence;

public class LuceneTester {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		String indexDir = "src/luceneSRC/index/";
		String dataDir = "src/luceneSRC/data/";
		
		LucenePersistence lucene = new LucenePersistence(indexDir, dataDir);
		lucene.dataInit();
		
		lucene.createIndex();
		lucene.search("hello");
	}
}
