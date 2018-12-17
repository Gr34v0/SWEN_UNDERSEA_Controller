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
		double MAX_ENERGY	= Double.MAX_VALUE;
	
		//analyse configuration
		for (Integer index : Knowledge.getInstance().PMCResultsMap.keySet()){
			PMCResult result = Knowledge.getInstance().PMCResultsMap.get(index);
			if(Knowledge.getInstance().getBattery() >= 200){
				if ( (result.getReq1Result()>MIN_READINGS) && 
					 (result.getReq2Result()<MAX_ENERGY)  &&
					 ( result.getCost() < bestCost) 
						)
				{
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
	}	

}
