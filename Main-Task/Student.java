package Assignment;
public class Student extends Admin {
    private int rollNumber;
    private float marks;
    public Student(String name, int rollNumber, float marks) {
        super(name);
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public float getMarks() {
        return marks;
    }
    public void setMarks(float marks) {
        this.marks = marks;
    }
    @Override
    public void display() {
        System.out.println("Name: " + getName() + "\nRoll Number: " + rollNumber + "\nMarks: " + marks);
    }
}