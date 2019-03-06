package functions;

import java.util.ArrayList;

/**
 * The class to represent the multiplication operation. Note that the Function
 * terms are stored in an ArrayList in order to make methods such as derivative
 * more efficient than would be using a primitive array.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Product extends Function {

    /**
     * The terms to be multiplied
     */
    private ArrayList<Function> terms;

    /**
     * Constructs an instance of the Product class, converting the terms array
     * argument to an ArrayList.
     *
     * @param terms The terms to be multiplied together and filled into the
     *              ArrayList
     */
    public Product(Function... terms) {
        this.terms=new ArrayList<>();
        for (Function term : terms) {
            if (term instanceof Product) {
                Product prod = (Product) term;
                this.terms.addAll(prod.getTerms());
            } else {
                this.terms.add(term);
            }
        }
    }

    /**
     * Accessor for terms
     *
     * @return The terms of the product.
     */
    public ArrayList<Function> getTerms(){return this.terms;}


    /**
     * Evaluates the product for a given value.
     *
     * @param to_eval The double to plug into the equation.
     * @return The product of all terms evaluated at the given value.
     */
    @Override
    public double evaluate(double to_eval) {
        double total = 1;
        for (int i = 0; i < this.terms.size(); i++) {
            total *= this.terms.get(i).evaluate(to_eval);
        }
        return total;
    }

    /**
     * The infix string representation of the product of the terms.
     *
     * @return The string representation of the product of the terms.
     */
    @Override
    public String toString() {
        int terms_length = this.terms.size();
        ArrayList<String> function = new ArrayList<>();
        double multi_consts = 1;
        for (int i = 0; i < terms_length; i++) {
            Function term = this.terms.get(i);
            if (term.isConstant()) {
                multi_consts *= term.evaluate(0);
            } else {
                String str_term = term.toString();
                function.add(str_term);
            }
        }
        int function_length = function.size();
        if (multi_consts == 0) {
            return "( 0.0 )";
        } else if (function.isEmpty()) {
            return "( " + multi_consts + " )";
        } else {
            String to_ret = "( ";
            if (multi_consts != 1) {
                to_ret += multi_consts + " * ";
            }
            for (int i = 0; i < function_length; i++) {
                if (i != function_length - 1) {
                    to_ret += function.get(i) + " * ";
                } else {
                    to_ret += function.get(i) + " )";
                }
            }
            return to_ret;
        }
    }

    /**
     * Creates a new array for the derivative terms and uses a for loop to
     * create derivative terms, in which one element at a time has its
     * derivative calculated, and is multiplied to the rest of the terms. The
     * sum of the derivative terms is returned.
     *
     * @return The derivative of the product.
     */
    @Override
    public Function derivative() {
        int length = this.terms.size();
        if (length == 0 | this.isConstant()) {
            return new Constant(0);
        }
        Function[] derivative_terms = new Function[length];
        for (int i = 0; i < length; i++) {
            ArrayList<Function> temp = new ArrayList<>(this.terms);
            Function term_derivative=temp.remove(i).derivative();
            if (term_derivative.equals(new Constant(0))){
                derivative_terms[i]=term_derivative;
            }
            else if (term_derivative.equals(new Constant(1))){
                derivative_terms[i]=new Product(temp.toArray(
                        new Function[temp.size()]));
            }
            else {
                derivative_terms[i] = new Product(term_derivative,
                        new Product(temp.toArray(new Function[temp.size()])));
            }
        }
        return new Sum(derivative_terms);
    }

    /**
     * Checks whether or not the child branches of the product are instances of
     * the Constant class
     *
     * @return True if all terms are constant; false otherwise.
     */
    @Override
    public boolean isConstant() {
        int length = this.terms.size();
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!this.terms.get(i).isConstant()) {
                return false;
            }
        }
        return true;
    }
}
