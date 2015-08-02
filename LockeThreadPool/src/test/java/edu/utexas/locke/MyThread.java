package test.java.edu.utexas.locke;

import main.java.edu.utexas.locke.LockeThread;

public class MyThread extends LockeThread {
	private String name;

	public MyThread(String name) {
		this.name = name;		
	}

	public void run() {
		System.out.println("Hi! My name is " + name);		
	}
}
