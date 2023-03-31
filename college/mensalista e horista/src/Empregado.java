public class Empregado {
    protected String nome;
    protected String endereco;
    protected double salario;


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

    public double getSalario() {
        return this.salario;
    }

    public double calcularInss(){
        double inss=0;

        inss = this.salario * 0.11;

        return inss;
    }


    public double calcularImpostoDeRenda(){
        double imposto=0;

        if(this.salario<1800){
            imposto = 0.15;
        }else{
            imposto = 0.27;
        }

        return imposto;
    }


    public  void calcularSalario(){

    }
}
