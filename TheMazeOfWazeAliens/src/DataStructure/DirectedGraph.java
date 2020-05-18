package DataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import Gui.Gui;



//import Gui.GuiwithStdDraw;



public class DirectedGraph implements graph , Serializable
{
	///////// Private Data //////////
	private HashMap<Integer , GraphNode> _VertMap = new HashMap<>();
	private int _numOfEdges = 0;
	private int _ModeCount = 0;
	

	

	////////////// Constructor ///////////////
	// Empty default Constructor For the gui
	public DirectedGraph()
	{
	//this.gui = new Gui(this);
	}
	// Constructor from a given graph
	public DirectedGraph(graph gra)
	{
		// Recive all Nodes from gra
		Collection<node_data> tempVmap = gra.getV();
		for (node_data nodeData : tempVmap) 
		{ // For Each node in gra ,  put it into the new Directed Graph so all the nodes will be presented at the map
			GraphNode node = new GraphNode(nodeData); 
			this._VertMap.put(node.getKey() , node);
		}
		// Once all nodes are in the hashMap we can connect all the edges
		for (node_data nodeData : tempVmap)
		{ // For each node ,  get a list of all neighbors
			Integer nodeID = nodeData.getKey();
			Collection<edge_data> nodesNeigbors= gra.getE(nodeID);
			 for (edge_data theNeigbour : nodesNeigbors) 
			 { 
				 Integer destID = theNeigbour.getDest();
				 double edgeWeight = theNeigbour.getWeight();
				 this.connect(nodeID, destID, edgeWeight);
			 }
		}		
	}
	
	/////// Getters ////////////
	/**
	 * helper method for getNode
	 * @param key
	 * @return
	 */
	public GraphNode get_node(int key)
	{
		GraphNode theNode = this.getVerMap().get(key);
		return theNode;
	}
	public  GraphEdge edgeParser(int src , int dest)
	{
		edge_data theEdge = getEdge(src, dest);
		
		return (GraphEdge)theEdge;
	}
	
	public int getNumOfEdges()
	{
		return this._numOfEdges;
	}
	

	@Override
	public node_data getNode(int key) 
	{
		GraphNode temp = this.get_node(key);
		return temp;
				
	}

	@Override
	public edge_data getEdge(int src, int dest)
	{
		GraphNode srcNode = get_node(src);
		edge_data theEdge = srcNode._adjMap.get(dest);
		return theEdge;
	}
	
	private Collection<GraphNode> getNodeCollection()
	{
		Collection<GraphNode> theCollection = this.getVerMap().values();
		return theCollection;
	}
	@Override
	public Collection<node_data> getV() 
	{
		Collection<GraphNode> temp = getNodeCollection(); // Getting the Node Collection
		Collection<node_data> theCollection = (Collection)temp; // Parsing it into node_data collection
		return theCollection;
		
	}
	
	private Collection<edge_data> getEdgesCollection(int key)
	{
		// Fetching the source Node
		GraphNode srcNode = get_node(key);
		Collection<edge_data> theCollection = srcNode.getAdjMap().values();
		return theCollection;
	}

	@Override
	public Collection<edge_data> getE(int node_id) 
	{
	// Use helper private function to extract the collection
		return getEdgesCollection(node_id);
	}
	public  HashMap<Integer, GraphNode> getVerMap()
	{
		return this._VertMap;
	}
	/////// Setters ////////////
	

	@Override
	/**
	 * 
	 */
	public void addNode(node_data n)
	{
		Integer n_key = n.getKey();
		getVerMap().putIfAbsent(n_key, (GraphNode) n);
		_ModeCount++;
	}	

	/**
	 * This method returns true iff bouth Node exist.
	 * otherwise return false;
	 * @param src 
	 * @param dest
	 * @return
	 */
	public boolean doesNodeExist(int key)
	{
		return(this.get_node(key) != null);
	}
	
	public boolean doesTheeseNodeExist(int src , int dest)
	{
		
		return((this.get_node(src)!= null) && (this.get_node(dest) != null));
	}
	@Override
	/**
	 * This method created an Edge, replacing the current Edge stored there (or Null Edge)
	 * if Any of the nodes to be connected deoes not exist, this method Prints an Error
	 */
	public void connect(int src, int dest, double w)
	{	// Check if the two nodes even exist
		if(this.doesTheeseNodeExist(src, dest)) 
		{ // They exist so we can connect them
			
			// Construction the Edge
			GraphEdge newEdge = new GraphEdge(src, dest, w);
			// Put it into the source Node hashMap
			this.get_node(src).getAdjMap().put(dest, newEdge);
			// Adding the Edge to _allEdges;
			_numOfEdges++;
			_ModeCount++;
		}
		else
		{ // They do not exist
			System.out.println("Error! one of the nodes you try to connect , does not Exist");
		}
		
	}
	
	
	@Override
	public node_data removeNode(int key) 
	{
		if(!doesNodeExist(key))
			// If this Node Dosen't exist print Error
		{
			System.out.println("Error This node Dosent Exist");
		}
		else 
		{	
		// Removing all Edges which destination is the key Vertex.
			// For each key in the hashMap remove every edge poting to removedNode
			for (Integer otherkey : this._VertMap.keySet()) 
			{
				this.removeEdge(otherkey,key);			
			}
		
		// Removing the Node it self
			_ModeCount++;
		return this.getVerMap().remove(key);
		}
		_ModeCount++;
		return null;
	}
	/**
	 * This is a helper method assumes there is a valid edge to remove, and remove it
	 * @param src
	 * @param dest
	 * @return
	 */
	public edge_data removeValidEdge(GraphNode srcNode ,int dest)
	{
		
		edge_data edgeToRemove = getEdge(srcNode.getKey(),dest);
		if(edgeToRemove != null) // If an edge was removed
		{
			System.out.println("Edge "+ edgeToRemove + " was sucssesfully removed!");
		}
		return edgeToRemove;
	}
	@Override
	/**
	 * This method checks if there are such nodes, and then removes their connectiong , even if there was no edge to begin with.
	 */
	public edge_data removeEdge(int src, int dest) 
	{
		// Check if the two nodes even exist
		if(this.doesTheeseNodeExist(src, dest)) 
		{ // They exist check
			// Remove the edge
			GraphNode srcNode = this.get_node(src);
			_ModeCount++;
			return this.removeValidEdge(srcNode, dest);
		}	
		return null;
	}

	@Override
	public int nodeSize() 
	{
		
		return this.getVerMap().size();
	}

	@Override
	public int edgeSize() 
	{
		return _numOfEdges;
	}

	@Override
	public int getMC() 
	{
		return _ModeCount;
	}
	public void printAllVrticies()
	{
		System.out.println(this.getVerMap().toString());
	}
}