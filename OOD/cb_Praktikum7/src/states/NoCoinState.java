package states;

import interfaces.GumballState;
import control.GumballMachineContext;

public class NoCoinState implements GumballState {
	GumballMachineContext gumballMachine;
		
	public NoCoinState(GumballMachineContext gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	public void insertCoin() {
		gumballMachine.setMessage("You insterted a coin.");
		gumballMachine.setState(gumballMachine.getHasCoinState());
	}
	
	public void ejectCoin() {
		gumballMachine.setMessage("You haven't insertet a coin.");
	}
	
	public void turnCrank() {
		gumballMachine.setMessage("You turned, but you haven't insertet a coin.");
	}
	
	public void dispense() {
		gumballMachine.setMessage("You turned, but you haven't insertet a coin.");
	}
}