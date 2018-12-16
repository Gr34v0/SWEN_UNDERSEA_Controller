package ControllerCustom;

import java.util.List;
import java.util.ArrayList;

import controller.Executor;
import controller.Knowledge;
import controller.uuv.UUVSensor;
import ControllerCustom.Tools.*;

public class ExecutorCustom extends Executor {
	
	public ExecutorCustom() {
	}

	@Override
	public void run () {
		for (UUVSensor uuvSensor : Knowledge.getInstance().sensorsMap.values()) {

			List<CustomSensor> sensorList = Knowledge.getInstance().getBestConfig().getSensors();

			for(CustomSensor snsrcngf : sensorList){
				if(snsrcngf.getSensorName().equals(uuvSensor.getName())){
					Knowledge.getInstance().setSensorState(
							uuvSensor.getName(),
							(int)snsrcngf.getState()
					);
				}
			}
		}
	}	
}
