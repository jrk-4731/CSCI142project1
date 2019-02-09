package Part1;

public class Sum extends Function{

    private Function[] terms;

    public Sum(Function... terms){
        this.terms=terms;
    }

    public double evaluate(double to_eval){
        double total=0;
        for (int i=0; i<this.terms.length; i++){
            total+=this.terms[i].evaluate(to_eval);
        }
        return total;
    }

    @Override
    public String toString(){
        String function="( ";
        for (int i=0; i<this.terms.length; i++){
            String str_term=this.terms[i].toString();
            function+=str_term+" ";
        }
        return function+")";
    }

    @Override
    public Function derivative(Function to_derive){
        Function[] derivative_terms=new Function[this.terms.length];
        for (int i=0; i<this.terms.length; i++){
            Function term_derivative=this.terms[i].derivative(to_derive);
            derivative_terms[i]=term_derivative;
        }
        return new Sum(derivative_terms);
    }

    @Override
    public boolean isConstant(){
        for (int i=0; i<this.terms.length; i++){
            if (!this.terms[i].isConstant()){
                return false;
            }
        }
        return true;
    }
}
