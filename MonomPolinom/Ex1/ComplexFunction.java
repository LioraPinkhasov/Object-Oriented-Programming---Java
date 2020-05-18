

package Ex1;
import Ex1.Polynom;

import java.lang.management.CompilationMXBean;

//import org.graalvm.compiler.nodes.calc.IntegerDivRemNode.Op;

import Ex1.Operation;

/**
 * this class represent a Complex function such as a function reciving a function. C(x) = f(g(x))
 * abstructing it as (g(x),f(x)) while the operation is the interuction between the two functions
 * @param op is the Operations avaliable as the described in Operations Class
 * @param fx & gx are either Polynoms or ComplexFunctin themselves 
 * @author RoieMalykin & LioraPinkhasov
 *
 */

public class ComplexFunction implements complex_function
{
	@Override
	/**
	 * Comp operation returns 1 if the values are the same , else returns -1;
	 */
	
	public double f(double x) 
	{
		
		
		switch(this.op) 
		{
		case Plus: 
			return this.leftFunc.f(x) + this.rightFunc.f(x);//return the sum of f(x)'s
			
		case Times: 
			return this.leftFunc.f(x) * this.rightFunc.f(x);//return the multyplication if f(x)'s
			
		case Divid:
			if(this.rightFunc.f(x)!=0)//if checking division by zero
			{
			return this.leftFunc.f(x) / this.rightFunc.f(x);//return the division of leftFunc.f(x) by right functiuon f(x)
			}
			else 
				throw new RuntimeException("Err:no division by 0");//seriosly...dont divide by 0
		case Min:
			if(this.rightFunc.f(x)>=this.leftFunc.f(x))//if the left f(x) is smaller then right f(x)  
				return this.leftFunc.f(x);//return left f(x);
			return this.rightFunc.f(x);//and if its not return the right f(x);
		case Max:
			if(this.rightFunc.f(x)<=this.leftFunc.f(x))//if the right f(x) is smaller then right f(x) 
				return this.leftFunc.f(x);//return left f(x)
			return this.rightFunc.f(x);//return right f(x)
		case Comp:
			if (this.rightFunc != null ) //returns 1 if they are the same value , otherwise -1;
			{
				double ans = 0;
				if( isEpsilonDistance(this.leftFunc.f(x) , this.rightFunc.f(x)))//if they are approximitly the same value (in a radius of EPSILON) 
				 ans = 1;//yes they are the same value
				 else
				 ans = -1;//no they are different values
				
				 return ans;
			}
			return this.leftFunc.f(x);
		case None:
			return this.leftFunc.f(x);
		case Error:	
			throw new RuntimeException("An error occured");
		}
		return x;
	}
	/**
	 * this method checks if two given fx's are close values by a radius of EPSLIDON (defined in Monom Class)
	 * @param f1x
	 */
	public boolean isEpsilonDistance(double f1x , double f2x)
	{
		double distance = Math.abs(f1x - f2x);
		return (distance <= 2*Monom.EPSILON);
	}
	@Override
	public function copy() {
		// TODO Auto-generated method stub
		function copyfunc = new ComplexFunction(this.op,this.leftFunc,this.rightFunc);
		return copyfunc;
		
	}

	@Override
	public void plus(function f1) 
	{
		ComplexFunction a = (ComplexFunction) this.copy();
		leftFunc=a.right();
		//leftFunc=this.copy();
		this.op = Operation.Plus;
		this.rightFunc=f1;

	}

	@Override
	public void mul(function f1)
	{

		ComplexFunction a = (ComplexFunction) this.copy();
		leftFunc=a.right();
		//leftFunc=this.copy();
		this.op = Operation.Times;
		this.rightFunc=f1;
	}

	@Override
	public void div(function f1) 
	{

		ComplexFunction a = (ComplexFunction) this.copy();
		leftFunc=a.right();
		//leftFunc=this.copy();
		this.op = Operation.Divid;
		this.rightFunc=f1;
	}

	@Override
	public void max(function f1)
	{

		ComplexFunction a = (ComplexFunction) this.copy();
		leftFunc=a.right();
		//leftFunc=this.copy();
		this.op = Operation.Max;
		this.rightFunc=f1;
	}

	@Override
	public void min(function f1) 
	{

		ComplexFunction a = (ComplexFunction) this.copy();
		leftFunc=a.right();
		//leftFunc=this.copy();
		this.op = Operation.Min;
		this.rightFunc=f1;

	}

	@Override
	public void comp(function f1) 
	{
		ComplexFunction a = (ComplexFunction) this.copy();
		leftFunc=a.right();
		//leftFunc=this.copy();
		this.op = Operation.Comp;
		this.rightFunc=f1;
	}

	
		
		
	
		///////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\
	/////////////////   Data and Priavate Methods \\\\\\\\\\\\\\\\\\\

							/////\\\\\\\\
							//// Data \\\\
	
	private function leftFunc = null;
	private function rightFunc = null;
	private Operation op = Operation.None;
						   /////\\\\\\\\
	                      /// Getters \\\

	@Override
	public function left() {
		// TODO Auto-generated method stub
		return this.leftFunc;
	}

	@Override
	public function right() {
		// TODO Auto-generated method stub
		return this.rightFunc;
	}

	@Override
	public Operation getOp() {
		return this.op;
		
		
	}
						//////////\\\\\\\\\\\
					    //// Constructors \\\\
	/**
	 * the ZERO polynom;
	 * @return
	 */
	public ComplexFunction()
	{
		Polynom zero = new Polynom();
		this.leftFunc = zero;
		this.rightFunc = null;
		this.op = Operation.None;
				
	}
	
	/**
	 * 
	 * @param op is a type of Operation 
	 * @param left
	 * @param right
	 */
	public ComplexFunction(Operation op, function left, function right)
	{
		leftFunc = left;
		rightFunc = right;
		this.op = op;
	}
	
	
	/**
	 * 
	 * @param op is a string representing an operation :"Must use Plus, Times, Divid, Max, Min, Comp , None...any other argumenbt will turn into Error
	 * @param left
	 * @param Right
	 */
	public ComplexFunction(String op, function left, function right)
	{
		leftFunc = left;
		rightFunc = right;
		try 
		{
			Operation opFromString = Operation.valueOf(op);
			this.op = opFromString;
		}catch
		(Exception e){
			this.op = Operation.Error;
		}
	}

	
	public ComplexFunction(function f1) 
	{

		this.op = Operation.None;
		this.leftFunc = f1;
		this.rightFunc = null;

	}
	
	public ComplexFunction(String s) {
		ComplexFunction x = (ComplexFunction) this.initFromString(s);
		this.op=x.op;
		this.leftFunc=x.leftFunc;
		this.rightFunc=x.rightFunc;
		
	}
	/////

	
	
				         /////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\
		                ////Methods Helping InitFromString() method\\\\\\\
	/**
	 * this method finds the location of the main comma (',') to understand where leftFunc ends and rightFunc beggins.
	 * the function assumes that the main comma is located after the first '(' unbalanced paranthesis, while the are no unbalanced paranthesis between them.
	 * good Examples : " ( , "  or   " ( ( () () ) , "
	 * bad Examples : " ( ( ," or "() ) , "
	 */
	private int positionOfMainComma(String s) 
	{
		int validParanthesis=0;//countes  both '(' and ')' paranthesis
		int	theMainCommaLocation=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(')
				validParanthesis++; //add 1 for each '('
			if(s.charAt(i)==')')
				validParanthesis--;//substruct 1 for each ')'
			if(s.charAt(i)==',' && validParanthesis==1) //found the proper MainComma location if and only if there is only 1 open Para '(' in our counting
				theMainCommaLocation=i;//found the location
			
		}
		return theMainCommaLocation; //please return it
	}
	/**
	 * Uses the string method "String.placeAll()" to turn the given string	
	 * into a one operatable by our Constructors
	 * @param s is the string we initiate a COmplexFunction from;
	 * @return
	 */
	public String aBetterStringForMyConstructors(String s)
	{
		String s1 = s.replaceAll("plus", "Plus");
		String s2 = s1.replaceAll("mul", "Times");
		String s3 = s2.replaceAll("div", "Divid");
		String s4 = s3.replaceAll("max", "Max");
		String s5 = s4.replaceAll("min", "Min");
		String s6 = s5.replaceAll("comp", "Comp");
		String s7 = s6.replaceAll("none", "None");
		String s8 = s7.replaceAll("\\s+",""); // delete all white spaces as they are bothering my constructors
		String s9 = s8.replaceAll("-", "+-"); // turning every "-" into "+-" for the polynom constructor;
		return s9;
	}
	@Override
	/**
	 * this method first casts the String s from its original form ,  into a form usefull for our Polynom constructor
	 * then sends the new string to the 
	 */
	public function initFromString(String s) 
	{
		String stringToInitFrom = aBetterStringForMyConstructors(s);
		function initiatedFunction = initFromStringRec(stringToInitFrom);
		return initiatedFunction;
	}
	public function initFromStringRec(String s) 
	{
		//reccursion stopping condition , no more '()'
		if(!s.contains("(") && !s.contains(")")) {
			function poly = new Polynom(s);
			ComplexFunction justPoly = new ComplexFunction(poly);
			return justPoly;		
		}
		
		else //there must be '('
		{
			int firstParanthesis_Location = s.indexOf("(");
			/*
			 * int j = 0; while(s.charAt(j)!='(') { j++;
			 */
		
		String op = s.substring(0,firstParanthesis_Location);
		int possitionOfMainComma = positionOfMainComma(s);
		String s1 = s.substring(firstParanthesis_Location+1,possitionOfMainComma);  //this substring represents the left func
		function f1 = initFromStringRec(s1);//f1 will become the leftFunc
		String s2 = s.substring(possitionOfMainComma+1,s.length()-1);  //this substring represents the right func
		function f2 = initFromStringRec(s2);// f2 will become the rightFunc
		ComplexFunction monsterFunction = new ComplexFunction(op,f1,f2);
		return monsterFunction;
		
		}
	}
	
	public String toString() {
		String s =  (this.op.name() != "None") ? this.op.name() : "" ;
		if(this.rightFunc != null && this.leftFunc != null) {
			s = s + "(" + this.leftFunc.toString() + "," + this.rightFunc.toString() + ")";
		}else if(this.leftFunc != null &&!(this.leftFunc instanceof ComplexFunction)) {
			return this.leftFunc.toString();
		}
		return s;
	}
	

		

	


}
