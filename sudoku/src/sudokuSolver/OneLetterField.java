package sudokuSolver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.AbstractDocument;

public class OneLetterField extends JTextField {
	private Color color;
	/**
	 * Creates a text field to display only one character.
	 */
	public OneLetterField(Color color) {
		super("");
		((AbstractDocument) this.getDocument())
				.setDocumentFilter(new OneNumberFilter());
		this.color=color;
		setBackground(color);}

	private class OneNumberFilter extends DocumentFilter {
		OneNumberFilter() {
			super();	
		}

		public void insertString(FilterBypass fb, int offset, String str,
				AttributeSet attr) throws BadLocationException {
			if ((fb.getDocument().getLength() + str.length()) > 1) {
				return;
			}
			if (!str.isEmpty() && !Character.isDigit(str.charAt(0))) {
				return;
			}
			fb.insertString(offset, str, attr);
		}

		public void replace(FilterBypass fb, int offset, int length,
				String str, AttributeSet attr) throws BadLocationException {
			if ((fb.getDocument().getLength() + str.length() - length) > 1) {
				return;
			}
			if (!str.isEmpty() && !Character.isDigit(str.charAt(0))) {
				return;
			}
			fb.replace(offset, length, str, attr);
		}
	}

	@Override
	public Font getFont() {
		return new Font("Harrington", Font.BOLD, 40);
	}

	@Override
	public int getHorizontalAlignment() {
		return JTextField.CENTER;
	}
	
}
