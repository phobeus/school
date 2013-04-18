package measure;

import sortModes.Quick;

public class AirPressure extends Measurements {
	
	public AirPressure(double[] data) {
		super(data, new Quick());		
	}

}
