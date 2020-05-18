package Algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

import DataStructure.GraphNode;
import DataStructure.edge_data;
import DataStructure.GraphEdge;
import DataStructure.DirectedGraph;
import DataStructure.graph;
import DataStructure.node_data;

/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms , Serializable
{
	private static final long serialVersionUID = 1L;
	private static final int ListIterator = 0;
	public DirectedGraph gra;
	public static graph go;
	private ConnectedStatus _status = ConnectedStatus.NOTCHECKED;
	
	//////////////// Constructor //////////////
	
	public Graph_Algo(DirectedGraph g) 
	{
		this.gra = g;
	}
	
	public Graph_Algo(graph  g)
	{
		this.gra = new DirectedGraph(g);
	}
	
	///////////// Getters /////////
	public ConnectedStatus getConnectedStatus()
	{
		return this._status;
	}
	
	public GraphNode getNode(int key)
	{
		return gra.get_node(key);
	}
	
	public GraphEdge getEdge(int srcKey , int destKey)
	{
		return (GraphEdge) gra.getEdge(srcKey, destKey);
	}
	public HashMap< Integer,edge_data> getNeighborList(int key)
	{
		return gra.get_node(key)._adjMap;
	}
	//////////// Setter ///////////
	private void setConnectedStatus(ConnectedStatus status)
	{
		this._status = status;
	}
	
	@Override
	public void init(graph g) 
	{
		// TODO Auto-generated method stub
		DirectedGraph graph = new DirectedGraph(g);
		gra=graph;
	}

	@Override
	public void init(String file_name)
	{
		// TODO Auto-generated method stub

		try 
		{
			FileInputStream file = new FileInputStream(file_name);
			ObjectInputStream InputStream = new ObjectInputStream(file);
			graph g = (DirectedGraph) InputStream.readObject();
			init(g);

			System.out.println("mission acomplish!");
		}
		catch (IOException e)
		{
			
			System.out.println("we gat a problem huostuon!");

		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void save(String file_name) 
	{
		
			// TODO Auto-generated method stub

			//trying to save our file
			try {
				FileOutputStream file = new FileOutputStream(file_name);
				ObjectOutputStream outputStream = new ObjectOutputStream(file);
				outputStream.writeObject(this.gra);
				outputStream.close();
				file.close();
			} catch (Exception e) 
			{
				System.out.println("Error: Couldn't save this graph :( ");
				e.printStackTrace();
			}
	}
	/**
	 * This method mark all the nodes as unvisited, this method is used to reset the DFS algorithem so it can be repeated.
	 */
	public void markAllNodesUnvisited()
	{
		// Fetching the Verticies
		Collection<node_data> temp_verticies = this.gra.getV();
		Collection<GraphNode> verticies = (Collection) temp_verticies;
		
		// ForEach vertex , change _visited status to unvisited.
		for (GraphNode graphNode : verticies) 
		{
			graphNode.setVisited(false);
		}
		
	}
	
	@Override
	public boolean isConnected() 
	{ // Check the connected Status
		if(this.getConnectedStatus() == ConnectedStatus.NOTCHECKED)
		{
			////// Send to Connection BFS ALGOS and send Status
			boolean connectedGraph = true;
			Collection<GraphNode> verticiesCollection = gra.getVerMap().values();
			int numOfVerticies = gra.getV().size();
			ForLoop:
			for (GraphNode graphNode : verticiesCollection)
			{	this.markAllNodesUnvisited();
				int nodeKey = graphNode.getKey();
				int nodesConnectedTo = this.findConnectivityBFS(nodeKey);
				if(numOfVerticies != nodesConnectedTo)
				{
					connectedGraph = false;
					break ForLoop;
					
				}
				
			}
			if(connectedGraph)
				this.setConnectedStatus(ConnectedStatus.CONNECTED);
			else
				this.setConnectedStatus(ConnectedStatus.NOTCONNECTED);
			
		}
		
		// Now we checked if the graph is connected, the Status has been set.
		// send true if Connected , else false.
		if(this.getConnectedStatus() == ConnectedStatus.NOTCONNECTED) // 	
		return false;
		else
			return true;
	}
	/**
	 * this helper method finds how many different nodes we can visit by traversing the graph from a statring Node.
	 * @param Starting_key
	 * @return counter : how many different Nodes have we visited including the starting node
	 */
	public int findConnectivityBFS(int Starting_key)
	{
		int counter = 0;
		// Declaring of the Node Q used in BFS
		Queue<GraphNode>  Q = new LinkedList<GraphNode>();
		// Init the Q with the Starting Node and mark it
		GraphNode CurrentNode = this.getNode(Starting_key);
		Q.add(CurrentNode);
		CurrentNode.setVisited(true);
		counter++;
		
		while(!Q.isEmpty())
		{
			Queue<GraphNode>  tempQ = new LinkedList<GraphNode>();
			
			// Add currentNode neighbers to the Q
			for (GraphNode a : Q) 
			{
				
				Collection<edge_data> edgeCollection = gra.getE(a.getKey());
				
				for (edge_data edge : edgeCollection)
				{

					int neighborKey = edge.getDest();
					GraphNode NeiNode= getNode(neighborKey);
					if(!NeiNode.isVisited())
					{
						NeiNode.setVisited(true);
						tempQ.add(NeiNode);
						counter++;
					}
				}
			}
			Q = tempQ;
		
		}
		
		return counter;
	}
	
	@Override
	public double shortestPathDist(int src, int dest)
	{
		// Init maps and Priority Queue
		
				final Map<Integer, Double> distances = new HashMap<Integer, Double>(); // weightSums
				final Map<Integer, GraphNode> previous = new HashMap<Integer, GraphNode>(); // PreviousNode
				PriorityQueue<GraphNode> nodes =  new PriorityQueue<GraphNode>(new NodeWeightComperator());

				

				for(Integer vertexKey : this.gra.getVerMap().keySet())
				{
					GraphNode CurrentVertex = gra.getVerMap().get(vertexKey); 
					// If this is the source node
					if (vertexKey == src) 
					{ 
						distances.put(vertexKey, 0.0); // Put it with distance zero
						CurrentVertex.setWeight(0.0); // change Weight to 0.0
						nodes.add(CurrentVertex); // add node to the Priority queue
					} else 
					{ // This is not the starting node, so initilize the rest of it with max_values.
						distances.put(vertexKey, Double.MAX_VALUE);
						CurrentVertex.setWeight(Double.MAX_VALUE); // change Weight to max double value
						nodes.add(CurrentVertex); // Storing all the nodes in priority queue
					}
					previous.put(vertexKey, null); // Finishing the Init with all the previous nodes as null;
				}
				while (!nodes.isEmpty())  // While there are still nodes in the queue
				{
					GraphNode smallest = nodes.poll(); // Pull s node from the queue 
					if (smallest.getKey() == dest)  // If this is the Destination we are looking for
					{
						double Distance = 0 ;
						while (previous.get(smallest.getKey()) != null) // While there is a previos node	
						{
							Distance = Distance + distances.get(smallest.getKey());
							smallest = previous.get(smallest.getKey()); // make the current node to be the previous and repeat

						}
						
						return Distance; // Return the shortest path.
					}
					if (distances.get(smallest.getKey()) == Integer.MAX_VALUE)
					{
						break;
					}
					///////////
					for (Entry<Integer, edge_data> neighbor : this.gra.getVerMap().get(smallest.getKey())._adjMap.entrySet())
					{  
						Integer neiDest = neighbor.getKey();
					
						Double edgeWeight = gra.getEdge(smallest.getKey(), neiDest).getWeight();
						Double alt = distances.get(smallest.getKey()) + edgeWeight;
						if (alt < distances.get(neiDest)) {
							distances.put(neiDest, alt);
							previous.put(neiDest, smallest);

							forloop:
								for(GraphNode n : nodes) {
									if (n.getKey() == neighbor.getKey()) {
										nodes.remove(n);
										n.setWeight(alt);
										nodes.add(n);
										break forloop;
									}
								}
						}
					}

				}
				return -1;
	}

	
	private List<Integer> dijkstra(int src , int dest)
	{
		// Init maps and Priority Queue
		
		final Map<Integer, Double> distances = new HashMap<Integer, Double>(); // weightSums
		final Map<Integer, GraphNode> previous = new HashMap<Integer, GraphNode>(); // PreviousNode
		PriorityQueue<GraphNode> nodes =  new PriorityQueue<GraphNode>(new NodeWeightComperator());

		

		for(Integer vertexKey : this.gra.getVerMap().keySet())
		{
			GraphNode CurrentVertex = gra.getVerMap().get(vertexKey); 
			// If this is the source node
			if (vertexKey == src) 
			{ 
				distances.put(vertexKey, 0.0); // Put it with distance zero
				CurrentVertex.setWeight(0.0); // change Weight to 0.0
				nodes.add(CurrentVertex); // add node to the Priority queue
			} else 
			{ // This is not the starting node, so initilize the rest of it with max_values.
				distances.put(vertexKey, Double.MAX_VALUE);
				CurrentVertex.setWeight(Double.MAX_VALUE); // change Weight to max double value
				nodes.add(CurrentVertex); // Storing all the nodes in priority queue
			}
			previous.put(vertexKey, null); // Finishing the Init with all the previous nodes as null;
		}
		while (!nodes.isEmpty())  // While there are still nodes in the queue
		{
			GraphNode smallest = nodes.poll(); // Pull s node from the queue 
			if (smallest.getKey() == dest)  // If this is the Destination we are looking for
			{
				final List<Integer> path = new ArrayList<Integer>(); // Initilize a path var to hold the path to our destination	
				while (previous.get(smallest.getKey()) != null) // While there is a previos node	
				{
					path.add(smallest.getKey()); // Add the previous to the path
					smallest = previous.get(smallest.getKey()); // make the current node to be the previous and repeat

				}
				return path; // Return the shortest path.
			}
			if (distances.get(smallest.getKey()) == Integer.MAX_VALUE)
			{
				break;
			}
			///////////
			for (Entry<Integer, edge_data> neighbor : this.gra.getVerMap().get(smallest.getKey())._adjMap.entrySet())
			{  
				Integer neiDest = neighbor.getKey();
			
				Double edgeWeight = gra.getEdge(smallest.getKey(), neiDest).getWeight();
				Double alt = distances.get(smallest.getKey()) + edgeWeight;
				if (alt < distances.get(neiDest)) {
					distances.put(neiDest, alt);
					previous.put(neiDest, smallest);

					forloop:
						for(GraphNode n : nodes) {
							if (n.getKey() == neighbor.getKey()) {
								nodes.remove(n);
								n.setWeight(alt);
								nodes.add(n);
								break forloop;
							}
						}
				}
			}

		}
		return null;

	}
	
	@Override
	//Does not return starting Node!
	public List<node_data> shortestPath(int src, int dest) 
	{
		// Applying the dijkstra Algorithem and reciving a list of key's wich are the shortest path.
		 List<Integer> path_keys = this.dijkstra(src, dest);
		 
		List<node_data> nodeList = new LinkedList <node_data>();
		((LinkedList<node_data>) nodeList).addFirst(gra.getNode(src));
		
		 //forEach 
		 ListIterator<Integer> itr = path_keys.listIterator();    
	      
	        while(itr.hasNext())
	        {
	        	itr.next();
	        }
	        while(itr.hasPrevious()) 
	        {
	        node_data thisNode = gra.getNode(itr.previous());
	       // Add to the linked list the node which is the current key       
	       nodeList.add(thisNode); 
	      // itr.next();
	        }    
		
		
		return nodeList;
	}
	public List<node_data> shortestPathforTsp(int src, int dest) 
	{
		// Applying the dijkstra Algorithem and reciving a list of key's wich are the shortest path.
		 List<Integer> path_keys = this.dijkstra(src, dest);
		 
		List<node_data> nodeList = new LinkedList <node_data>();
		//((LinkedList<node_data>) nodeList).addFirst(gra.getNode(src));
		
		 //forEach 
		 ListIterator<Integer> itr = path_keys.listIterator();    
	      
	        while(itr.hasNext())
	        {
	        	itr.next();
	        }
	        while(itr.hasPrevious()) 
	        {
	        node_data thisNode = gra.getNode(itr.previous());
	       // Add to the linked list the node which is the current key       
	       nodeList.add(thisNode); 
	      // itr.next();
	        }    
		
		
		return nodeList;
	}
	public int findPathBFS(int Starting_key)
	{
		int counter = 0;
		// Declaring of the Node Q used in BFS
		Queue<GraphNode>  Q = new LinkedList<GraphNode>();
		// Init the Q with the Starting Node and mark it
		GraphNode CurrentNode = this.getNode(Starting_key);
		Q.add(CurrentNode);
		CurrentNode.setVisited(true);
		counter++;
		
		while(!Q.isEmpty())
		{
			Queue<GraphNode>  tempQ = new LinkedList<GraphNode>();
			
			// Add currentNode neighbers to the Q
			for (GraphNode a : Q) 
			{
				
				Collection<edge_data> edgeCollection = gra.getE(a.getKey());
				
				for (edge_data edge : edgeCollection)
				{

					int neighborKey = edge.getDest();
					GraphNode NeiNode= getNode(neighborKey);
					if(!NeiNode.isVisited())
					{
						NeiNode.setVisited(true);
						tempQ.add(NeiNode);
						counter++;
					}
				}
			}
			Q = tempQ;
		
		}
		
		return counter;
	}

	@Override
	
	public List<node_data> TSP(List<Integer> targets) 
	{
		int listSize = targets.size();
		List<node_data> TSPans = new LinkedList <node_data>();
		List<node_data> pathFromSrcToDest = new LinkedList <node_data>();
		// First Iterration includes the sourceNode in the path
		int src = targets.get(0);
		int dest = targets.get(1);
		int pathSize;
		try {
			pathFromSrcToDest = shortestPath(src, dest);
			pathSize = pathFromSrcToDest.size();
			TSPans.addAll(pathFromSrcToDest);
			}
			catch(Exception e) {
			  System.out.println("Node # "+src+ " or Node # "+dest+ " are not connected");
			}
		// Other Iterations
		for(int i = 1 ; i < (listSize-1) ; i++)
		{
			 src = targets.get(i);
			 dest = targets.get(i+1);
			try {
				pathFromSrcToDest = shortestPathforTsp(src, dest);
			    pathSize = pathFromSrcToDest.size();
				TSPans.addAll(pathFromSrcToDest);
				}
				catch(Exception e) {
				  System.out.println("Node # "+src+ " or Node # "+dest+ " are not connected");
				}
		}
		
		return TSPans;
	}

	@Override
	public graph copy() {
		// TODO Auto-generated method stub
		graph clone = new DirectedGraph(gra);
		return clone;
	}

}