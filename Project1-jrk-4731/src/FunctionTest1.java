import functions.Constant;
import functions.Function;
import functions.Sum;
import functions.Variable;

/**
 * Class used to test all aspects of Constant, Variable and Sum classes (except
 * for integral method)
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class FunctionTest1 {

    /**
     * Main method used for testing.
     *
     * @param args Command line arguments; ignored.
     */
    public static void main(String[] args){
        Function test_1=new Sum();
        Function test_2=new Constant(5);
        Function test_3=new Sum(test_2);
        Variable var=Variable.X;
        Function test_4=new Sum(var);
        Constant constant1=new Constant(1);
        Constant constant2=new Constant(2);
        Function test_5=new Sum(constant1, constant2);
        Function test_6=new Sum(var, var, var, var);
        Function test_7=new Sum(var, var, var, var, constant1, constant2);
        Function test_8=new Sum(new Sum(var, constant2),
                new Sum(var, constant2));
        Function[] tests={test_1, test_2, test_3, var, test_4, test_5, test_6,
                test_7, test_8};
        for (int i=0; i<tests.length; i++){
            System.out.println("Testing for "+ tests[i].toString()+" ...");
            System.out.println("Testing isConstant: "+(tests[i].isConstant()));
            System.out.println("Testing derivative: "+(tests[i].derivative()));
            System.out.println("Testing evaluate for 5: "+
                    (tests[i].toString()+"="+tests[i].evaluate(5)));
            System.out.println("Testing evaluate for -5: "+
                    (tests[i].toString()+"="+tests[i].evaluate(-5)));
            System.out.println("");
        }
    }
}

//OUTPUT
/**
 * Testing for ( 0.0 ) ...
 * Testing isConstant: true
 * Testing derivative: null
 * Testing evaluate for 5: ( 0.0 )=0.0
 * Testing evaluate for -5: ( 0.0 )=0.0
 *
 * Testing for 5.0 ...
 * Testing isConstant: true
 * Testing derivative: 0.0
 * Testing evaluate for 5: 5.0=5.0
 * Testing evaluate for -5: 5.0=5.0
 *
 * Testing for ( 5.0 ) ...
 * Testing isConstant: true
 * Testing derivative: ( 0.0 )
 * Testing evaluate for 5: ( 5.0 )=5.0
 * Testing evaluate for -5: ( 5.0 )=5.0
 *
 * Testing for x ...
 * Testing isConstant: false
 * Testing derivative: 1.0
 * Testing evaluate for 5: x=5.0
 * Testing evaluate for -5: x=-5.0
 *
 * Testing for ( x ) ...
 * Testing isConstant: false
 * Testing derivative: ( 1.0 )
 * Testing evaluate for 5: ( x )=5.0
 * Testing evaluate for -5: ( x )=-5.0
 *
 * Testing for ( 3.0 ) ...
 * Testing isConstant: true
 * Testing derivative: ( 0.0 )
 * Testing evaluate for 5: ( 3.0 )=3.0
 * Testing evaluate for -5: ( 3.0 )=3.0
 *
 * Testing for ( x + x + x + x ) ...
 * Testing isConstant: false
 * Testing derivative: ( 4.0 )
 * Testing evaluate for 5: ( x + x + x + x )=20.0
 * Testing evaluate for -5: ( x + x + x + x )=-20.0
 *
 * Testing for ( x + x + x + x + 3.0 ) ...
 * Testing isConstant: false
 * Testing derivative: ( 4.0 )
 * Testing evaluate for 5: ( x + x + x + x + 3.0 )=23.0
 * Testing evaluate for -5: ( x + x + x + x + 3.0 )=-17.0
 *
 * Testing for ( 4.0 + x + x ) ...
 * Testing isConstant: false
 * Testing derivative: ( 2.0 )
 * Testing evaluate for 5: ( 4.0 + x + x )=14.0
 * Testing evaluate for -5: ( 4.0 + x + x )=-6.0
 *
 */