import java.util.Scanner;

public class Locacao {
    private Locatario locatario;
    private Quadra quadra;
    private int tempoMinuto;
    private char necessitaEquipamento;
    private Scanner scan = new Scanner(System.in);
    

    public Locatario getLocatario() {
        return this.locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public Quadra getQuadra() {
        return this.quadra;
    }

    public void setQuadra(Quadra quadra) {
        this.quadra = quadra;
    }

    public int getTempoMinuto() {
        return this.tempoMinuto;
    }

    public void setTempoMinuto(int tempoMinuto) {
        this.tempoMinuto = tempoMinuto;
    }

    public char getNecessitaEquipamento() {
        return this.necessitaEquipamento;
    }

    public void setNecessitaEquipamento(char necessitaEquipamento) {
        this.necessitaEquipamento = necessitaEquipamento;
    }

    public double calcularLocacao(){
        double total;

        // verificar se o tempo de aluguel é superior as 120 min
        if(this.tempoMinuto > 120){

            // dar os 10% de desocnto no valor do minuto
            total = this.tempoMinuto * (this.quadra.getValorMinuto()/10);
        }
        else{

            // calculo para tempo de aluguel inferior a 120 min
            total = this.tempoMinuto * this.quadra.getValorMinuto();
        }

        // verifica se é preciso equipamento
        if(this.necessitaEquipamento == 's'){

            //adiciona os 50.00 caso necessite equipamentos
            total+=50;
        }


        return total;
    }

    public void mostrarResumoLocacao(){
        System.out.println("DADOS DO LOCATÁRIO");
        System.out.printf("Nome: %s\n",this.locatario.getNome());
        System.out.printf("CPF: %s\n",this.locatario.getCPF());
        System.out.printf("Telefone: %s\n",this.locatario.getTelefone());
        System.out.printf("Ano de nascimento: %d\n",this.locatario.getAnoNascimento());

        System.out.println("DADOS DA QUADRA");
        System.out.printf("Nome: %s\n",this.quadra.getNome());
        System.out.printf("Tipo: %s\n",this.quadra.getTipo());
        System.out.printf("Valor do minuto: %.2f\n",this.quadra.getValorMinuto());

        System.out.println("DADOS DA LOCAÇÃO");
        System.out.printf("Tempo: %d\n",this.tempoMinuto);
        System.out.printf("Equipamentos: %c\n",this.necessitaEquipamento);
        System.out.printf("Valor do aloguel: %.2f\n",this.calcularLocacao());

    }

    public void cadastrarLocacao(){
        
        Quadra novaQuadra = new Quadra();
        novaQuadra.cadastrarQuadra();
        this.quadra = novaQuadra;

        Locatario novoLocatario = new Locatario();
        novoLocatario.cadastrarLoacatario();
        this.locatario = novoLocatario;

        boolean maiorDeIdade = novoLocatario.verificarMaioridade();
        if(maiorDeIdade == false){
            System.out.println("Você é menor de idade e não pode realizar a locação.");
            System.out.println("Pressione qualquer tecla para sair.");
            scan.next();
            System.exit(0);
        }
        
        System.out.println("quantos minutos deseja alugar a quadra?");
        this.tempoMinuto = scan.nextInt();

        System.out.println("precisas de algum quipamento? (s / n)");
        this.necessitaEquipamento = scan.next().charAt(0);
        
        this.mostrarResumoLocacao();
    }
}
