package states;

import interfaces.GumballState;
import control.GumballMachineContext;

public class HasCoinState implements GumballState {
	GumballMachineContext gumballMachine;
		
	public HasCoinState(GumballMachineContext gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	public void insertCoin() {
		gumballMachine.setMessage("You already inserted a coin.");		
	}
	
	public void ejectCoin() {
		gumballMachine.setMessage("You received your coin back.");
		gumballMachine.setState(gumballMachine.getNoCoinState());
	}
	
	public void turnCrank() {
		gumballMachine.setState(gumballMachine.getSoldState());
	}
	
	public void dispense() {
	}
}