package data.structures.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import data.structures.stack.Stack;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StackTest {

	private Stack<String> stack;
	private static final String TEST_STRING_NAME_HOMER = "HOMER";
	private static final String TEST_STRING_NAME_ALEX = "ALEX";
	private static final String TEST_STRING_NAME_DENIS = "DENIS";

	@Before
	public void dataPrepare() {
		stack = new Stack<String>();
		stack.push(TEST_STRING_NAME_HOMER);
		stack.push(TEST_STRING_NAME_ALEX);
	}

	@Test
	public void addAndGetValueFromStackTest() {
		stack.push(TEST_STRING_NAME_DENIS);
		assertEquals(TEST_STRING_NAME_DENIS, stack.pop());
	}

	@Test
	public void stackIterationTest() {
		Iterator<String> itr = stack.iterator();
		while (itr.hasNext()) {
			String name = itr.next();
			if (TEST_STRING_NAME_HOMER.equals(name)) {
				itr.remove();
			}
		}
		assertEquals(stack.size(), 1);

	}
}
