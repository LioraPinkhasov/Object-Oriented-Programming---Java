package GameData;

import org.json.JSONException;
import org.json.JSONObject;

import Server.robot;
import Utils.Point3D;
import GameData.Fruit;

public class Robot 
{
	int id; //define the id of the robot
	double val;
	int src;
	int dest;
	double speed;
	double pathlen;
	Fruit fruit;
	Point3D location;

	boolean fmove = false;




	public double getValue()
	{
		return this.val;
	}

	public int getId()
	{
		return id;
	}

	public Point3D getLocation()
	{
		return location;
	}
	
	public int getSrc() 
	{
		return src;
	}
	
	public int getDest()
	{
		return dest;
	}
	
	public double getSpeed() 
	{
		return speed;
	}

	public boolean fmove()
	{
		return getDest() != -1;
	}


}
