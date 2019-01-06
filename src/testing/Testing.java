package testing;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Testing extends JFrame implements ActionListener {

	private static final int FRAME_WIDTH	= 300;
	private static final int FRAME_HEIGHT	= 200;
	private static final int FRAME_X_ORIGIN	= 150;
	private static final int FRAME_Y_ORIGIN	= 250;

	private static final int BUTTON_WIDTH	= 80;
	private static final int BUTTON_HEIGHT	= 30;

	private JButton cancelButton;
	private JButton okButton;
	
	private JTextField inputLine;
	
	public static void main(String[] args) {
		Testing frame = new Testing();
		frame.setVisible(true);	
	}

	public Testing() {
		Container contentPane;
		
		setSize (FRAME_WIDTH, FRAME_HEIGHT);
		setResizable (true);
		setTitle ("Program Ch14SecondJFrame");
		setLocation (FRAME_X_ORIGIN, FRAME_Y_ORIGIN);
		
		contentPane = getContentPane( );
		contentPane.setLayout(new FlowLayout ());
		
		inputLine = new JTextField();
		inputLine.setColumns(22);
		contentPane.add(inputLine);
		
		inputLine.addActionListener(this);
		
		okButton = new JButton("OK");
		okButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		contentPane.add(okButton);
		
		cancelButton = new JButton("CANCEL");
		cancelButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		contentPane.add(cancelButton);
		
		cancelButton.addActionListener(this);
		okButton.addActionListener(this);
		
		setDefaultCloseOperation( EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() instanceof JButton) {
			JButton clickedButton = (JButton) event.getSource();			
			setTitle("You clicked " + clickedButton.getText());
		} else {
			setTitle("You entered '" + inputLine.getText() + "'");
		}
	}
}
