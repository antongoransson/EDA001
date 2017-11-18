package sudokuSolver;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SudokuInterface extends JFrame {
	private Sudoku sudoku;
	private DrawingPanel northPanel;
	private JPanel southPanel;

	public SudokuInterface() {
		super("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		northPanel = new DrawingPanel(this);
		southPanel = new CommandPanel(this);
		add(southPanel, BorderLayout.SOUTH);
		add(northPanel, BorderLayout.NORTH);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new SudokuInterface();
	}
	
	public boolean solve() {
		return sudoku.solve();
	}

	/**
	 * Tömmer alla rutor
	 * 
	 */
	public void clear() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				northPanel.boards[i][j].setText("");
			}
		}
	}

	/**
	 * Hämtar brädan som syns i interfacet
	 * 
	 * @return
	 */
	public int[][] getBoard() {
		int[][] board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (northPanel.boards[i][j].getText().length() == 0) {
					board[i][j] = 0;
				} else {
					board[i][j] = Character
							.getNumericValue(northPanel.boards[i][j].getText()
									.charAt(0));
				}
			}
		}
		return board;
	}

	/**
	 * Sätter värden från den lösta matrisen i interfacets matris
	 * 
	 * @param ints
	 */
	protected void setBoard(int[][] ints) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (ints[i][j] == 0) {
					northPanel.boards[i][j].setText("");
				} else {
					northPanel.boards[i][j].setText(((Integer) ints[i][j])
							.toString());
				}
			}
		}
	}
}
