package algorithms;
import java.util.LinkedList;
import java.util.List;

import dataStructure.DirectedGraph;
import dataStructure.GraphNode;
import dataStructure.node_data;
public class Testing_algos
{

	public static void main(String[] args)
	{
		// testTSP();
		testSave();
		
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

}
