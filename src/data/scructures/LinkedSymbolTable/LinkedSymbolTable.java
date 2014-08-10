package data.scructures.LinkedSymbolTable;

import data.structures.Queue.Queue;
import java.util.NoSuchElementException;

public class LinkedSymbolTable<Key, Value> {

  private Node first;
  private int size;

  private class Node {
    Key key;
    Value value;
    Node next;

    private Node(Key key, Value value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void put(Key key, Value value) {
    for (Node i = first; i != null; i = i.next) {
      if (key.equals(i.key)) {
        i.value = value;
        return;
      }
    }
    first = new Node(key, value, first);
    size++;
  }

  public Value get(Key key) {
    Node node = getNode(key);
    if (node != null) {
      return node.value;
    }
    return null;
  }

  private Node getNode(Key key) {
    for (Node i = first; i != null; i = i.next) {
      if (i.key.equals(key)) {
        return i;
      }
    }
    return null;
  }

  public boolean contains(Key key) {
    if (get(key) != null) {
      return true;
    }
    return false;
  }

  public void delete(Key key) {
    Node node = getNode(key);
    if (node == null) {
      throw new NoSuchElementException();
    }
    if (node.next != null) {
      node.key = node.next.key;
      node.value = node.next.value;
      node.next = node.next.next;
    } else {
      for (Node i = first; i != null; i = i.next) {
        if (i.next == node) {
          i.next = null;
          return;
        }
      }
    }
    size--;
  }

  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue<Key>();
    for (Node i = first; i != null; i = i.next) {
      queue.enQueue(i.key);
    }
    return queue;
  }

}
