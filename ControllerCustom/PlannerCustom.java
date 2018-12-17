package ControllerCustom;

import controller.Knowledge;
import controller.Planner;
import controller.uuv.UUVSensor;

import java.util.List;

import ControllerCustom.Tools.*;

public class PlannerCustom extends Planner {

	public PlannerCustom() {
	}

	@Override
	public void run() {
	
		double bestUtil=-1000;
		int minHertz = 2;
		
		
		for(CustomConfig index : Knowledge.getInstance().getCustomConfigList()){
			boolean isBroken=false;
			//System.out.println(index.getSensorCost());
			if(index.getUtil()>bestUtil&& index.getSensorCost()>=minHertz){
				//System.out.println("running line 23");
				for(CustomSensor sensor : index.getSensors()){
					//System.out.println(sensor.getState());
					if(sensor.getState()==-1){
						isBroken = true;
						break;
					}
					continue;
				}
				if(!isBroken){
					bestUtil = index.getUtil();
					Knowledge.getInstance().setBestConfig(index);	
				}
			}
		}
//		Knowledge.getInstance().setUUVspeed(Knowledge.getInstance().getBestConfig().getSpeed());
//		for (UUVSensor uuvSensor : Knowledge.getInstance().sensorsMap.values()) {
//
//			List<CustomSensor> sensorList = Knowledge.getInstance().getBestConfig().getSensors();
//
//			for(CustomSensor snsrcngf : sensorList){
//				if(snsrcngf.getSensorName().equals(uuvSensor.getName())){
//					Knowledge.getInstance().setSensorState(
//							uuvSensor.getName(),
//							(int)snsrcngf.getState()
//					);
//				}
//			}
//		}
	}	
}
