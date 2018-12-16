package ControllerCustom;

import java.util.List;
import java.math.*;

import auxiliary.Utility;
import controller.Knowledge;
import controller.uuv.UUVSensor;
import controller.Analyser;
import controller.uuv.UUVSensor;
import ControllerCustom.Tools.CustomConfig;
import ControllerCustom.Tools.CustomSensor;

public class AnalyserCustom extends Analyser {

	/** Name of model file */
	String modelFileName;

	/** Name of properties file */
	String propertiesFileName;
	
	/** Model string*/
	String modelAsString;

    /** output file */
    String fileName;
        
    /** System characteristics*/
    private final int NUM_OF_SENSORS		= Utility.getProperty("SENSORS").split(",").length;
    private final int NUM_OF_SENSOR_CONFIGS	=  (int) (Math.pow(2,NUM_OF_SENSORS)); //possible sensor configurations

    
	/**
	 * Constructor
	 */
	public AnalyserCustom() {		
		
    }	
    
    
    /**
     * Run quantitative verification
     * @param parameters
     */
	public void  run(){
		Knowledge.getInstance().PMCResultsMap.clear();		
		
		//For all configurations run QV and populate RQVResultArray
		
		//TODO: come up with data to store and sort by
		
		for (int CSC=1; CSC<NUM_OF_SENSOR_CONFIGS; CSC++){
			for (int sp=10; sp<=40; sp++){

				int index 	= ((CSC-1)*21)+(sp-20);
				int totalSensorHertz=0;
				
				CustomConfig cc = new CustomConfig();
				for (UUVSensor uuvSensor : Knowledge.getInstance().sensorsMap.values()){
					
					String sensorName = uuvSensor.getName();
					double sensorRate = Knowledge.getInstance().getSensorRate(sensorName);
					double state = Knowledge.getInstance().getSensorState(sensorName);

					CustomSensor customSensor = new CustomSensor(
							sensorName,
							sensorRate,
							estimateP(sp/10.0, 5),
							state
							);
					totalSensorHertz += sensorRate;
					cc.addSensor(customSensor); 
					
					
				}

				cc.setSensorCost(totalSensorHertz);
				
				cc.setArg6_1(1);
				cc.setArg7_CSC(CSC);
				cc.setSpeed(sp/10);

				double cost = Math.pow(cc.getSensorCost(), 1.5) + Math.pow(sp/10, 2);
				double perf = cc.getSensorCost() + sp/10;

				cc.setUtil( perf/cost );
				
				//4) store configuration results
				Knowledge.getInstance().addCustomConfig(cc);
			}
		}		
		
	}

			
	/**
	 * Estimate Probability of producing a successful measurement
	 * @param speed
	 * @param alpha
	 * @return
	 */
	private static double estimateP(double speed, double alpha){
		return 100 - alpha * speed;
	}
}

