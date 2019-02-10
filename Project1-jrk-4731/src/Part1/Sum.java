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
        double add_vars=0;
        double add_consts=0;
        for (int i=0; i<this.terms.length; i++){
            Function term=this.terms[i];
            if (term.isConstant()){
                add_consts+=term.evaluate(0);
            }
            else{
                add_vars+=1;
            }
        }
        if(add_consts==0 && add_vars==0){
            return function+ "0 )";
        }
        else if(add_consts==0 && add_vars!=0){
            return function+add_vars+"x )";
        }
        else if(add_consts!=0 && add_vars==0){
            return function+add_consts+" )";
        }
        else{
            return function+add_vars+"x + "+add_consts+" )";
        }
    }

    @Override
    public Function derivative(){
        if (this.terms.length==0){
            return null;
        }
        Function[] derivative_terms=new Function[this.terms.length];
        for (int i=0; i<this.terms.length; i++){
            Function term_derivative=this.terms[i].derivative();
            derivative_terms[i]=term_derivative;
        }
        return new Sum(derivative_terms);
    }

    @Override
    public boolean isConstant(){
        if (this.terms.length==0){
            return false;
        }
        for (int i=0; i<this.terms.length; i++){
            if (!this.terms[i].isConstant()){
                return false;
            }
        }
        return true;
    }
}
