package queue;

import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
	}

	/**
	 * Returns an iterator over the elements in this queue
	 * 
	 * @return an iterator over the elements in this queue
	 */
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserts the specified element into this queue, if possible post: The
	 * specified element is added to the rear of this queue
	 * 
	 * @param x
	 *            the element to insert
	 * @return true if it was possible to add the element to this queue, else
	 *         false
	 */
	public boolean offer(E x) {
		QueueNode<E> n = new QueueNode<E>(x);
		if (last == null) {
			last = n;
			last.next = last;
		} else {
			QueueNode<E> oldN = last.next;
			last.next = n;
			last = n;
			last.next = oldN;
		}
		size++;
		return true;
	}

	/**
	 * Retrieves and removes the head of this queue, or null if this queue is
	 * empty. post: the head of the queue is removed if it was not empty
	 * 
	 * @return the head of this queue, or null if the queue is empty
	 */
	public E poll() {
		if (last == null) {
			return null;
		} else {
			QueueNode<E> n = last.next;
			last.next = last.next.next;
			size--;
			if (size == 0) {
				last = null;
			}
			return n.element;
		}
	}

	/**
	 * Retrieves, but does not remove, the head of this queue, returning null if
	 * this queue is empty
	 * 
	 * @return the head element of this queue, or null if this queue is empty
	 */
	public E peek() {
		if (last == null) {
			return null;
		} else {
			return last.next.element;
		}
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

	/**
	 * Appends the specified queue to this queue post: all elements from the
	 * specified queue are appended to this queue. The specified queue (q) is
	 * empty
	 * 
	 * @param q
	 *            the queue to append
	 */
	public void append(FifoQueue<E> q) {
		if (q.last == null) {
			return;
		}
		if (last == null) {
			last = q.last;
			last.next = q.last.next;
		} else {
			QueueNode<E> first = last.next;
			last.next = q.last.next;
			last = q.last;
			last.next = first;
		}
		size += q.size;
		q.size = 0;
		q.last = null;
	}

	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;

		private QueueIterator() {
			pos = last;
		}

		public boolean hasNext() {
			return pos != null;
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				QueueNode<E> temp = pos;
				pos = pos.next;
				if (pos == last) {
					pos = null;
				}
				return temp.next.element;
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
