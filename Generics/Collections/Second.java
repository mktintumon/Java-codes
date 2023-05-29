import java.util.*;

class Student {
    String regno;
    int marks;
    int age;

    Student(String regno, int marks, int age) {
        this.regno = regno;
        this.marks = marks;
        this.age = age;
    }
}

class MarksComparator implements Comparator<Student> {
    public int compare(Student o1, Student o2) {
        if (o1.marks == o2.marks)
            return 0;
        else if (o1.marks > o2.marks)
            return 1;
        else
            return -1;
    }
}



class Second {
    public static void main(String args[]) {

        ArrayList<Student> department = new ArrayList<>();
        department.add(new Student("22MCA0101", 84, 23));
        department.add(new Student("22MCA0106", 76, 27));
        department.add(new Student("22MCA0105", 93, 21));

        // Iterate through the arraylist
        System.out.println("Reg No\t\tMarks\tAge");
        Iterator<Student> itr = department.iterator();
        while (itr.hasNext()) {
            Student st = itr.next();
            System.out.println(st.regno + "\t" + st.marks + "\t" + st.age);
        }

        
        System.out.println("\nSorting by marks :");

        Collections.sort(department, new MarksComparator());

        System.out.println("Reg No\t\tMarks\tAge");
        Iterator<Student> itr2 = department.iterator();
        while (itr2.hasNext()) {
            Student st = itr2.next();
            System.out.println(st.regno + "\t" + st.marks + "\t" + st.age);
        }
    }
}
