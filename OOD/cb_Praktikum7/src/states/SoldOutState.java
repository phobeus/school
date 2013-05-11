package states;

import interfaces.GumballState;
import control.GumballMachineContext;

public class SoldOutState implements GumballState {
	GumballMachineContext gumballMachine;
		
	public SoldOutState(GumballMachineContext gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	public void insertCoin() {
		gumballMachine.setMessage("There are no Gum's left.");
	}
	
	public void ejectCoin() {
		gumballMachine.setMessage("There are no Gum's left.");
	}
	
	public void turnCrank() {
		gumballMachine.setMessage("There are no Gum's left.");
	}
	
	public void dispense() {
	}
}