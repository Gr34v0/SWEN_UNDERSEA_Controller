package controllerMax;

import java.util.Random;

import controller.Knowledge;
import controller.Planner;
import controllerPMC.prism.PMCResult;

public class PlannerMax extends Planner {
	
	public PlannerMax() {
	}

	@Override
	public void run() {
		int bestIndex		= -1;
		double bestCost 	= Double.MAX_VALUE;
		double MIN_READINGS = 20;
		double MAX_ENERGY	= 120;
	
		//analyse configuration
		for (Integer index : Knowledge.getInstance().PMCResultsMap.keySet()){
			PMCResult result = Knowledge.getInstance().PMCResultsMap.get(index);
			if(Knowledge.getInstance().getBattery() >= 50){
				if ( (result.getReq1Result()>MIN_READINGS) && 
					 (result.getReq2Result()<MAX_ENERGY)  &&
					 ( result.getCost() < bestCost) 
						)
				{
					System.out.println("line 30");
					bestCost 	= result.getCost();
					bestIndex	= index;
				}
			} else{
				if (result.getReq1Result()>MIN_READINGS)
				{
					bestCost 	= result.getCost();
					bestIndex	= index;
					Knowledge.getInstance().setBestIndex(bestIndex);
				}
			}
		}
		double desiredSpeed = Knowledge.getInstance().PMCResultsMap.get(bestIndex).getSpeed();
		Knowledge.getInstance().setUUVspeed(desiredSpeed);
		
		//set new sensor configuration
//		for (UUVSensor uuvSensor : Knowledge.sensorsMap.values()){
			Knowledge.getInstance().setSensorState("SENSOR1", Knowledge.getInstance().PMCResultsMap.get(bestIndex).getSensor1());
			Knowledge.getInstance().setSensorState("SENSOR2", Knowledge.getInstance().PMCResultsMap.get(bestIndex).getSensor2());
			Knowledge.getInstance().setSensorState("SENSOR3", Knowledge.getInstance().PMCResultsMap.get(bestIndex).getSensor3());
//		}
	}	

}
