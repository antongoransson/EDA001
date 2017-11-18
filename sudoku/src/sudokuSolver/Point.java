package sudokuSolver;

public class Point {
	private int x, y;

	/** Constructs and initializes a point at the specified (x,y) location. */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/** 
	 * Returns the x coordinate. 
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/** 
	 * Returns the y coordinate. 
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}
	
	/** Indicates whether some other object is "equal to" this one.
	 * @param  obj the reference object with which to compare
	 * @return  true if this object is the same as the obj argument; false otherwise
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			return x == p.x && y == p.y;
		} else {
			return false;
		}
	}

	/** Moves this point to the specified (x,y) location.
	 * post: the point is moved to the location (x,y)
	 * @param  x the x coordinate of the new location
	 * @param  y the y coordinate of the new location
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setX(int newX){
		this.x = newX;
		
	}
	public void setY(int newY){
		this.y = newY;
	}
}
