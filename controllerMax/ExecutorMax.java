package controllerMax;

import controller.Executor;
import controller.Knowledge;

public class ExecutorMax extends Executor {
	
	public ExecutorMax() {
	}

	@Override
	public void run () {		
		
//		int bestIndex = Knowledge.getInstance().getBestIndex();
//		
//		//set new speed
//		double desiredSpeed = Knowledge.getInstance().PMCResultsMap.get(bestIndex).getSpeed();
//		Knowledge.getInstance().setUUVspeed(desiredSpeed);
//		
//		//set new sensor configuration
////				for (UUVSensor uuvSensor : Knowledge.sensorsMap.values()){
//			Knowledge.getInstance().setSensorState("SENSOR1", Knowledge.getInstance().PMCResultsMap.get(bestIndex).getSensor1());
//			Knowledge.getInstance().setSensorState("SENSOR2", Knowledge.getInstance().PMCResultsMap.get(bestIndex).getSensor2());
//			Knowledge.getInstance().setSensorState("SENSOR3", Knowledge.getInstance().PMCResultsMap.get(bestIndex).getSensor3());
////				}		
		
		//construct command
		String sp = "SPEED="   + (Knowledge.getInstance().getUUVspeed());
		String s1 = "SENSOR1=" + (Knowledge.getInstance().getSensorState("SENSOR1"));
		String s2 = "SENSOR2=" + (Knowledge.getInstance().getSensorState("SENSOR2"));
		String s3 = "SENSOR3=" + (Knowledge.getInstance().getSensorState("SENSOR3"));
		command = sp +","+ s1 +","+ s2 +","+ s3;
//		System.out.println(command);
	}	
}
