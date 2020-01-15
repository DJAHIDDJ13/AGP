package business.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {
	private HashMap<PathEntry, Float> dist;
	private HashMap<PathEntry, Node> prev;
	
    private Set<PathEntry> settled; 
    private PriorityQueue<Node> pq;
    private HashMap<PathEntry, List<Node>> adj;
    private int defaultPriorityQueueSize = 30;
    
    // TODO: remove V
    public Graph() {
		dist = new HashMap<PathEntry, Float>();
    	prev = new HashMap<PathEntry, Node>();

    	settled = new HashSet<PathEntry>(); 
    	pq = new PriorityQueue<Node>(defaultPriorityQueueSize, new Node()); 
    	this.adj = new HashMap<PathEntry, List<Node>>();
    }
    
    // Function for Dijkstra's Algorithm 
    public void dijkstra(PathEntry src) {
        // Add source Node to the priority queue 
        pq.add(new Node(src, 0)); 
  
        // Distance to the source is 0 
        dist.put(src, (float) 0); 
        //while (settled.size() != V) { 
        while(pq.size() > 0) {
            // remove the minimum distance Node  
            // from the priority queue  
            Node u = pq.remove(); 
            // adding the Node whose distance is 
            // finalized 
            settled.add(u.node); 
  
            dijkstraHelper(u); 
        }
    } 
      
    // Function to process all the neighbors  
    // of the passed node 
    private void dijkstraHelper(Node u) {
        float edgeDistance = -1; 
        float newDistance = -1; 
  
        // All the neighbors of v 
        List<Node> lst = adj.get(u.node);
        if(lst == null) { return ; } // sanity check
        for (Node v: lst) {  
            // If current node hasn't already been processed 
            if (!settled.contains(v.node)) { 
                edgeDistance = v.cost;
            	newDistance = getDist(u.node) + edgeDistance;

                
                // If new distance is cheaper in cost 
                if (newDistance < getDist(v.node)) {
                    dist.put(v.node, newDistance); 
                    prev.put(v.node, u);
                }
                // Add the current Node to the queue 
                pq.add(new Node(v.node, getDist(v.node))); 
            } 
        } 
    }
  
    /**
     * @param k the key to access from
     * @return Float.MAX_VALUE as a default, otherwise the actual value
     */
    private float getDist(PathEntry k) {
        Float distVal = dist.get(k);
        float val = Float.MAX_VALUE;
        if(distVal != null) {
        	val = dist.get(k); 
        }
        
        return val;
    }
    
	public HashMap<PathEntry, List<Node>> getAdj() {
		return adj;
	}

	public void setAdj(HashMap<PathEntry, List<Node>> adj) {
		this.adj = adj;
	}
		
	public void addAdjacencyEntry(PathEntry src, Node entry) {
		List<Node> lst = adj.get(src);
	    if(lst == null) {
	    	lst = new ArrayList<Node>();
	    	adj.put(src, lst);
	    }
	    lst.add(entry);
	}	
	
	public void removeAdjacencyList(PathEntry src) {
		adj.remove(src);
	}
	/*
	public HashMap<pathEntry, Node> getPrev() {
		return prev;
	}
	*/
    public List<Object> getPath(PathEntry src, PathEntry dst) {
    	List<Object> res = new ArrayList<Object>();
    	
		while(!dst.equals(src)) {
			res.add(dst); 

			Node n = prev.get(dst);
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