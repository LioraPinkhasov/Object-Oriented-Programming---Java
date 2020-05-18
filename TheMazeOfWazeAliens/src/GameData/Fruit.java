package GameData;

import org.json.JSONException;
import org.json.JSONObject;

import DataStructure.edge_data;
import DataStructure.GraphNode;
import DataStructure.DirectedGraph;
import Utils.Point3D;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fruit  
{
	int type; // define the type of the fruit
	int id; //define the id of the fruit
	double val; //define the value of the fruit
	Point3D location; //define the location
	boolean takenfruit = false; //check if the fruit taken
	edge_data edge; 

/*	public Fruit(DirectedGraph g, String jsonString)
	{
		try{
			JSONObject fruit = new JSONObject(jsonString);
            fruit = fruit.getJSONObject("Fruit");
            String locat = fruit.getString("location");
            int type = fruit.getInt("type");
            double value = fruit.getDouble("value");
            
            this.location = new Point3D(locat);
            this.val = value;
            this.edge = fedge (g,type);
				
 		  }
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}*/

	
	
	public Fruit(double v, Point3D p, edge_data e ,int type, int id) 
	{
    this.edge=e;
    this.location = new Point3D(p);
    this.type = type;
    this.val = v;
    this.id = id;
	}

	
	
	public double getID()
	{
		return this.id;
	}
	
	public edge_data getFruitEdge()
	{
		return this.edge;
	}
	
	public double getValue() 
	{
		return this.val;
	}
	
	public double getType() 
	{
		return this.type;
	}
	
	public Point3D getLocation() 
	{
		return this.location;
	}	   
	
	public void setValue(double v)
	{
		this.val = v;
	}
	




}
