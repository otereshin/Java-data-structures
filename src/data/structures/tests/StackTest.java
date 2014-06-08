package data.structures.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import data.structures.stack.Stack;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StackTest {

	private Stack<String> stack;
	private static final String TEST_STRING_NAME_HOMER = "HOMER";
	private static final String TEST_STRING_NAME_ALEX = "AlEX";
	private static final String TEST_STRING_NAME_DENIS = "DENIS";

	@Test
	public void CreateEmptyTest() {
		stack = new Stack<String>();
		assertNotNull(stack);
	}

	@Test
	public void AddSomeValuesToStackTest() {
		stack.push(TEST_STRING_NAME_HOMER);
		stack.push(TEST_STRING_NAME_ALEX);
		stack.push(TEST_STRING_NAME_DENIS);
		assertEquals(stack.size(), 2);
	}
	
	@Test
	public void GetValueFromStackTest() {
		assertEquals(TEST_STRING_NAME_DENIS, stack.pop());
	}

	@Test
	public void StackIterationTest() {
		for (String name : stack) {
			assertTrue(name.equals(TEST_STRING_NAME_ALEX)
					|| name.equals(TEST_STRING_NAME_DENIS));
		}
	}

	@Test
	public void RemoveValueFromStackDuringIterationTest() {
		Iterator<String> itr = stack.iterator();
		while (itr.hasNext()) {
			String name = itr.next();
			assertEquals(TEST_STRING_NAME_ALEX, name);
			itr.remove();
		}
		assertEquals(stack.size(), 1);
	}

}
