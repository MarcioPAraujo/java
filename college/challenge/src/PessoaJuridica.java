public class PessoaJuridica extends Contribuinte {
    private String cnpj;
    private double gastosPessoais;
    private double gastosComEquipamentos;


    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getGastosPessoais() {
        return this.gastosPessoais;
    }

    public void setGastosPessoais(double gastosPessoais) {
        this.gastosPessoais = gastosPessoais;
    }

    public double getGastosComEquipamentos() {
        return this.gastosComEquipamentos;
    }

    public void setGastosComEquipamentos(double gastosComEquipamentos) {
        this.gastosComEquipamentos = gastosComEquipamentos;
    }


    public double calcularImpostoDeRenda(){
        double impostoDeRenda=0;
        double aliquota,parcelaDeduzir;

        
        if(super.rendaLiquidaAnual>200000){
            aliquota = 0.3;
            parcelaDeduzir = 45000;
        }else{
            if(super.rendaLiquidaAnual<=100000){
                aliquota = 0.05;
                parcelaDeduzir=0;
            }else{
                aliquota=0.1;
                parcelaDeduzir=5000;
            }
        }

        impostoDeRenda = super.rendaLiquidaAnual*aliquota-parcelaDeduzir;
        
        return impostoDeRenda;
    }
}
