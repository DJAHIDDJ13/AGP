package business.engine;

import java.util.Comparator;

public class Node implements Comparator<Node> {
    
	public int node;
    public float cost;
  
    public Node() {
    	
    } 
    
    public Node(int node, float cost) { 
        this.node = node; 
        this.cost = cost; 
    } 
    
    @Override
    public int compare(Node node1, Node node2) { 
        if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
    } 
}