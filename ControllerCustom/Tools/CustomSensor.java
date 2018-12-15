package ControllerCustom.Tools;

public class CustomSensor {
	
	String sensorName;
	double updateRate;
	double sensorP;
	
	public CustomSensor(String name, double rate, double p){
		sensorName = name;
		updateRate = rate;
		sensorP = p;
	}

}
