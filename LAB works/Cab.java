//package LAB works;

public class Cab {
    private String regNo;
    private String name;
    private Double rate;
    private Double distance;

    public Cab(String name, String regNo, Double rate, Double distance) {
        this.name = name;
        this.regNo = regNo;
        this.rate = rate;
        this.distance = distance;
    }

    public String getRegNo(String regNo) {
        return regNo;
    }

    void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName(String name) {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Double getRate(Double rate) {
        return rate;
    }

    void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getDistance(Double distance) {
        return distance;
    }

    void setDistance(Double distance) {
        this.distance = distance;
    }

    public double computeIncome(){
        return distance * rate;
    }

    public static void main(String[] args) {
        Cab cab = new Cab("Mohit","22MCBC", 0.6,223.0);
        
    }
}
