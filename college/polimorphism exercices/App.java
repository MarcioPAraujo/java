import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Employee employee;
        boolean choose = true;
        while (choose) {
            System.out.println("please choose your position:\n1 - employee\n2 -manager\n3 -directo\n");
            int option = scan.nextInt();
            employee = create(option);
            boolean invalidOption = employee == null;
            if (invalidOption) {
                continue;
            }

            employee = register(employee,scan);

            System.out.println("your whatever is called:" + employee.calcularBonificacao());

            System.out.println("add one more? 1 - yes 2 - no");
            option = scan.nextInt();

            choose = (option == 1) ? true : false;
            
        }

    }
    public static Employee create(int option){
        Employee employee;
        switch (option) {
            case 1:
                employee = new Employee();
                break;
            case 2:
                employee = new Manager();
                break;
            case 3:
                employee = new Director();
                break;
            default:
                return null;
                
        }
        return employee;
    }

    public static Employee register(Employee employee,Scanner scan){
         System.out.println("type your name:");
         employee.setName(scan.next());
         System.out.println("type your age:");
         employee.setAge(scan.nextInt());
         System.out.println("type your wage:");
         employee.setSalario(scan.nextDouble());
        return employee;
    }

    
}