
class CabDetails {
    private String regNo;
    private String name;
    private double rate;
    private double distance;

    public CabDetails(String regNo, String name, double rate, double distance) {
        this.regNo = regNo;
        this.name = name;
        this.rate = rate;
        this.distance = distance;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    
    public double computeIncome(){
        return rate * distance;
    }

    @Override
    public String toString() {
        return "Mohit{" + "regNo = " + regNo + ", name = " + name + ", Income = " + computeIncome() + '}';
    }

}

public class Cab{
    public static void main(String[] args) throws Exception {
        CabDetails[] ob = new CabDetails[3];
       ob[0] = new CabDetails("22MCA0208","avrodip",20,100);
       ob[1] = new CabDetails("22MCA2010" , "Abhilash" , 30 ,-20);
       ob[2] = new CabDetails("22MCA0212","shashank",80,100);
       
       System.out.println(ob[0].toString());
       System.out.println(ob[1].toString());
       System.out.println(ob[2].toString());
    }
}

