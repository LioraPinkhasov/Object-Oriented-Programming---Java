package dataStructure;


import java.io.Serializable;
import java.util.HashMap;

import utils.Point3D;

public class GraphNode implements node_data , Serializable
{
	
////////Private Data //////////
int _key;
private static int _keyForPoints = 1;
double _weight = 0.0;
Point3D _location  = null; 
String _info ="No Info Setted"; 
int _tag = 0; 
private boolean _visited = false;
public HashMap< Integer,edge_data> _adjMap = new HashMap<>();

/////// Getters ////////////
public boolean isVisited()
{
	return _visited;
}
/**
 * Getter for the __adjMap.
 * @return _adjMap
 */
public HashMap getAdjMap()
{
	return this._adjMap;
}
/**
 * This method returns a casted GraphNode as its interface "node_data"
 * @return
 */
public node_data getNodeData()
{
	return((node_data)this);	
}
	@Override
	public int getKey() {
		// TODO Auto-generated method stub
		return _key;
	}

	@Override
	public Point3D getLocation() {
		
		return _location;
	}
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return _info;
	}
	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return _weight;
	}


	@Override
	public void setLocation(Point3D p) {
		
		this._location = p ;
	}
	//////////// Setters ///////
	public void setVisited(boolean visit)
	{
		this._visited = visit;
	}
	public void setKey(int key)
	{
		this._key=key;
	}
	

	@Override
	public void setWeight(double w) 
	{
		// TODO Auto-generated method stub
		this._weight = w;
	}
	
	@Override
	public void setInfo(String s)
	{
		// TODO Auto-generated method stub
		_info = s ;
	}

	@Override
	public int getTag() {
		// TODO Auto-generated method stub
		return _tag;
	}

	@Override
	public void setTag(int t) 
	{
		_tag = t;
		
	}
	
	//////////////// Constructors ///////////////
	public  GraphNode(int key)
	{
		if(key > 0)
		_key = key;
		else 
		{
				System.out.println("A key must be a positive Integer");
		}
	}
	public GraphNode(int key ,double weight)
	{
		_key = key;
		_weight = weight;		
	}
	
	public GraphNode(node_data nD)
	{
		this._key = nD.getKey();
		this._location = nD.getLocation();
		this._weight = nD.getWeight();
		this._info = nD.getInfo();
		this._tag = nD.getTag();
	}
	
	/**
	 * This counstructor used by the gui to draw new nodes , starting from id 1 and forward 
	 * @param location
	 * @return 
	 */
	 public GraphNode(Point3D location)
	 {
	        _key = _keyForPoints ;
	        _keyForPoints++;
	        _location = location;

	  }
	/**
	 * to String function for testing
	 * 
	 */
	public String toString()
	{
		String ans = "(key : "+this._key+" W :"+this._weight+")"; 
		return ans;
	}
	/**
	 * a full detailed toString
	 */
	public String fullToString()
	{
		String ans = "(key : "+this._key+" Weight : "+getWeight()+" Location : "+getLocation()+ " Info :"+getInfo()+ " Tag :"+getTag()+" )"; 
		return ans;
	}
	public void printDestEdge(int destKey)
	{
		System.out.println(this._adjMap.get(destKey));
	}
	public void printAllEdges()
	{
		System.out.println("Node : "+ this.getKey());
		System.out.println(this.getAdjMap().toString());
	}
	public void printVisited()
	{
		if (this.isVisited())
			System.out.println("Node :"+this.getKey()+" is Visited");
		else
			System.out.println("Node :"+this.getKey()+" is Not Visited");
	}
	


}
