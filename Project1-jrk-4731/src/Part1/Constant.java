package Part1;

public class Constant extends Function{

    private double value;

    public Constant(double value){
        this.value=value;
    }

    public double evaluate(double to_eval){
        return this.value;
    }

    @Override
    public String toString(){
        return String.valueOf(this.value);
    }

    public Function derivative(){
        return new Constant(0);
    }

    public boolean isConstant(){
        return true;
    }
}
