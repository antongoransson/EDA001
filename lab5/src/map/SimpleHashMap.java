package map;

import java.util.Random;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private Entry<K, V>[] table;
	private int size;

	public SimpleHashMap() {
		table = (Entry<K, V>[]) new Entry[16];
	}

	public SimpleHashMap(int capacity) {
		table = (Entry<K, V>[]) new Entry[capacity];
	}

	public static void main(String[] args) {
		SimpleHashMap map = new SimpleHashMap(10);
		Random rand = new Random();
		for (int i = 0; i < 50; i++) {
			int r = rand.nextInt(100)*10;
			map.put(r, r);
		}
		System.out.println(map.show());
		for (int i = 0; i < 100; i++) {
		  double r1 = 20 * Math.random();
			map.put(r1, r1);
		}
		System.out.println(map.show());
		System.out.println(map.size);
		

	}

	@Override
	public V get(Object object) {
		int index = index((K) object);
		Entry<K, V> e = find(index, (K) object);
		if (e == null) {
			return null;
		}
		return e.value;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		int index = index(key);
		Entry<K, V> temp = find(index, key);
		if (table[index] == null) {
			table[index] = new Entry<K, V>(key, value);
			size++;
			rehash();
			return null;
		} else {
			if (temp != null) {
				return temp.setValue(value);
			} else {
				temp = table[index];
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = new Entry<K, V>(key, value);
				size++;
				rehash();
				return null;
			}
		}
	}

	@Override
	public V remove(Object key) {
		int index = index((K) key);
		Entry<K, V> temp = table[index];
		if (temp == null) {
			return null;
		}
		if (temp.key.equals((K) key)) {
			table[index] = temp.next;
			size--;
			return temp.value;
		}
		while (temp != null) {
			if (temp.next != null) {
				if (temp.next.key.equals((K) key)) {
					size--;
					V value = temp.next.value;
					temp.next = temp.next.next;
					return value;
				}
			}
			temp = temp.next;
		}
		return null;
	}

	@Override
	public int size() {
		return size;
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		for (Entry<K, V> e : table) {
			if (e != null) {
				sb.append("\n");
			}
			while (e != null) {
				sb.append(e.toString() + "  ");
				e = e.next;
			}

		}
		return sb.toString();
	}

	private int index(K key) {
		int index = key.hashCode() % table.length;
		if (index < 0) {
			index *= -1;
		}
		return index;
	}

	private Entry<K, V> find(int index, K key) {
		Entry<K, V> temp = table[index];
		while (temp != null) {
			if (temp.key.equals(key)) {
				return temp;
			}
			temp = temp.next;
		}

		return null;
	}

	private void rehash() {
		if (((double) size / (double) table.length) >= 0.75) {
			Entry<K, V>[] copy = table;
			size = 0;
			table = (Entry<K, V>[]) new Entry[table.length * 2];
			for (int i = 0; i < copy.length; i++) {
				Entry<K, V> temp = copy[i];
				while (temp != null) {
					put(temp.key, temp.value);
					temp = temp.next;
				}
			}
		}
	}

	private static class Entry<K, V> implements Map.Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldVal= this.value;
			this.value = value;
			return oldVal;
		}

		@Override
		public String toString() {
			return key + " = " + value;
		}
	}
}
