public class Horista extends Empregado{
    public int horas; 


    public int getHoras() {
        return this.horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }


    @Override
    public void calcularSalario(){
        this.salario = this.horas * 50;
    }
}
