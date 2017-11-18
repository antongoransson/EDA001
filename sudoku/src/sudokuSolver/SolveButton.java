package sudokuSolver;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class SolveButton extends JButton implements ActionListener {
	private SudokuInterface si;
		
	public SolveButton (SudokuInterface si) {
		super("Solve");
		this.si = si;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//si.getBoard();
		Sudoku s = new Sudoku(si.getBoard());
		si.getBoard();
		if(s.checkIfValidBoard()){ //&& s.solve()){//(s.check() ){//&& s.solve()){
		s.getBoard();	
		si.setBoard(s.getBoard());				
		}else{
			JOptionPane.showMessageDialog(null, "Sudokut går ej att lösa", "Olösligt", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100,60);
	}

}
