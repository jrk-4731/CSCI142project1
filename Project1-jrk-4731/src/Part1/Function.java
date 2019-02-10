package Part1;

public abstract class Function {


    public Function(){

    }

    public abstract double evaluate(double to_eval);

    @Override
    public String toString(){
        return "";
    }

    public abstract Function derivative();

    public boolean isConstant(){
        return false;
    }
}
