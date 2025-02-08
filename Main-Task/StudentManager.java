package Assignment;
public class StudentManager {
    private Student students;
    private StudentManager next;
    public StudentManager(Student students) {
        this.students = students;
        this.next = null;
    }
    public Student getStudent() {
        return students;
    }
    public void setStudent(Student students) {
        this.students = students;
    }
    public StudentManager getNext() {
        return next;
    }
    public void setNext(StudentManager next) {
        this.next = next;
    }
}