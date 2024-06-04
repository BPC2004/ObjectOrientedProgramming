package pair;

import static org.junit.Assert.*;

import org.junit.Test;

public class PairTest {

	public class Pair {
		private final Object first;
		private final Object second;
	
		public Pair(Object first, Object second) {
			this.first = first;
			this.second = second;
		}
	
		public Object getFirst() {
			return first;
		}
	
		public Object getSecond() {
			return second;
		}
	}

	@Test
	public void firstInOut() {
		Pair p = new Pair("foo", true);
		assertEquals("foo", (String) p.getFirst());
		assertEquals(true, (Boolean) p.getSecond());
	}

	@Test
	public void fails()
	{
		Pair p = new Pair(10, "Hello Geeks!");
		// This should be a compile error, not a run time error
		assertEquals(true, (Boolean) p.getFirst());
		assertEquals("foo", (String) p.getSecond());
	}
}
