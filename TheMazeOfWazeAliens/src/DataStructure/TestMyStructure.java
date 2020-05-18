package DataStructure;

import DataStructure.GraphNode;
import Utils.Point3D;

import java.util.Collection;
import java.util.prefs.NodeChangeEvent;

import Algorithms.Graph_Algo;
import DataStructure.GraphEdge;
public class TestMyStructure
{

	public static void main(String[] args)
	{//NodeCreator();
	
		//EdgeCreator();
		//graphCreator();
       // testConnection1();
		//TestDrawing();
		testGetE();
		System.out.println("Tests are Over");
	}
	public static void testGetE()
	{
		DirectedGraph g1 = g1ForTest();
		DirectedGraph g1p = g1ForTest2();
		Collection<edge_data> yossi = g1.getE(1);
		System.out.println(yossi);
		Collection<edge_data> moshe = g1p.getE(1);
		System.out.println(moshe);
		
	}
	public static DirectedGraph g1ForTest()
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
		GraphNode n9 = new GraphNode(9,3);
		GraphNode n10 = new GraphNode(10,3);
		GraphNode n11 = new GraphNode(11,8);
		GraphNode n12 = new GraphNode(12,3);
		GraphNode n13= new GraphNode(13,3);
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
		return g1;

	}
	public static DirectedGraph g1ForTest2()
	{
		// init points
		Point3D p1 = new Point3D (361,88);
		Point3D p2 = new Point3D (270,187);
		Point3D p3 = new Point3D (452,187);
		Point3D p4 = new Point3D (173,273);
		Point3D p5 = new Point3D (592,285);
		Point3D p6 = new Point3D (269,392);
		Point3D p7 = new Point3D (466,399);
		Point3D p8 = new Point3D (373,506);
		// init Nodes with points and Weigt
		GraphNode n1 = new GraphNode(p1);
		GraphNode n2 = new GraphNode(p2);
		GraphNode n3 = new GraphNode(p3);
		GraphNode n4 = new GraphNode(p4);
		GraphNode n5 = new GraphNode(p5);
		GraphNode n6 = new GraphNode(p6);
		GraphNode n7 = new GraphNode(p7);
		GraphNode n8 = new GraphNode(p8);
		// init DirectedGraph
		DirectedGraph g1 = new DirectedGraph();
		// add Nodes
		g1.addNode(n1);
		g1.addNode(n2);
		g1.addNode(n3);
		g1.addNode(n4);
		g1.addNode(n5);
		g1.addNode(n6);
		g1.addNode(n7);
		g1.addNode(n8);
		// Connect Nodes
		g1.connect(1, 2, 7);
		g1.connect(1, 3, 8);
		g1.connect(2, 6, 2);
		g1.connect(3, 7, 4);
		g1.connect(3, 6, 6);
		g1.connect(7, 6, 9);
		g1.connect(6, 4, 8);
		g1.connect(6, 8, 3);
		g1.connect(8, 5, 1);
		return g1;
		
		
		
	}
	////Node Result Tests
	public static void NodeCreator()
	{
		
		
	}
	/// EdgeResult Tests
	public static void EdgeCreator() 
	{
		
	}
	public static void TestDrawing()
	{
		Point3D p1 = new Point3D(0.3,0.3,0);
		Point3D p2 = new Point3D(0.4,0.4,0);
		Point3D p3 = new Point3D(0.5,0.5,0);
		GraphNode n1 = new GraphNode(p1);
		DirectedGraph g1 = new DirectedGraph();
		GraphNode n2 = new GraphNode(p2);
		GraphNode n3 = new GraphNode(p3);
		g1.addNode(n1);
		g1.addNode(n2);
		g1.addNode(n3);
		

		
	}
	///Graph Testing
	
	public static void graphCreator()
	{
		/*
		 * DGraph gve = new DGraph(); NodeResult n1 = new NodeResult(1); NodeResult n2 =
		 * new NodeResult(2); NodeResult n3 = new NodeResult(3);
		 * 
		 * gve.addNode(n1); gve.addNode(n2); gve.connect(1, 2, 6);
		 * System.out.println(n1.getEdge(2));
		 */
		GraphNode n1 = new GraphNode(1,0.5);
		DirectedGraph g1 = new DirectedGraph();
		GraphNode n2 = new GraphNode(2,8);
		GraphNode n3 = new GraphNode(3,3);
		GraphNode n4 = new GraphNode(4,3);
		GraphNode n5 = new GraphNode(5,8);
		GraphNode n6 = new GraphNode(6,3);
		GraphNode n7 = new GraphNode(7,3);
		GraphNode n8 = new GraphNode(8,8);
		GraphNode n9 = new GraphNode(9,3);
		GraphNode n10 = new GraphNode(10,3);
		GraphNode n11 = new GraphNode(11,8);
		GraphNode n12 = new GraphNode(12,3);
		GraphNode n13= new GraphNode(13,3);
		g1.addNode(n1);
		g1.addNode(n2);
		g1.addNode(n3);
		g1.addNode(n4);
		g1.addNode(n5);
		g1.addNode(n6);
		g1.addNode(n7);
		g1.addNode(n8);
		//g1.addNode(n9);
		//g1.addNode(n10);
		//g1.addNode(n11);
	//	g1.addNode(n12);
		//g1.addNode(n13);
		g1.connect(1, 2, 7);
		g1.connect(1, 3, 8);
		g1.connect(2, 6, 2);
		g1.connect(3, 7, 4);
		g1.connect(3, 6, 6);
		g1.connect(7, 6, 9);
		g1.connect(6, 4, 8);
		g1.connect(6, 8, 3);
		g1.connect(8, 5, 1);
		Graph_Algo tempG = new Graph_Algo(g1);
    	int ammountOfNodes  = tempG.findConnectivityBFS(2);
		System.out.println(ammountOfNodes);
		System.out.println(tempG.isConnected()+"    "+tempG.getConnectedStatus());
		//g1.removeNode(2);
	//g1.printAllVrticies();
		//n3.printAllEdges();
		//n1.printAllEdges();
		//((GraphNode) g1.getNode(2)).printAllEdges();
		DirectedGraph g2 = new DirectedGraph();	
		g2.addNode(n1);
		g2.addNode(n2);
		g2.addNode(n3);
		///////////////
		g2.connect(1, 2, 9);
		g2.connect(1, 3, 4);
		g2.connect(2, 1, 4);
		g2.connect(2, 3, 7);
		g2.connect(3, 1, 4);
		g2.connect(3, 2, 7);
		Graph_Algo tempG2 = new Graph_Algo(g2);
		System.out.println(tempG2.isConnected()+"    "+tempG2.getConnectedStatus());
		
		

		
	}
	public static void testConnection1()
	{ 
		GraphNode yossi = new GraphNode(1,0.5);
		DirectedGraph g2 = new DirectedGraph();
		GraphNode n2 = new GraphNode(2,8);
		GraphNode n3 = new GraphNode(3,3);
	
		g2.addNode(yossi);
		g2.addNode(n2);
		g2.addNode(n3);
		///////////////
		g2.connect(1, 2, 9);
		g2.connect(1, 3, 4);
		g2.connect(2, 1, 4);
		g2.connect(2, 3, 7);
		g2.connect(3, 1, 4);
		g2.connect(3, 2, 7);
		Graph_Algo tempG2 = new Graph_Algo(g2);
		System.out.println(tempG2.isConnected()+"    "+tempG2.getConnectedStatus());
	}
	
	

}