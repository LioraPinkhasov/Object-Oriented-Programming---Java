package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Ex1.Monom;

class MonomTest {

/*	@Test*/
/*	void testGetComp() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testMonomDoubleInt()
	{
		fail("Not yet implemented");
	}*/

/*	@Test
	static*/
/*	void testMonomMonom() 
	{
		System.out.println("*****  InitMonomTest *****");
		ArrayList<Monom> monoms = new ArrayList<Monom>();
		monoms.add(new Monom(0,5));
		monoms.add(new Monom(-1,0));
		monoms.add(new Monom(-1.3,1));
		monoms.add(new Monom(-2.2,2));

		for(int i=0;i<monoms.size();i++) {
			Monom m = new Monom(monoms.get(i));
			String s = m.toString();
			Monom m1 = new Monom(s);
			boolean e = m.equals(m1);
			System.out.println(i+") "+m +"    \tisZero: "+m.isZero()+"  \teq: "+e);
		}
		fail("Not yet implemented");
	}*/

	@Test
	void testGet_coefficient()
	{
		Monom m3 =new Monom(3,1);
		System.out.println("testGet_coefficient " + m3.get_coefficient());
		
	}

	@Test
	void testGet_power() {
		Monom m = new Monom(2,6);
		m.get_power();
		System.out.println("testGet_power " + m.get_power());
	}

	@Test
	void testDerivative() 
	{
		Monom m = new Monom(2,6);
		Monom m1 = new Monom(4,5);
		Monom m2 = m.derivative();
		System.out.println("testDerivative "+ m2.toString());
	}

/*	@Test
	void testF() {
		fail("Not yet implemented");
	}

	@Test
	void testIsZero() {
		fail("Not yet implemented");
	}

	@Test
	void testValidValues() {
		fail("Not yet implemented");
	}

	@Test
	void testInvSign() {
		fail("Not yet implemented");
	}*/

	@Test
	void testMonomString() {
		System.out.println("testMonomString");
		String[] monoms = {"x^4","x^-4","2x^4","-3.2x^2.6","7","2ax","2bx^5"};
		for(int i=0;i<monoms.length;i++)
		{
			System.out.println("this i is :"+i);
			Monom m4 = new Monom(monoms[i]);
			System.out.println(m4.toString());
		}
	}

	@Test
	void testEqualsMonom() {
		Monom m1 = new Monom("x^2");  
		Monom m2 = new Monom("x^2");  
		boolean e = m1.equals(m2);
		System.out.println("testEqualsMonom " + e );
	}

/*	@Test
	void testEquals2Epsilon() {
		fail("Not yet implemented");
	}
*/
	@Test
	void testAdd() {
		Monom m = new Monom(2,6);
		Monom m1 = new Monom(4,6);
		m.add(m1);
		System.out.println("testAdd " + m.toString() );
	}

	@Test
	void testMultipy() {
		Monom m = new Monom(2,6);
		Monom m1 = new Monom(4,5);
		m.multipy(m1);
		System.out.println("testMultipy " + m.toString());
	}

/*	@Test
	void testIsEqual() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}*/
	/**/

}
