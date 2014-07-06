package data.structures.tests;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import data.structures.PriorityQueue.PriorityQueue;

@FixMethodOrder(MethodSorters.DEFAULT)
public class PriorityQueueTest {
  class Person implements Comparable<Person> {
    String name;
    int priority;

    @Override
    public int compareTo(Person o) {
      return (this.priority > o.priority) ? 1 : (this.priority < o.priority) ? -1 : 0;
    }
  }

  private PriorityQueue<Person> priorityQueue = new PriorityQueue<Person>();
  private String[] listOfNames = {"Homer", "Alex", "Denis"};

  @Before
  public void prepareDataForTests() {
    for (int i = 0; i < listOfNames.length; i++) {
      Person person = new Person();
      person.name = listOfNames[i];
      person.priority = i;
      priorityQueue.enQueue(person);
    }
  }

  @Test
  public void getValueFromQueueTest() {
    for (int i = 2; i >= 0; i--) {
      assertEquals(listOfNames[i], priorityQueue.dequeue().name);
    }
  }

  @Test
  public void stackIterationTest() {
    Iterator<Person> iter = priorityQueue.iterator();
    int iterCount = 2;
    while (iter.hasNext()) {
      Person person = iter.next();
      assertEquals(listOfNames[iterCount], person.name);
      iter.remove();
      iterCount--;
    }
    // check that went through all the elements
    assertEquals(iterCount, -1);
  }

}
