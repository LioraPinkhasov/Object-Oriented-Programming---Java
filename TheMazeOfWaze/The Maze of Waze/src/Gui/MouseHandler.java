package Gui;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import utils.Point3D;
import utils.StdDraw;

public class MouseHandler implements ActionListener, MouseListener, MouseMotionListener
{
/*	private Point points[] = new Point[10000];
	private Point pointends[] = new Point[10000];
	private int pointCount = 0;*/

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//mousePressed(arg0);
		if(GuiwithStdDraw.pointCount < GuiwithStdDraw.pointsx.length)
		{
			GuiwithStdDraw.pointCount++;
			GuiwithStdDraw.pointsx[ GuiwithStdDraw.pointCount ] = arg0.getXOnScreen();
			GuiwithStdDraw.pointsy[ GuiwithStdDraw.pointCount ] = arg0.getYOnScreen();
			double u = StdDraw.mouseX();
			double v = StdDraw.mouseY();
			System.out.println("here: " + u +" " + v);
			//GuiwithStdDraw.pointends[ GuiwithStdDraw.pointCount ] = arg0.getLocationOnScreen();
			
		}
		int x = arg0.getXOnScreen();
		int y = arg0.getYOnScreen();

/*		Point loc = arg0.getLocationOnScreen();
		System.out.println(x);
		System.out.println(y);
		System.out.println(pointCount);
		System.out.println(points[pointCount]);
		Point3D p = new Point3D (x,y);
		System.out.println(p.toString());
		//StdDraw.filledCircle(x, y, 0);
		 
*/	
		//System.out.println(a+ " " + b);
		Point3D p = new Point3D (x,y);
		p.x();
		System.out.println(p.x());
		System.out.println(p.toString());
		GuiwithStdDraw.paint(x,y);
	/*	if (StdDraw.isMousePressed()==true){
               double a = StdDraw.mouseX();
               double b = StdDraw.mouseY();
               Point3D temp3 = new Point3D(a,b);
               System.out.println("we are: " +temp3.toString());
		}*/

		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
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
		//Graph_Algo.save(projectname);

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
	

}
