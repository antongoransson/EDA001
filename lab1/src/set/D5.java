package set;

public class D5 extends MaxSet<Integer> {

	public static void main(String[] args) {
		int[] j = { 1, 2, 3, 3, 3, 3, 5, 99, 1000, 66, 3, 6, 7, 1, 9,8,6,65,44,446,79,11110 };
		j = uniqueElements(j);
		for (int i = 0; i < j.length; i++) {
			System.out.println(j[i]);
		}
	}

	public D5() {

	}

	public static int[] uniqueElements(int[] ints) {
		MaxSet<Integer> set = new MaxSet<Integer>();
		for (int i : ints) {
			set.add(i);
		}
		int[] out = new int[set.size()];
		for (int i = set.size() - 1; i >= 0; i--) {
			out[i] = set.getMax();
			set.remove(set.getMax());
		}
		return out;
	}
}
