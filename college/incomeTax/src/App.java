public class App {
    public static void main(String[] args) throws Exception {
        Contributor contributor = new Contributor();

        contributor.setName("Flaer");
        contributor.setAge(23);
        contributor.setEmail("exampleemail@test.com");
        contributor.setCpf("12345678901");
        contributor.setWage(3000);
        contributor.calculateIncomTax();
        System.out.println("tax:"+contributor.getIncomeTax());
        System.out.println("age: "+contributor.getAge());
    }
}
