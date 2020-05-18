package DataStructure;

import java.io.Serializable;
import java.util.ArrayList;

public class GraphEdge implements edge_data, Serializable
{
	/////////// Private Data //////////////
	
	Integer _srcKey;
	Integer _destKey;
	boolean _existSourceNode;
	double _eWeight;
	private String _eInfo;
	int _eTag;
	
	///////// Constructor ///////////////
	/**
	 * Basic constructor
	 * @param src
	 * @param dest
	 * @param weight
	 */
	public  GraphEdge(int src, int dest , double weight)
	{
		if( weight < 0.0) throw new RuntimeException("Error! : Only Positive weight is exeptable!");
		if(src == dest) throw new RuntimeException("Error! : No edge from source to itself !");
		// At this point all the data is valid
		_srcKey = src;
		_destKey = dest;
		_eWeight = weight;
		
	}
	/**
	 * This is a copy constructor from the interface to GraphEdge Type
	 * @param edge
	 */
	public GraphEdge(edge_data edge)
	{
		
		this._srcKey = edge.getSrc();
		this._destKey = edge.getDest();
		this._eWeight = edge.getWeight();
		
	}
	/**
	 * toString method for testing
	 */
	public String toString()
	{
		return "E( Src "+getSrc()+" , Dst "+getDest()+" , Weight "+getWeight()+" )";
	}
	
	@Override
	public int getSrc() 
	{
		return _srcKey;
	}

	@Override
	public int getDest()
	{
		return _destKey;
	}

	@Override
	public double getWeight() 
	{
		return _eWeight;
	}

	@Override
	public String getInfo()
	{
		return _eInfo;
	}

	@Override
	public void setInfo(String s)
	{
		_eInfo = s;
	}

	@Override
	public int getTag()
	{
		return _eTag;
	}

	@Override
	public void setTag(int t)
	{
		_eTag = t;
	}

}
