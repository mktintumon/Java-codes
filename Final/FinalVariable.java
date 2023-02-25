package Final;

public class FinalVariable {
    final int speed = 100;

    void changeSpeed(){
        // speed = 400; -----> throws compilation error
        //              -----> cannot assign a value to final variable 
    }

    public static void main(String[] args) {
        FinalVariable fv = new FinalVariable();
        fv.changeSpeed();
    }
}
