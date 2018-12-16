package ControllerCustom;

import controller.Executor;
import controller.Knowledge;
import controller.uuv.UUVSensor;

public class ExecutorCustom extends Executor {
	
	public ExecutorCustom() {
	}

	@Override
	public void run () {
		for (UUVSensor uuvSensor : Knowledge.getInstance().sensorsMap.values()) {

			ArrayList<SensorConfig> sensorList = Knowledge.getInstance().getBestConfig().getSensors();

			for(SensorConfig snsrcngf : sensorList){
				if(snsrcngf.getSensorName().equals(uuvSensor.getName())){
					Knowledge.getInstance().setSensorState(
							uuvSensor.getName(),
							snsrcngf.getState()
					);
				}
			});
		}
	}	
}
