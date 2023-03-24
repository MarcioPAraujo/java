import java.util.Scanner;

public class ImpostoDeRenda {
    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
            
        boolean escolha = false;
        byte opcao=0;
        while(escolha==false){
            System.out.println("Prossiga como:");
            System.out.println("1 - Pessoa Fisíca");
            System.out.println("2 - Pessoa Juridica");

            opcao = ler.nextByte();
            if(opcao==1){
                escolha = true;
            }else{
                if(opcao==2){
                    escolha = true;
                }else{
                    System.out.println("digite algo válido");
                }
            }
        }
        if(opcao==1){
            PessoaFisica pf = new PessoaFisica();

            System.out.println("digite seu nome");
            pf.setNome(ler.next());

            System.out.println("digite seu cpf");
            pf.setCpf(ler.next());

            System.out.println("informe o rendimento bruto anual");
            pf.setRendaBrutaAnual(ler.nextDouble());

            System.out.println("informe os gastos com educação");
            pf.setGastosComEducacao(ler.nextDouble());

            System.out.println("informe os gastos com saúde");
            pf.setGastosComSaude(ler.nextDouble());

            pf.CalcularRendaLiquida(pf.getGastosComEducacao(),pf.getGastosComSaude());
            System.out.println("sua renda liquida: "+pf.getRendaLiquidaAnual());
            System.out.println("seu imposto de renda: "+pf.calcularImpostoDeRenda()); 

        }else{
            PessoaJuridica pj = new PessoaJuridica();

            System.out.println("digite seu nome");
            pj.setNome(ler.next());

            System.out.println("digite seu cnpj");
            pj.setCnpj(ler.next());

            System.out.println("informe o rendimento bruto anual");
            pj.setRendaBrutaAnual(ler.nextDouble());

            System.out.println("informe os gastos pessoais");
            pj.setGastosPessoais(ler.nextDouble());

            System.out.println("informe os gastos com equipamentos");
            pj.setGastosComEquipamentos(ler.nextDouble());

            pj.CalcularRendaLiquida(pj.getGastosComEquipamentos(), pj.getGastosPessoais());
            System.out.println("sua renda liquida anual: "+pj.getRendaLiquidaAnual());

            System.out.println("seu imposto de renda: "+pj.calcularImpostoDeRenda());
        }


        
    }
}
