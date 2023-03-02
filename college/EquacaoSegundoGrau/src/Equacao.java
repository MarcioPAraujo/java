public class Equacao {
    private double a;
    private double b;
    private double c;
    private double delta;
    private double x1;
    private double x2;

    public double getA() {
        return this.a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return this.b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return this.c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDelta() {
        return this.delta;
    }


    public double getX1() {
        return this.x1;
    }

    public double getX2() {
        return this.x2;
    }

    public void calculateDelta(){
        this.delta = Math.pow(b, 2) - 4*a*c;
    }

    public void calculateX1(){
        this.x1 = ((-b+Math.sqrt(this.delta))/(2*a));
    }

    public void calculateX2(){
        this.x2 = ((-b-Math.sqrt(this.delta))/(2*a));
    }
    
}
