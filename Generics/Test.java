// User defined generic
class Demo<T>{
    T obj;

    Demo(T obj){
        this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }
}

// Multiple type generic
class Demo2<T,S>{
    T obj;
    S obj2;

    Demo2(T obj,S obj2){
        this.obj = obj;
        this.obj2 = obj2;
    }

    public void print(){
        System.out.print(obj + " ");
        System.out.println(obj2);
    }
}

// Generic method
class Gen_Method{
    <T> void display(T obj){
        System.out.println(obj);
    }
}


public class Test{
    public static void main(String[] args) {
        Demo<Integer> d = new Demo<>(15);
        System.out.println(d.getObj());

        Demo2<Integer , String> d2 = new Demo2<>(20,"Mohit");
        d2.print();

        Gen_Method gm = new Gen_Method();
        gm.display(50);
        gm.display("mktintumon");
    }
}