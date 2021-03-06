package mountain;

public class Side {
	private Point p1, p2, m;

	public Side(Point p1, Point p2, Point m) {
		this.p1 = p1;
		this.p2 = p2;
		this.m = m;
	}

	public boolean equals(Side s) {
		return s.getP1() == p1 && s.getP2() == p2 || s.getP1() == p2
				&& s.getP2() == p1;
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}
	public Point getM(){
		return m;
	}
}
