package data.structures.tests;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import data.structures.stack.Stack;

@FixMethodOrder(MethodSorters.DEFAULT)
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
		stack.push(TEST_STRING_NAME_HOMER);
		assertEquals(TEST_STRING_NAME_HOMER, stack.pop());
		assertEquals(1, stack.size());
		assertEquals(TEST_STRING_NAME_ALEX, stack.pop());
		assertEquals(true, stack.isEmpty());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void stackIsEmptyTest() {
		Stack<String> emptyStack = new Stack<String>();
		emptyStack.pop();
	}
}
