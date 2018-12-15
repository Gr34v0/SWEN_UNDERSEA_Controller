package ControllerCustom.Tools;

import java.util.List;

public class CustomConfig {

	
	List<CustomSensor> sensorRates;
	
	int mysteryArg6_1;
	int mysteryArg7_CSC;
	int mysteryArg8_SPover10;
	double cost;
	double util;
	
	
	public CustomConfig(){
		
	}
	
	public void addSensor(CustomSensor sensor){
		sensorRates.add(sensor);
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
	
	public void setArg8_SPover10(int i){
		mysteryArg8_SPover10 = i;
	}
	
	public void setUtil(double i){
		util = i;
	}
	
}
