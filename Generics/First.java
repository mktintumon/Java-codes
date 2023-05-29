class Product<T,S>{
    private T id;
    private S price;

    Product(T id , S price){
        this.id = id;
        this.price = price;
    }

    public T getName() {
        return this.id;
    }

    public void setName(T id) {
        this.id = id;
    }

    public S getPrice() {
        return this.price;
    }

    public void setPrice(S price) {
        this.price = price;
    }

    public void display(){
        System.out.println("Product Name : "+ id);
        System.out.println("Product Price : "+ price);
        System.out.println();
    }
    
}

public class First {
    public static void main(String[] args) {
        Product<String , Integer> p1 = new Product<>("AP#3",200);
        p1.display();

        Product<Integer , Double> p2 = new Product<>(2043, 394.50);
        p2.display();

        Product<Character , String> p3 = new Product<>('D', "Free");
        p3.display();
    }
}
