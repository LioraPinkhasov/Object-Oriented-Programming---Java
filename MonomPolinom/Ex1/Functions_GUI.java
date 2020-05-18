package Ex1;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.Font;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class Functions_GUI implements functions
{
	static ComplexFunction Complex =new ComplexFunction();
	public LinkedList<function> ListOfComplexFunction = new LinkedList<function>();

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

	public Functions_GUI() {
		
	}
	@Override
	public boolean add(function arg0)
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.add(arg0);
	}
	
	public function get(int i){
		return ListOfComplexFunction.get(i);
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) 
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.addAll(arg0);
	}

	@Override
	public void clear() 
	{
		// TODO Auto-generated method stub
		ListOfComplexFunction.clear();

	}

	@Override
	public boolean contains(Object arg0) 
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.contains(arg0);
	}

	@Override
	public boolean containsAll(Collection<?> arg0)
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.containsAll(arg0);
	}

	@Override
	public boolean isEmpty() 
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.isEmpty();
	}

	@Override
	public Iterator<function> iterator()
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.iterator();
	}

	@Override
	public boolean remove(Object arg0) 
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.remove(arg0);
	}

	@Override
	public boolean removeAll(Collection<?> arg0)
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.removeAll(arg0);
	}

	@Override
	public boolean retainAll(Collection<?> arg0) 
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.retainAll(arg0);
	}

	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.size();
	}

	@Override
	public Object[] toArray() 
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) 
	{
		// TODO Auto-generated method stub
		return ListOfComplexFunction.toArray(arg0);
	}

	@Override
	public void initFromFile(String file) throws IOException
	{
		// TODO Auto-generated method stub
		File ourfile= new File(file);
		Scanner moveon = new Scanner(ourfile);
		while (moveon.hasNext())
		{
			this.ListOfComplexFunction.add(Complex.initFromString(moveon.nextLine()));
		}
	}

	@Override
	public void saveToFile(String file) throws IOException 
	{
		// TODO Auto-generated method stub	
		FileWriter ourfile = new FileWriter(file);
		PrintWriter printWriter = new PrintWriter(ourfile);
		Iterator <function> ouriter=this.ListOfComplexFunction.iterator();
		for (int i=0;i<=ListOfComplexFunction.size();i++)
		{
			printWriter.println(ListOfComplexFunction.get(i));
		}
		printWriter.close();

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) 
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

		/////////Drawing the functions!\\\\\\\\
		int curFunc=0;
		//for( int curFunc = 0 ; curFunc <= ListOfComplexFunction.size() ; curFunc++) //for each function in our list 
		while (ListOfComplexFunction.isEmpty()!=true)
		{
			double delta_x = 0.1;
			function currentFunction = ListOfComplexFunction.pop();//take the current function
			StdDraw.setPenColor(Colors[curFunc++%Colors.length]);
			StdDraw.setPenRadius(0.005);
			for(double x = rx.get_min()+delta_x ; x < rx.get_max() ; x = x + delta_x)
			{

				double y1 = currentFunction.f(x); // calculate fx of this specific x
				double y2 = currentFunction.f(x-delta_x); // calculate fx of this specific x

				StdDraw.line(x, y1 , x-delta_x , y2);//drawit


			}

		}


	}

	@Override
	public void drawFunctions(String json_file)
	{
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		{
			FileReader reader;
			try {
//				String s = ""
				reader = new FileReader(json_file);
				GuiParmaters guiPar = gson.fromJson(reader, GuiParmaters.class);
				Range x = new Range(guiPar.Range_X[0], guiPar.Range_X[1]);
				Range y = new Range(guiPar.Range_Y[0], guiPar.Range_Y[1]);
				drawFunctions(guiPar.Width, guiPar.Height, x, y, guiPar.Resolution);

			} 
			catch (FileNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return;
			}

		}

	}


}
