package control;


import interfaces.GumballState;
import states.*;

public class GumballMachineContext implements GumballState {
	GumballState soldOutState, noCoinState, hasCoinState, soldState, state;
	int nrOfGumBalls = 0;
	String message;
	
	public GumballMachineContext(int nrOfGumBalls) {
		this.soldOutState = new SoldOutState(this);
		this.noCoinState = new NoCoinState(this);
		this.hasCoinState= new HasCoinState(this);
		this.soldState= new SoldState(this);
		this.nrOfGumBalls = nrOfGumBalls;
		this.state = (nrOfGumBalls >0) ? noCoinState : soldOutState;
	}
	
	public void insertCoin() {
		state.insertCoin();
	}
	
	public void ejectCoin() {
		state.ejectCoin();
	}
	
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	public void dispense() {
		message="a gum is rolling out...";
		nrOfGumBalls--;
		if(nrOfGumBalls <= 0) { 
			setState(soldOutState);
		}
	}
	
	public void setState(GumballState state) {
		this.state = state;
	}
	
	public GumballState getCurrentState() {
		return state;
	}
	
	public GumballState getHasCoinState() {
		return hasCoinState;
	}
	
	public GumballState getNoCoinState() {
		return noCoinState;
	}
	
	public GumballState getSoldState() {
		return soldState;
	}
	
	public GumballState getSoldOutState() {
		return soldOutState;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
		
	}
	
	public int getGumsAvailability() {
		return nrOfGumBalls;
	}
	
}
//end of class