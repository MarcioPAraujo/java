import java.util.Scanner;

public class CalculoDeSalaraio {
    public static void main(String[] args) throws Exception {
        Empregado empregado;
        Mensalista mens = new Mensalista();
        Horista hor = new Horista();
        System.out.println("funcionário mensalista");
        mens.setCargo("JUNIOR");
        preencher(empregado = mens);
        
        System.out.println("funcionário horista");
        hor.setHoras(20);
        preencher(empregado = hor);
        
        System.out.println("nome do funcionario horista: "+hor.getNome());
        System.out.println("nome do funcionario mensalista: "+ mens.getNome());
    }
    public static void preencher(Empregado empregado){
        Scanner scan = new Scanner(System.in);
        System.out.println("digite nome");
        empregado.setNome(scan.next());
        System.out.println("digite endereço");
        empregado.setEndereco(scan.next());
        
        empregado.calcularInss();
        empregado.calcularImpostoDeRenda();
        empregado.calcularSalario();
        
    }
}
