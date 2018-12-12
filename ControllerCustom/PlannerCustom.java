package ControllerCustom;

import java.util.Random;

import controller.Knowledge;
import controller.Planner;
import controllerPMC.prism.PMCResult;

public class PlannerCustom extends Planner {

	//Random rand = new Random(System.currentTimeMillis());

	public PlannerCustom() {
	}

	@Override
	public void run() {
		int bestIndex		= -1;
		double bestCost 	= Double.MAX_VALUE;
		double MIN_READINGS = 20;
		double MAX_ENERGY	= Double.MAX_VALUE;
	
		//analyse configuration
		for (Integer index : Knowledge.getInstance().PMCResultsMap.keySet()){
			
		}
		

	}	

}
