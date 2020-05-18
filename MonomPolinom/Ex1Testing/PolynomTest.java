package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.Monom;
import Ex1.Polynom;

class PolynomTest {

/*	@Test
	void testPolynom() 
	{
		
		fail("Not yet implemented");
	}*/

	@Test
	void testPolynomString()
	{
		String s1= "2x^5+4x^8+22";
		Polynom p1 = new Polynom(s1);
		System.err.println("testPolynomString " + p1.toString());
	}

/*	@Test
	void testPolynomArrayListOfMonom()
	{
		fail("Not yet implemented");
	}

	@Test
	void testValid() {
		fail("Not yet implemented");
	}

	@Test
	void testGMonom() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testF() 
	{
		fail("Not yet implemented");
	}

	@Test
	void testToString() 
	{
		fail("Not yet implemented");
	}*/

/*	@Test
	void testAddPolynom_able()
	{
		fail("Not yet implemented");
	}

	@Test
	void testRemoveZero()
	{
		fail("Not yet implemented");
	}

	@Test
	void testSize() 
	{
		fail("Not yet implemented");
	}*/

	@Test
	void testAddMonom() 
	{
		Polynom p1 = new Polynom("x^2+3");
		Polynom p2 = new Polynom("6x");
		p1.add(p2);
		System.out.println("testAddMonom" + p1.toString());
		
	}

	@Test
	void testSubstract() 
	{
		Polynom p1 = new Polynom("x^2+3");
		Polynom p2 = new Polynom("6x+2");
		p1.substract(p2);
		System.out.println("testSubstract" + p1.toString());
	}

	@Test
	void testMultiplyPolynom_able() 
	{
		Polynom p1 = new Polynom(), p2 =  new Polynom();
		String[] monoms1 = {"2", "-x","-3.2x^2","4","-1.5x^2"};
		String[] monoms2 = {"5", "1.7x","3.2x^2","-3","-1.5x^2"};
		for(int i=0;i<monoms1.length;i++) {
			Monom m = new Monom(monoms1[i]);
			p1.add(m);
		}
		for(int i=0;i<monoms2.length;i++) {
			Monom m = new Monom(monoms2[i]);
			p2.add(m);
		}
		System.out.println("testMultiplyPolynom_able");
		System.out.println("p1: "+p1);
		System.out.println("p2: "+p2);
		p1.add(p2);
		System.out.println("p1+p2: "+p1);
		p1.multiply(p2);
		System.out.println("(p1+p2)*p2: "+p1);
		String s1 = p1.toString();
	}

/*	@Test
	void testEqualsPolynom_able() {
		fail("Not yet implemented");
	}

	@Test
	void testIsZero() {
		fail("Not yet implemented");
	}

	@Test
	void testRoot() {
		fail("Not yet implemented");
	}*/

	@Test
	void testCopy() {
		Polynom P1 = new Polynom("x^2-3");
		Polynom pc = (Polynom) P1.copy();

		System.out.println("testCopy"+pc);
	}
/*
	@Test
	void testDerivative() {
		fail("Not yet implemented");
	}*/

	@Test
	void testArea() {
		Polynom p1 = new Polynom();
		String[] monoms = {"1","x","x^2", "0.5x^2"};
		for(int i=0;i<monoms.length;i++) {
		Monom m = new Monom(monoms[1]);
		p1.add(m);
		double aa = p1.area(0, 1, 0.0001);
		p1.substract(p1);
		System.out.println("testArea" + p1);
	}
	}

/*	@Test
	void testIteretor() {
		fail("Not yet implemented");
	}*/

	@Test
	void testMultiplyMonom() {
		Polynom p1 = new Polynom("x^2+3");
		Monom m1 = new Monom ("3x");
		p1.multiply(m1);
		System.out.println("testMultiplyMonom" + p1.toString());
	}

}
