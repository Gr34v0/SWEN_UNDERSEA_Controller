package ControllerCustom;

import controller.Executor;
import controller.Knowledge;
import controller.uuv.UUVSensor;

public class ExecutorCustom extends Executor {
	
	public ExecutorCustom() {
	}

	@Override
	public void run () {
		for (UUVSensor uuvSensor : Knowledge.getInstance().sensorsMap.values())
			Knowledge.getInstance().setSensorState(uuvSensor.getName(),Knowledge.getInstance().getBestConfig().getSensors().);
	}	
}
