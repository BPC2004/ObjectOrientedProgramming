package student;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Assignment01Test {

	@Test
	public void testGroupOfTwo() {
		Assignment01Tester tester = new Assignment01Tester();
		tester.createGroup(2);
		tester.addStudent(42, "Lucy", "Liddels", 0);
		tester.addStudent(101, "Bob", "Biggens", 1);
		assertEquals("Lucy Liddels, s42\nBob Biggens, s101\n", tester.printStudents());
	}

	@Test
	public void testChangeStudent() {
		Assignment01Tester tester = new Assignment01Tester();
		tester.createGroup(2);
		tester.addStudent(42, "Luucy", "Liddels", 0);
		tester.addStudent(101, "Bob", "Biggens", 1);
		assertEquals("Luucy Liddels, s42\nBob Biggens, s101\n", tester.printStudents());
		tester.changeStudent(42, "Lucy", "Liddels", 0);
		assertEquals("Lucy Liddels, s42\nBob Biggens, s101\n", tester.printStudents());
	}
}
