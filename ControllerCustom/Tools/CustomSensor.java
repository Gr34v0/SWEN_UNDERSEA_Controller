package ControllerCustom.Tools;

public class CustomSensor {
	
	String sensorName;
	double updateRate;
	double sensorP;
	double state;
	
	public CustomSensor(String name, double rate, double p, double s){
		sensorName = name;
		updateRate = rate;
		sensorP = p;
		state = s;
	}
	public double getState(){
		return state;
	}

	public String getSensorName(){
		return sensorName;
	}

}
