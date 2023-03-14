
abstract class Workers{
    private String name;
    private String address;
    
    Workers(String name , String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    abstract double earning();
}

class PieceWorker extends Workers{
    private double wage;
    private int piece;

    public PieceWorker(double wage, int piece, String name, String address) {
        super(name, address);
        this.wage = wage;
        this.piece = piece;
    }
    
    double earning(){
        return wage*piece;
    }

    @Override
    public String toString() {
        return "PieceWorker{" + "wage=" + wage + ", piece=" + piece + '}';
    }
    
    
}
public class Worker {
    public static void main(String[] args) {
        PieceWorker pw = new PieceWorker(550.5 , 20 ,"Mohit","Patna");
        System.out.println(pw.toString());
        System.out.println("Total earning :" + pw.earning());
    }
}


