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
		Knowledge.getInstance().setUUVspeed(Knowledge.getInstance().getBestConfig().getSpeed());
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
		String sp = "SPEED="   + (Knowledge.getInstance().getUUVspeed());
		String s1 = "SENSOR1=" + (Knowledge.getInstance().getSensorState("SENSOR1"));
		String s2 = "SENSOR2=" + (Knowledge.getInstance().getSensorState("SENSOR2"));
		String s3 = "SENSOR3=" + (Knowledge.getInstance().getSensorState("SENSOR3"));
		command = sp +","+ s1 +","+ s2 +","+ s3;
	}	
}
