package sudokuSolver;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClearButton extends JButton implements ActionListener {
	private SudokuInterface si;
		
	public ClearButton(SudokuInterface si) {
		super("Clear");
		addActionListener(this);
		this.si = si;;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		si.clear();
		
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100,60);
	}

}
