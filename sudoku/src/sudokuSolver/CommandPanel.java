package sudokuSolver;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class CommandPanel extends JPanel {
	private SudokuInterface si;

	public CommandPanel(SudokuInterface si) {
		this.si = si;
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(new ClearButton(si));
		add(new SolveButton(si));
	}

}
