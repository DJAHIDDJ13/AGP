package bde.api;
import java.io.IOException;

import bde.iterator.IndexedJoint;
import bde.iterator.NestedLoopJoint;
import bde.iterator.OperatorLucene;
import bde.iterator.OperatorSQL;
import bde.lucene.core.LuceneBuilder;
import bde.lucene.persistence.LuceneConstants;
import bde.lucene.persistence.LucenePersistence;
import bde.lucene.persistence.TextFileFilter;

public class APIFacade {
	
	private String tableName;
	private String tableKey;
	private String dataDirectory;
	
	private LucenePersistence lucene;
	
	private LuceneBuilder builder;
	
	public APIFacade(String tableName, String tableKey, String dataDirectory) {
		this.tableName = tableName;
		this.tableKey = tableKey;
		this.dataDirectory = dataDirectory;
		
		builder = new LuceneBuilder(dataDirectory);
		try {
			builder.createFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lucene = new LucenePersistence(LuceneConstants.INDEX_FILE, dataDirectory);
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
	
	public OperatorLucene luceneQuery(String query) {
		OperatorLucene iterator = new OperatorLucene(query);
		
		iterator.init();
		
		return iterator;
	}
	
	public OperatorSQL SQLQuery(String query) {
		OperatorSQL iterator = new OperatorSQL(query);
		
		iterator.init();
		
		return iterator;
	}
	
	public NestedLoopJoint MixedQuery(String Mixedquery) {
		String[] query = Mixedquery.split(" with ");		
		NestedLoopJoint iterator = new NestedLoopJoint();
		
		String queryModified = checkSyntax(query[0]);
		if(!queryModified.isEmpty()) {
			iterator = new NestedLoopJoint(queryModified, query[1]);
			iterator.init();
		}
		else {
			System.err.println("Syntax error please give the right table !");
		}
		
		return iterator;
	}
	
	public IndexedJoint MixedIndexedQuery(String Mixedquery) {
		String[] query = Mixedquery.split(" with ");		
		IndexedJoint iterator = new IndexedJoint();
		
		String queryModified = checkSyntax(query[0]);
		if(!queryModified.isEmpty()) {
			iterator = new IndexedJoint(queryModified, query[1], tableKey);
			iterator.init();
		}
		else {
			System.err.println("Syntax error please give the right table !");
		}
		
		return iterator;
	}	

	private String checkSyntax(String string) {
		String check = "";
		
		string = string.toLowerCase();
		String[] data = string.split(" from ");
		
		if(data[1].contains(tableName)) {
			String tmp = string.replace("select", "");
			tmp = string.replace(" ", "");
			
			if(!tmp.equals("*") && !tmp.contains(tableKey)) {
				string = string.replace("select", "");
				check = "select " + tableKey + "," + string;
			}
			else {
				check = string;
			}
		}
		
		return check;
	}
}