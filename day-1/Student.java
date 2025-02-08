
class Student {
    private String name;  
    private int rollNumber;
    private double marks;
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }
}
abstract class Classroom {
    public abstract void details();
}
class Science extends Classroom {
    private String teacher;

    public Science(String teacher) {
        this.teacher = teacher;
    }
    @Override
    public void details() {
        System.out.println("This is a Science Classroom. Teacher: " + teacher);
    }
}
class Maths extends Classroom {
    private String teacher;
    public Maths(String teacherNameteacher) {
        this.teacher = teacher;
    }
    @Override
    public void details() {
        System.out.println("This is a Math Classroom. Teacher: " + teacher);
    }
}
public class Oops {
    public static void main(String[] args) {
        Student s1 = new Student("Bharath", 1, 85.5);
        System.out.println("Student Name: " + s1.getName());
        System.out.println("Roll Number: " + s1.getRollNumber());
        System.out.println("Old Marks: " + s1.getMarks());
        s1.setMarks(90);
        System.out.println("New Marks: " + s1.getMarks());
        Classroom science = new Science("Ramesh");
        Classroom math = new Maths("Suresh");
        science.details(); 
        math.details();   
    }
}
