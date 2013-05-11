package states;

import interfaces.GumballState;
import control.GumballMachineContext;

public class SoldState implements GumballState {
	GumballMachineContext gumballMachine;
		
	public SoldState(GumballMachineContext gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	public void insertCoin() {
	}
	
	public void ejectCoin() {
	}
	
	public void turnCrank() {
	}
	
	public void dispense() {
		gumballMachine.setState(gumballMachine.getNoCoinState());
		gumballMachine.dispense();
	}
}