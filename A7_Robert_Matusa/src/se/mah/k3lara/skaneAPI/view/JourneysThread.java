package se.mah.k3lara.skaneAPI.view;
import java.util.Calendar;

public class JourneysThread extends Thread{
	private API_GUI gui;
	private boolean on = true;

	public JourneysThread(API_GUI g){
		this.gui = g;
	}

	public void run() {
		while(on){
			try{
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gui.UpdateLables();
		}

	}

}