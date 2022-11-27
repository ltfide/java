public class ManagerApp {
    public static void main(String[] args) {

        Manager manager = new Manager("Lutfi");
        manager.sayHello("Lisa");

        Manager VP = new VicePresident("Lisa");
        VP.sayHello("Lutfi");
    }
}
