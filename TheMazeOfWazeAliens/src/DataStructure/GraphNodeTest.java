package DataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraphNodeTest extends GraphNode {

	public GraphNodeTest(int key) {
		super(key);
		// TODO Auto-generated constructor stub
	}

	@Test
	void testIsVisited() {
		fail("Not yet implemented");
	}

	@Test
	void testGetKey()
	{
		GraphNode n1 = new GraphNode(24);
		GraphNode n2 = new GraphNode(-56);
		System.out.println(24 == n1.getKey());
		System.out.println(-56 == n2.getKey());
		
		fail("Not yet implemented");
	}

	@Test
	void testSetWeight() 
	{
		GraphNode n1 = new GraphNode (1,8.789);
		System.out.println(n1.getWeight());
		n1.setWeight(12.84);
		System.out.println(n1.getWeight());
		fail("Not yet implemented");
	}

	@Test
	void testGraphNodeInt() 
	{
		GraphNode n1 = new GraphNode(24);
		System.out.println((n1 != null));
		fail("Not yet implemented");
	}

	@Test
	void testGraphNodeIntDouble() 
	{
		GraphNode n1 = new GraphNode(24,87.4);
		System.out.println((n1 != null));
		fail("Not yet implemented");
	}

	@Test
	void testToString() 
	{
		GraphNode n1 = new GraphNode(24,87.4);
		System.out.println(n1.toString());
		fail("Not yet implemented");
	}

	@Test
	void testFullToString() 
	{

		GraphNode n1 = new GraphNode(24,87.4);
		System.out.println(n1.fullToString());
		fail("Not yet implemented");
	}

	
}
