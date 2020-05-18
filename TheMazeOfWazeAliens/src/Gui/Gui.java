package Gui;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;



import Algorithms.Graph_Algo;
import DataStructure.DirectedGraph;
import Utils.Point3D;
import DataStructure.DirectedGraph;
import DataStructure.GraphNode;
import DataStructure.edge_data;
import DataStructure.graph;
import DataStructure.node_data;

import java.awt.Panel;
import java.awt.Point;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Random;
import java.awt.SystemColor;

public class Gui {
	
	//define graph
	private  static DirectedGraph hui;
	public static graph go;
	public static Graph_Algo a ;
	public static Graphics ourgraph = null;
	public static Graphics2D onscreen ;
	public Collection<node_data> vertex;
	public Collection<edge_data> edges;
	public static Panel panel = new Panel();
	//public  Graphics2D g2 = (Graphics2D) panel.getGraphics();
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
		public static  Color colorlightgrey = new Color(240, 240, 240); 

		public static Color[] Colors = {colorDarkBlue, colorblue, colormegenta, colororange, colorgreen, colorred, colorpink,purple,colorchocolate,colorlightsalmon};
		
		

	private JFrame frmDirectedGraph;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
/*	public Gui(graph g) {
		initialize(g);
	}*/

	public Gui() {//delete g
		//graph g= new graph  ;
		initialize(hui);
	}
	public Gui(graph g)
	{
		go = g; // Not shure if needed
		hui = new DirectedGraph(g); // Create our custom made Directed graph from g
		a = new Graph_Algo(hui); // Create a Graph_Algo from hui <if any problems detected , can also recive g) 
		ourgraph = null; // No idea what it is
		//onscreen ;  // No idea what it is
		vertex = hui.getV(); // Set all hui Nodes into Vertex
		//public static Panel panel = new Panel(); Not shure if I should init it here
		
	}
	/** NOT WORKING YET!
	 * This Method return a Collection of Edges whos source node is node_id.
	 * @param node_id
	 * @return
	 */
	public Collection<edge_data> getEdgesOfSpecificNode(int node_id ) 
	{
		return hui.getE(node_id);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(DirectedGraph g) {//changed to directed
		//Graphics g = new Graphics;
		//Graphics g = Graphics ();
		//Graphics g = null ;
		Graphics2D g2d = (Graphics2D) ourgraph ;
		DirectedGraph benj = g;
		frmDirectedGraph = new JFrame();
		frmDirectedGraph.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\L_cyber\\Pictures\\AliensInAriel.png"));
		frmDirectedGraph.setTitle("Directed Graph");
		frmDirectedGraph.setBounds(100, 100, 750, 500);
		frmDirectedGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menuBar = new JMenuBar();
		frmDirectedGraph.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		//define the "new" button
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				frmDirectedGraph.remove(panel);
				frmDirectedGraph.getContentPane().add(panel);
				frmDirectedGraph.setJMenuBar(menuBar);
				}
		});

		mnFile.add(mntmNew);
		
		
		//define the open button
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				FileDialog chooser = new FileDialog(frmDirectedGraph, "Use a .txt extension", FileDialog.LOAD);
				chooser.setVisible(true);
				String filename =chooser.getDirectory()+chooser.getFile();
				a.init(filename);
				a.init(go);
				drawVertecies(go);
			}

		});
		mnFile.add(mntmOpen);
		
		
		//define "save as" button
		JMenuItem mntmSaveAs = new JMenuItem("Save As..");
		mntmSaveAs.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				FileDialog choose = new FileDialog(frmDirectedGraph, "Use a .txt extension", FileDialog.SAVE);
				choose.setVisible(true);
				String filename =choose.getDirectory()+choose.getFile();
				a.save(filename);
				System.out.println(a);
			}
		});

		mnFile.add(mntmSaveAs);
		
		
		//define randome button
		JMenuItem mntmRandome = new JMenuItem("Randome");
		mntmRandome.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				Graphics2D g2 = (Graphics2D) panel.getGraphics();
				int numberofnodes=(int) (Math.random()*400);
				
				System.out.println("the number of nodes is:" + numberofnodes);
				for (int i=0;i<=numberofnodes;i++)
				{
					int x=(int) (Math.random()*750);
					int y=(int) (Math.random()*500);
					Point3D p1 = new Point3D(x, y);
					GraphNode n1 = new GraphNode(p1);
					hui.addNode(n1);
					int curFunc=(int) (Math.random()*Colors.length);
					g2.setColor(Colors[curFunc%Colors.length]);
					g2.fillOval(x, y, 3, 3);
					int c = n1.getKey();
					String d =  Integer.toString(c);
					g2.drawString(d, n1.getLocation().ix(), n1.getLocation().iy());
				}
				
				
			}
		});
		mnFile.add(mntmRandome);
		
		
		//the exit button
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				frmDirectedGraph.setVisible(false);
				frmDirectedGraph.dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnAlgoritams = new JMenu("Algoritams");
		menuBar.add(mnAlgoritams);
		
		//define is connected button
		JMenuItem mntmIsConnected = new JMenuItem("Is Connected");
		mntmIsConnected.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		mnAlgoritams.add(mntmIsConnected);
		
		JMenuItem mntmTsp = new JMenuItem("Tsp");
		mntmTsp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		mnAlgoritams.add(mntmTsp);
		
		JMenuItem mntmShortestWay = new JMenuItem("Shortest way");
		mntmShortestWay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				
				Collection<node_data> theNodes = g.getV();

				for (node_data node : theNodes)
				{
					double x_location =  node.getLocation().x();
					double y_location =  node.getLocation().y();
					System.out.println("the x location is: "+x_location + "the y location is: " + y_location);

				}
				
			}
		});
		mnAlgoritams.add(mntmShortestWay);
		
		JMenu mnInsertdelete = new JMenu("Insert\\Delete");
		menuBar.add(mnInsertdelete);
		
		JMenu mnEdages = new JMenu("Edages");
		mnInsertdelete.add(mnEdages);
		
		JMenuItem mntmAdd = new JMenuItem("add");
		mntmAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				JFrame op= null ;
				String srcx="";
				String srcy="";
				String dstx="";
				String dsty="";
				String weight="";
				
				srcx = JOptionPane.showInputDialog(op,"Enter the src point x location: ");
/*				if ()
				{
					
				}*/
				srcy = JOptionPane.showInputDialog(op,"Enter the src point y location: ");
/*				if ()
				{
					
				}*/
				
				dstx = JOptionPane.showInputDialog(op,"Enter the dst point x location:: ");
				/*	
				if ()
				{
					
				}*/
				
				dsty = JOptionPane.showInputDialog(op,"Enter the dst point y location:: ");
				/*	
				if ()
				{
					
				}*/
				
				weight = JOptionPane.showInputDialog(op,"Enter the weight of the point : ");
				/*	
				if ()
				{
					
				}*/
				
				Graphics2D g2 = (Graphics2D) panel.getGraphics();
				int x1 = Integer.parseInt(srcx);
				int y1 = Integer.parseInt(srcy);
				int x2 = Integer.parseInt(dstx);
				int y2 = Integer.parseInt(dsty);
				g2.drawLine(x1, y1, x2, y2);

			}
		});
		mnEdages.add(mntmAdd);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e)
			{
				JFrame op= null ;
				String srcx="";
				String srcy="";
				String dstx="";
				String dsty="";
				String weight="";
				
				srcx = JOptionPane.showInputDialog(op,"Enter the src point x location: ");
/*				if ()
				{
					
				}*/
				srcy = JOptionPane.showInputDialog(op,"Enter the src point y location: ");
/*				if ()
				{
					
				}*/
				
				dstx = JOptionPane.showInputDialog(op,"Enter the dst point x location:: ");
				/*	
				if ()
				{
					
				}*/
				
				dsty = JOptionPane.showInputDialog(op,"Enter the dst point y location:: ");
				/*	
				if ()
				{
					
				}*/
				
				weight = JOptionPane.showInputDialog(op,"Enter the weight of the point : ");
				/*	
				if ()
				{
					
				}*/
				
				Graphics2D g2 = (Graphics2D) panel.getGraphics();
				int x1 = Integer.parseInt(srcx);
				int y1 = Integer.parseInt(srcy);
				int x2 = Integer.parseInt(dstx);
				int y2 = Integer.parseInt(dsty);
				g2.setColor(colorlightgrey);
				g2.drawLine(x1, y1, x2, y2);	
			}
		});
		
		JMenuItem mntmAddByKey = new JMenuItem("Add by Key");
		mntmAddByKey.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0)
			{
				JFrame op= null ;
				Graphics2D g2 = (Graphics2D) panel.getGraphics();
				String srckey="";
				String destkey="";
				String weight="";
				int src,dest,weight2;
				
				srckey = JOptionPane.showInputDialog(op,"Enter the src key: ");
/*				if ()
				{
					
				}*/
				 src = Integer.parseInt(srckey); 
				 hui.get_node(src);
				 Point3D s = hui.get_node(src).getLocation();
				 System.out.println("this is s " + s);
				 //srcd = Double.valueOf(src);
				 
				 
				destkey = JOptionPane.showInputDialog(op,"Enter the dest key: ");
/*				if ()
				{
					
				}*/
				
				dest=Integer.parseInt(destkey);
				hui.get_node(dest);
				Point3D d = hui.get_node(dest).getLocation();
				System.out.println("this is d " + d);
				
				weight = JOptionPane.showInputDialog(op,"Enter the weight: ");
/*				if ()
				{
					
				}*/
				weight2 = Integer.parseInt(weight);
				
				hui.connect(src, dest, weight2);
				g2.setColor(colorDarkBlue);
				g2.drawLine((int)s.ix(),(int)s.iy(),(int)d.ix(),(int)d.iy());
				
				
				g2.drawString(weight, s.ix(), s.ix()+2);
				
			}
			
		});
		mnEdages.add(mntmAddByKey);
		mnEdages.add(mntmDelete);
		
		JMenuItem mntmDeleteByKey_1 = new JMenuItem("Delete by Key");
		mntmDeleteByKey_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		mnEdages.add(mntmDeleteByKey_1);
		
		JMenu mnPoints = new JMenu("Points");
		mnInsertdelete.add(mnPoints);
		
		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		mntmAdd_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFrame op= null ;
				
				Graphics2D g2 = (Graphics2D) panel.getGraphics();
				String x="";
				String y="";
				/*ImageIcon image = new ImageIcon("C:\\Users\\L_cyber\\eclipse-workspace\\OOPAriel\\MazeOfWaze\\src\\AliensInAriel.png");
				JLabel imagelabel = new JLabel(image);*/
				x = JOptionPane.showInputDialog(op,"Enter the x point location: ");
				//JOptionPane.showMessageDialog(op,"Add point",JOptionPane.INFORMATION_MESSAGE, imagelabel);
/*				if ()
				{
					
				}*/
				
				
				y = JOptionPane.showInputDialog(op,"Enter the y  point location: ");
				//y=JOptionPane.showInputDialog(op, "Enter the y point location" , "Adding point", op, imagelabel, op[], op);
				/*	
				if ()
				{
					
				}*/
				int curFunc=(int) (Math.random()*Colors.length);
				int x2 = Integer.parseInt(x);
				int y2 = Integer.parseInt(y);
				
				Point3D p1 = new Point3D((double)x2, (double)y2);
				GraphNode n1 = new GraphNode(p1);
				hui.addNode(n1);
				int c = n1.getKey();
				String d =  Integer.toString(c);
				System.out.println(c);
				System.out.println(n1.getLocation());
				g2.setColor(Colors[curFunc%Colors.length]);
				g2.fillOval(n1.getLocation().ix(), n1.getLocation().iy(), 3, 3);//remmber to return to 2
				g2.drawString(d, n1.getLocation().ix(), n1.getLocation().iy());
				
				
				
			}
		});
		mnPoints.add(mntmAdd_1);
		
		JMenuItem mntmDelete_1 = new JMenuItem("Delete");
		mntmDelete_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				JFrame op= null ;
				Graphics2D g2 = (Graphics2D) panel.getGraphics();
				String x="";
				String y="";

				x = JOptionPane.showInputDialog(op,"Enter the x point location : ");
/*				if ()
				{
					
				}*/
				
				
				y = JOptionPane.showInputDialog(op,"Enter the y  point location : ");
				/*	
				if ()
				{
					
				}*/
				
				int x2 = Integer.parseInt(x);
				int y2 = Integer.parseInt(y);
				
				Point3D p1 = new Point3D((double)x2, (double)y2);
				GraphNode n1 = new GraphNode(p1);
				g2.setColor(colorlightgrey);
				g2.fillOval(n1.getLocation().ix(), n1.getLocation().iy(), 3, 3);//remmber to return to 2
			}
		});
		mnPoints.add(mntmDelete_1);
		
		JMenuItem mntmDeleteByKey = new JMenuItem("Delete by Key");
		mnPoints.add(mntmDeleteByKey);
		panel.setBackground(SystemColor.control);
		
		//Panel panel = new Panel();
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				//define verbile for a diffrent colors
				int curFunc=(int) (Math.random()*Colors.length);
				//dosent bring good points - it is not same on the screen,not use it
				//int x = e.getXOnScreen();
				//int y = e.getYOnScreen();
				
				//get right points on the screen, use it
				Point a= e.getPoint();
				int x2=a.x;
				int y2=a.y;
				Point3D p1 = new Point3D(x2, y2);
				GraphNode n1 = new GraphNode(p1);
				hui.addNode(n1);
				//g.addNode(p1);
				
				
				
				
				//checking
				System.out.println(x2 + " "  +y2);
				//System.out.println(y2);
				
				
     			Graphics2D g2d = (Graphics2D) panel.getGraphics();
				
				//define diffrent colors
				g2d.setColor(Colors[curFunc%Colors.length]);
				
				//g2d.drawOval(x2, y2, 2, 2);
				
				//draw oval
				g2d.fillOval(x2, y2, 3, 3);
				int c = n1.getKey();
				String d =  Integer.toString(c);
				g2d.drawString(d, x2, y2);
				//g2d.setColor(colorpink);
				//g2d.drawOval(x, y, 2, 2);
			}
		
		});
		frmDirectedGraph.getContentPane().add(panel, BorderLayout.CENTER);
	}
	public void drawVertecies(graph g)
	{

		
		DirectedGraph theGraph = new DirectedGraph(g);
		// all verticies
		Collection<node_data> theNodes = theGraph.getV();



		for (node_data node : theNodes)
		{
			double x_location =  node.getLocation().x();
			double y_location =  node.getLocation().y();

		}
		
	}
	
	public static void main(String[] args) {
		

		Gui window = new Gui();//delete go
		window.frmDirectedGraph.setVisible(true);
		hui=GuiTest.g1ForTest();
		//hui.printAllVrticies();

}
}
