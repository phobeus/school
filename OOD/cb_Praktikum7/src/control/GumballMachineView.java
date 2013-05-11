package control;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import states.HasCoinState;
import states.NoCoinState;

@SuppressWarnings("serial")
public class GumballMachineView extends JFrame implements ActionListener {

	private JLabel stateLabel;
	private JLabel messageLabel;

	private JButton insertCoin;
	private JButton ejectCoin;
	private JButton turnCrank;

	private JPanel panel;

	GumballMachineContext context;

	public static void main(String args[]) {
		GumballMachineView view = new GumballMachineView();
	}

	public GumballMachineView() {
		context = new GumballMachineContext(5);
		context.setMessage("");
		this.setLayout(new BorderLayout());
		stateLabel = new JLabel();
		this.add(stateLabel, BorderLayout.NORTH);

		panel = new JPanel();

		insertCoin = new JButton("Insert Coin");
		insertCoin.addActionListener(this);
		panel.add(insertCoin);
		ejectCoin = new JButton("Eject Coin");
		ejectCoin.addActionListener(this);
		panel.add(ejectCoin);
		turnCrank = new JButton("Turn Crank");
		turnCrank.addActionListener(this);
		panel.add(turnCrank);

		insertCoin.setForeground(Color.RED);

		this.add(panel, BorderLayout.CENTER);

		messageLabel = new JLabel(" ");
		this.add(messageLabel, BorderLayout.SOUTH);

		this.setSize(600, 125);
		this.setVisible(true);
		updateGUI();
	}

	public void updateGUI() {
		stateLabel.setText("State: " + context.getCurrentState().toString());
		messageLabel.setText(context.getMessage() + " There are "
				+ context.getGumsAvailability() + " Gums available.");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(insertCoin))
			context.insertCoin();

		if (e.getSource().equals(ejectCoin))
			context.ejectCoin();
		if (e.getSource().equals(turnCrank))
			context.turnCrank();
		colorButton();
		updateGUI();
	}

	private void colorButton() {
		if (context.getCurrentState().equals(context.getNoCoinState())) {
			insertCoin.setForeground(Color.RED);
			ejectCoin.setForeground(Color.BLACK);
			turnCrank.setForeground(Color.BLACK);

		} else if (context.getCurrentState().equals(context.getHasCoinState())) {
			ejectCoin.setForeground(Color.RED);
			turnCrank.setForeground(Color.RED);
			insertCoin.setForeground(Color.BLACK);
		}

		else if (context.getCurrentState().equals(context.getSoldOutState())) {
			insertCoin.setForeground(Color.BLACK);
			ejectCoin.setForeground(Color.BLACK);
			turnCrank.setForeground(Color.BLACK);
		}

	}

}
