package student;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        welcome();
    }

    public static void welcome() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome, how big do you want the group to be?");
        int size = scan.nextInt();
        String bin1 = scan.nextLine();

        Group studentList = new Group(size);

        for (int i = 0; i < size; i++) {
            System.out.println("What is the given, family name and the student number of the student?");

            int stNumber = scan.nextInt();
            String firstName = scan.next();
            String lastName = scan.next();

            Student student = new Student(firstName, lastName, stNumber);

            studentList.addStudent(student, i);
        }
        System.out.println("\n" + studentList.toString());

        boolean askAgain = true;

        while (askAgain) {
            System.out.println("Student number and new given/family name?");

            int stNumber = scan.nextInt();

            if (stNumber < 0) {
                askAgain = false;
            } else {
                String firstName = scan.next();
                String lastName = scan.next();

                Student student = new Student(firstName, lastName, stNumber);

                studentList.editStudent(student, stNumber);

                System.out.println("\n" + studentList.toString());
            }
        }
        scan.close();
    }
}
