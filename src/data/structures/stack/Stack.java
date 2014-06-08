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

	@SuppressWarnings("hiding")
	private class MyStackIterator<Item> implements Iterator<Item> {
		int iterSize = size;

		@Override
		public boolean hasNext() {
			return iterSize > 0;
		}

		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Item next() {
			if (iterSize > 1) {
				Node next = last;
				last = last.previous;
				iterSize--;
				return (Item) next.value;
			}
			iterSize--;
			return (Item) last.value;
		}

		@Override
		public void remove() {
			pop();
		}

	}

	@Override
	public Iterator<Item> iterator() {
		return new MyStackIterator<Item>();
	}
}
