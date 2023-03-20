
import java.util.Scanner;
public class Quadra {
    private String nome;
    private String tipo;
    private double valorMinuto;
    private Scanner scan = new Scanner(System.in);
    

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValorMinuto() {
        return this.valorMinuto;
    }

    public void setValorMinuto(double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    public void cadastrarQuadra() {
        
        System.out.println("Digite o nome da quadra que deseja alugar");
        this.nome = scan.nextLine();

        System.out.println("Digite o tipo da quadra a ser alugada");
        this.tipo = scan.nextLine();

        System.out.println("Digite o valor do minuto de uso da quadra");
        this.valorMinuto = scan.nextDouble();
    }

}
