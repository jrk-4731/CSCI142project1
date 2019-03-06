package functions;

/**
 * The class to represent a variable.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Variable extends Function{

    /** The variable field */
    public static final Variable X=new Variable();

    /**
     * The variable constructor; only used to assign to the variable field, X.
     */
    public Variable(){
    }

    /**
     * Evaluates the variable given an argument.
     *
     * @param to_eval The double to plug into the equation.
     * @return The evaluated variable, or, the argument to_eval itself
     */
    @Override
    public double evaluate(double to_eval){
        return to_eval;
    }

    /**
     * The string representation of the variable.
     *
     * @return "x"
     */
    @Override
    public String toString(){
        return "x";
    }

    /**
     * The derivative of the variable, which is just the constant, 1.
     *
     * @return An instance of the Constant class, with a value of 1.
     */
    @Override
    public Function derivative(){
        return new Constant(1);
    }

    /**
     * Checks if the variable is a Constant; it is not.
     *
     * @return False.
     */
    @Override
    public boolean isConstant(){
        return false;
    }

    /**
     * Calculate the integral of the variable from a to b.
     *
     * @param a The start of the range
     * @param b End of the range
     * @param num_trap Number of trapezoids to use in the approximation; ignored
     * @return The integral calculated over the range
     */
    @Override
    public double integral(double a, double b, int num_trap){
        return 0.5*((b*b)-(a*a));
    }
}
