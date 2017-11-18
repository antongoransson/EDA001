package testqueue;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue.FifoQueue;

public class TestAppendFifoQueue {
	FifoQueue<Integer> q;
	FifoQueue<Integer> qu;

	@Before
	public void setUp() throws Exception {
		q = new FifoQueue<Integer>();
		qu = new FifoQueue<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		q = null;
		qu = null;
	}

	@Test
	public final void test() {
		/* Tom kö till tom kö */
		q.append(qu);
		System.out.println(q.size());
		assertEquals(0, q.size(), qu.size());

		/* Icke tom kö till icke tom kö */
		for (int i = 3; i <= 12; i++) {
			q.offer(i);
			qu.offer(i);
		}
		q.append(qu);
		assertEquals("Fel", 20, q.size());
		for (int i : q) {
			i = q.poll();
			System.out.println(i);

			/* Icke tom kö till tom kö */
		}
		for (int i = 20; i <= 30; i++) {
			qu.offer(i);
		}
		q.append(qu);
		assertEquals("Fel", 11, q.size());
		assertEquals("fel", 0, qu.size());
		for (int y : q) {
			y = q.poll();
			System.out.println(y);
		}
		/* Tom kö till icke tom kö */
		q.offer(3);
		q.offer(2);
		q.append(qu);
		assertEquals("Den ger fel storlek", 2, q.size());
		int a = q.poll();
		int n = q.poll();
		System.out.println(a + " " + n);
	}

}
