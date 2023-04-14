package Abstract;

// Abstract class can have abstract and non-abstract methods

// An abstract class can have a data member, abstract method, 
// method body (non-abstract method), constructor, and even main() method.

abstract class Animal{
    int id;
    abstract void naming();
}

class Dog extends Animal{
    // providing body to abstract methods
    void naming() {
        System.out.println("All animals in this category");
    }
}

public class Example{
    public static void main(String[] args) {
        Animal ex = new Dog();
        ex.id = 10;
        ex.naming();
        System.out.println(ex.id);
    }
}
