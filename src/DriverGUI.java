import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;



public class DriverGUI {
	protected static String vendChoice;
	protected static ArrayList<String> stocksDisplay;
	protected static String onClickMachinePreferences;
	protected static boolean holdsOne;
	protected static boolean holdsTwo;
	protected static int moneyMoney;
	private final String [] itemCode = {"A1","A2","A3","A4","A5","A6","B1","B2","B3","B4","B5","B6","C1","C2",
			"C3","C4","C5","C6","D1","D2","D3","D4","D5","D6","E1","E2","E3","E4","E5","E6","F1","F2","F3","F4","F5","F6"};

	/* Frame subclasses that creates frame for GUI */
	@SuppressWarnings("serial")
	class VendingMachinePreferences extends JFrame implements ActionListener, ItemListener {
		// private static final int frameWidth = 500;
		// private static final int frameHeight = 200;
		// private static final int frameXOrigin = 150;
		// private static final int frameYOrigin = 250;
		private JComboBox<String> comboBox;

		public VendingMachinePreferences() {

			Container contentPane;

			JButton okButton;
			String[] comboBoxItem = { "Snacks", "Drinks" };

			setSize(500, 200);
			setTitle("Vending Machine Selection");
			setLocation(150, 250);

			contentPane = getContentPane();
			contentPane.setBackground(Color.white);
			contentPane.setLayout(null);
			JLabel label = new JLabel("Please select a vending Machine:");
			label.setBounds(20, 20, 250, 40);
			comboBox = new JComboBox<String>(comboBoxItem);
			comboBox.setBounds(300, 20, 100, 40);
			comboBox.addItemListener(this);
			contentPane.add(label);
			contentPane.add(comboBox);

			okButton = new JButton("OK");
			okButton.setBounds(400, 100, 50, 50);
			Font f = new Font("Arial", Font.PLAIN, 10);
			okButton.setFont(f);
			okButton.addActionListener(this);
			contentPane.add(okButton);

			setBackground(Color.white);
			setDefaultCloseOperation(EXIT_ON_CLOSE);

		}

		public void actionPerformed(ActionEvent event) {
			JButton clickedButton = (JButton) event.getSource();
			JRootPane rootPane = clickedButton.getRootPane();
			Frame frame = (JFrame) rootPane.getParent();

			if (clickedButton.getText().equals("OK")) {
				holdsOne = true;
				DriverGUI d = new DriverGUI();
				DriverGUI.MoneyInput m = d.new MoneyInput();
				m.setVisible(true);
				String favorite;
				favorite = (String) comboBox.getSelectedItem();
				vendChoice = favorite;
				onClickMachinePreferences = favorite;

			}

		}

		public void itemStateChanged(ItemEvent event) {
			String state;

			if (event.getStateChange() == ItemEvent.SELECTED) {
				state = "is selected";
			} else {
				state = "is deselected";
			}
		}
	};

	class MoneyInput extends JFrame {
		private JLabel inputLabel, outputLabel, resultLabel;
		private JTextField moneyInput;

		// -----------------------------------------------------------------
		// Constructor: Sets up the main GUI components.
		// -----------------------------------------------------------------
		public MoneyInput() {
			setTitle("Money Input");
			Container contentPane = getContentPane();
			contentPane.setLayout(null);
			setLocation(150, 250);
			setSize(500, 200);
			inputLabel = new JLabel("Please enter money into the machine:");
			inputLabel.setBounds(10, 20, 265, 50);
			moneyInput = new JTextField(5);
			moneyInput.addActionListener(new TempListener());
			moneyInput.setBounds(265, 28, 120, 30);
			contentPane.add(inputLabel);
			contentPane.add(moneyInput);

			JButton okButton = new JButton("OK");
			okButton.setBounds(400, 100, 50, 50);
			Font f = new Font("Arial", Font.PLAIN, 10);
			okButton.setFont(f);
			okButton.addActionListener(new TempListener());
			contentPane.add(okButton);
			add(inputLabel);
			add(moneyInput);

			setBackground(Color.white);
		}

		// *****************************************************************
		// Represents an action listener for the temperature input field.
		// *****************************************************************
		private class TempListener implements ActionListener {
			// --------------------------------------------------------------
			// Performs the conversion when the enter key is pressed in
			// the text field.
			// --------------------------------------------------------------
			public void actionPerformed(ActionEvent event) {

				// resultLabel.setText(Integer.toString(money));
				JButton clickedButton = (JButton) event.getSource();
				JRootPane rootPane = clickedButton.getRootPane();
				Frame frame = (JFrame) rootPane.getParent();

				if (clickedButton.getText().equals("OK")) {
					holdsOne = true;
					DriverGUI d = new DriverGUI();
					DriverGUI.VendingMachineGUI v = d.new VendingMachineGUI();
					v.setVisible(true);

					String text = moneyInput.getText();

					moneyMoney = Integer.parseInt(text);

				}
			}
		}

	};

	class VendingMachineGUI extends JFrame {
		private JComboBox<String> comboBox;
		private JLabel inputLabel, outputLabel, resultLabel;
		JTextField inputLine;
		private JTextField input;

		private static final int BUTTON_WIDTH = 45;
		private static final int BUTTON_HEIGHT = 45;

		private JButton AButton;
		private JButton BButton;
		private JButton CButton;
		private JButton DButton;
		private JButton EButton;
		private JButton FButton;
		private JButton OneButton;
		private JButton TwoButton;
		private JButton ThreeButton;
		private JButton FourButton;
		private JButton FiveButton;
		private JButton SixButton;
		private JButton getChange;
		private JButton addMoney;
		private JButton Vend;

		public VendingMachineGUI() {
			setSize(700, 700);
			File file = null;

			if (onClickMachinePreferences.toLowerCase().equals("drinks")) {
				setTitle("Drinks Vending Machine");
				file = new File("data/drinks.txt");
			}
			if (onClickMachinePreferences.toLowerCase().equals("snacks")) {
				setTitle("Snacks Vending Machine");
				file = new File("data/snacks.txt");
			}
			Container contentPane = getContentPane();

			contentPane.setLayout(null);
			// JPanel comboPanel, okPanel;
			inputLabel = new JLabel("<html><br>Search for item</br></html>");
			inputLabel.setBounds(50, 25, 100, 45);
			input = new JTextField(10);
			input.addActionListener(new TempListener());
			inputLine = new JTextField();
			inputLine.setColumns(22);
			contentPane.add(inputLine);
			inputLine.setBounds(175, 37, 150, 35);
			// JLabel label1 = new JLabel ("Make a selection");
			JLabel selectionLabel = new JLabel("Make a selection: ");
			Font f = new Font("Arial", Font.PLAIN, 25);
			selectionLabel.setFont(f);
			selectionLabel.setBounds(125, 125, 250, 75);
			// label1.setText("Make a selection");
			// label1.setHorizontalTextPosition(JLabel.CENTER);
			contentPane.add(inputLabel);
			contentPane.add(input);
			contentPane.add(selectionLabel);
			AButton = new JButton("A");
			AButton.setBounds(100, 225, BUTTON_WIDTH, BUTTON_HEIGHT);
			AButton.addActionListener(new ButtonHandler());
			contentPane.add(AButton);
			BButton = new JButton("B");
			BButton.setBounds(165, 225, BUTTON_WIDTH, BUTTON_HEIGHT);
			BButton.addActionListener(new ButtonHandler());
			contentPane.add(BButton);
			CButton = new JButton("C");
			CButton.setBounds(100, 290, BUTTON_WIDTH, BUTTON_HEIGHT);
			CButton.addActionListener(new ButtonHandler());
			contentPane.add(CButton);
			DButton = new JButton("D");
			DButton.setBounds(165, 290, BUTTON_WIDTH, BUTTON_HEIGHT);
			DButton.addActionListener(new ButtonHandler());
			contentPane.add(DButton);
			EButton = new JButton("E");
			EButton.setBounds(100, 365, BUTTON_WIDTH, BUTTON_HEIGHT);
			EButton.addActionListener(new ButtonHandler());
			contentPane.add(EButton);
			FButton = new JButton("F");
			FButton.setBounds(165, 365, BUTTON_WIDTH, BUTTON_HEIGHT);
			FButton.addActionListener(new ButtonHandler());
			contentPane.add(FButton);
			OneButton = new JButton("1");
			OneButton.setBounds(250, 225, BUTTON_WIDTH, BUTTON_HEIGHT);
			OneButton.addActionListener(new ButtonHandler());
			contentPane.add(OneButton);
			TwoButton = new JButton("2");
			TwoButton.setBounds(315, 225, BUTTON_WIDTH, BUTTON_HEIGHT);
			TwoButton.addActionListener(new ButtonHandler());
			contentPane.add(TwoButton);
			ThreeButton = new JButton("3");
			ThreeButton.setBounds(250, 290, BUTTON_WIDTH, BUTTON_HEIGHT);
			ThreeButton.addActionListener(new ButtonHandler());
			contentPane.add(ThreeButton);
			FourButton = new JButton("4");
			FourButton.setBounds(315, 290, BUTTON_WIDTH, BUTTON_HEIGHT);
			FourButton.addActionListener(new ButtonHandler());
			contentPane.add(FourButton);
			FiveButton = new JButton("5");
			FiveButton.setBounds(250, 365, BUTTON_WIDTH, BUTTON_HEIGHT);
			FiveButton.addActionListener(new ButtonHandler());
			contentPane.add(FiveButton);
			SixButton = new JButton("6");
			SixButton.setBounds(315, 365, BUTTON_WIDTH, BUTTON_HEIGHT);
			SixButton.addActionListener(new ButtonHandler());
			contentPane.add(SixButton);
			getChange = new JButton("Get Change");
			getChange.setBounds(100, 590, 105, 40);
			getChange.addActionListener(new ButtonHandler());
			contentPane.add(getChange);
			addMoney = new JButton("Add Money");
			addMoney.setBounds(250, 590, 105, 40);
			addMoney.addActionListener(new ButtonHandler());
			contentPane.add(addMoney);
			Vend = new JButton("Vend!");
			Vend.setBounds(550, 590, 105, 40);
			Vend.addActionListener(new ButtonHandler());
			contentPane.add(Vend);
			JLabel itemSelection = new JLabel("Item Selection: ");
			itemSelection.setBounds(85, 455, 110, 35);
			contentPane.add(itemSelection);
			JTextField fieldSelection = new JTextField();
			JLabel moneyRemain = new JLabel("Money Remaining: ");
			moneyRemain.setBounds(85, 520, 110, 35);
			contentPane.add(moneyRemain);
			JTextField moneyLeft = new JTextField();
			moneyLeft.setText(String.format("$%d", moneyMoney));
			moneyLeft.getText();
			moneyLeft.setBounds(225, 520, 75, 35);
			contentPane.add(moneyLeft);
			// JButton okButton;
			DefaultListModel<String> model = new DefaultListModel<>();
			try {
				int i = 0;
				Scanner sc = new Scanner(file);
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					if (line.length() > 0) {
						String[] tokens = line.split(",");
						try {
							String itemDesc = tokens[0];
							Double itemPrice = Double.parseDouble(tokens[1]);
							int itemQuantity = Integer.parseInt(tokens[2]);

							Item item = new Item(itemDesc, itemPrice, itemQuantity);
							// stocksDisplay.add(item.toString());
							String display = itemCode[i]+ ": "+ item.toString();
							i++;
							model.addElement(display);
							// model.addElement("testing...");
						} catch (NumberFormatException nfe) {
							System.out.println("Bad item in file");
						}
					}
				}
				sc.close();
			} catch (FileNotFoundException e1) {
				System.out.println("No file found");
			}
			
			JList<String> list = new JList<String>(model);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setLayoutOrientation(JList.VERTICAL_WRAP);
			list.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					fixRowCountForVisibleColumns(list);
				}
			});
			JScrollPane scrollableList = new JScrollPane(list);
			scrollableList.setBounds(400, 25, 250, 425);
			scrollableList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollableList.setPreferredSize(new Dimension(230, 410));
			contentPane.add(scrollableList);

			contentPane.setBackground(Color.white);

		}

		private class TempListener implements ActionListener {
			// --------------------------------------------------------------
			// Performs the conversion when the enter key is pressed in
			// the text field.
			// --------------------------------------------------------------
			public void actionPerformed(ActionEvent event) {

				String text = input.getText();
				resultLabel.setHorizontalTextPosition(JLabel.RIGHT);
				resultLabel.setText(text);
			}
		}

		private void fixRowCountForVisibleColumns(JList list) {
			int nCols = computeVisibleColumnCount(list);
			int nItems = list.getModel().getSize();

			// Compute the number of rows that will result in the desired number of
			// columns
			if (nCols > 0) {
				int nRows = nItems / nCols;
				if (nItems % nCols > 0)
					nRows++;
				list.setVisibleRowCount(nRows);
			}
		}

		private int computeVisibleColumnCount(JList list) {
			// It's assumed here that all cells have the same width. This method
			// could be modified if this assumption is false. If there was cell
			// padding, it would have to be accounted for here as well.
			int cellWidth = list.getCellBounds(0, 0).width;
			int width = list.getVisibleRect().width;
			return width / cellWidth;
		}

	};

	public static void main(String args[]) {
		// Initialize driver object
		DriverGUI d = new DriverGUI();
		/* Output vending machine choices tab */
		DriverGUI.VendingMachinePreferences f = d.new VendingMachinePreferences();
		f.setVisible(true);

	}
}
