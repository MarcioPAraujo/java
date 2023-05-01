public class Cliente {
    protected String nome;
    protected String endereco;
    protected double quantidadeAguaConsumida;
    protected double quantidadeEsgotoProduzida;
    protected double valorDaConta;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getQuantidadeAguaConsumida() {
        return this.quantidadeAguaConsumida;
    }

    public void setQuantidadeAguaConsumida(double quantidadeAguaConsumida) {
        this.quantidadeAguaConsumida = quantidadeAguaConsumida;
    }

    public double getQuantidadeEsgotoProduzida() {
        return this.quantidadeEsgotoProduzida;
    }

    public void setQuantidadeEsgotoProduzida(double quantidadeEsgotoProduzida) {
        this.quantidadeEsgotoProduzida = quantidadeEsgotoProduzida;
    }

    public double getValorDaConta() {
        return this.valorDaConta;
    }

    public double aplicarAliquota(){
        return 0;
    }

    public void calcularValorConta(){

    }
    


}
