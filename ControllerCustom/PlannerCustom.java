package ControllerCustom;

import controller.Knowledge;
import controller.Planner;
import ControllerCustom.Tools.*;

public class PlannerCustom extends Planner {

	public PlannerCustom() {
	}

	@Override
	public void run() {
		double bestUtil=0;
		CustomConfig bestConfig;
		
	
		for(CustomConfig index : Knowledge.getInstance().getCustomConfigList()){
			if(index.getUtil()>bestUtil){
				bestUtil = index.getUtil();
				bestConfig = index;
			}

		}
			
		

	}	

}
