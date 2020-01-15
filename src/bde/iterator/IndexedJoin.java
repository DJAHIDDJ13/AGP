package bde.iterator;

import java.sql.SQLException;

import bde.lucene.persistence.LuceneConstants;

public class IndexedJoin implements Iterator{
	
	private Node head;
	
	private OperatorLucene LuceneIterator;
	
	private String LuceneQuery;
	private String SQLQuery;
	private String key;
	
	private boolean containsWHERE;
	
	public IndexedJoin() {
		
	}
	
	public IndexedJoin(String query, String key) {
		setQuery(query);
		this.key = key;
		containsWHERE = SQLQuery.contains(" where ");
	}

	@Override
	public void init() {
		LuceneIterator = new OperatorLucene(LuceneQuery);
		
		LuceneIterator.init();
	}

	@Override
	public boolean next() {
		boolean next = false;
		String pertinance;
		
		try {	
			while(!next && LuceneIterator.next()) {
				String id = LuceneIterator.getString(0);
				String query = injectIdToQuery(id);
				
				OperatorSQL SQLIterator = new OperatorSQL(query);
				SQLIterator.init();
				if(SQLIterator.next()) {
					pertinance = LuceneIterator.getString(1);
					fusion(SQLIterator, pertinance);
					next = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return next;
	}
	
	private void fusion(OperatorSQL sQLIterator, String pertinance) {
		int size = sQLIterator.getColumnCount() + 2;
		String[] data = new String[size];
		head = new Node(size);
		
		for(int i = 1; i < size-1; i++) {
			try {
				data[i] = sQLIterator.getString(i);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		data[size-1] = pertinance;
		
		head.setData(data);
	}

	private String injectIdToQuery(String id) {
		String query = SQLQuery;
		
		if(containsWHERE)
			query += " AND " + key +" = " + id;
		else
			query += " WHERE " + key +" = " + id;

		return query;
	}
	
	public void setQuery(String Mixedquery) {
		String[] query = Mixedquery.split(" with ");		
		
		String queryModified = checkSyntax(query[0]);
		if(!queryModified.isEmpty()) {
			this.SQLQuery = queryModified;
			this.LuceneQuery = query[1];
		}
		else {
			System.err.println("Syntax error please give the right table !");
		}		
	}
	
	private String checkSyntax(String string) {
		String check = "";
		
		string = string.toLowerCase();
		String[] data = string.split(" from ");
		
		if(data[1].contains(LuceneConstants.TABLEDB_NAME)) {
			String tmp = string.replace("select", "");
			tmp = string.replace(" ", "");
			
			if(!tmp.equals("*") && !tmp.contains(LuceneConstants.KEY_NAME)) {
				string = string.replace("select", "");
				check = "select " + LuceneConstants.KEY_NAME + "," + string;
			}
			else {
				check = string;
			}
		}
		
		return check;
	}	

	@Override
	public void add(Node node) {
		
	}

	@Override
	public int getColumnCount() {
		return head.getSize();
	}

	@Override
	public String getString(int columnIndex) throws Exception {
		return head.getColumnAt(columnIndex);
	}
}
