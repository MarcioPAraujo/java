
public class Person {

    private String name;
    private int age;
    private long phone;
    private double weight, height;
    
  public Person(){

  }

  public void setName(String name){
    this.name = name;
  }
  public String getName(){
    return this.name;
  }



  public void setAge(int value){
    boolean test=false;
    while(test == false){
        test = ageValidation(value);
         
    }
    this.age = value;
  }
  public int getAge(){
    return this.age;
  }



  public void setPhone(long phoneNumber){
    boolean test = false;
    while(test==false){
        test = phoneValidation(phoneNumber);
    }
    this.phone =phoneNumber;
  }
  public long getPhone(){
    return this.phone;
  }



  public void setWeight(double weight){
    boolean verification = false;
    while(verification == false){
      verification = weightValidation(weight);
    }
    this.weight=weight;
  }
  public double getWeight(){
    return this.weight;
  }



  public void setHeight(double height){
    this.height=height;
  }
  public double getHeight(){
    return this.height;
  }




  private boolean ageValidation(int age ){
    
    if(age < 0){
        return false;
    }
    if(age > 120){
        return false;
    }
    else{
        return true;
    }
  }
  private boolean phoneValidation(long phoneNumber){
    if(phoneNumber>99999999999l){
      return false;
    }
    else{
    return true;
    }
  }
  private boolean weightValidation(double weight){
    if(weight<1.00){
      return false;
    }
    if(weight>350.00){
      return false;
    }
    else{
      return true;
    }
  }
 
}
