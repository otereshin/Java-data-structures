package data.structures.tests;

import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import data.structures.Queue.Queue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueueTest {

	private Queue<String> queue;
	private static final String TEST_STRING_NAME_HOMER = "HOMER";
	private static final String TEST_STRING_NAME_ALEX = "ALEX";
	private static final String TEST_STRING_NAME_DENIS = "DENIS";

	@Before
	public void dataPrepare() {
		queue = new Queue<String>();
		queue.enQueue(TEST_STRING_NAME_HOMER);
		queue.enQueue(TEST_STRING_NAME_ALEX);
		queue.enQueue(TEST_STRING_NAME_DENIS);
	}

	@Test
	public void addAndGetValueFromQueueTest() {
		assertEquals(TEST_STRING_NAME_HOMER, queue.deQueue());
	}

	@Test
	public void queueIterationTest() {
		Iterator<String> itr = queue.iterator();
		while (itr.hasNext()) {
			String name = itr.next();
			if (TEST_STRING_NAME_ALEX.equals(name)) {
				itr.remove();
			}
		}
		queue.enQueue(TEST_STRING_NAME_ALEX);
		assertEquals(TEST_STRING_NAME_HOMER, queue.deQueue());
		assertEquals(TEST_STRING_NAME_DENIS, queue.deQueue());
		assertEquals(TEST_STRING_NAME_ALEX, queue.deQueue());
		assertEquals(true, queue.isEmpty());
	}
}
