public class Mensalista extends Empregado {
    private String cargo;


    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public  void calcularSalario(){
        if(this.cargo.equalsIgnoreCase("junior")){
            this.salario = 2500;
        }else{
            if(this.cargo.equalsIgnoreCase("pleno")){
                this.salario = 3500;
            }else{
                this.salario = 6000;
            }
        }

        
    }
}
