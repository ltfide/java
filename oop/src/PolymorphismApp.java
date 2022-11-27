public class PolymorphismApp {
    public static void main(String[] args) {

        Employee employee = new Employee("Jack");
        employee.sayHello("Sam");

        Manager manager = new Manager("Lutfi");
        manager.sayHello("Lisa");

        VicePresident vicePresident = new VicePresident("Lisa");
        vicePresident.sayHello("Lutfi");

        sayHello(new Employee("Jack"));
        sayHello(new Manager("Lutfi"));
        sayHello(new VicePresident("Lisa"));
    }

    static void sayHello(Employee employee) {
        if (employee instanceof VicePresident) {
            VicePresident vicePresident = (VicePresident) employee;
            System.out.println("Hello VP " + vicePresident.name);
        } else if (employee instanceof  VicePresident) {
            Manager manager = (Manager) employee;
            System.out.println("Hello Manager " + manager.name);
        } else {
            System.out.println("Hello " + employee.name);
        }
    }
}
