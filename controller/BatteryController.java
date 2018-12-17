package controller;

import java.util.TimerTask;
import java.lang.InterruptedException;

public class BatteryController extends TimerTask {
	
	private int MAX_LIFE = 200;
	private int total;
	
	@Override
	public void run() {

		total = 0;
		
		while(total < MAX_LIFE)
		{
			total++;
			try{
			Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	
	public int getTotal(){
		return total;
	}

}
