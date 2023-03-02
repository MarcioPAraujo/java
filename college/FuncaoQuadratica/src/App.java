import java.util.Random;

public class App {
    
    public static void main(String[] args) throws Exception {
        
        Funcao funcao = new Funcao();
        Random random = new Random();
        calculate(funcao,random);
        boolean key = false;
        while(key==false){
            
            key = validateDelta(funcao,random);
            if(key==false){
                calculate(funcao,random);
            }

        }
        
        
        funcao.calcularXUm();
        funcao.calcularXDois();

        System.out.println("o valor de delta: "+ funcao.getDelta());
        System.out.println("o valor de x1: "+ funcao.getXUm());
        System.out.println("o valor de x2: "+ funcao.getXDois());
        
    }
    public static void calculate(Funcao funcao,Random random){
        
        
        funcao.setA(random.nextDouble(100)+1);
        funcao.setB(random.nextDouble(100)+1);
        funcao.setC(random.nextDouble(100)+1);
    }

    public static boolean validateDelta(Funcao funcao,Random random){
        funcao.calcularDelta();
        if(funcao.getDelta()<0){
           return false;
        }
        else{
            return true;
        }
    }
}
