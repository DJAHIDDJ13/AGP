package business.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph<X> {
	private HashMap<X, Float> dist;
	private HashMap<X, Node<X>> prev;
	
    private Set<X> settled; 
    private PriorityQueue<Node<X>> pq;
    private HashMap<X, List<Node<X>>> adj;
    
    // TODO: remove V
    public Graph(int V) {
    	this(V, new HashMap<X, List<Node<X>>>());
    }
    
	public Graph(int V, HashMap<X, List<Node<X>>> adj) {
		dist = new HashMap<X, Float>();
    	prev = new HashMap<X, Node<X>>();

    	settled = new HashSet<X>(); 
    	pq = new PriorityQueue<Node<X>>(V, new Node<X>()); 
    	this.adj = adj;
	}
	
    // Function for Dijkstra's Algorithm 
    public void dijkstra(X src) {
        // Add source Node<X> to the priority queue 
        pq.add(new Node<X>(src, 0)); 
  
        // Distance to the source is 0 
        dist.put(src, (float) 0); 
        //while (settled.size() != V) { 
        while(pq.size() > 0) {
            // remove the minimum distance Node<X>  
            // from the priority queue  
            Node<X> u = pq.remove(); 
            // adding the Node<X> whose distance is 
            // finalized 
            settled.add(u.node); 
  
            dijkstraHelper(u); 
        }
    } 
      
    // Function to process all the neighbors  
    // of the passed node 
    private void dijkstraHelper(Node<X> u) {
        float edgeDistance = -1; 
        float newDistance = -1; 
  
        // All the neighbors of v 
        List<Node<X>> lst = adj.get(u.node);
        if(lst == null) { return ; } // sanity check
        for (Node<X> v: lst) {  
            // If current node hasn't already been processed 
            if (!settled.contains(v.node)) { 
                edgeDistance = v.cost;
            	newDistance = getDist(u.node) + edgeDistance;

                
                // If new distance is cheaper in cost 
                if (newDistance < getDist(v.node)) {
                    dist.put(v.node, newDistance); 
                    prev.put(v.node, u);
                }
                // Add the current Node<X> to the queue 
                pq.add(new Node<X>(v.node, getDist(v.node))); 
            } 
        } 
    }
  
    /**
     * @param k the key to access from
     * @return Float.MAX_VALUE as a default, otherwise the actual value
     */
    private float getDist(X k) {
        Float distVal = dist.get(k);
        float val = Float.MAX_VALUE;
        if(distVal != null) {
        	val = dist.get(k); 
        }
        
        return val;
    }
    
	public HashMap<X, List<Node<X>>> getAdj() {
		return adj;
	}

	public void setAdj(HashMap<X, List<Node<X>>> adj) {
		this.adj = adj;
	}
		
	public void addAdjacencyEntry(X src, Node<X> entry) {
		List<Node<X>> lst = adj.get(src);
	    if(lst == null) {
	    	lst = new ArrayList<Node<X>>();
	    	adj.put(src, lst);
	    }
	    lst.add(entry);
	}	
	
	public void removeAdjacencyList(X src) {
		adj.remove(src);
	}
	/*
	public HashMap<X, Node<X>> getPrev() {
		return prev;
	}
	*/
    public List<Object> getPath(X src, X dst) {
    	List<Object> res = new ArrayList<Object>();
    	
		while(!dst.equals(src)) {
			res.add(dst); 

			Node<X> n = prev.get(dst);
			if(n == null) {
				return null;
			}
			
			dst = n.node;
		}
		res.add(src);
		
		Collections.reverse(res);
		return res;
    }

}