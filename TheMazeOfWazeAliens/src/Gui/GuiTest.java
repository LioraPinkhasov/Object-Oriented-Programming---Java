package Gui;

import java.util.Collection;

import Algorithms.Graph_Algo;
import DataStructure.DirectedGraph;
import DataStructure.GraphNode;
import DataStructure.edge_data;
import Utils.Point3D;

public class GuiTest {

	public static void main(String[] args) 
	{
		//testGuifromgraph(); //not working yet
		//testgraphConstructor();
		g1ForTest();


	}
	public static void testGuifromgraph()
	{
		
		DirectedGraph g1 = g1ForTest2();
		Gui g1Gui = new Gui(g1);
		
		System.out.println(g1Gui.getEdgesOfSpecificNode(1));
		System.out.println("for Testing");
		
	}
	public static void testgraphConstructor()
	{
	DirectedGraph g1 = g1ForTest2();
	DirectedGraph g2 = new DirectedGraph(g1);
	System.out.println("thats all folks");
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
	

}
