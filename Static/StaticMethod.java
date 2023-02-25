public class StaticMethod {
    int regNo;
    String name;
    static String clgName = "VIT"; 

    public StaticMethod(int regNo, String name){
        this.regNo = regNo;
        this.name = name;
    }

    // static method
    static void changeClg(){
        clgName = "IIT";
    }

    void display(){
        System.out.println(regNo + ": " + name + " -> " + clgName);
    }

    public static void main(String[] args) {
        StaticMethod.changeClg();

        StaticMethod st1 = new StaticMethod(111,"Mohit");
        StaticMethod st2 = new StaticMethod(222,"Govind");
        
        st1.display();
        st2.display();
    }
}
