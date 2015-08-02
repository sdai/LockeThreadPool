package main.java.edu.utexas.locke;

import org.apache.commons.javaflow.Continuation;

// Vince
public class LockeThread implements Runnable {
		
	private Runnable target;
	private Continuation continuation;
	
	public LockeThread() {
		this.target = null;
		this.continuation = null;
	}
	
	public LockeThread(Runnable target) {
		this.target = target;
	}
	
	public void run() {
		if (this.target != null) {
			this.target.run();
		}
	}

	// package-private because Process needs to call this, but users should not
	SynchronizationOperation execute() {
		if (continuation == null) {
			continuation = Continuation.startWith(this);
		} else {
			continuation = Continuation.continueWith(continuation);
		}
		
		if (continuation == null) {
			return null;
		} else {
			return (SynchronizationOperation) continuation.value();
		}
	}
	
	
}