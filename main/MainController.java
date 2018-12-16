package main;

import controller.Analyser;
import controller.Controller;
import controller.Executor;
import controller.Monitor;
import controller.Planner;
import controllerPMC.AnalyserPMC;
import controllerPMC.ExecutorPMC;
import controllerPMC.MonitorPMC;
import controllerPMC.PlannerPMC;
import controllerMax.*;
import ControllerCustom.*;

public class MainController {

	public static String configFile = "resources/config.properties";	

	public static void main(String[] args) {
		//Default controller: does nothing
//	    Monitor monitor  	= new MonitorDefault();
//	    Analyser analyser	= new AnalyserDefault();
//	    Planner planner		= new PlannerDefault();
//	    Executor executor	= new ExecutorDefault();

	    //Random controller
//	    Monitor monitor  	= new MonitorRandom();
//	    Analyser analyser	= new AnalyserRandom();
//	    Planner planner		= new PlannerRandom();
//	    Executor executor	= new ExecutorRandom();


		//PMC-based controller
//	    Monitor monitor  	= new MonitorPMC();
//	    Analyser analyser	= new AnalyserPMC();
//	    Planner planner		= new PlannerPMC();
//	    Executor executor	= new ExecutorPMC();
		
//		Monitor monitor  	= new MonitorMax();
//	    Analyser analyser	= new AnalyserMax();
//	    Planner planner		= new PlannerMax();
//	    Executor executor	= new ExecutorMax();
		
		//CT-based controller
//	    Monitor monitor  	= new MonitorCT();
//	    Analyser analyser	= new AnalyserCT();
//	    Planner planner		= new PlannerCT();
//	    Executor executor	= new ExecutorCT();
		
		
		Monitor monitor  	= new MonitorCustom();
	    Analyser analyser	= new AnalyserCustom();
	    Planner planner		= new PlannerCustom();
	    Executor executor	= new ExecutorCustom();
		
		//create new controller
		Controller controller = new Controller(monitor, analyser, planner, executor);
					
		//start engine
		ControllerEngine.start(controller);
	}

}
