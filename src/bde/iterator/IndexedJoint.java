package bde.iterator;

public class IndexedJoint implements Iterator{
	
	private Node head;
	
	private OperatorLucene LuceneIterator;
	
	private String LuceneQuery;
	
	public IndexedJoint() {
		
	}
	
	public IndexedJoint(String luceneQuery) {
		LuceneQuery = luceneQuery;
	}

	@Override
	public void init() {
		LuceneIterator = new OperatorLucene(LuceneQuery);
		
		LuceneIterator.init();
	}

	@Override
	public boolean next() {
		boolean next = false;
		
		
		
		return next;
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
