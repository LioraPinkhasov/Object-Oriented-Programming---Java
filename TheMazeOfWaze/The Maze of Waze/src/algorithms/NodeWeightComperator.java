package algorithms;

import java.util.Comparator;

import dataStructure.GraphNode;
import dataStructure.node_data;

public class NodeWeightComperator implements Comparator<GraphNode>
{
	
	    @Override
	    public int compare(GraphNode x, GraphNode y) 
	    {
	        // Assume neither string is null. Real code should
	        // probably be more robust
	        // You could also just return x.length() - y.length(),
	        // which would be more efficient.
	        if (x.getWeight() < y.getWeight())
	        {
	            return -1;
	        }
	        if (x.getWeight() > y.getWeight()) 
	        {
	            return 1;
	        }
	        return 0;
	    }
}
