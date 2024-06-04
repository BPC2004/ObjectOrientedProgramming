package student;

public class Assignment01Tester {
	Group studentList = new Group(2);

	public void createGroup(int i) {
		Group studentList = new Group(i);
	}

	public void addStudent(int sNumber, String firstName, String lastName, int i) {
		Student student = new Student(firstName, lastName, sNumber);
		studentList.addStudent(student, i);
	}

	public void changeStudent(int sNumber, String firstName, String lastName, int i) {
		Student student = new Student(firstName, lastName, sNumber);
		studentList.addStudent(student, i);
		studentList.editStudent(student, sNumber);
	}

	public String printStudents() {
		return studentList.toString();
	}

}
