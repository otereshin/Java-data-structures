package data.structures.Queue;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private int size;
	private Node<Item> last;
	private Node<Item> first;

	private static class Node<Item> {
		Node<Item> next;
		Item value;
	}

	public void enQueue(Item item) {
		if (first == null) {
			last = new Node<Item>();
			last.value = item;
			first = last;
			size++;
		} else {
			Node<Item> newLast = new Node<Item>();
			newLast.value = item;
			last.next = newLast;
			last = newLast;
			size++;
		}
	}

	public Item deQueue() {
		if (first == null) {
			first = last;
		}
		Item retItem = first.value;
		first = first.next;
		size--;
		return retItem;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	private class QueueIterator<Item> implements Iterator<Item> {
		private Node<Item> nextNode = (Node<Item>) first;
		private Node<Item> currentNode = null;

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public Item next() {
			currentNode = nextNode;
			nextNode = nextNode.next;
			return currentNode.value;
		}

		@Override
		public void remove() {
			if (hasNext()) {
				currentNode.value = currentNode.next.value;
				currentNode.next = currentNode.next.next;
			} else {
				currentNode = null;
			}
			size--;
		}

	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator<Item>();
	}

}
