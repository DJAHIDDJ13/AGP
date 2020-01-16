package bde.lucene.persistence;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;

import bde.iterator.Node;
import bde.iterator.OperatorLucene;
import bde.lucene.core.Indexer;
import bde.lucene.core.Searcher;

public class LucenePersistence {

	private static String indexDir = LuceneConstants.INDEX_FILE;
	private String dataDir = LuceneConstants.DATA_FILE;
	
	private Indexer indexer;
	private static Searcher searcher;
	
	public LucenePersistence() {
		try {
			this.createIndex();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public LucenePersistence(String indexDir, String dataDir) {
		LucenePersistence.indexDir = indexDir;
		this.dataDir = dataDir;
	}
	
	public void dataInit() {
		try {
			indexer = new Indexer(indexDir);
			searcher = new Searcher(indexDir);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void createIndex() throws IOException {
		System.out.println(indexDir);
		indexer = new Indexer(indexDir);
		
		int numIndexed;
		long startTime = System.currentTimeMillis();	
		
		numIndexed = indexer.createIndex(dataDir, new TextFileFilter());
		long endTime = System.currentTimeMillis();
		indexer.close();
		
		System.out.println(numIndexed+" File indexed, time taken: "+(endTime-startTime)+" ms");		
	}
	
	public void createIndex(String data, String id) {
		
	}
		   
	public static OperatorLucene search(String searchQuery) throws IOException, ParseException {
		OperatorLucene listLuceneResult = new OperatorLucene();
		
		int size = 2;
		
		searcher = new Searcher(indexDir);
		
		TopDocs hits = searcher.search(searchQuery);
		   		
		for(ScoreDoc scoreDoc : hits.scoreDocs) {
			Document doc = searcher.getDocument(scoreDoc);
			
			Node node = new Node(size);
			String fileName = doc.get(LuceneConstants.FILE_NAME);
			String id = fileName.split(".txt")[0];
			
			String[] data = {id, ""+scoreDoc.score};
			node.setData(data);
			
			listLuceneResult.add(node);
		}
		
		return listLuceneResult;
	}
	
	public void deletIndexFile() {
		File dir = new File(indexDir);
		
		if(dir.isDirectory() == false) {
			System.out.println("Not a directory. Do nothing");
			return;
		}
		
		File[] listFiles = dir.listFiles();
		
		for(File file : listFiles){
			file.delete();
		}		
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
		LucenePersistence.searcher = searcher;
	}
}