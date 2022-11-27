class Manager extends  Employee {

    Manager(String name) {
        super(name);
    }

    void sayHello(String name) {
        System.out.println("Hello " + name + ", My name is Manager " + this.name);
    }

}
