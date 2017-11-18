package sudokuSolver;

public class Sudoku {
	protected int[][] board;

	public Sudoku(int[][] board) {
		this.board = board;

	}

	public static void main(String[] args) {
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++)
				// System.out.print(test1[x][y] + " ");
				System.out.println();
		}
	}

	/**
	 * Nollställer brädet.
	 * 
	 */
	public void clear() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = 0;
			}
		}
	}
	/** Löser sudokut samt returnerar matrisen av brädet.
	 * 
	 * @return
	 */
	public int[][] getBoard() {
		solve();
		return board;
	}

	/**
	 * Löser sudokut med backtrackingteknik och med hjälp av points.
	 * 
	 * @return
	 */
	public boolean solve() {
		return solve(new Point(0, 0));
	}

	/**
	 * Kollar om brädet går att lösa med sina startvärden.
	 * 
	 * @return
	 */
	public boolean checkIfValidBoard() {
		Point p = new Point(0, 0);
		return check(p, board[p.getY()][p.getX()]);
	}

	private boolean check(Point p, int value) {
		int row = p.getY();
		int col = (p.getX() + 1) % 9;
		if (col == 0)
			row = p.getY() + 1;
		Point p1 = new Point(col, row);
		if (value != 0) {
			if (isValid(p, value)) {
				if (row == 9)
					return true;
				return check(p1, board[p1.getY()][p1.getX()]);
			} else {
				return false;
			}
		}
		if (row == 9)
			return true;
		return check(p1, board[p1.getY()][p1.getX()]);
	}

	/**
	 * Löser sudokut med rekursion
	 * 
	 * @param p
	 * @return
	 */
	private boolean solve(Point p) {
		int row = p.getY();
		int col = (p.getX() + 1) % 9;
		if (col == 0) {
			row = p.getY() + 1;
		}
		if (board[p.getY()][p.getX()] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isValid(p, i)) {
					board[p.getY()][p.getX()] = i;
					if (row == 9) {
						return true;
					}
					if (solve(new Point(col, row))) {
						return true;
					}
				}
			}
			board[p.getY()][p.getX()] = 0;
			return false;
		} else if (isValid(p, board[p.getY()][p.getX()])) {
			if (row == 9) {
				return true;
			}
			return solve(new Point(col, row));
		}
		return false;
	}

	/**
	 * Kollar om raden innehåller talet value
	 * 
	 * @param p
	 * 
	 * @param value
	 * 
	 * @return
	 */
	private boolean rowContains(Point p, int value) {
		for (int i = 0; i < 9; i++) {
			if (board[p.getY()][i] == value && i != p.getX()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Kollar om kolumnen innehåller värdet value
	 * 
	 * @param p
	 * @param value
	 * @return
	 */
	private boolean columnContains(Point p, int value) {
		for (int i = 0; i < 9; i++) {
			if (board[i][p.getX()] == value && i != p.getY()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Kollar om kvadraten som point P ligger i innehåller värdet value
	 * 
	 * @param p
	 * @param value
	 * @return
	 */
	private boolean squareContains(Point p, int value) {
		Point newP = getSquare(p);
		for (int i = newP.getY(); i < newP.getY() + 3; i++) {
			for (int j = newP.getX(); j < newP.getX() + 3; j++) {
				if (i == p.getY() && j == p.getX()) {
					continue;
				}
				if (board[i][j] == value) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Kollar om det är okej att lägga in talet value på platsen p
	 * 
	 * @param p
	 * @param value
	 * @return
	 */
	private boolean isValid(Point p, int value) {
		return !rowContains(p, value) && !columnContains(p, value)
				&& !squareContains(p, value);

	}

	private Point getSquare(Point p) {
		Point newP = new Point(0, 0);
		if (p.getX() >= 6) {
			newP.setX(6);
		} else if (p.getX() >= 3) {
			newP.setX(3);
		} else {
			newP.setX(0);
		}
		if (p.getY() >= 6) {
			newP.setY(6);
		} else if (p.getY() >= 3) {
			newP.setY(3);
		} else {
			newP.setY(0);
		}
		return newP;
	}
}
