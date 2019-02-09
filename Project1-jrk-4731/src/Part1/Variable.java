package Part1;

public class Variable extends Function{

    public static final Variable X=new Variable();


    private Variable(){

    }

    @Override
    public double evaluate(double to_eval){
        return to_eval;
    }

    @Override
    public String toString(){
        return "x";
    }

    @Override
    public Function derivative(Function to_derive){
        return new Constant(1);
    }

    @Override
    public boolean isConstant(){
        return false;
    }
}
