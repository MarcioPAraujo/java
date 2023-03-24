public class PessoaFisica extends Contribuinte{
    private String cpf;
    private double gastosComSaude;
    private double gastosComEducacao;

    

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getGastosComSaude() {
        return this.gastosComSaude;
    }

    public void setGastosComSaude(double gastosComSaude) {
        this.gastosComSaude = gastosComSaude;
    }

    public double getGastosComEducacao() {
        return this.gastosComEducacao;
    }

    public void setGastosComEducacao(double gastosComEducacao) {
        this.gastosComEducacao = gastosComEducacao;
    }

    public double calcularImpostoDeRenda(){
        double impostoDeRenda=0;
        double aliquota,parcelaDeduzir;


        if(super.rendaLiquidaAnual>20000){
            aliquota = 0.25;
            parcelaDeduzir = 4000;
        }else{
            if(super.rendaLiquidaAnual<=10000){
                aliquota = 0;
                parcelaDeduzir=0;
            }else{
                aliquota=0.1;
                parcelaDeduzir=1000;
            }
        }

        impostoDeRenda = super.rendaLiquidaAnual*aliquota-parcelaDeduzir;
        
        return impostoDeRenda;
    }
}
