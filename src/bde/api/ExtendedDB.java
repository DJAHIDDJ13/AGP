package bde.api;
import java.io.IOException;

import bde.iterator.IndexedJoin;
import bde.iterator.NestedLoopJoin;
import bde.iterator.OperatorLucene;
import bde.iterator.OperatorSQL;
import bde.lucene.core.LuceneBuilder;
import bde.lucene.persistence.LuceneConstants;
import bde.lucene.persistence.LucenePersistence;
import bde.lucene.persistence.TextFileFilter;

public class ExtendedDB {
	
	private String tableName;
	private String tableKey;
	private String dataDirectory;
	
	private LucenePersistence lucene; 
	
	private LuceneBuilder builder;
	
	public ExtendedDB(String tableName, String tableKey, String dataDirectory) {
		this.tableName = tableName;
		this.tableKey = tableKey;
		this.dataDirectory = dataDirectory;
		
		builder = new LuceneBuilder();
		try {
			builder.createFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lucene = new LucenePersistence(LuceneConstants.INDEX_FILE, dataDirectory);
	}
	
	public OperatorLucene luceneQuery(String query) {
		OperatorLucene luceneIterator = new OperatorLucene(query);
		
		luceneIterator.init();
		
		return luceneIterator;
	}
	
	public OperatorSQL SQLQuery(String query) {
		OperatorSQL sqlIterator = new OperatorSQL(query);
		
		sqlIterator.init();
		
		return sqlIterator;
	}
	
	public NestedLoopJoin MixedQuery(String Mixedquery) {		
		NestedLoopJoin nestedLoopIterator = new NestedLoopJoin();
		
		nestedLoopIterator.setQuery(Mixedquery);
		
		nestedLoopIterator.init();
		
		return nestedLoopIterator;
	}
	
	public IndexedJoin MixedIndexedQuery(String Mixedquery) {	
		IndexedJoin mixedIndexedIterator = new IndexedJoin(Mixedquery, tableKey);
		
		mixedIndexedIterator.init();
		
		return mixedIndexedIterator;
	}		
	 
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableKey() {
		return tableKey;
	}

	public void setTableKey(String tableKey) {
		this.tableKey = tableKey;
	}

	public String getDataDirectory() {
		return dataDirectory;
	}

	public void setDataDirectory(String dataDirectory) {
		this.dataDirectory = dataDirectory;
	}

	public LuceneBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(LuceneBuilder builder) {
		this.builder = builder;
	}
	
	public void addText(String t, String c) {
		try {
			TextFileFilter filter = new TextFileFilter();
			lucene.getIndexer().createIndex(dataDirectory, t,  filter, c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createIndexDir() {
		try {
			lucene.createIndex();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		lucene.deletIndexFile();
	}
}	