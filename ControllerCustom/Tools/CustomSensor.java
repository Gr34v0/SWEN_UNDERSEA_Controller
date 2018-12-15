package ControllerCustom.Tools;

public class CustomSensor {
	
	String sensorName;
	double updateRate;
	double sensorP;
	int state;
	
	public CustomSensor(String name, double rate, double p, int s){
		sensorName = name;
		updateRate = rate;
		sensorP = p;
		state = s;
	}

}
