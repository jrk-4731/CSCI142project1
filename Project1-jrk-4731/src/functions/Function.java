package functions;


/**
 * An abstract class of a general function. Used as a parent class for all
 * other functions in the program.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public abstract class Function {

    /**
     * Constructor for Function class.
     */
    public Function(){
    }

    /**
     * Evaluate the function for a given double.
     *
     * @param to_eval The double to plug into the equation.
     * @return The solution to the the function at the given to_eval input.
     */
    public abstract double evaluate(double to_eval);

    /**
     * Overides the toString() method in Object to give a string representation
     * for each function. Implemented in child classes.
     *
     * @return The string representation of the function.
     */
    @Override
    public String toString(){
        return "";
    }

    /**
     * Overrides the equals method of Object to see if two functions are equal
     * to each; compares their string representations.
     *
     * @param other The other function to compare.
     * @return True if the string representations of the two functions are the
     * same; false otherwise.
     */
    @Override
    public boolean equals(Object other){
        if (other instanceof Function){
            Function func=(Function) other;
            return this.toString().equals(func.toString());
        }
        return false;
    }

    /**
     * Find the general form of the derivative of the function.
     *
     * @return The derivative of the function, left in variable form.
     */
    public abstract Function derivative();

    /**
     * Confirms whether or not the function is a constant.
     *
     * @return True if an instance of Constant, or all "children" of the
     * function are instances of Constant.
     */
    public abstract boolean isConstant();

    /**
     * Calculates the integral of the function for a given range, using
     * trapezoidal approximation (given the number of trapezoids with which to
     * approximate the integral).
     *
     * @param a The start of the range
     * @param b End of the range
     * @param num_trap Number of trapezoids to use in the approximation.
     * @return The approximated integral solution.
     */
    public double integral(double a, double b, int num_trap) {
        if (!this.isConstant()) {
            double h = (b - a) / num_trap;
            double total = this.evaluate(a) + this.evaluate(b);
            double increment = a + h;
            while (increment < b - h) {
                double val_to_add = 2 * this.evaluate(increment);
                total += val_to_add;
                increment += h;
            }
            return total * (h / 2);
        } else {
            double b_val=this.evaluate(0)*b;
            double a_val=this.evaluate(0)*a;
            return b_val-a_val;
        }
    }
}
