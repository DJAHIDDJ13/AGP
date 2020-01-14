package business.engine;

import java.util.Comparator;

public class Node<X> implements Comparator<Node<X>>{
    public X node; 
    public float cost; 
    
    public Node() {
    	
    } 
    
    public Node(X node, float cost) { 
        this.node = node; 
        this.cost = cost; 
    }
    
    @Override
    public int compare(Node<X> node1, Node<X> node2) {
        if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
    } 
}