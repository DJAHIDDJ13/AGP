package bde.iterator;

import java.sql.SQLException;

public class NestedLoopJoint implements Iterator{
	
	private Node head;
	
	private OperatorSQL SQLIterator;
	private OperatorLucene LuceneIterator;
	
	private String SQLQuery;
	private String LuceneQuery;
	
	public NestedLoopJoint() {
		
	}
	
	public NestedLoopJoint(String sQLQuery, String luceneQuery) {
		SQLQuery = sQLQuery;
		LuceneQuery = luceneQuery;
	}

	@Override
	public void init() {
		SQLIterator = new OperatorSQL(SQLQuery);
		LuceneIterator = new OperatorLucene(LuceneQuery);
		
		SQLIterator.init();
		LuceneIterator.init();
	}

	@Override
	public boolean next() {
		boolean next = false;
		Node node;
		try {
			String id = SQLIterator.getString(0);
			node = LuceneIterator.exists(id);
			
			while(node == null && SQLIterator.next()) {
				id = SQLIterator.getString(0);
				node = LuceneIterator.exists(id);
			}
			
			next = node != null;
			if(next)
				fusion(SQLIterator, node);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return next;
	}


	private void fusion(OperatorSQL sQLIterator, Node node) {
		int size = sQLIterator.getColumnCount() + 1;
		String[] data = new String[size];
		head = new Node(size);
		
		for(int i = 0; i < size-1; i++) {
			try {
				data[i] = sQLIterator.getString(i);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		data[size-1] = node.getColumnAt(1);
		
		head.setData(data);
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