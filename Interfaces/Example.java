package Interfaces;

interface naming{
    // By default public , final and static
    void name();
}

public class Example implements naming {
    // should be declared public 
    public void name() {
        System.out.println("Helloo ! My name is Mr X.");
    }

    public static void main(String[] args) {
        Example ex = new Example();
        ex.name();
    }
}
