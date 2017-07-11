package hw4;

import java.util.*;
/**
 * This class represents a node on a graph.
 *
 * Specification fields:
 *  @specfield data       : String                   // The data held by the node
 *  @specfield edges      : Set<Edge>                // Set of edges originating at this node
 *  @specfield EC         : Comparator<Edge<TN,TE>>  // Comparator for edges, defined only if edges are to be sorted
 *
 *
 * rep Invariant:
 * edges should be sorted by the specified comparator if applicable
 * 
 * Abs. function:
 * This is a graph vertex that has value/label "data". "Edges" defines all edges leading out of the vertex.
 */
public class Node<TN,TE> {
	private Set<Edge<TN,TE>> edges;
	private TN data;
	Comparator<Edge<TN,TE>> EC;
	  /** Creates a new Node with given data
	   * @return a new Node with given data
	   */
	protected Node(TN d) {
		this.data=d;
		edges=new HashSet<Edge<TN,TE>>();
		//checkRep();
		EC=null;
	} 
	  /** Creates a new Node with given data and sorted edge list, sorted by given comparator
	   * @requires ec is not null
	   * @return a new Node with given data and comparator
	   */
	protected Node(TN d,Comparator<Edge<TN,TE>> ec) {
		this.data=d;
		EC=ec;
		edges=new TreeSet<Edge<TN,TE>>(ec);
		//checkRep();
	} 
	/** adds e to edges, only usable by Graph
	   * @requires e is a valid edge
	   * @effects adds e to edges
	   */
	protected void addEdge(Edge<TN,TE> e) {
		edges.add(e);
	}
	
	/** Returns the node's data value.
	   * @return this.data.
	   */
	public TN getData() {
		return data; 
	}
	
	/** Returns an iterator for all edges originating from this node.
	   * @return an iterator for edges.
	   */
	public Iterator<Edge<TN,TE>> getEdges() {
		return edges.iterator();
	}
	//equals replacement, based on node label
	public boolean equals(Node<TN,TE> N) {
		return getData().equals(N.getData());
	}
	//hashcode replacement, based on node label
	@Override
	public int hashCode() {
		return getData().hashCode();
	}
	
}
/*
final class NodeComp implements Comparator<Node> {

	public int compare(Node n,Node n2) {
		return n.getData().compareTo(n2.getData());
	}
	
}
*/
