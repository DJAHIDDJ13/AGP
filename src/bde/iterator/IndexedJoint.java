package bde.iterator;

import java.sql.SQLException;

public class IndexedJoint implements Iterator{
	
	private Node head;
	
	private OperatorLucene LuceneIterator;
	
	private String LuceneQuery;
	private String SQLQuery;
	private String key;
	
	private boolean containsWHERE;
	
	public IndexedJoint() {
		
	}
	
	public IndexedJoint(String sQLQuery, String luceneQuery, String key) {
		LuceneQuery = luceneQuery;
		SQLQuery = sQLQuery.toLowerCase();
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
