class Wood{
    //something
}

class Metal{
    //something
}

class Plastic{
    //something
}

public class Furniture<Material> {
    private Material m;

    public Furniture(Material m) {
        this.m = m;
    }

    public double calculatePrice() {
        if (m instanceof Wood) {
            return 100.0;
        } else if (m instanceof Metal) {
            return 150.0;
        } else if (m instanceof Plastic) {
            return 80.0;
        } else {
            return 50.0;
        }
    }

    public static void main(String[] args) {
        Furniture<Wood> w = new Furniture<>(new Wood());
        double woodPrice = w.calculatePrice();
        System.out.println("Wooden price: $" + woodPrice);

        Furniture<Metal> m = new Furniture<>(new Metal());
        double metalPrice = m.calculatePrice();
        System.out.println("Metal price: $" + metalPrice);

        Furniture<Plastic> p = new Furniture<>(new Plastic());
        double plasticPrice = p.calculatePrice();
        System.out.println("Plastic price: $" + plasticPrice);

        Furniture<String> unknown = new Furniture<>("Unknown Material");
        double unknownPrice = unknown.calculatePrice();
        System.out.println("Unknown price: $" + unknownPrice);
    }
}
