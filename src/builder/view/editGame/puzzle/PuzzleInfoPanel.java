package builder.view.editGame.puzzle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import builder.view.dropdownMenu.DropMenuFrame;
import builder.view.editGame.GameFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class PuzzleInfoPanel extends JPanel {
	
	JTextField textField;
	JLabel maximumWords;
	
	JButton preview;
	JButton saveLevel;
	JButton quit;

	/**
	 * Create the panel.
	 */
	public PuzzleInfoPanel(){
		initialize();
	}
	
	private void initialize(){
		setLayout(null);
		setBounds(660, 170, 260, 510);
		//setBackground(Color.lightGray);
		
		maximumWords = new JLabel("Maximum Words:");
		maximumWords.setBounds(90, 26, 125, 39);
		add(maximumWords);
		
		textField = new JTextField();
		textField.setBounds(80, 57, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btnPreview = new JButton("Preview");
		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPreview.setBounds(0, 300, 91, 29);
		add(btnPreview);
		
		JButton btnSaveLevel = new JButton("Save");
		btnSaveLevel.setBounds(90, 300, 91, 29);
		add(btnSaveLevel);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(180, 300, 91, 29);
		btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	GameFrame currentFrame = (GameFrame) SwingUtilities.getRoot(btnQuit);
        		currentFrame.dispose();
        		DropMenuFrame frame = new DropMenuFrame();
				frame.setVisible(true);
            }
        });
		add(btnQuit);

	}
}
