package Assignment;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentManagementSystem {
	static class InvalidMarkException extends Exception {
		public InvalidMarkException(String message) {
			super(message);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentManager head = null;
		while (true) {
			System.out.print("1. Admin Access\n2. Student Access\n3. Exit\n");
			int accessType = sc.nextInt();
			sc.nextLine();

			switch (accessType) {
				case 1:
					while (true) {
						System.out.print(
								"1. Register Students\n2. Update Marks\n3. Display Student Details\n4. Delete the student detail\n5. Logout\n");
						int adminAcc = sc.nextInt();
						sc.nextLine();
						switch (adminAcc) {
							case 1:
								System.out.println("Enter Roll Number:");
								int roll = sc.nextInt();
								boolean exists = false;
								StudentManager temp = head;
								while (temp != null) {
									if (temp.getStudent().getRollNumber() == roll) {
										exists = true;
										break;
									}
									temp = temp.getNext();
								}
								if (exists) {
									System.out.println("Roll number already exists.");
									continue;
								}
								System.out.println("Enter Name:");
								String name = sc.next();
								System.out.println("Enter Marks:");
								float marks = sc.nextFloat();
								try {
									ValidMarks(marks);
								} catch (Exception e) {
									System.err.println(e.getMessage());
								}
								Student student = new Student(name, roll, marks);
								StudentManager newStudent = new StudentManager(student);
								if (head == null) {
									head = newStudent;
								} else {
									temp = head;
									while (temp.getNext() != null) {
										temp = temp.getNext();
									}
									temp.setNext(newStudent);
								}
								System.out.println("Student registered successfully!");
								break;
							case 2:
								System.out.println("Enter Roll Number:");
								int t = 0;
								try {
									t = sc.nextInt();
								} catch (InputMismatchException e) {
									System.out.println("Invalid Input");
								}
								System.out.println("Enter Updated Marks:");
								float newMarks = 0;
								try {
									newMarks = sc.nextFloat();
								} catch (InputMismatchException e) {
									System.out.println("Invalid Input");
								}
								temp = head;
								while (temp != null && temp.getStudent().getRollNumber() != t) {
									temp = temp.getNext();
								}
								if (temp == null) {
									System.out.println("Student not found.");
								} else {
									temp.getStudent().setMarks(newMarks);
									System.out.println("Marks updated successfully!");
								}
								break;
							case 3:
								Display(head);
								break;
							case 4:
								System.out.println("Enter Roll Number:");
								int deleteRoll = sc.nextInt();
								if (head == null) {
									System.out.println("Student List is empty.");
									continue;
								}
								if (head.getStudent().getRollNumber() == deleteRoll) {
									head = head.getNext();
									continue;
								}
								temp = head;
								while (temp.getNext() != null
										&& temp.getNext().getStudent().getRollNumber() != deleteRoll) {
									temp = temp.getNext();
								}
								if (temp.getNext() == null) {
									System.out.println("Student name not found.");
								} else {
									temp.setNext(temp.getNext().getNext());
									System.out.println(" deleted.");
								}
								break;
							case 5:
								System.out.println("Logging out from Admin access");
								break;
							default:
								System.out.println("Invalid option. Try again.");
						}
						if (adminAcc == 5)
							break;
					}
					break;
				case 2:
					System.out.print("1. Display Student Details\n2. Logout\n");
					int stuAcc = sc.nextInt();
					switch (stuAcc) {
						case 1:
							Display(head);
							break;
						case 2:
							break;
						default:
							System.out.println("Invalid Number");
					}
					break;
				case 3:
					System.out.println("Exiting program.");
					sc.close();
					return;
				default:
					System.out.println("Invalid option.");
			}
		}
	}
	public static void ValidMarks(float marks) throws InvalidMarkException {
		if (marks > 100 || marks < 0) {
			throw new InvalidMarkException("Invalid Marks");
		}
	}
	public static void Display(StudentManager head) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Roll Number:");
		int tempRoll = sc.nextInt();
		StudentManager temp = head;
		while (temp != null && temp.getStudent().getRollNumber() != tempRoll) {
			temp = temp.getNext();
		}
		if (temp == null) {
			System.out.println("Student not found.");
		} else {
			temp.getStudent().display();
		}
		sc.close();
	}
}