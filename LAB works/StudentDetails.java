
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;

class Student {
    private String regNo;
    private String name;
    private LocalDate DOB;
    private String[] courses;

    // first constructor
    public Student(String regNo, String name, LocalDate DOB, String[] courses) {
        this.regNo = regNo;
        this.name = name;
        this.DOB = DOB;
        this.courses = courses;
    }

    // calling first constructor having 4 elements
    public Student(String regNo, String name, LocalDate DOB) {
        this(regNo, name, DOB, null);
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

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        return Period.between(DOB, today).getYears();
    }
}

public class StudentDetails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Array of object
        Student[] std = new Student[3];

        // getting input
        for (int i = 0 ; i < 3 ; i++) {
            System.out.println("Enter details for Student " + (i+1) + ":");
            System.out.print("Reg no : ");
            String regNo = br.readLine();
            System.out.print("Name : ");
            String name = br.readLine();
            System.out.print("DOB (YYYY-MM-DD) : ");
            String birthDate = br.readLine();
            LocalDate dob = LocalDate.parse(birthDate);

            // storing courses in list
            String[] courses = new String[3];
            System.out.println("Enter courses [Enter 'null' if no course taken] : ");
            for (int s = 1 ; s <= 3; s++) {
                System.out.print("Course " + s + ": ");
                String course = br.readLine();
                if (course.equals("null") == false) {
                    courses[s-1] = course;
                }
            }

            System.out.println();

            // creating object of each student
            std[i] = new Student(regNo, name, dob, courses);
        }


        // tabular reresentation
        System.out.println("\nReg No.\t\tName\t\tAge");
        for (Student st : std) {
            System.out.println(st.getRegNo() + "\t\t" + st.getName() + "\t\t" + st.getAge());
        }
    }
}
