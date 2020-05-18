
package Ex1;
import Ex1.Polynom;

import java.util.Comparator;

/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Roie Malykin & Liora Pinkhasov
 *
 */

public class Monom implements function{
	public static final Monom ZERO = new Monom(0,0);
	public static final Monom MINUS1 = new Monom(-1,0);
	public static final double EPSILON = 0.0000001;
	public static final Comparator<Monom> _Comp = new Monom_Comperator();
	public static Comparator<Monom> getComp() {return _Comp;}
	
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}

	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	public double get_coefficient() {
		return this._coefficient;
	}

	public int get_power() {
		return this._power;
	}
	/** 
	 * this method returns the derivative monom of this.
	 * @return
	 */
	public Monom derivative()
	{
		if(this.get_power()==0) {return getNewZeroMonom();}
		return new Monom(this.get_coefficient()*this.get_power(), this.get_power()-1);
	}
/**
 * This method calculated the value of a Monom for a given x
 */
	public double f(double x)
	{
		double ans=0;
		double p = this.get_power();
		ans = this.get_coefficient()*Math.pow(x, p);
		return ans;
	} 

	public boolean isZero() {return this.get_coefficient() == 0;}
	// ***************** add your code below **********************

	public boolean validValues()
	{
		boolean validValues = true;
		if(this.get_power()<0)
		{
			validValues=false;
		}
		if(this.get_coefficient() == 0)
		{
			validValues=false;
		}
		return validValues;
	}
	
	/**
	 * multiply this Monom by -1 
	 * @return negative coefficient
	 */
	public Monom InvSign()
	{
		this. set_coefficient(this.get_coefficient()*-1);
		return this;
	}
	
	public Monom(String s)
	{
		s=s.toLowerCase();//turn 'X' into 'x'
		int x_Location = s.indexOf('x');//find the index of 'x'
		if(x_Location == -1)//if this is a Monom type "a" with no x and power.
		{
			try
			{
				//System.out.println("you are trying to build A monom type");
				double double_coef = Double.parseDouble(s);

				this.set_coefficient(double_coef);
				this.set_power(0);
				//System.out.println("successfully built a ("+double_coef+","+0+" ) Monom");
				
			}

			catch(Exception e)
			{new RuntimeException("ERR the coefficient should be a number");}
		}
		else
		{ 
			String string_coEf = s.substring(0,x_Location);// coEf is a string that represents the _coefficient,might be a an empty string
			String string_pow="";
			try
			{ 
				string_pow = s.substring(x_Location+1);// pow this string represents the _power
				
			}
			catch(Exception ArrayOutOfBound) 
				{
				System.out.println("line 382: string_pow had problem array index");
				 string_pow = "";//this is now an empty string
			    }
			
			//if there is a ^ , trim it from string_pow: example "^67" --> "67"
			if(s.indexOf('^')!=-1)
			string_pow = string_pow.substring(1);
			
			////we are now ready to create a Monom;
			int int_pow;
			double double_coef;
			try 
			{
				if(string_coEf.isEmpty() && string_pow.isEmpty())//only "x"
				{//"x"
					//System.out.println("you are trying to build X monom type");
					this.set_coefficient(1);
					this.set_power(1);
					//System.out.println("successfully built a ("+1+","+1+" ) Monom");
				}
				else if(string_pow.isEmpty())
				{//"ax"
					//System.out.println("you are trying to build AX monom type");
					double_coef = Double.parseDouble(string_coEf);
					this.set_coefficient(double_coef);
					this.set_power(1);
					//System.out.println("successfully built a ("+double_coef+","+1+" ) Monom");
				}
				else if(string_coEf.isEmpty())
				{//"x^b"
					//System.out.println("you are trying to build X^B monom type");
					int_pow = Integer.parseInt(string_pow);
					if(int_pow > 0)
					{
					this.set_coefficient(1);
					this.set_power(int_pow);
					//System.out.println("successfully built a ("+1+","+int_pow+" )  Monom");
					}
				}
				else
				{//"ax^b"
					//System.out.println("you are trying to build AX^B monom type");
					double_coef = Double.parseDouble(string_coEf);
					int_pow = Integer.parseInt(string_pow);
					if(int_pow > 0)
					{
						this.set_coefficient(double_coef);
						this.set_power(int_pow);
						//System.out.println("successfully built a ("+double_coef+","+int_pow+" )  Monom");
					}
					
					
				}
			}
			catch(Exception e) {
				System.out.println("Couldent Construct Monom from string line 401");	
			}
		}
		
		
	}
	/**
	 * check if m1 and m2 are the same monoms
	 * by comparing their powers , and the coefficients will be measured by equals2EPSILON() to overcome double type problems
	 * @param m2
	 * @return
	 */
	public boolean equals(Monom m2)
	{	
		boolean same_coef = this.Equals2Epsilon(m2.get_coefficient());
		boolean same_power = (this.get_power()==m2.get_power());
		return (same_coef && same_power);
	}
	/**
	 * this metod returns true if the delta between two coefficients is less the twice the EPSILON
	 * Example 2.9999999=3=3.00000001 all will be the same value;
	 * @param m_coef
	 * @return
	 */
	public boolean Equals2Epsilon(double m_coef)
	{
		double distance = Math.abs(this.get_coefficient()-m_coef);
		return (distance<= 2*EPSILON);
		
	}

	public void add(Monom m) 
	{
		if(this.get_power()!= m.get_power())
		{
			throw new RuntimeException("Error! the power of Monom's should be equal!/n got "+this.get_power ()+ " and m power is "+m.get_power());

		}
		else
		{
			this.set_coefficient(this.get_coefficient()+m.get_coefficient());
		}
	}

	public void multipy(Monom d) 
	{
		//setting a new coefficient for tempMonom
		this.set_coefficient(this.get_coefficient()*d.get_coefficient());
		//setting a new power for tempMonom;
		this.set_power(this.get_power()+d.get_power());
	}

	public boolean isEqual(Monom m1) 
	{
		boolean monom=false;
		
		if(m1!=null)
		{
			if(this.get_power() == m1.get_power() && this.get_coefficient() == m1.get_coefficient())
			{
				monom=true;
			}
			else
			{
				monom=false;
			}
		}
		return monom;
		
	}
	
	
	public String toString() 
	{
		if(this.get_power() == 0 )
		{
		String ans = Double.toString(this.get_coefficient())	;
		return ans;
		}
		else 
		{
		String ans = (this.get_coefficient()+"x^"+this.get_power());
		return ans;
		}
	}
	// you may (always) add other methods.

	//****************** Private Methods and Data *****************


	private void set_coefficient(double a){
		this._coefficient = a;
	}
	private void set_power(int p) {
		if(p<0) {throw new RuntimeException("ERR the power of Monom should not be negative, got: "+p);}
		this._power = p;
	}
	private static Monom getNewZeroMonom() {return new Monom(ZERO);}
	private double _coefficient; 
	private int _power;
	@Override
	public function initFromString(String s) {
		function func = new Monom(s);
		return func;
	}
	@Override
	public function copy() {
		// TODO Auto-generated method stub
		return null;
	}


}
