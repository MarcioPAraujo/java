public class Director extends Employee {
    public String unity;

    public String getUnity() {
        return this.unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    @Override
    public double calcularBonificacao(){
        return this.getSalario() + (this.getSalario() * 0.15);
    }
}
