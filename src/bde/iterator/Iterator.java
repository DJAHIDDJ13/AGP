package bde.iterator;

public interface Iterator {

	public void init();
	
	public boolean next();
	
	public void add(Node node);
	
	public int getColumnCount();
	
	public String getString(int columnIndex) throws Exception;
	
	public void setQuery(String Mixedquery);
}
