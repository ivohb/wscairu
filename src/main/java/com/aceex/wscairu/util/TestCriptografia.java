package com.aceex.wscairu.util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestCriptografia {

	public static void main(String[] args) {
		 String senha = "Tray@123";
	        System.out.println(Criptografia.criptografar(senha));

	        //new TestCriptografia().tempo();
	}

	private void tempo() {
		int minuto = 1;
		
		final long TEMPO = ((1000 * minuto ) * 60);
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() { 
				System.out.println("Executou em "+new Date());
			}
		};

		timer.scheduleAtFixedRate(timerTask, TEMPO, TEMPO);
	}
		
	

}
