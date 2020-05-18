<p align="center">
  <img src="https://user-images.githubusercontent.com/50797734/70247315-d893b400-1781-11ea-968a-4123e8f767a5.png">
</p>

@created by Roie Malykin & Liora Pinkhasov

## About
### Time
#### estemated time : 5 work days (6 hours each)
#### actual time :
  - 5.12.19 : uploaded the old version. (just uplode)
  - 6.12.19 : open 2 new class and begin to work on them (ComplexFunction, Functions_GUI). (about 4 hours)
  - 7.12.19 : added more functions into ComplexFunction. 
  - 8.12.19 : rebuilt structure in ComplexFunction.
  - 10.12.19 : working on init from string in ComplexFunction.
  - 11.12.19 : finished ComplexFunction + build most of Functions_GUI.
  - 12.12.19 : finished Functions_GUI + tests + addTostring func into ComplexFunction.

### Info
in this project we can find 2 java libararys:
- **Ex1**: tool kit.
- **Ex1_tests**: test for our tools.

### the files in Ex1:
- **complex_function**: this interface represents a complex function of type y=g(f1(x), f2(x)), where both f1, f2 are functions (or complex functions), y and x are real numbers and g is an operation: plus, mul, div, max, min, comp (f1(f2(x))).
- **complex_function**: this class represent a Complex function such as a function reciving a function. C(x) = f(g(x)) abstructing it as (g(x),f(x)) while the operation is the interuction between the two functions.
- **cont_function:** The interface represents a continuance function. 
- **function:** This interface represents a simple function of type y=f(x), where both y and x are real numbers.
- **functions:** This interface represents a collection of mathematical functions which can be presented on a GUI window and can be saved (and load) to file. 
- **Functions_GUI:** ///////
- **Monom:**  This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
- **Monom_Comperator:**  this is a Monom Comperator.
- **Range:**  This class represents a simple 1D range of shape [min,max].
- **Operation:** this enum presents the set of operations applicable on function to compose a complex function from two functions.
- **Polynom:**  This class represents a Polynom with add, multiply functionality.
- **Polynom_able:** This interface represents a general Polynom: f(x) = a_1X^b_1 + a_2*X^b_2 ... a_n*Xb_n.
- **StdDraw:** The {@code StdDraw} class provides a basic capability for creating drawings with your programs.

### the files in Ex1_tests:
- **Functions_GUITest**: do test on Functions GUI by using Junite.
- **ComplexFunctionTest**: do test on ComplexFunction by using Junite.
- **MonomTest:** do test on Monom by using Junite.
- **PolynomTest:** do test on Polynom by using Junite.
- **TestStuff:**  many types of test.
