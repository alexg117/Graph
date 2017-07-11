package hw4;

/**
 * This class represents an edge on a graph.
 *
 * Specification fields:
 *  @specfield data        : TE    // The data held by the edge
 *  @specfield N           : TN    // The destination Node's data
 *
 *
 * rep Invariant:
 *  An edge's destination node may not be null.
 *  
 *  Abstraction function:
 *  This is a directed edge that leads from the node that holds it to the node 
 *  specified by N and has label/weight data
 */
public class Edge<TN,TE> {
	private TE data;
	private TN N;
	  /** Creates a new Edge with given data and destination node
   * @return a new Edge with given data and destination node
   */
	protected Edge(TN nodeData,TE data) {
		N=nodeData; this.data=data;
		//checkRep();
	}
	
	/** Returns the edge's data value.
   * @return this.data.
   */
	public TE getData() {
		return data;
	}
	
	/** Returns the edge's destination node's data.
   * @return this.N.
   */
	public TN getNodeData() {
		return N;
	}
	//.equals replacement, compares edges based on label and destination node label
	public boolean equals(Edge<TN,TE> E) {
		return getData().equals(E.getData())&&N.equals(E.getNodeData());
	}
	//hashcode replacement, based on edge label and destination node label
	@Override
	public int hashCode() {
		return getData().hashCode()*1337+N.hashCode();
	}
	/*
	private void checkRep() {
		if (N==null) throw new RuntimeException("Error: invalid edge");
	}
	*/
}
/*
final class EdgeComp implements Comparator<Edge<T>> {

	public int compare(Edge e1,Edge e2) {
		if (e1==null) return -1;
		else if (e2==null) return 1;
		if (e1.getNodeData()!=(e2.getNodeData())) 
			return e1.getNodeData().compareTo(e2.getNodeData());
		return e1.getData().compareTo(e2.getData());
	}
	
}
*/