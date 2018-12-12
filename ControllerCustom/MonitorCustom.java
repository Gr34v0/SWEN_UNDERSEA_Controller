package ControllerCustom;

import controller.Knowledge;
import controller.Monitor;

public class MonitorCustom extends Monitor {

		public MonitorCustom() {
		}

		@Override
		public void run() {
			boolean analysisRequired = Knowledge.getInstance().systemStateChanged();
			Knowledge.getInstance().analysisRequired  = analysisRequired;
		}	

}

