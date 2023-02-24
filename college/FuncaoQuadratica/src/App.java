import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        
        Funcao funcao = new Funcao();
        Random random = new Random();
        funcao.setA(random.nextDouble(100)+1);
        funcao.setB(random.nextDouble(100)+1);
        funcao.setC(random.nextDouble(100)+1);

        funcao.calcularDelta();
        
        funcao.calcularXUm();
        funcao.calcularXDois();

        System.out.println("o valor de delta: "+ funcao.getDelta());
        System.out.println("o valor de x1: "+ funcao.getXUm());
        System.out.println("o valor de x2: "+ funcao.getXDois());
    }
}
