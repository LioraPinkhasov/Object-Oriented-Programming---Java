package Algorithms;



import java.util.LinkedList;
import java.util.List;



import DataStructure.DirectedGraph;
import DataStructure.GraphNode;
import DataStructure.node_data;

class Graph_AlgoTest 
{
	public static Graph_Algo testG1()
	{
		GraphNode n1 = new GraphNode(1,0.5);
		DirectedGraph g1 = new DirectedGraph();
		GraphNode n2 = new GraphNode(2,8);
		GraphNode n3 = new GraphNode(3,3);
		GraphNode n4 = new GraphNode(4,3);
		GraphNode n5 = new GraphNode(5,8);
		GraphNode n6 = new GraphNode(6,3);
		GraphNode n7 = new GraphNode(7,3);
		GraphNode n8 = new GraphNode(8,8);
		
		g1.addNode(n1);
		g1.addNode(n2);
		g1.addNode(n3);
		g1.addNode(n4);
		g1.addNode(n5);
		g1.addNode(n6);
		g1.addNode(n7);
		g1.addNode(n8);
		g1.connect(1, 2, 7);
		g1.connect(1, 3, 8);
		g1.connect(2, 6, 2);
		g1.connect(3, 7, 4);
		g1.connect(3, 6, 6);
		g1.connect(7, 6, 9);
		g1.connect(6, 4, 8);
		g1.connect(6, 8, 3);
		g1.connect(8, 5, 1);
		Graph_Algo testG1 = new Graph_Algo(g1);
		return testG1;
	}
	public static Graph_Algo testG2()
	{
		GraphNode n1 = new GraphNode(1,0.5);
		DirectedGraph g1 = new DirectedGraph();
		GraphNode n2 = new GraphNode(2,8);
		GraphNode n3 = new GraphNode(3,3);
		g1.addNode(n1);
		g1.addNode(n2);
		g1.addNode(n3);
		g1.connect(1, 2, 3);
		g1.connect(1, 3, 4);
		g1.connect(2, 3, 3);
		g1.connect(3, 2, 3);
		g1.connect(3, 1, 3);
		Graph_Algo testG1 = new Graph_Algo(g1);
		return testG1;
	}
	public static void testSave()
	{
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		GraphNode n8 = new GraphNode(8);
		DirectedGraph g1 = new DirectedGraph();
		g1.addNode(n1);
		g1.addNode(n2);
		g1.addNode(n3);
		g1.addNode(n4);
		g1.addNode(n5);
		g1.addNode(n6);
		g1.addNode(n7);
		g1.addNode(n8);
		g1.connect(1, 2, 7);
		g1.connect(1, 3, 8);
		g1.connect(2, 6, 2);
		g1.connect(3, 6, 6);
		g1.connect(3, 7, 4);
		g1.connect(7, 6, 9);
		g1.connect(6, 4, 8);
		g1.connect(6, 8, 3);
		g1.connect(8, 5, 1);
		Graph_Algo testG = new Graph_Algo(g1);
		testG.save("‪C:\\TestingAlgosBoaz\\BoazBatata.txt");
	}
	public static void testTSP()
	{
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		GraphNode n7 = new GraphNode(7);
		GraphNode n8 = new GraphNode(8);
		DirectedGraph g1 = new DirectedGraph();
		g1.addNode(n1);
		g1.addNode(n2);
		g1.addNode(n3);
		g1.addNode(n4);
		g1.addNode(n5);
		g1.addNode(n6);
		g1.addNode(n7);
		g1.addNode(n8);
		g1.connect(1, 2, 7);
		g1.connect(1, 3, 8);
		g1.connect(2, 6, 2);
		g1.connect(3, 6, 6);
		g1.connect(3, 7, 4);
		g1.connect(7, 6, 9);
		g1.connect(6, 4, 8);
		g1.connect(6, 8, 3);
		g1.connect(8, 5, 1);
		Graph_Algo testG = new Graph_Algo(g1);
		List<Integer> pathList = new LinkedList<Integer>();
		pathList.add(1);
		pathList.add(7);
		pathList.add(4);
		List<node_data> ans = testG.TSP(pathList);
		System.out.println(ans);
		
	}
	public static void testMarkAllNodesUnvisited()
	{
		Graph_Algo testG1 = testG1();
		System.out.println(testG1.getNode(1).isVisited());
		System.out.println(testG1.getNode(2).isVisited());
		testG1.getNode(1).setVisited(true);// Change to visited
		testG1.getNode(2).setVisited(true);// Change to visited
		System.out.println(testG1.getNode(1).isVisited());
		System.out.println(testG1.getNode(2).isVisited());
	}
	public static void testIsConnected()
	{
		Graph_Algo testG1 = testG1(); // Not connected
		Graph_Algo testG2 = testG2(); // Connected
		System.out.println(testG1.isConnected());
		System.out.println(testG2.isConnected());
	}
	
	public static void testShortestPath()
	{

		Graph_Algo testG1 = testG1(); // Not connected
		Graph_Algo testG2 = testG2(); // Connected
		System.out.println(testG1.shortestPathDist(1, 5)); //Supposed to be 13
		System.out.println(testG1.shortestPathDist(3, 4));  //Supposed to be 21
		System.out.println(testG1.shortestPathDist(2, 6));  //Supposed to be 2
		System.out.println(testG1.shortestPath(1, 5)); //Supposed to be 13
		System.out.println(testG1.shortestPath(3, 4));  //Supposed to be 21
		System.out.println(testG1.shortestPath(2, 6));  //Supposed to be 2
		
		
	}
	
	

}
