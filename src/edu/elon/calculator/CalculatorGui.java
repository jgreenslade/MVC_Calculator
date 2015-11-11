package edu.elon.calculator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorGui extends JFrame implements Observer{
	
	CalculatorControllerInterface controller;
	CalculatorModelInterface model;
	
	private JButton[][] buttons;
	
	public CalculatorGui(CalculatorControllerInterface controller, CalculatorModelInterface model) {
		this.controller = controller;
		this.model = model;
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
				{ new JButton("0"), new JButton("."), new JButton("="), new JButton("+") } };

		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttonPanel.add(buttons[i][j]);
			}
		}
		
		addListeners();
		
		c.add(new JTextField(), BorderLayout.NORTH);
		c.add(buttonPanel);
		this.pack();
		this.repaint();
		this.revalidate();
		this.setVisible(true);
	}
	
	private void addListeners() {
		// Listener gets the button's value and passes it to the controller as a string
		 ActionListener listener = new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            if (e.getSource() instanceof JButton) {
		            	
		                String text = e.getActionCommand();
		                //System.out.println("run");
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
		
	}

}
