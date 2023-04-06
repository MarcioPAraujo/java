
import java.util.Scanner;



public class Challenge_II {
    public static void main(String[] args){
        //System.out.println("Hello, World!");
        Cliente cliente;

        ClienteRural rural = new ClienteRural();
        ClienteUrbano urbano = new ClienteUrbano();
        Scanner scan = new Scanner(System.in);

        System.out.println("onde você mora:\n1 - Rural\n2 - Urbano");

        
            int aux = scan.nextInt();
       
        

        if(aux == 1){
            cliente = rural;
            preencherDados(cliente,scan);
        }
        else{
            cliente = urbano;
            preencherDados(cliente,scan);
        }
        mostrarInformacoes(cliente);
    }

    public static void preencherDados(Cliente cliente, Scanner scan){
        System.out.println("Digite seu nome:");
        cliente.setNome(scan.next());

        System.out.println("Digite seu endereço:");
        cliente.setEndereco(scan.next());

        System.out.println("Digite a quantidade de água consumida:");
        cliente.setQuantidadeAguaConsumida(scan.nextDouble());

        System.out.println("Digite a quantidade de esgoto produzida:");
        cliente.setQuantidadeEsgotoProduzida(scan.nextDouble());

        cliente.calcularValorConta();
        
        
    }
    public static void mostrarInformacoes(Cliente cliente){
        System.out.println("nome: "+cliente.getNome());
        System.out.println("endereço: "+cliente.getEndereco());
        System.out.println("quantidade de água consumida: "+cliente.getQuantidadeAguaConsumida());
        System.out.println("quantiddade de esgoto produzida: "+cliente.getQuantidadeEsgotoProduzida());
        System.out.println("total da conta: "+cliente.getValorDaConta());
    }
}
