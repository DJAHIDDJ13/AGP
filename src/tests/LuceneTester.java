package tests;

import java.io.IOException;
import java.util.Iterator;

import org.apache.lucene.queryparser.classic.ParseException;

import bde.iterator.LinkedList;
import bde.lucene.core.LuceneResult;
import bde.lucene.persistence.LucenePersistence;

public class LuceneTester {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		String indexDir = "src/luceneSRC/index/";
		String dataDir = "src/luceneSRC/data/";
		
		LucenePersistence lucene = new LucenePersistence(indexDir, dataDir);
		
		lucene.createIndex();
		LinkedList<LuceneResult> luceneResult = lucene.search("hello");
		
        Iterator<LuceneResult> itr = luceneResult.iterator();
        while (itr.hasNext()) {
            LuceneResult couple = itr.next();
            System.out.println("id: " + couple.getId() + ",score: "+ couple.getScore());
        }
		
		lucene.deletIndexFile();
	}
}
