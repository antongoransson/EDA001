package sudokuSolver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	private SudokuInterface si;
	private OneLetterField fi;
	protected OneLetterField[][] boards = new OneLetterField[9][9];

	public DrawingPanel(SudokuInterface si) {
		this.si = si;
		GridLayout grid = new GridLayout(9, 9, 1, 1);
		setLayout(grid);
		OneLetterField field = new OneLetterField(Color.white);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if ((i < 3 || i > 5) && (j < 3 || j > 5)) {
					field = new OneLetterField(Color.CYAN);
				} else if (i > 2 && i < 6 && j > 2 && j < 6) {
					field = new OneLetterField(Color.CYAN);
				} else {
					field = new OneLetterField(Color.YELLOW);
				}
				boards[i][j] = field;
				add(field);
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(700, 700);
	}
	// getFont
	// gets
}
