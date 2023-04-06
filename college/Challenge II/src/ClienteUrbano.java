public class ClienteUrbano extends Cliente {
    @Override
    public double aplicarAliquota(){
        double aliquota;

        if(super.getQuantidadeAguaConsumida()>20){
            aliquota = super.getValorDaConta() * 0.15;
            
        }
        else{

            aliquota = super.getValorDaConta() * 0.03;
        }

        return aliquota;
    }
    @Override
    public void calcularValorConta(){
        super.valorDaConta = (super.getQuantidadeAguaConsumida() + super.getQuantidadeEsgotoProduzida()) * 3.5;
        super.valorDaConta = super.valorDaConta + aplicarAliquota(); 
    }
}
