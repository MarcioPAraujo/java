
public class Person {

    private String name;
    private int age, phone;
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
  public void setPhone(int phoneNumber){
    boolean test = false;
    while(test==false){
        test = phoneValidation(phoneNumber);
    }
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
  private boolean phoneValidation(int phoneNumber){
    
  }
 
}
