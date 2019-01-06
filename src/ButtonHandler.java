
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ButtonHandler implements ActionListener {

	public ButtonHandler () {
	}
	
	public void actionPerformed(ActionEvent event) {

		JButton clickedButton 	= (JButton) event.getSource();
		JRootPane rootPane		= clickedButton.getRootPane();
		Frame frame				= (JFrame) rootPane.getParent();
		frame.setTitle("You clicked " + clickedButton.getText());
	
	}

}
