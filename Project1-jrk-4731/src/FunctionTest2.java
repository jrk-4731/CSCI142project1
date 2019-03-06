import functions.*;

/**
 * Class to test full functionality of the program.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class FunctionTest2 {

    /**
     * Main method used for testing of all functions in the program.
     *
     * @param args Command line arguments; ignored.
     */
    public static void  main(String[] args) {
        Function test_1 = new Product();
        Variable x = new Variable();
        Constant zero = new Constant(0);
        Constant one = new Constant(1);
        Constant two = new Constant(2);
        Constant three = new Constant(3);
        Function test_2 = new Sine(zero);
        Function test_3 = new Cosine(zero);
        Function test_4 = new Product(three, one);
        Function test_5 = new Product(three, zero);
        Function test_6=new Product(two, x);
        Function test_7 = new Sine(new Product(two, x));
        Function test_8 = new Cosine(new Product(two, x));
        Function test_9 = new Product(three, two, test_6);
        Function test_10 = new Sum(new Product(two, x, x), zero);
        Function test_11 = new Product(new Sum(two, x, x), one);
        Function test_12=new Product(new Product(two, x), new Product(two, x));
        Function test_13=new Sum(new Sum(two, x), new Sum(two, x));
        Function[] tests = {test_1, test_2, test_3, test_4, test_5, test_6,
                test_7, test_8, test_9, test_10, test_11, test_12, test_13};
        for (int i = 0; i < tests.length; i++) { //MAY WANT TO CREATE MORE ROBUST TESTS
            System.out.println("Testing for " + tests[i].toString() + " ...");
            System.out.println("Testing isConstant: " + (tests[i].isConstant()));
            System.out.println("Testing derivative: " + (tests[i].derivative()));
            System.out.println("Testing evaluate for 5: " +
                    (tests[i].toString() + "=" + tests[i].evaluate(5)));
            System.out.println("Testing evaluate for -5: " +
                    (tests[i].toString() + "=" + tests[i].evaluate(-5)));
            System.out.println("Testing integral for 0 to 5, 5 " +
                    "trapezoids: " + (tests[i].integral(0, 5,
                    5)));
            System.out.println("Testing integral for 0 to 5, 100 " +
                    "trapezoids: " + (tests[i].integral(0, 5,
                    100)));
            System.out.println("Testing integral for 0 to 5, 100000 " +
                    "trapezoids: " + (tests[i].integral(0, 5,
                    100000)));
            System.out.println("");
        }
    }
}

//OUTPUT
/**
 * Testing for ( 1.0 ) ...
 * Testing isConstant: true
 * Testing derivative: 0.0
 * Testing evaluate for 5: ( 1.0 )=1.0
 * Testing evaluate for -5: ( 1.0 )=1.0
 * Testing integral for 0 to 5, 5 trapezoids: 5.0
 * Testing integral for 0 to 5, 100 trapezoids: 5.0
 * Testing integral for 0 to 5, 100000 trapezoids: 5.0
 *
 * Testing for sin( 0.0 ) ...
 * Testing isConstant: true
 * Testing derivative: ( 0.0 )
 * Testing evaluate for 5: sin( 0.0 )=0.0
 * Testing evaluate for -5: sin( 0.0 )=0.0
 * Testing integral for 0 to 5, 5 trapezoids: 0.0
 * Testing integral for 0 to 5, 100 trapezoids: 0.0
 * Testing integral for 0 to 5, 100000 trapezoids: 0.0
 *
 * Testing for cos( 0.0 ) ...
 * Testing isConstant: true
 * Testing derivative: ( 0.0 )
 * Testing evaluate for 5: cos( 0.0 )=1.0
 * Testing evaluate for -5: cos( 0.0 )=1.0
 * Testing integral for 0 to 5, 5 trapezoids: 5.0
 * Testing integral for 0 to 5, 100 trapezoids: 5.0
 * Testing integral for 0 to 5, 100000 trapezoids: 5.0
 *
 * Testing for ( 3.0 ) ...
 * Testing isConstant: true
 * Testing derivative: 0.0
 * Testing evaluate for 5: ( 3.0 )=3.0
 * Testing evaluate for -5: ( 3.0 )=3.0
 * Testing integral for 0 to 5, 5 trapezoids: 15.0
 * Testing integral for 0 to 5, 100 trapezoids: 15.0
 * Testing integral for 0 to 5, 100000 trapezoids: 15.0
 *
 * Testing for ( 0.0 ) ...
 * Testing isConstant: true
 * Testing derivative: 0.0
 * Testing evaluate for 5: ( 0.0 )=0.0
 * Testing evaluate for -5: ( 0.0 )=0.0
 * Testing integral for 0 to 5, 5 trapezoids: 0.0
 * Testing integral for 0 to 5, 100 trapezoids: 0.0
 * Testing integral for 0 to 5, 100000 trapezoids: 0.0
 *
 * Testing for ( 2.0 * x ) ...
 * Testing isConstant: false
 * Testing derivative: ( 2.0 )
 * Testing evaluate for 5: ( 2.0 * x )=10.0
 * Testing evaluate for -5: ( 2.0 * x )=-10.0
 * Testing integral for 0 to 5, 5 trapezoids: 17.0
 * Testing integral for 0 to 5, 100 trapezoids: 24.99999999999998
 * Testing integral for 0 to 5, 100000 trapezoids: 24.999999999992884
 *
 * Testing for sin( ( 2.0 * x ) ) ...
 * Testing isConstant: false
 * Testing derivative: ( 2.0 * cos( ( 2.0 * x ) ) )
 * Testing evaluate for 5: sin( ( 2.0 * x ) )=-0.5440211108893698
 * Testing evaluate for -5: sin( ( 2.0 * x ) )=0.5440211108893698
 * Testing integral for 0 to 5, 5 trapezoids: -0.39893112212585724
 * Testing integral for 0 to 5, 100 trapezoids: 0.9187693569907331
 * Testing integral for 0 to 5, 100000 trapezoids: 0.9195357637747062
 *
 * Testing for cos( ( 2.0 * x ) ) ...
 * Testing isConstant: false
 * Testing derivative: ( -2.0 * sin( ( 2.0 * x ) ) )
 * Testing evaluate for 5: cos( ( 2.0 * x ) )=-0.8390715290764524
 * Testing evaluate for -5: cos( ( 2.0 * x ) )=-0.8390715290764524
 * Testing integral for 0 to 5, 5 trapezoids: -0.0291559352986146
 * Testing integral for 0 to 5, 100 trapezoids: -0.2717838421935636
 * Testing integral for 0 to 5, 100000 trapezoids: -0.27201055521177786
 *
 * Testing for ( 12.0 * x ) ...
 * Testing isConstant: false
 * Testing derivative: ( 12.0 )
 * Testing evaluate for 5: ( 12.0 * x )=60.0
 * Testing evaluate for -5: ( 12.0 * x )=-60.0
 * Testing integral for 0 to 5, 5 trapezoids: 102.0
 * Testing integral for 0 to 5, 100 trapezoids: 149.99999999999986
 * Testing integral for 0 to 5, 100000 trapezoids: 149.99999999995725
 *
 * Testing for ( ( 2.0 * x * x ) ) ...
 * Testing isConstant: false
 * Testing derivative: ( ( 2.0 * x ) + ( 2.0 * x ) )
 * Testing evaluate for 5: ( ( 2.0 * x * x ) )=50.0
 * Testing evaluate for -5: ( ( 2.0 * x * x ) )=50.0
 * Testing integral for 0 to 5, 5 trapezoids: 53.0
 * Testing integral for 0 to 5, 100 trapezoids: 83.33749999999978
 * Testing integral for 0 to 5, 100000 trapezoids: 83.33333333742276
 *
 * Testing for ( ( 2.0 + x + x ) ) ...
 * Testing isConstant: false
 * Testing derivative: ( 2.0 )
 * Testing evaluate for 5: ( ( 2.0 + x + x ) )=12.0
 * Testing evaluate for -5: ( ( 2.0 + x + x ) )=-8.0
 * Testing integral for 0 to 5, 5 trapezoids: 25.0
 * Testing integral for 0 to 5, 100 trapezoids: 34.99999999999997
 * Testing integral for 0 to 5, 100000 trapezoids: 34.99999999999289
 *
 * Testing for ( 4.0 * x * x ) ...
 * Testing isConstant: false
 * Testing derivative: ( ( 4.0 * x ) + ( 4.0 * x ) )
 * Testing evaluate for 5: ( 4.0 * x * x )=100.0
 * Testing evaluate for -5: ( 4.0 * x * x )=100.0
 * Testing integral for 0 to 5, 5 trapezoids: 106.0
 * Testing integral for 0 to 5, 100 trapezoids: 166.67499999999956
 * Testing integral for 0 to 5, 100000 trapezoids: 166.66666667484552
 *
 * Testing for ( 4.0 + x + x ) ...
 * Testing isConstant: false
 * Testing derivative: ( 2.0 )
 * Testing evaluate for 5: ( 4.0 + x + x )=14.0
 * Testing evaluate for -5: ( 4.0 + x + x )=-6.0
 * Testing integral for 0 to 5, 5 trapezoids: 45.0
 * Testing integral for 0 to 5, 100 trapezoids: 45.0
 * Testing integral for 0 to 5, 100000 trapezoids: 45.0
 *
 */
