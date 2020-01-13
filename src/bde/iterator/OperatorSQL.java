package bde.iterator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("rawtypes")
public class OperatorSQL implements Iterable {
	
	private ResultSet head;
	
    public OperatorSQL() {
    	head = null;
    }
    
    public OperatorSQL(ResultSet data) {
    	head = data;
    }   
	
	@Override
	public Iterator iterator() {
		return new OperatorSQLIterator();
	}
	
    //private iterator for thin container
	private class OperatorSQLIterator implements Iterator {
 
        private ResultSet node = head;
 
        @Override
        public boolean hasNext() {
            return node != null;
        }
 
        @Override
        public ResultSet next() {
            if (!hasNext())
                throw new NoSuchElementException();
            ResultSet prevNode = node;
            
            try {
				node.next();
			} catch (SQLException e) {
				e.printStackTrace();
			}
            return prevNode;
        }
 
        @Override
        public void remove() {
        	throw new UnsupportedOperationException("Removal logic not implemented.");
        }
    }	

}
