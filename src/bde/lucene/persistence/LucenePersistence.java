package bde.lucene.persistence;

import java.io.IOException;

import bde.dao.Persistence;
import bde.lucene.core.Indexer;
import bde.lucene.core.Searcher;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

public class LucenePersistence implements Persistence{

	private String indexDir;
	private String dataDir;
	
	private Indexer indexer;
	private Searcher searcher;
	
	public LucenePersistence() {
		
	}
	
	public LucenePersistence(String indexDir, String dataDir) {
		this.indexDir = indexDir;
		this.dataDir = dataDir;
	}
	
	@Override
	public void dataInit() {
		try {
			indexer = new Indexer(indexDir);
			searcher = new Searcher(indexDir);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void createIndex() throws IOException {
		int numIndexed;
		long startTime = System.currentTimeMillis();	
		
		numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
		long endTime = System.currentTimeMillis();
		indexer.close();
		
		System.out.println(numIndexed+" File indexed, time taken: "+(endTime-startTime)+" ms");		
	}
		   
	public void search(String searchQuery) throws IOException, ParseException {
		long startTime = System.currentTimeMillis();
		TopDocs hits = searcher.search(searchQuery);
		long endTime = System.currentTimeMillis();
		   
		System.out.println(hits.totalHits +" documents found. Time :" + (endTime - startTime));
		
		for(ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = searcher.getDocument(scoreDoc);
			
			System.out.println("File: " + doc.get(LuceneConstants.FILE_PATH));
		}  
	}

	public String getIndexDir() {
		return indexDir;
	}

	public void setIndexDir(String indexDir) {
		this.indexDir = indexDir;
	}

	public String getDataDir() {
		return dataDir;
	}

	public void setDataDir(String dataDir) {
		this.dataDir = dataDir;
	}

	public Indexer getIndexer() {
		return indexer;
	}

	public void setIndexer(Indexer indexer) {
		this.indexer = indexer;
	}

	public Searcher getSearcher() {
		return searcher;
	}

	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}
}