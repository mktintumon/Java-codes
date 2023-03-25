package Exception_Handling;

// user-defined exception should be part of excepiton class
class EligibilityException extends Exception{
    EligibilityException(String msg){
        System.out.println(msg);
    }
}


public class UserDefinedException {

    static void voting(int age) throws EligibilityException {
        if(age < 18){
            throw new EligibilityException("Age must be above 18");
        }
        else{
            System.out.println("Eligible for voting");
        }
    }

    public static void main(String[] args) {
        try {
            voting(15);
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(e);
        }
    }
}
