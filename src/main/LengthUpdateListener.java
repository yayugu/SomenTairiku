package main;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LengthUpdateListener implements DocumentListener {
	
	private final JTextArea textArea;
	private final JLabel labelCount;
	
	public LengthUpdateListener(JTextArea textArea, JLabel labelCount) {
		this.textArea = textArea;
		this.labelCount = labelCount;
	}

	@Override
	public void changedUpdate(DocumentEvent arg0) {
		updateCount();
	}

	@Override
	public void insertUpdate(DocumentEvent arg0) {
		updateCount();
	}

	@Override
	public void removeUpdate(DocumentEvent arg0) {
		updateCount();
	}

	private void updateCount() {
		labelCount.setText(Integer.toString(140 - textArea.getText().length()));
	}

}
