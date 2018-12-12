package controllerMax;

import controller.Knowledge;
import controller.Monitor;

public class MonitorMax extends Monitor {

		public MonitorMax() {
		}

		@Override
		public void run() {
			boolean analysisRequired = Knowledge.getInstance().systemStateChanged();
			Knowledge.getInstance().analysisRequired  = analysisRequired;
		}	

}

