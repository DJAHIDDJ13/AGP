package business.engine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {
	private float dist[];
	private Node prev[];
    private Set<Integer> settled; 
    private PriorityQueue<Node> pq;
    private int V;
	private HashMap<Integer, List<Node>> adj;
	
	public Graph(int V, HashMap<Integer, List<Node>> adj) {
		this.V = V; 
    	dist = new float[V];
    	prev = new Node[this.V];

    	settled = new HashSet<Integer>(); 
    	pq = new PriorityQueue<Node>(V, new Node()); 
    	this.adj = adj;
	}
	
    // Function for Dijkstra's Algorithm 
    public void dijkstra(int src) {
    	
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE; 
            prev[i] = null;
        }
        // Add source node to the priority queue 
        pq.add(new Node(src, 0)); 
  
        // Distance to the source is 0 
        dist[src] = 0; 
        while (settled.size() != V) { 
  
            // remove the minimum distance node  
            // from the priority queue  
            Node u = pq.remove(); 
            // adding the node whose distance is 
            // finalized 
            settled.add(u.node); 
  
            e_Neighbours(u); 
        }
    } 
  
    // Function to process all the neighbors  
    // of the passed node 
    private void e_Neighbours(Node u) { 
        float edgeDistance = -1; 
        float newDistance = -1; 
  
        // All the neighbors of v 
        List<Node> lst = adj.get(u.node);
        for (Node v: lst) { //  (int i = 0; i < lst.size(); i++) { 
            // Node v = lst.get(i); 
  
            // If current node hasn't already been processed 
            if (!settled.contains(v.node)) { 
                edgeDistance = v.cost; 
                newDistance = dist[u.node] + edgeDistance; 
  
                // If new distance is cheaper in cost 
                if (newDistance < dist[v.node]) {
                    dist[v.node] = newDistance; 
                    prev[v.node] = u;
                }
                // Add the current node to the queue 
                pq.add(new Node(v.node, dist[v.node])); 
            } 
        } 
    }

	public Node[] getPrev() {
		return prev;
	}   
}