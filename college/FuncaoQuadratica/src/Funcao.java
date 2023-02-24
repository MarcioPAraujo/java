public class Funcao {
    private double a;
    private double b;
    private double c;
    private double xUm;
    private double xDois;
    private double delta;

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

    public double getXUm() {
        return this.xUm;
    }

    

    public double getXDois() {
        return this.xDois;
    }

    

    public double getDelta() {
        return this.delta;
    }

    public void calcularDelta(){
        
        this.delta = Math.pow(getB(),2) - 4* getA() * getC();
        
    }

    public void calcularXUm(){
        this.xUm = (-getB() + Math.sqrt(getDelta())) /2*getA();
        
    }
    public void calcularXDois(){
        this.xDois = (-getB() - Math.sqrt(getDelta())) /2*getA();
        
    }
}
