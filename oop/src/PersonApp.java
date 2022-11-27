public class PersonApp {
    public static void main(String[] args) {

        var person1 = new Person("Lutfi", "Sukabumi");
//        person1.name = "Lutfi";
//        person1.address = "Sukabumi";

        System.out.println(person1.name);
        System.out.println(person1.address);
        System.out.println(person1.country);

        person1.sayHello("Lisa");

//        Person person2 = new Person();
//        Person person3;
//        person3 = new Person();
    }

}
