package functions;

/**
 * The class to represent the sinusoidal function.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Sine extends Function {

    /**
     * The function to put inside of the sine function
     */
    private Function function;

    /**
     * Constructs an instance of the Sine class by passing assigning the
     * function field to the given function argument.
     *
     * @param function The function to be operated on by the Sine function.
     */
    public Sine(Function function) {
        this.function = function;
    }

    /**
     * Evaluates the sine of the given function.
     *
     * @param to_eval The double to plug into the equation.
     * @return The value of the sine of the function field.
     */
    @Override
    public double evaluate(double to_eval) {
        return Math.sin(function.evaluate(to_eval));
    }

    /**
     * String representation of the sine function.
     *
     * @return The string of the sine function.
     */
    @Override
    public String toString() {
        return "sin( " + this.function.toString() + " )";
    }

    /**
     * Takes the derivative of the sine function using the chain rule.
     *
     * @return The derivative of the sine function.
     */
    @Override
    public Function derivative() {
        new Product(new Cosine(this.function),
                this.function.derivative()).toString();
        return new Product(new Cosine(this.function),
                this.function.derivative());
    }

    /**
     * Checks whether or not the function passed into the sine function is an
     * instance of the Constant class.
     *
     * @return True if the function field is an instance of the Constant class;
     * false otherwise.
     */
    @Override
    public boolean isConstant() {
        if (this.function.isConstant()) {
            return true;
        }
        return false;
    }
}
