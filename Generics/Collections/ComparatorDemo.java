import java.util.*;

class Student {
    String regno;
    String name;
    int age;

    Student(String regno, String name, int age) {
        this.regno = regno;
        this.name = name;
        this.age = age;
    }
}

class AgeComparator implements Comparator<Student> {

    public int compare(Student o1, Student o2) {

        if (o1.age == o2.age)
            return 0;
        else if (o1.age > o2.age)
            return 1;
        else
            return -1;
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class ComparatorDemo {
    public static void main(String args[]) {

        ArrayList<Student> al = new ArrayList<>();
        al.add(new Student("22CCA0101", "Vijay", 23));
        al.add(new Student("22CCA0106", "Ajay", 27));
        al.add(new Student("22CCA0105", "Jai", 21));

        System.out.println("Sorting by Name");

        Collections.sort(al, new NameComparator());

        Iterator<Student> itr = al.iterator();
        while (itr.hasNext()) {
            Student st = itr.next();
            System.out.println(st.regno + " " + st.name + " " + st.age);
        }

        
        System.out.println("Sorting by age");

        Collections.sort(al, new AgeComparator());

        Iterator<Student> itr2 = al.iterator();
        while (itr2.hasNext()) {
            Student st = itr2.next();
            System.out.println(st.regno + " " + st.name + " " + st.age);
        }
    }
}
