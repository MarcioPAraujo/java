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
         return 0;
    }

    public void mostrarResumoLocacao(){

    }

    public void cadastrarLocacao(){
        
        System.out.println("");

    }
}
