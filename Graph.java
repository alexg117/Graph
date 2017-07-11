
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


/**
 * This class represents a graph
 *
 * Specification fields:
 *  @specfield nodes       : Map<NT,Node<NT,ET>      // Maps Strings to their nodes, which in turn store their edges
 *  @specfield EC          : Comparator<Edge<NT,ET>> // Comparator for edges which may be defined by user
 *
 *
 * rep Invariant:
 * no two nodes have identical data values
 * nodes should not have edges that point to nodes that are not in the graph
 * Nodes are sorted by the specified comparator if applicable
 * 
 * Abs. function:
 * The graph consists of vertices defined by "nodes". The Node class is used to describe the graph's vertices
 * and the Edge class defines directed edges between nodes.
 */

public class Graph<TN,TE> {
	private Map<TN,Node<TN,TE>> nodes;
	private Comparator<Edge<TN,TE>> EC;
	
	/** Creates a new blank Graph
   * @return a new blank Graph
   */
	public Graph() {
		nodes=new HashMap<TN,Node<TN,TE>>();
//		checkRep();
		EC=null;
	}

	/** Creates a new blank sorted Graph
   * @return a new blank Graph sorted by given comparators
   */
	public Graph(Comparator<TN> nc,Comparator<Edge<TN,TE>> ec) {
		nodes=new TreeMap<TN,Node<TN,TE>>(nc);
		EC=ec;
//		checkRep();
	}
	/** adds new node with given data to nodes. If the node already exists, nothing is changed
   * @effects adds new node with given data to nodes
   */
	public void addNode(TN data) {
		if (EC!=null) nodes.put(data, new Node<TN,TE>(data,EC));
		else nodes.put(data, new Node<TN,TE>(data));
//		checkRep();
	}
	
	/** adds new edge to node StartNode that has destination EndNode and data
   * @requires StartNode and EndNode are in graph
   * @throws RuntimeException if one or both nodes is not in graph
   * @effects adds new edge to node StartNode
   */

	public void addEdge(TN StartNode,TN EndNode,TE data) throws RuntimeException {
		Node<TN,TE> temp=nodes.get(StartNode);
		if (hasNode(StartNode)&&hasNode(EndNode))
			temp.addEdge(new Edge<TN,TE>(EndNode,data));
		else throw new RuntimeException("Error: Adding Edge between nonexistent nodes");
		//checkRep();
	}
	
	/** Returns an iterator for all nodes.
   * @return an iterator for nodes.
   */
	public Iterator<Node<TN,TE>> getNodes() {
		return nodes.values().iterator();
	}
	/** Returns the node with label s.
	   * @return a Node with label s.
	   * @throws RuntimeException if no node with this label exists
	   */
	public Node<TN,TE> getNode(TN s) {
		if (nodes.containsKey(s))
				return nodes.get(s);
		else throw new RuntimeException("It's not in the graph!");
	}
	public boolean hasNode(TN s) {
		if (nodes.containsKey(s)) return true;
		return false;
		
	}
	/*
	void checkRep() {
		for (int x=0;x<nodes.size()-1;x++) {
			if (nodes.get(x).getData().compareTo(nodes.get(x+1).getData())>=0) throw new RuntimeException("Error: invalid Graph");
			//As connections to nodes not on the graph cannot be created and nodes can't be removed, there is no need to check
			//for such connections.
		}
	}
	*/
}
