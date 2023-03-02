public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Equacao equacao = new Equacao();
        equacao.setA(1);
        equacao.setB(-5);
        equacao.setC(6);

        equacao.calculateDelta();
        equacao.calculateX1();
        equacao.calculateX2();

        System.out.println("x 1: "+equacao.getX1());
        System.out.println("x 2: "+equacao.getX2());
    }
}
