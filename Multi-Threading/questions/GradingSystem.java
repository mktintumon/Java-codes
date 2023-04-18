
class Student {
    String name;
    int marks1, marks2;
    char grade;
    double gpa;
    
    public Student(String name, int marks1, int marks2) {
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
    }
}

class GradeThread extends Thread {
    Student student;
    
    public GradeThread(Student student) {
        this.student = student;
    }
    
    public void run() {
        int totalMarks = student.marks1 + student.marks2;
        if (totalMarks >= 80) {
            student.grade = 'A';
            student.gpa = 10.0;
        } else if (totalMarks >= 60) {
            student.grade = 'B';
            student.gpa = 8.0;
        } else {
            student.grade = 'F';
            student.gpa = 0.0;
        }
        System.out.println(student.name + " GPA : " + student.gpa);
    }
}

class DisplayThread extends Thread {
    Student student;
    
    public DisplayThread(Student student) {
        this.student = student;
    }
    
    public void run() {
        try {
            // Wait for the GradeThread to finish processing
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(student.name + " Grade : " + student.grade);
    }
}

public class GradingSystem {
    public static void main(String[] args) {
        Student[] students = {
            new Student("Mohit", 75, 85),
            new Student("Sanket", 20, 50),
            new Student("Abishek", 55, 15),
            new Student("Govind", 80, 60),
            new Student("Sobhik", 20, 15)
        };
        
        for (int i = 0; i < students.length; i++) {
            GradeThread gradeThread = new GradeThread(students[i]);
            DisplayThread displayThread = new DisplayThread(students[i]);
            gradeThread.start();
            displayThread.start();
            try {
                gradeThread.join();
                displayThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
