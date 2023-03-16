public class Contributor {
    private String name;
    private String cpf;
    private int age;
    private String email;
    private double wage=0;
    private double incomeTax;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        boolean validation = false;
        validation = validateAge(age);
        if(validation==false){
            System.out.println("age is invalid");
        }
        else{
            this.age = age;
        }
    }   
    private boolean validateAge(int yearsOld){
        if(yearsOld<0){
            return false;
        }
        if(yearsOld>130){
            return false;
        }
        else{
            return true;
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getWage() {
        return this.wage;
    }

    public void setWage(double wage) {
        boolean validation = false;
        validation = validateWage(wage);
        if(validation==false){
            System.out.println("wage is invalid value");
        }else{
        
            this.wage = wage;
        }

    }
    private boolean validateWage(double salary){
        if(salary<0){
            return false;
        }
        else{
            return true;
        }
    }

    public double getIncomeTax(){
        return this.incomeTax;
    }

    public void calculateIncomTax(){
        if(this.wage<=900){
            this.incomeTax=0;
        }
        if(this.wage>1800){
            this.incomeTax = (this.wage*0.15);
        }
        else{
            this.incomeTax = (this.wage*0.1);
        }
    }
}