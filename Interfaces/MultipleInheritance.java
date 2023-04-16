
interface printable{
    void print();
}

interface showable{
    void show();
}

public class MultipleInheritance implements printable,showable{
    public void print(){
        System.out.println("Printing....");
    }

    public void show(){
        System.out.println("Displaying....");
    }

    public static void main(String[] args) {
        MultipleInheritance mh = new MultipleInheritance();
        mh.print();
        mh.show();
    }
}
