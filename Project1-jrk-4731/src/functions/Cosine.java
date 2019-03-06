package functions;

/**
 * Class to represent the cosinusoidal function
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Cosine extends Function{

    /** The function to be passed into the cosine function */
    private Function function;

    /**
     * The constructor for an instance of Cosine; assigns a given function
     * argument to the function field.
     *
     * @param function The function to be passed into the cosine function.
     */
    public Cosine(Function function) {
        this.function=function;
    }

    /**
     * Evaluates the cosine of the function at the given argument.
     *
     * @param to_eval The double to plug into the equation.
     * @return The evaluated cosine function.
     */
    @Override
    public double evaluate(double to_eval){
        return Math.cos(function.evaluate(to_eval));
    }

    /**
     * String representation of the cosine function.
     *
     * @return "cos('the function field string representation')"
     */
    @Override
    public String toString(){
        return "cos( "+this.function.toString()+" )";
    }

    /**
     * Returns the derivative of the cosine function using the chain rule
     *
     * @return The derivative of the cosine function.
     */
    @Override
    public Function derivative(){
        return new Product(new Constant(-1), new Sine(this.function),
                this.function.derivative());
    }

    /**
     * Checks whether or not all of the child branches of the cosine function
     * are instances of the Constant class
     *
     * @return True if all child branches are instances of Constant, false
     * otherwise.
     */
    @Override
    public boolean isConstant() {
        if (this.function.isConstant()) {
            return true;
        } else {
            return false;
        }
    }
}
