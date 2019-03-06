package functions;

import java.util.ArrayList;

/**
 * Class used to represent the addition operator.
 *
 * @author Jake Koerner <jrk4731@g.rit.edu>
 */
public class Sum extends Function{

    /** The function terms to be added together */
    public ArrayList<Function> terms;

    /**
     * Constructor for the Sum class; adds to terms to the terms array.
     *
     * @param terms The function terms to add to the terms array.
     */
    public Sum(Function... terms){
        this.terms=new ArrayList<>();
        for (Function term : terms) {
            if (term instanceof Sum) {
                Sum sum = (Sum) term;
                this.terms.addAll(sum.getTerms());
            } else {
                this.terms.add(term);
            }
        }
    }

    /**
     * Accessors for terms field
     *
     * @return Terms field
     */
    public ArrayList<Function> getTerms(){return this.terms;}

    /**
     * Evaluates each term for the given input, summing the terms and returning
     * the total.
     *
     * @param to_eval The double to plug into the equation.
     * @return The total of the terms evaluate at the given argument.
     */
    @Override
    public double evaluate(double to_eval){
        double total=0;
        for (int i=0; i<this.terms.size(); i++){
            total+=this.terms.get(i).evaluate(to_eval);
        }
        return total;
    }

    /**
     * An infix representation of the function terms summed together.
     *
     * @return The string representation of the function.
     */
    @Override
    public String toString() {
        int terms_length = this.terms.size();
        ArrayList<String> function = new ArrayList<>();
        double add_consts = 0;
        for (int i = 0; i < terms_length; i++) {
            Function term = this.terms.get(i);
            if (term.isConstant()) {
                add_consts += term.evaluate(0);
            } else {
                String str_term = term.toString();
                function.add(str_term);
            }
        }
        int function_length = function.size();
        if (function.isEmpty()) {
            return "( " + add_consts + " )";
        } else {
            String to_ret = "( ";
            if (add_consts != 0) {
                to_ret += add_consts + " + ";
            }
            for (int i = 0; i < function_length; i++) {
                if (i != function_length - 1) {
                    to_ret += function.get(i) + " + ";
                } else {
                    to_ret+=function.get(i) + " )";
                }
            }
            return to_ret;
        }
    }

    /**
     * The derivative in variable form.
     *
     * @return The sum of the derivatives of each term.
     */
    @Override
    public Function derivative(){
        int terms_length=this.terms.size();
        if (terms_length==0 | this.isConstant()){
            return new Constant(0);
        }
        Function[] derivative_terms=new Function[terms_length];
        for (int i=0; i<terms_length; i++){
            Function term_derivative=this.terms.get(i).derivative();
            derivative_terms[i]=term_derivative;
        }
        return new Sum(derivative_terms);
    }

    /**
     * Checks whether the sum contains only instances of Constant.
     *
     * @return True if every term is an instance of Constant, false otherwise.
     */
    @Override
    public boolean isConstant(){
        int terms_length=this.terms.size();
        if (terms_length==0){
            return true;
        }
        for (int i=0; i<terms_length; i++){
            if (!this.terms.get(i).isConstant()){
                return false;
            }
        }
        return true;
    }

    /**
     * Takes the integral of each term over the given range and sum together
     * the terms, returning the total.
     *
     * @param a The start of the range
     * @param b End of the range
     * @param num_trap Number of trapezoids to use in the approximation; ignored
     * @return The total integral evaluated over the range.
     */
    @Override
    public double integral(double a, double b, int num_trap){
        int terms_length=this.terms.size();
        if (terms_length==0){
            return 0;
        }
        double term_integrals=0;
        for (int i=0; i<terms_length; i++){
            term_integrals+=this.terms.get(i).integral(a, b, num_trap);
        }
        return term_integrals;
    }
}
