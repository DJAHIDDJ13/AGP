package bde.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
 
	private Node<T> head;
 
    public LinkedList(T data) {
        head = new Node<>(data);
    }
 
    public void add(T data) {
    	Node<T> current = head;
        while (current.next != null)
        	current = current.next;
        current.next = new Node<>(data);
    }
    
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }
 
    private class LinkedListIterator implements Iterator<T> {
 
        private Node<T> node = head;
 
        @Override
        public boolean hasNext() {
            return node != null;
        }
 
        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Node<T> prevNode = node;
            node = node.next;
            return prevNode.data;
        }
 
        @Override
        public void remove() {
        	throw new UnsupportedOperationException("Removal logic not implemented.");
        }
    }
}