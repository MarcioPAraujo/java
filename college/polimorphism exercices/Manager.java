public class Manager extends Employee {
 
    private String sector;

    public String getSector() {
        return this.sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public double calcularBonificacao(){
        return this.getSalario() + (this.getSalario() * 0.1);
    }
}
