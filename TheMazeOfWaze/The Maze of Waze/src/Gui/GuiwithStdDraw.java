package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Gui.MouseHandler;
import algorithms.Graph_Algo;

import dataStructure.DirectedGraph;
import dataStructure.GraphNode;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;
import utils.StdDraw;

public class GuiwithStdDraw extends JFrame implements Serializable
{
	public GuiwithStdDraw(graph g)
	{
		
		
		DirectedGraph theGraph = new DirectedGraph(g);
		// all verticies
		Collection<node_data> theNodes = theGraph.getV();



		for (node_data node : theNodes)
		{
			double x_location =  node.getLocation().x();
			double y_location =  node.getLocation().y();
			StdDraw.point(x_location, y_location);
		}

	}
	public static int pointsx[] = new int[10000];
	public static int pointsy[] = new int[10000];
	private Point pointends[] = new Point[10000];
	public static int pointCount = 0;

	public static JFrame frame = new JFrame("DirectedGraph");
	//public static JPanel canvas = new JPanel();
	public static Graphics pointed ;

	//define graph
	private static DirectedGraph hui;
	public static Graph_Algo a ;
	public static Graphics ourgraph;
	//create colors
	public static  Color colorDarkBlue = new Color(95, 158, 160); 
	public static  Color colorblue = new Color(32, 178, 170); 
	public static  Color colormegenta = new Color(219, 112, 147); 
	public static  Color colororange = new Color(255, 127, 80); 
	public static  Color colorgreen = new Color(143, 188, 143); 
	public static  Color colorred = new Color(220, 20, 60); 
	public static  Color colorpink = new Color(219,112,147); 
	public static  Color purple = new Color(128,0,128); 
	public static  Color colorchocolate = new Color(210,105,30); 
	public static  Color colorlightsalmon = new Color(255,160,122); 

	public static Color[] Colors = {colorDarkBlue, colorblue, colormegenta, colororange, colorgreen, colorred, colorpink,purple,colorchocolate,colorlightsalmon};

	public void drawVertecies(graph g)
	{

		StdDraw.clear();
		
		StdDraw.setPenColor(colorDarkBlue);
		StdDraw.setPenRadius(0.05);
		DirectedGraph theGraph = new DirectedGraph(g);
		// all verticies
		Collection<node_data> theNodes = theGraph.getV();



		for (node_data node : theNodes)
		{
			double x_location =  node.getLocation().x();
			double y_location =  node.getLocation().y();
			StdDraw.point(x_location, y_location);
			StdDraw.text(x_location, y_location, "1");
		}
		
	}
	public static void paint(int x,int y)
	{


		StdDraw.clear();
		StdDraw.setPenColor(colorDarkBlue);
		StdDraw.setPenRadius(0.01);
		double x2 = pointsx[pointCount]/1000.0;
		double y2 = pointsy[pointCount]/1000.0;
		System.out.println(x2);
		System.out.println(y2);

		StdDraw.point(x2,y2);
		System.out.println("gui x: " +  pointsx[pointCount]);
		System.out.println("gui y: " +  pointsy[pointCount]);



	}
	public void StartDrawing(graph g)
	{

		StdDraw.clear();
		StdDraw.setPenColor(colorDarkBlue);
		StdDraw.setPenRadius(0.15);
		
	}
	public static void draw ()
	{
		StdDraw.clear();
		StdDraw.setPenColor(colorDarkBlue);
		StdDraw.setPenRadius(0.15);

		//StdDraw.filledCircle(x, y, radius);
		//g.setVisible(true);
		System.out.println("hi");




	}



	/*
	 * public static void reset()
	 * 
	 * { tsp = false; shortespath = false; coonected = false; costum = false; }
	 */
}



