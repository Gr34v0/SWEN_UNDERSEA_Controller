package ControllerCustom;

import controller.Knowledge;
import controller.Planner;
import ControllerCustom.Tools.*;

public class PlannerCustom extends Planner {

	public PlannerCustom() {
	}

	@Override
	public void run() {
		double bestUtil=-1;
	
		for(CustomConfig index : Knowledge.getInstance().getCustomConfigList()){
			if(index.getUtil()>bestUtil){
				for(CustomSensor sensor : index.getSensors()){
					System.out.println(sensor.getState());
					if(sensor.getState()!=-1){
						bestUtil = index.getUtil();
						Knowledge.getInstance().setBestConfig(index);
					}
				}
			}

		}
			
		

	}	

}
