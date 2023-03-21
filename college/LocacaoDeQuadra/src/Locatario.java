import java.util.Calendar;
import java.util.Scanner;

public class Locatario {
    private String nome;
    private String CPF;
    private int anoNascimento;
    private String telefone;
    private Calendar data = Calendar.getInstance();
    private Scanner scan = new Scanner(System.in);
     

    public Locatario(){
        
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public boolean verificarMaioridade(){

        int anoAtual = data.get(Calendar.YEAR);
        // retorna verdadeiro se for maior de idade e falso se for menor de idade;
        if((anoAtual - this.anoNascimento)<18){
            return false;
        }
        else{
            return true;
        }

    }

    public void cadastrarLoacatario(){
        // Leitura do nome do locatário
        System.out.println("Digite o nome do locatário");
        this.nome = scan.nextLine();

        // Leitura do cpf do locatário
        System.out.println(this.nome+" digite seu cpf: ");
        this.CPF = scan.nextLine();

        // Leitura do ano de nascimento do locatário
        System.out.println("digite sua data de nascimento:");
        System.out.print("ano:");
        this.anoNascimento = scan.nextInt();

        // Leitura do telefone
        System.out.println("digite o seu telefone:");
        this.telefone = scan.next();


    }
}
