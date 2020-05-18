package Ex1Testing;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Ex1.ComplexFunction;
import Ex1.Functions_GUI;
import Ex1.Monom;
import Ex1.Operation;
import Ex1.Polynom;
import Ex1.Range;
import Ex1.function;
import Ex1.functions;

public class TestStuff {

	public static void main(String[] args)
	{
		//testingComplexFunctionOperationFuncFunc();
		//testingStringToEnumConstructor();
		//OurTest();

		String s = System.getProperty("user.dir");
		s =  s + "\\GUI_params.json";
		Functions_GUI fg= new Functions_GUI();
		ComplexFunction func = new ComplexFunction("Plus(x^3+2,5)");
		System.out.println(func);
		fg.drawFunctions(s);
		
	
		Polynom p1 = new Polynom("x^2");
		Polynom p2 = new Polynom("x^4");
		Polynom p3 = new Polynom("6");
		Polynom p4 = new Polynom("-1");
		ComplexFunction f1 = new ComplexFunction("x^2+3");
		ComplexFunction f2 = new ComplexFunction("x^2+7");
		
		Functions_GUI huigui = new Functions_GUI();
		huigui.add(f1);
		huigui.add(p2);
		huigui.add(p3);
		huigui.add(f2);
		huigui.add(p1);
		huigui.add(p4);
		
		huigui.drawFunctions(1000, 1000, new Range(-10,10), new Range(-5,15), 200);
		

	}
	public static void OurTest()
	{
		ComplexFunction p1 = new ComplexFunction("x^2+3");
		ComplexFunction x1 = new ComplexFunction(" plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0) ");
		ComplexFunction x2 = new ComplexFunction( "plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x 4.0)),2.0)"); 
		ComplexFunction x3 = new ComplexFunction( "div(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)"); 
		ComplexFunction x4 = new ComplexFunction( " -1.0x^4 +2.4x^2 +3.1"); 
		ComplexFunction x5 = new ComplexFunction( " +0.1x^5 -1.2999999999999998x +5.0 "); 
		ComplexFunction x6 = new ComplexFunction( " max(max(max(max(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)"); 
		ComplexFunction x7 = new ComplexFunction( " min(min(min(min(plus(-1.0x^4 +2.4x^2 +3.1,+0.1x^5 1.2999999999999998x +5.0),plus(div(+1.0x +1.0,mul(mul(+1.0x +3.0,+1.0x -2.0),+1.0x -4.0)),2.0)),div(plus(1.0x^4 +2.4x^2 +3.1,+0.1x^5 -1.2999999999999998x +5.0),-1.0x^4 +2.4x^2 +3.1)),-1.0x^4 +2.4x^2 +3.1),+0.1x^5 -1.2999999999999998x +5.0)"); 
		
	}
	public static void testingComplexFunctionOperationFuncFunc()
	{
		Polynom a = new Polynom("x^2");
		Polynom b = new Polynom("x+1");
		ComplexFunction r1 = new ComplexFunction(Operation.Plus ,a,b );
	}
	public static void testingStringToEnumConstructor()
	{
		function a = new Polynom("x^2");
		function b = new Polynom("x+1");
		ComplexFunction r1 = new ComplexFunction("Plus" ,a,b );
		System.out.println(r1+" and the op is " +r1.getOp());
		ComplexFunction r2 = new ComplexFunction("plus" ,a,b );
		System.out.println(r2+" and the op is " +r2.getOp());
	
		ComplexFunction r3 = new ComplexFunction("bullshit" ,a,b );
		System.out.println(r3+" and the op is " +r3.getOp());
	}
	
	

	
	
}
