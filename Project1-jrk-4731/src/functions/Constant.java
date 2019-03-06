package functions;

/**
 * A class to represent a constant value.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Constant extends Function{

    /** The value of the constant */
    private double value;

    /**
     * Constructs an instance of the Constant class
     *
     * @param value The value of the constant.
     */
    public Constant(double value){
        this.value=value;
    }

    /**
     * Returns the value of the constant.
     *
     * @param to_eval The double to plug into the equation; ignored.
     * @return The value of the constant.
     */
    @Override
    public double evaluate(double to_eval){
        return this.value;
    }

    /**
     * Simply the string representation of the constant value.
     *
     * @return The string representation of the constant value.
     */
    @Override
    public String toString(){
        return String.valueOf(this.value);
    }

    /**
     * The derivative of the value; 0.
     *
     * @return 0
     */
    @Override
    public Function derivative(){
        return new Constant(0);
    }

    /**
     * Checks if the class is a constant; always true for constant class.
     *
     * @return True
     */
    @Override
    public boolean isConstant(){
        return true;
    }

    /**
     * Calculates the integral of the constant.
     *
     * @param a The start of the range
     * @param b End of the range
     * @param num_trap Number of trapezoids to use in the approximation; ignored
     * @return The value of the integral over the given range.
     */
    @Override
    public double integral(double a, double b, int num_trap){
        double value=this.value;
        return value*b-value*a;
    }
}
