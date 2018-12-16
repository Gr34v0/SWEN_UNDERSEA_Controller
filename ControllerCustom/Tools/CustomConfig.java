package ControllerCustom.Tools;

import java.util.ArrayList;
import java.util.List;

public class CustomConfig {

	
	List<CustomSensor> sensors = new ArrayList<CustomSensor>();
	
	int mysteryArg6_1;
	int mysteryArg7_CSC;
	int speed;
	double cost;
	double util;
	
	
	public CustomConfig(){
		
	}

	
	public void addSensor(CustomSensor sensor){
		sensors.add(sensor);
	}


	public void setSensorCost(double newcost){
		cost = newcost;
	}

	public double getSensorCost(){
		return cost;
	}

	
	public void setArg6_1(int i){
		mysteryArg6_1 = i;
	}
	
	public void setArg7_CSC(int i){
		mysteryArg7_CSC = i;
	}
	
	public void setSpeed(int i){
		speed = i;
	}
	
	public int getSpeed(){
		return speed;
	}
	
	public void setUtil(double i){
		util = i;
	}
	public double getUtil(){
		return util;
	}
	public List<CustomSensor> getSensors(){
		return sensors;
	}
	
}
