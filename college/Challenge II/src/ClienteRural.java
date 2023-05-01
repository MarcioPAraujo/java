public class ClienteRural extends Cliente{
    @Override
    public double aplicarAliquota(){
        double aliquota;

        if(super.getQuantidadeEsgotoProduzida()>200){
            aliquota = super.getValorDaConta() * 0.05;
        }else{
            aliquota = super.getValorDaConta() * 0.1;
        }

        return aliquota;
    }
    @Override
    public void calcularValorConta(){
        super.valorDaConta = (super.getQuantidadeAguaConsumida() + getQuantidadeEsgotoProduzida()) * 2.5;
        super.valorDaConta = super.valorDaConta - aplicarAliquota();
    }
}
