public class Employee {
    private String name;
    private int age;
    private double salario;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double calcularBonificacao(){
        return this.salario + (this.salario * 0.05);
    }
}
