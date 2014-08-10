package data.structures.BTSSymbolTable;

import data.structures.Queue.Queue;

public class BTSSymbolTable<Key extends Comparable<Key>, Value> {

  private Node root;
  private int size;

  private class Node {
    private Key key;
    private Value value;
    private Node left;
    private Node right;

    public Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void put(Key key, Value value) {
    Node addedNode = new Node(key, value);
    if (root == null) {
      root = addedNode;
      size++;
      return;
    }
    size++;
    put(root, addedNode);
  }

  private Node put(Node node, Node addedNode) {
    if (node == null) {
      return addedNode;
    }
    int cmp = addedNode.key.compareTo(node.key);
    if (cmp > 0) {
      node.right = put(node.right, addedNode);
    } else {
      if (addedNode.key.compareTo(node.key) < 0) {
        node.left = put(node.left, addedNode);
      } else {
        if (cmp == 0) {
          node.value = addedNode.value;
          size--;
        }
      }
    }
    return node;
  }


  public void deleteMin() {
    root = deleteMin(root);
    size--;
  }

  private Node deleteMin(Node node) {
    if (node.left == null) {
      return node.right;
    }
    node.left = deleteMin(node.left);
    return node;
  }

  public Value get(Key key) {
    Node node = root;
    while (node != null) {
      int cmp = key.compareTo(node.key);
      if (cmp < 0) {
        node = node.left;
      }
      if (cmp > 0) {
        node = node.right;
      }
      if (cmp == 0) {
        return node.value;
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

  public Iterable<Key> keys() {
    Queue<Key> queue = new Queue<Key>();
    keys(root, queue);
    return queue;
  }

  private void keys(Node node, Queue<Key> queue) {
    if (node == null) {
      return;
    }
    keys(node.left, queue);
    queue.enQueue(node.key);
    keys(node.right, queue);
  }

  public Key minKey() {
    return  min(root).key;
  }
  private Node min(Node node) {
    if (node.left == null) {
      return node;
    }
    return min(node.left);
  }
}
