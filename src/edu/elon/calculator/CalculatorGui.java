package edu.elon.calculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorGui extends JFrame implements Observer {

  private static final int FRAME_HEIGHT = 450;
  private static final int FRAME_WIDTH = 450;

  CalculatorControllerInterface controller;
  CalculatorModelInterface model;

  private JButton[][] buttons;
  private JTextField screen;

  public CalculatorGui(CalculatorControllerInterface controller, CalculatorModelInterface model) {
	this.controller = controller;
	this.model = model;
	model.addObserver(this);
	createView();
  }

  private void createView() {
	// Create everything here
	Container c = this.getContentPane();
	JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

	buttons = new JButton[][] { 
	  	{ new JButton("7"), new JButton("8"), new JButton("9"), new JButton("/") },
		{ new JButton("4"), new JButton("5"), new JButton("6"), new JButton("*") },
		{ new JButton("1"), new JButton("2"), new JButton("3"), new JButton("-") },
		{ new JButton("0"), new JButton("."), new JButton("="), new JButton("+") }};

	for (int i = 0; i < buttons.length; i++) {
	  for (int j = 0; j < buttons[i].length; j++) {
		buttonPanel.add(buttons[i][j]);
	  }
	}

	addListeners();
	c.add(screen = new JTextField(), BorderLayout.NORTH);
	screen.setHorizontalAlignment(JTextField.RIGHT);
	screen.setFont(new Font("SansSerif", Font.PLAIN, 50));
	c.add(buttonPanel);
	this.pack();
	this.repaint();
	this.revalidate();
	this.setVisible(true);
	this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
	this.setTitle("MVC Calculator");
  }

  private void addListeners() {
	// Listener gets the button's value and passes it to the controller as a
	// string
	ActionListener listener = new ActionListener() {
	  @Override
	  public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
		  String text = e.getActionCommand();
		  controller.buttonPressed(text);
		}
	  }
	};

	for (int i = 0; i < buttons.length; i++) {
	  for (int j = 0; j < buttons[i].length; j++) {
		buttons[i][j].addActionListener(listener);
	  }
	}
  }

  @Override
  public void update(CalculatorModelInterface o) {
	Double currentValue = o.getCurrentValue();
	if (currentValue != null)
	  screen.setText("" + o.getCurrentValue());
  }

  public void setScreenText(String str) {
	this.screen.setText(str);
  }

  public void disableAllButtons() {
	for (JButton[] row : buttons) {
	  for (JButton b : row) {
		b.setEnabled(false);
	  }
	}
  }

  public void enableAllButtons() {
	for (JButton[] row : buttons) {
	  for (JButton b : row) {
		b.setEnabled(true);
	  }
	}

  }

}
