package bde.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import bde.lucene.core.LuceneResult;

@SuppressWarnings("rawtypes")
public class OperatorLucene implements Iterable {
 
	private Node<LuceneResult> head;
 
    public OperatorLucene() {
    	head = null;
    }
	
    public OperatorLucene(LuceneResult data) {
        head = new Node<>(data);
    }

	public void add(LuceneResult data) {
		if(head == null) {
			head = new Node<>(data);
		}
		else {
			Node<LuceneResult> current = head;
			while (current.next != null)
				current = current.next;
			current.next = new Node<>(data);
		}
    }
    
    @SuppressWarnings("unchecked")
	public Iterator<LuceneResult> iterator() {
        return new OperatorLuceneIterator();
    }
 
    //private iterator for this container
    private class OperatorLuceneIterator implements Iterator {
 
        private Node<LuceneResult> node = head;
 
        @Override
        public boolean hasNext() {
            return node != null;
        }
 
        @Override
        public LuceneResult next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Node<LuceneResult> prevNode = node;
            node = node.next;
            return prevNode.data;
        }
 
        @Override
        public void remove() {
        	throw new UnsupportedOperationException("Removal logic not implemented.");
        }
    }
}