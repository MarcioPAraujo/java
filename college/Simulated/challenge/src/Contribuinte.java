public class Contribuinte {
    private String nome;
    protected double rendaBrutaAnual ;
    protected double rendaLiquidaAnual;


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRendaBrutaAnual() {
        return this.rendaBrutaAnual;
    }

    public void setRendaBrutaAnual(double rendaBrutaAnual) {
        this.rendaBrutaAnual = rendaBrutaAnual;
    }

    public double getRendaLiquidaAnual(){
        return this.rendaLiquidaAnual;
    }


    public double CalcularRendaLiquida(double abatimento1,double abatimento2 ){
        double renda = 0;
        
        renda = this.rendaBrutaAnual - (abatimento1 + abatimento2);
        this.rendaLiquidaAnual= renda;
        
        return renda;
    }

}

