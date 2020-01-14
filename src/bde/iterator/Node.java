package bde.iterator;

public class Node {
	
	private int size;
	private String[] data;
    
	private Node next;

	public Node() {
		
	}
	
	public Node(int size) {
		this.size = size;
		data = new String[size];
		next = null;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String[] getData() {
		return data;
	}

	public void setData(String[] data) {
		this.data = data;
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getColumnAt(int i) throws IndexOutOfBoundsException{
		if(i < size) {
			return data[i];
		}
		else {
			throw new IndexOutOfBoundsException();
		}
	}
}