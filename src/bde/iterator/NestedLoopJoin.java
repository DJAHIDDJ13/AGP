package bde.iterator;

import java.sql.SQLException;

import bde.lucene.persistence.LuceneConstants;

public class NestedLoopJoin implements Iterator{
	
	private Node head;
	
	private OperatorSQL SQLIterator;
	private OperatorLucene LuceneIterator;
	
	private String SQLQuery;

	private String LuceneQuery;
	
	
	public NestedLoopJoin() {
		
	}

	@Override
	public void init() {
		SQLIterator = new OperatorSQL();
		
		SQLIterator.setQuery(SQLQuery);
		
		LuceneIterator = new OperatorLucene(LuceneQuery);
		
		SQLIterator.init();
		LuceneIterator.init();
	}

	@Override
	public boolean next() {
		boolean next = false;
		Node node;
		
		try {
			if(SQLIterator.next()) {
				String id = SQLIterator.getString(1);
				node = LuceneIterator.exists(id);
			
				while(node == null && SQLIterator.next()) {
					id = SQLIterator.getString(1);
					node = LuceneIterator.exists(id);
				}
			
				next = node != null;
				if(next)
					fusion(SQLIterator, node);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return next;
	}

	private void fusion(OperatorSQL sQLIterator, Node node) {
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
		data[size-1] = node.getColumnAt(1);
		
		head.setData(data);
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
	
	public String getSQLQuery() {
		return SQLQuery;
	}

	public void setSQLQuery(String sQLQuery) {
		SQLQuery = sQLQuery;
	}

	public String getLuceneQuery() {
		return LuceneQuery;
	}

	public void setLuceneQuery(String luceneQuery) {
		LuceneQuery = luceneQuery;
	}

}