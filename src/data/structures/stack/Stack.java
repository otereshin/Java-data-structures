package data.structures.stack;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

	private int size;
	private Node<Item> last;

	private static class Node<Item> {
		Node<Item> previous;
		Item value;
	}

	public void push(Item item) {
		if (last == null) {
			last = new Node<Item>();
		} else {
			Node<Item> oldLast = last;
			last = new Node<Item>();
			last.previous = oldLast;
		}
		size++;
		last.value = item;
	}

	public Item pop() {
		Item retValue = (Item) last.value;
		if (size() == 1) {
			last = null;
		}
		if (size() > 1) {
			last = last.previous;
		}
		size--;
		return retValue;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	private class StackIterator<Item> implements Iterator<Item> {
		private Node<Item> nextNode = (Node<Item>) last;
		private Node<Item> currentNode = null;

		@Override
		public boolean hasNext() {
			return nextNode != null;
		}

		@Override
		public Item next() {
			currentNode = nextNode;
			nextNode = nextNode.previous;
			return currentNode.value;
		}

		@Override
		public void remove() {
			if (hasNext()) {
				currentNode.value = currentNode.previous.value;
				currentNode.previous = currentNode.previous.previous;
			} else {
				currentNode = null;
			}
			size--;
		}

	}

	@Override
	public Iterator<Item> iterator() {
		return new StackIterator<Item>();
	}
}
