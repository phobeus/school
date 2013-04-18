package measure;

import sortModes.Bubble;

public class Temperature extends Measurements {

	public Temperature(double[] data) {
		super(data, new Bubble());		
	}
}
