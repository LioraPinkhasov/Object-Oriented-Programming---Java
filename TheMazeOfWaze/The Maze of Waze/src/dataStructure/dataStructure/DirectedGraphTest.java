package dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;

class DirectedGraphTest 
{
	/**
	 * 
	 * @return g1 unconnected graph , picture is provided
	 */
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
	/**
	 * 
	 * @return g2 a connected graph , Picture is provided
	 */
	public static  dataStructure.DirectedGraph g2ForTest()
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
		return g1;

	}

	@Test
	void testGetNumOfEdges() 
	{
		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		int num_of_g1 = g1.getNumOfEdges();
		int num_of_g2 = g2.getNumOfEdges();
		System.out.println("g1 should contain 9 edges , it containes : "+num_of_g1);
		System.out.println("g2 should contain 6 edges , it containes : "+num_of_g2);
		fail("Not yet implemented");
	}

	@Test
	void testGetNode() 
	{
		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		System.out.println(g1.get_node(1));
		System.out.println(g2.get_node(1));
	}

	@Test
	void testGetEdge() 
	{
		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		edge_data edge1 = g1.getEdge(1, 2);
		edge_data edge2 = g2.getEdge(1, 2);
		System.out.println(edge1);
		System.out.println(edge2);
		
		fail( );
	}

	@Test
	void testGetV() {
		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		Collection<node_data> v1 = g1.getV();
		Collection<node_data> v2 = g2.getV();
		System.out.println(v1 +" & "+v2);
		fail("Not yet implemented");
	}

	@Test
	void testGetE() {
		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		Collection<edge_data> e1 = g1.getE(1);
		Collection<edge_data> e2 = g2.getE(1);
		System.out.println(e1 +" & "+e2);
	}

	@Test
	void testAddNode() 
	{
	DirectedGraph g1 = g1ForTest();
	DirectedGraph g2 = g2ForTest();
	GraphNode n5 = new GraphNode(7);
	GraphNode n6 = new GraphNode(8,9);
	g1.addNode(n5);
	g1.addNode(n6);
	g2.addNode(n5);
	g2.addNode(n6);
		fail("Not yet implemented");
	}

	@Test
	void testDoesNodeExist() 
	{
		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		System.out.println(g1.doesNodeExist(1)); // Exists
		System.out.println(g2.doesNodeExist(1)); // Exists
		System.out.println(g1.doesNodeExist(20)); // Not exist
		System.out.println(g2.doesNodeExist(20)); // Not exist
		fail("Not yet implemented");
	}

	@Test
	void testDoesTheeseNodeExist() {
		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		System.out.println(g1.doesTheeseNodeExist(1, 2)); // Exists
		System.out.println(g2.doesTheeseNodeExist(1, 2)); // Exists
		System.out.println(g1.doesTheeseNodeExist(1, 20)); // Not Exists
		System.out.println(g2.doesTheeseNodeExist(1, 20)); //  Not Exists
		
		fail("Not yet implemented");
	}

	
	
	@Test
	void testRemoveNode() 
	{
		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		g1.removeNode(1);
		g2.removeNode(1);
		fail("Not yet implemented");
	}

	@Test
	void testRemoveEdge() 
	{

		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		System.out.println(g1.getE(1));
		g1.removeEdge(1, 2);
		System.out.println(g1.getE(1));
		System.out.println(g2.getE(1));
		g2.removeEdge(1, 2);
		System.out.println(g2.getE(1));
		fail("Not yet implemented");
	}

	@Test
	void testNodeSize() {
		fail("Not yet implemented");
	}

	@Test
	void testEdgeSize() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMC() {
		fail("Not yet implemented");
	}

	@Test
	void testPrintAllVrticies()
	{

		DirectedGraph g1 = g1ForTest();
		DirectedGraph g2 = g2ForTest();
		g1.printAllVrticies();
		g2.printAllVrticies();
		fail("Not yet implemented");
	}

}
