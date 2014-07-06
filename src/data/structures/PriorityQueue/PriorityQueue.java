package data.structures.PriorityQueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class PriorityQueue<Key> implements Iterable<Key> {

  private int size;
  @SuppressWarnings("unchecked")
  private Key[] binaryHeap = (Key[]) new Object[16];
  private int capacity = 16;
  private Comparator<Key> comparator;

  public PriorityQueue() {}

  public PriorityQueue(Comparator<Key> comparator) {
    this.comparator = comparator;
  }

  public void enQueue(Key value) {
    binaryHeap[++size] = value;
    if (size == capacity) {
      resize();
    }
    swim(size);
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    Key[] tempArray = (Key[]) new Object[capacity * 2];
    for (int i = 0; i < binaryHeap.length; i++) {
      binaryHeap[i] = tempArray[i];
    }
    binaryHeap = tempArray;
  }

  public Key dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException("The queue is empty.");
    }
    Key maxElement = binaryHeap[1];
    exch(1, size--);
    sink(1);
    binaryHeap[size + 1] = null;
    return maxElement;
  }

  public int size() {
    return size;
  };

  public boolean isEmpty() {
    return size == 0;
  };

  private void swim(int key) {
    while (key > 1 && less(key / 2, key)) {
      exch(key / 2, key);
      key = key / 2;
    }
  }

  private void sink(int key) {
    while (2 * key <= size) {
      int j = 2 * key;
      if (j < size && less(j, j + 1)) {
        j++;
      }
      if (!less(key, j)) {
        break;
      }
      exch(key, j);
      key = j;
    }
  }

  @SuppressWarnings("unchecked")
  private boolean less(int i, int j) {
    if (comparator == null) {
      return ((Comparable<Key>) binaryHeap[i]).compareTo(binaryHeap[j]) < 0;
    } else {
      return comparator.compare(binaryHeap[i], binaryHeap[j]) < 0;
    }
  }

  private void exch(int i, int j) {
    Key tempKey = binaryHeap[i];
    binaryHeap[i] = binaryHeap[j];
    binaryHeap[j] = tempKey;
  }



  @Override
  public Iterator<Key> iterator() {
    return new QueueIterator<Key>();
  }

  @SuppressWarnings({"unchecked", "hiding"})
  private class QueueIterator<Key> implements Iterator<Key> {
    private Key[] iterableHeap = (Key[]) binaryHeap.clone();
    private int iterSize = size;
    // max element always in first position
    private static final int FIRST_ELEMENT_POSITION = 1;

    @Override
    public boolean hasNext() {
      return iterableHeap[FIRST_ELEMENT_POSITION] != null;
    }

    @Override
    public Key next() {
      Key resultKey = iterableHeap[FIRST_ELEMENT_POSITION];
      return resultKey;
    }

    @Override
    public void remove() {
      int lastElement = iterSize--;
      iterableHeap[FIRST_ELEMENT_POSITION] = iterableHeap[lastElement];
      iterableHeap[lastElement] = null;
      sink(FIRST_ELEMENT_POSITION);
    }

  }



}
