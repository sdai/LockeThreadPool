package main.java.edu.utexas.locke;
import java.util.concurrent.atomic.AtomicLong;

public class ComputationTracker {
	private static AtomicLong computationsRemaining;

	public static void initialize(long initialComputations) {
		assert (initialComputations > 0);
		computationsRemaining.set(initialComputations);
	}

	public static boolean done() {
		return computationsRemaining.get() == 0;
	}
	
	public static void increment() {
		computationsRemaining.incrementAndGet();		
	}

	public static void decrement() {
		assert (computationsRemaining.get() > 0);
		computationsRemaining.decrementAndGet();		
	}
}