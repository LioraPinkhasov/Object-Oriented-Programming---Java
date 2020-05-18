package Ex1Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Polynom;
import Ex1.complex_function;

class ComplexFunctionTest {

/*	@Test
	void testF() {
		
		fail("Not yet implemented");
	}

	@Test
	void testInitFromString() {
		//String plystr = "plus(x^2,3)";
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}*/

	@Test
	void testPlus() {
		Polynom p1 = new Polynom ("2x+1");
		Polynom p2 = new Polynom ("3x^2+2x");
		ComplexFunction compf = new ComplexFunction ("Plus",p1,p2);
		System.out.println(compf.toString());
	}

	@Test
	void testMul() {
		Polynom p1 = new Polynom ("2x+1");
		Polynom p2 = new Polynom ("3x^2+2x");
		ComplexFunction compf = new ComplexFunction ("Times",p1,p2);
		System.out.println(compf.toString());
	}

	@Test
	void testDiv() {
		Polynom p1 = new Polynom ("2x+1");
		Polynom p2 = new Polynom ("3x^2+2x");
		ComplexFunction compf = new ComplexFunction ("Divid",p1,p2);
		System.out.println(compf.toString());
	}

	@Test
	void testMax() {
		Polynom p1 = new Polynom ("2x+1");
		Polynom p2 = new Polynom ("3x^2+2x");
		ComplexFunction compf = new ComplexFunction ("Max",p1,p2);
		System.out.println(compf.toString());
	}

	@Test
	void testMin() {
		Polynom p1 = new Polynom ("2x+1");
		Polynom p2 = new Polynom ("3x^2+2x");
		ComplexFunction compf = new ComplexFunction ("Times",p1,p2);
		System.out.println(compf.toString());
	}

	@Test
	void testComp() {
		Polynom p1 = new Polynom ("2x+1");
		Polynom p2 = new Polynom ("3x^2+2x");
		ComplexFunction compf = new ComplexFunction ("Comp",p1,p2);
		System.out.println(compf.toString());
	}  

	/*@Test
	void testLeft() {
		fail("Not yet implemented");
	}

	@Test
	void testRight() {
		fail("Not yet implemented");
	}

	@Test
	void testGetOp() {
		fail("Not yet implemented");
	}

	@Test
	void testComplexOperationStringFunctionFunction() {
		Polynom a = new Polynom("x^2");
		Polynom b = new Polynom("x+1");
		ComplexFunction r1 = new ComplexFunction(Operation.Plus ,a,b );
		fail("Not yet implemented");
	}
	
	@Test
	void testComplexFunctionStringFunctionFunction() {
		fail("Not yet implemented");
	}

	@Test
	void testComplexFunctionStringPolynomPolynom() {
		fail("Not yet implemented");
	}

	@Test
	void testComplexFunctionStringPolynom() {
		fail("Not yet implemented");
	}
*/
	@Test
	void testValidParanthesis() 
	{
		String str1 = "(((())))";
		String str2 = "((())))";
		String str3 = "x+3(5,4+7(+8*9))";

	}

	/*@Test
	void testTearDownTheString() {
		fail("Not yet implemented");
	}

	@Test
	void testComplexFunctionPolynom() {
		fail("Not yet implemented");
	}

	@Test
	void testComplexFunctionOperationPolynomPolynom() {
		fail("Not yet implemented");
	}

	@Test
	void testComplexFunctionOperationComplexFunctionComplexFunction() {
		fail("Not yet implemented");
	}
*/

	@Test
	void testCheckOperation() 
	{
		String  s1 = "mul(four)";
		//Operation num = Ex1.ComplexFunction.checkOperation(s1);
		//System.out.println("what???"+num);

		}
}
