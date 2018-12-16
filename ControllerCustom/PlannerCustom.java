package ControllerCustom;

import controller.Knowledge;
import controller.Planner;
import ControllerCustom.Tools.*;

public class PlannerCustom extends Planner {

	public PlannerCustom() {
	}

	@Override
	public void run() {
		double bestUtil=-1000000000;
		int minHertz = 1;
	
		for(CustomConfig index : Knowledge.getInstance().getCustomConfigList()){
			System.out.println(index.getSensorCost());
			if(index.getUtil()>bestUtil&& index.getSensorCost()>=minHertz){
				for(CustomSensor sensor : index.getSensors()){
					//System.out.println(sensor.getState());
					if(sensor.getState()==-1){
						break;
					}
				}
				continue;
			}
			bestUtil = index.getUtil();
			Knowledge.getInstance().setBestConfig(index);
		}
	}	
}
