package Part1;

public abstract class Function {


    public Function(){

    }

    public abstract double evaluate(double to_eval);

    @Override
    public String toString(){
        return "";
    }

    public Function derivative(Function to_derive){
        return null;
    }

    public boolean isConstant(){
        return false;
    }
}
