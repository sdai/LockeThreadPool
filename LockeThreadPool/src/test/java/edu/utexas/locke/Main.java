package test.java.edu.utexas.locke;

import java.util.HashSet;
import java.util.Set;

import main.java.edu.utexas.locke.LockeThread;
import main.java.edu.utexas.locke.LockeThreadPool;

public class Main {

	public static void main(String[] args) {
		LockeThread thread1 = new MyThread("Bob");
		LockeThread thread2 = new MyThread("Tim");
		
		Set<LockeThread> threads = new HashSet<LockeThread>();
		threads.add(thread1);
		threads.add(thread2);
		
		int numProcesses = 1;
		LockeThreadPool threadPool = new LockeThreadPool(numProcesses);
		threadPool.submit(threads);
		
		// Hooray!

	}

}
