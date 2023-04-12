import java.util.Random;

class Grade extends Thread{
    protected String name;
    private int marks1 , marks2;
    private char grade;
    private double gpa;

    public Grade(String name,int marks1,int marks2){
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
    }

    public void run(){
        int totalMarks = marks1 + marks2;
        if(totalMarks >= 80){
            grade = 'A';
            gpa = 10.0;
        }
        else if(totalMarks >= 60){
            grade = 'B';
            gpa = 8.0;
        }
        else{
            grade = 'C';
            gpa = 0.0;
        }
    }

    public char getGrade(){
        return grade;
    }

    public double getGpa(){
        return gpa;
    }
}

class Display extends Thread{
    private Grade gdThread;

    public Display(Grade gdThread){
        this.gdThread = gdThread;
    }

    public void run(){
        System.out.println("Name: " + gdThread.name);
        System.out.println("Grade: " + gdThread.getGrade());
        System.out.println("GPA: " + gdThread.getGpa());
    }
}

public class GradingSystem{
    public static void main(String[] args) throws InterruptedException {
        Random rand = new Random();

        for(int i=1 ; i<=5 ; i++){
            int m1 = rand.nextInt(101);
            int m2 = rand.nextInt(101);

            Grade g = new Grade("Student "+i ,m1 , m2);
            Thread t1 = new Thread(g);
            Thread t2 = new Thread(new Display(g));
            t1.start();
            t1.join();
            t2.start();
        }
    }
}