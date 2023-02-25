/*
  // without the static variable
    public class Student{
        int regNo;
        String name;
        String clgName = "VIT";  // common to all students
    }
*/

public class UseOfStatic {
        int regNo;
        String name;
        static String clgName = "VIT"; // make it static

        public UseOfStatic(int regNo, String name){
            this.regNo = regNo;
            this.name = name;
        }

        void display(){
            System.out.println(regNo + ": " + name + " -> " + clgName);
        }

    public static void main(String[] args) {
        UseOfStatic st1 = new UseOfStatic(111,"Mohit");
        UseOfStatic st2 = new UseOfStatic(222,"Govind");
        
        st1.display();
        st2.display();
    }
}


