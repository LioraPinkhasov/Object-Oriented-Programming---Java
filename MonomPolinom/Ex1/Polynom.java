package Ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import Ex1.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Roie Malykin & Liora Pinkhasov
 *
 */
public class Polynom implements Polynom_able{

	/**
	 * Zero (empty polynom)
	 */
	public Polynom() 
	{
		//we init an polynom into array list
		this.MonomAList = new ArrayList<>();
	}
	/**
	 * we init a polynom from a string like: "x" , "2x^5+1","-1.4x-1), (3x+4x^3)*(5x^4)
	 * this s: is a string that represents  Polynom
	 */
	public Polynom(String s) 
	{
		// we check if our Polynom string format are valid.
		String s1 = s.replaceAll("-", "+-");
		if(valid(s1) == true)
			MonomAList = GMonom(s1);//put the Monoms into the MonomAList,to represent a functional Polynom
		else
			throw new NullPointerException("Your string is problamtic!!"); 
		
	}
	/**
	 * this method is a deep copy Constructor
	 * @param the function get MonomAList and construct another polynom with the same MonomAList;
	 * @return new polynom after add equal power
	 */

	public Polynom(ArrayList<Monom> list) 
	{
		
		this.MonomAList = new ArrayList<>();
		Iterator<Monom> itr= list.iterator();//iterating over the AList copping all the Monoms in it.

		while(itr.hasNext()) 
		{
			this.MonomAList.add(itr.next()) ;
		}
	}
	/**
	 * 
	 * @param String MonStr (Monom String) represents a Monom
	 * @return
	 */
	boolean valid(String MonStr)
	{
		char[]dChar = new char[MonStr.length()];
		//init a char array as the MonStr length,this array will be used later by the .getChars() function.
		int SB=0;//srcBegin 
		int SE = MonStr.length();//srcEnd
		int DB = 0;//dstBegin
		MonStr.getChars(SB, SE, dChar, DB);
		for (char c : dChar) {
			if(!Character.isDigit(c) || Character.isAlphabetic(c))
				// check using Character class if c is not digit or if c is an alphabetic char; 
			{
				if(c!='x'&&c!='X'&&c!='-'&&c!='+'&&c!='^'&&c!='.')//if c is any other char then specified, return false, this string is not valid
					// 
				{
					System.out.println("Error: your expression shouldn't contains alphabtic characters!!!");
					return false;
				}
			}
		}

		return true;

	}
	/**
	 * PlyStr is our polynom string
	 * with this method we get
	 * @param polynomStr
	 * @return
	 */
	
	/**
	 * this method operates on the given string representing a polynom, splitting it and preparing for Polynom(String) constructor
	 * @param String PlyStr (Polynom String) represents a polynom
	 * @return ArrayList<Monom>
	 */
	public ArrayList<Monom> GMonom(String PlyStr)
	{
		String polynomial= PlyStr;
		
		String[] splited = polynomial.split("[+]");//the polynom is splited;
		ArrayList<Monom> lstMonom = new ArrayList<Monom>() ;//this arrayList will be returned after we will fill it with Monoms
		for (int i = 0; i < splited.length; i++) 
		{
			Monom mony = new Monom(splited[i]);//mony the Monom will be added to the ArrayList
			lstMonom.add(mony);
		}

		return lstMonom;
	}
	
	@Override
	/**
	 * this method will calculate the Polynom for a given x , it will sum all the monoms using for this x.
	 *  @param x is the variable of our polynom functiom
	 */
	public double f(double x) 
	{
		double function=0;
		Iterator<Monom> itr=this.iteretor();
		while(itr.hasNext())
		{
			Monom m=itr.next();
			function+=m.f(x);
		}
		return function;
		
	}
	/**
	 * this method represents the Polynom as a String
	 */
	public String toString() 
	{
		String polynom="";
		Iterator<Monom> itr= this.iteretor();

		if(this.isZero())//if its just an empty polynom return Zero 
		{
			return "0";
		}

		while(itr.hasNext()) //if it ain't empty, we string it in with a +
		{
			Monom m1=itr.next();
	
			polynom+=m1.toString()+"+";
		}

		if(polynom.endsWith("+"))//trim out the last +
		{
			polynom = polynom.substring(0, polynom.length()-1);
		}
		polynom = polynom.replaceAll("\\+-", "-");//lets make it look better
		//pretty pretty polynom
		return polynom;
	}

	@Override
	public void add(Polynom_able p1) 
	{
		Polynom p=new Polynom();
		Map<Integer,Double> map= new HashMap<>();
		// add p1 to polynom 
		Iterator<Monom> itr1= this.iteretor();//itr1 iterates over our polynom
		Iterator<Monom> itr2= p1.iteretor();//while itr2 runs over p1
		ArrayList<Monom> lstTotal= new ArrayList<>();
		while(itr1.hasNext()) // check if there are other elements in the array
		{			
			lstTotal.add(itr1.next());
		}
		while(itr2.hasNext()) // check if there are other elements in the array
		{			
			lstTotal.add(itr2.next());
		}
		Iterator<Monom> itrTotal = lstTotal.iterator();
		while(itrTotal.hasNext()) // while itrTotal have elements
		{
			Monom m=itrTotal.next(); 
			int KeyPow =m.get_power(); // get the power from the m into key pow
			if(map.containsKey(KeyPow))//exist in map,means equal powers 
			{
				Double sum = map.get(KeyPow) + m.get_coefficient(); // if there are an equal powers we sum the coefficient
				map.put(KeyPow, sum); //we put into the map our power and the new summbly coefficient
			}
			else//not exist in map,means not equal powers 
			{
				map.put(KeyPow,m.get_coefficient());
			}			
		}
		// Set<Integer> keys = map.keySet();
		Set<Entry<Integer, Double>> entry  = map.entrySet();
		Iterator<Entry<Integer, Double>> itr = entry.iterator();
		MonomAList.clear();
		while(itr.hasNext())// if itr not empty 
		{
			Entry<Integer, Double> en = itr.next(); //en means entry
			Double coff = en.getValue();
			if(coff!=0)
			{
				Monom m = new Monom(coff,en.getKey());
				p.removeZero();
				MonomAList.add(m); 
			}
		} 
		
	}

	/**
	 * this functions removes zeros
	 * if any monom is zero we trim it
	 */
	public void removeZero() 
	{
		for(int i=0 ; i<this.Size(); i++)
		{
			if(this.MonomAList.get(i).get_coefficient()==0) 
			{
				this.MonomAList.remove(i);
			}
		}

	}
	/**
	 * 
	 * @return the ammount of Monons in this polynom. Expected : natural numbers
	 */
	public int Size() 
	{
		return MonomAList.size();
	}
	
	@Override
	public void add(Monom m1) 
	{
		boolean foundPow=false;//flag used for position finding later
		Iterator<Monom> itr= this.iteretor(); 
		while(itr.hasNext()) // check if there are other elements in the array
		{	
			Monom m2=itr.next();
			if(m1.get_power()== m2.get_power() && m1.get_coefficient()!=0)//found the proper monom m2 with the same power as m1
			{
				m2.add(m1);
				foundPow=true;
				if(!m2.validValues())
				{
					itr.remove();
				}
				break;
			}
		}

		if(foundPow==false && m1.get_coefficient()!=0 )// if there is no such monom with the same Power, just add it to the MonomArrayList;
		{
			MonomAList.add(m1);
		}

		MonomAList.sort(MonComp);
	}
	
	

	@Override
	/**
	 * this method substructs p1 from out polynom , by adding the polynom (p1*-1) 
	 */
	public void substract(Polynom_able p1) {
		// TODO Auto-generated method stub
		ArrayList<Monom> lst2Sub = new ArrayList<>();
		Iterator<Monom> itr1 = iteretor();
		Iterator<Monom> itr2 = p1.iteretor();
		while (itr2.hasNext()) //invert sign for second polynom.
		{
			Monom m = itr2.next();
			m.InvSign();//invert coefficient
		}
		this.add(p1);
	}

	@Override
	/**
	 * this method mathematicly Multiplies a Polynom by the polynom p1 
	 */
	public void multiply(Polynom_able p1)
	{
		// TODO Auto-generated method stub
		ArrayList<Monom> alResult = new ArrayList<Monom>();
		Iterator<Monom> itr2 = this.iteretor();
		Iterator<Monom> itr1 = p1.iteretor();

		while (itr2.hasNext()) //for each Monom in this polynom
		{
			Monom m = itr2.next();
			while (itr1.hasNext()) 
			{
				Monom m1= itr1.next();
				m.multipy(m1);//multiply it by every Monom in p1.
				Monom res = m;;
				alResult.add(res);
			}
			itr1 = p1.iteretor();
		}
		this.MonomAList = alResult;
		mergeEqualPowers();//merge monoms who are at the same power
	}

	/**
	 * merge monoms who are at the same power
	 */
	private void mergeEqualPowers()
	{
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		Iterator<Monom> itr = this.iteretor();
		while (itr.hasNext()) 
		{ 
			Monom m = itr.next(); 
			int keyPow = m.get_power();

			if(!map.containsKey(keyPow))
				map.put(m.get_power(), m.get_coefficient());
			else//if power exist
			{
				double coff = map.get(keyPow);
				coff+=m.get_coefficient();
				map.put(m.get_power(),coff);
			} 
		}
		Set<Integer> keys = map.keySet();//collection of all powers in map
		Iterator<Integer> itrKeys = keys.iterator();
		ArrayList<Monom> lstCombine = new ArrayList<>();
		while (itrKeys.hasNext())//iterate of all powers in map
		{ 
			Integer keyPow = itrKeys.next();//get power
			Double valCoff = map.get(keyPow);//get corresponding coff to given power 
			lstCombine.add(new Monom(valCoff,keyPow));//create new monom from pair (coff,power)
			//add created monom to lstCombine
		}
		lstCombine.sort(MonComp);
		this.MonomAList = lstCombine;
	}
	
/*	@Override
	*//**
	 * this method checks if two polynoms are logically equal
	 *//*
	public boolean equals(Polynom_able p1) {
		// TODO Auto-generated method stub
		Iterator<Monom> itrP= this.iteretor();
		Iterator<Monom> itrP1= p1.iteretor();
		if(this.Size()!=((Polynom)p1).Size())//not the same length
			return false;
		while(itrP.hasNext()) 
		{
			Monom mP=itrP.next();
			while(itrP1.hasNext())
			{
				Monom mP1=itrP1.next();

				if(!mP.isEqual(mP1)) 
				{
					return false;
				}

			}
		}
		return true;
	}*/

	@Override
	/**
	 * this method check each coefficient in the array
	 * returns true if all of the coefficients are 0
	 */
	public boolean isZero() {
		if(this.Size()==0) 
		{
			return true;
		}

		//boolean ans= true;
		Iterator<Monom> itr=this.iteretor();
		while(itr.hasNext()) 
		{
			Monom m= itr.next();
			if(m.get_coefficient()!=0) 
			{
				return false;
			}

		}

		return true;
	}

	@Override
	/**
	 * this method finds 'x2' between 'x0' and 'x1' for wich f(x2)=0
	 * if no such 'x2' exists, return an exeption
	 */
	public double root(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		double y0 = this.f(x0);
		double y1 = this.f(x1);
		
		try {
		double center = (x0 + x1) / 2;//middle
		if(y0*y1 > 0)
		{	
			throw new Exception("Error y0 and y1 cannot be both positive!");
		}
		
		if(y0==0) 
		{
			return x0;
		}
		
		if(y1==0) 
		{
			return x1;
		}
	
		if(Math.abs(x0 - x1) < eps)
		{
			return x0;
		}
		
		 if (f(center) * y0 < 0)
		{
			return root(x0, center, eps);
		}
		else
		{
			return root(center, x1, eps);
		}
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		return x0;
	}

	@Override
	/**
	 * this methood makes a copy of a Polynom p and cast it as Polynom_able
	 */
	public Polynom_able copy() {
		// TODO Auto-generated method stub
		Polynom p = new Polynom();
		Iterator<Monom> itr= this.iteretor();
		while(itr.hasNext())
		{
			Monom m1= itr.next();
			p.add(new Monom(m1));
		}
		return p;
	}

	@Override
	/**
	 * this method returns a logical dervative of a given Polynom
	 */
	public Polynom_able derivative() 
	{
		// TODO Auto-generated method stub
		ArrayList<Monom>lstDrv= new ArrayList<>();

		Iterator<Monom> itr= this.iteretor();

		while(itr.hasNext()) 
		{
			Monom m= itr.next();
			Monom drvMon = m.derivative();
			if(drvMon.get_coefficient()!=0)
			{
				lstDrv.add(drvMon);
			}
		}
		Polynom ans = new Polynom(lstDrv);
		return ans;
	}

	@Override
	/**
	 * this method calculates the Area between our polynom , and the x axis (polynom x=0)
	 * between two x values defined as x0,x1 such as  x1 > x0 
	 * returns 0 if x0>x1
	 */
	public double area(double x0, double x1, double eps) {
		// TODO Auto-generated method stub
		double AreaRectangle=0;
		double xNum=x0;
		double Area= Math.abs((x1-x0)/eps);
		if(x0>x1) //must be x1>x0
		{
			return 0;
		}
		
		for(int i=0;i<Area;i++)
		{
			if(this.f(xNum)>0)
			{
			AreaRectangle+=eps*f(xNum);
			}
			xNum+=eps;
			
		}
		//double ARround=round(AreaRectangle);
		double ARround=Math.round(AreaRectangle* 100.0)/100.0;
		return ARround;
	}

	@Override
	/**
	 * iterator
	 */
	public Iterator<Monom> iteretor() {
		// TODO Auto-generated method stub
		Iterator<Monom> itr= MonomAList.iterator();
		return itr;
	}
	
	@Override
	/**
	 * this methed multiplies a given polynom by a Monom m1
	 */
	public void multiply(Monom m1)
	{
		Iterator<Monom> itr= this.iteretor();

		while(itr.hasNext()) 
		{
			Monom m= itr.next();
			m.multipy(m1);;	
		}
	}
	///////////////////////Private data////////////////////
	public static Monom_Comperator MonComp= new Monom_Comperator();
	private ArrayList<Monom> MonomAList;
	@Override
	public function initFromString(String s) 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
}
