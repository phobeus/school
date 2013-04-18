package measure;

import sortModes.Shell;


public class TestMeasurements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Temperature temperatures = new Temperature(Measurements.createRandomData(24, -10.0, 40.0));
		System.out.println("Temperatur ");
		System.out.println("Rohdaten:   "+ temperatures);
		System.out.println("Mittelwert: "+ temperatures.average());
		System.out.println("Minimum:    "+ temperatures.min());
		System.out.println("Maximum:    "+ temperatures.max());
		temperatures.process();
		System.out.println("Verarbeitet:"+ temperatures);

		AirPressure airpressure = new AirPressure(Measurements.createRandomData(24, 950.0, 1050.));
		System.out.println("Luftdruck ");
		System.out.println("Rohdaten:   "+ airpressure);
		System.out.println("Mittelwert: "+ airpressure.average());
		System.out.println("Minimum:    "+ airpressure.min());
		System.out.println("Maximum:    "+ airpressure.max());
		airpressure.process();
		System.out.println("Verarbeitet:"+ airpressure);
		
		Measurements something = new Measurements(Measurements.createRandomData(24, 100.0, 35.0), new Shell());
		System.out.println("Something ");
		System.out.println("Rohdaten:   "+ something);
		System.out.println("Mittelwert: "+ something.average());
		System.out.println("Minimum:    "+ something.min());
		System.out.println("Maximum:    "+ something.max());
		something.process();
		System.out.println("Verarbeitet:"+ something);
		
	}

}
