package Gui;

import java.awt.Color;
import java.awt.Font;

import algorithms.Graph_Algo;
import dataStructure.AVLTree;
import dataStructure.DGraph;
import dataStructure.EdgeResult;
import dataStructure.NodeResult;
import dataStructure.graph;
import utils.Point3D;
import utils.StdDraw;
import utils.Range;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.*;


public class Graph_Gui 
{
	private graph hui;
	//maybe we will add here anoter varibles
	//to check what is the status of the option in the menu
	
	
	//print our graph
	public static void toolbar()
	{
		//drawFunctions(1000, 1000, new Range(-10,10), new Range(-5,15), 200);
		
		//set an menu
		MenuBar menu = new MenuBar();
		Menu option = new Menu ("file"); //set option in the toolbar
		menu.add(option);
		MenuItem subop = new MenuItem("New");
		MenuItem subop2 = new MenuItem("Open");
		MenuItem subop3 = new MenuItem("Save");
		MenuItem subop4 = new MenuItem("ShortPath");
		MenuItem subop5 = new MenuItem("Connectd");
		//MenuItem subop6 = new MenuItem("");
		
		subop.addActionListener();
		subop2.addActionListener();
		subop3.addActionListener();
		subop4.addActionListener();
		subop5.addActionListener();
		
		//add suboption to option in the menu
		option.add(subop);
		option.add(subop2);
		option.add(subop3);
		option.add(subop4);
		option.add(subop5);
		
	}
	
	public static void drawGraph (  )
	{
		///draw the graph with node and edges
	}

	public static void subOpConnectd ()
	{
	//show if they are connectd
	}
	
	public static void subOpShortPath ()
	{
		//show us the shortest path 
	}
	
	public static void subOpSave ()
	{
		//as you gess it save the graph, i think there a function that ready for it at algo
		//becoue i remmber i wrote something like this
		
	}
	
	public static void subOpNew ()
	{
		// i think we just shold to clear the page
		//and remove all the data about the graph before
		
	}
	
	public static void subOpOpen()
	{
		//open your imagnition, i think i write the function about it
		//before, so we need just connect between them
	}
	
	public static void mouseFun ()
	{
		//need to read how to do it, but becouse he
		//want us to draw nodes with the mouse 
		//and connectd with mouse, i think we need this section
		
	}
	
	
	
	//draw our graph
	public static void drawFunctions(int width, int height, Range rx, Range ry, int resolution) 
	{
		StdDraw.setCanvasSize(width,height); //define canvas size
		StdDraw.setXscale(rx.get_min(), rx.get_max()); 
		StdDraw.setYscale(ry.get_min(), ry.get_max());//setting fixed scales for all drawings

		double x_length = Math.abs(rx.get_max()) + Math.abs(rx.get_min()); //horizontal line length
		double y_length = Math.abs(ry.get_max()) + Math.abs(ry.get_min()); //vertical line length

		/////////// drawing squares grid for scale , every squaresize 0.5*0.5\\\\\\
		double sizeOfSquare = 0.5;
		StdDraw.setPenColor(Color.LIGHT_GRAY);//giving the grid a collor of its own
		// vertical grid lines \\
		for (double i = rx.get_min() ; i <= x_length; i = i + sizeOfSquare) 
		{
			//draw every line from the points p1 = (i,ry.min) , p2 = (i,ry.max) 
			StdDraw.line(i , ry.get_min() , i, ry.get_max());		
		}
		// horizontal grid lines \\
		for(double i = ry.get_min() ; i <= ry.get_max() ; i = i + sizeOfSquare)
		{
			StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		}
		//We finished the grid,  now drawing X and Y axis with numbers.
		//define new color and pen radius
		StdDraw.setPenRadius(0.007);
		StdDraw.setPenColor(Color.BLACK);

		//draw X axis
		StdDraw.line(rx.get_min(),0 , rx.get_max(),0);//draw x axis
		StdDraw.setFont(new Font("Ariel", Font.BOLD, 15));//set Numbers Font and size

		//draw numbers for X axis
		for (double i = rx.get_min(); i <= Math.abs(rx.get_max())+Math.abs(rx.get_min()); i++)
		{
			StdDraw.text(i, -1, Integer.toString((int)i));
		}

		//draw Y axis
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());

		//draw the numbers of Y axis
		for (double i = ry.get_min(); i <= ry.get_max(); i++) 
		{
			StdDraw.text(-1, i, Integer.toString((int)i));
		}


	}
}

