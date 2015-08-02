 package main.java.edu.utexas.locke;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// Sierra
public class LockeThreadPool {

	// @TODO: When the initial set of LockeThreads are added to
	// the LockeThreadPool, we need to call 
	// ComputationTracker.initialize(numLockeThreads);
	// This will allow us to keep track of when all LockeThreads
	// have completed.
	
	//To create multiple processes and their associated serial machines, a program instantiates 
	// an object of type HoodParMach Ñ a Òparallel machine.Ó 
	// The HoodParMach constructor takes an integer argument P . 
	// It creates P serial machines, and it forks P processes. 
	// Initially, the P processes just park on a condition variable. 
	// After creating the parallel machine and one or more threads, 
	// the program calls the HoodParMach runScheduler method. 
	// The P processes are released from the condition variable, 
	// and they begin executing the scheduling loop, as described in the next section.
	// When the scheduling loop terminates, they repark and runScheduler returns.
	// Member Variables
	//  startExecution (condition variable)
	// Methods
	//void runScheduler()

	Set<LockeProcess> processes;

	public LockeThreadPool(int numProcesses) {
		processes = new HashSet<LockeProcess>();
		for (int i = 0; i < numProcesses; i++) {
			LockeProcess process = new LockeProcess(startSemaphore);
			process.start();
			processes.add(process);
		}
	}

	public void submit(Collection<LockeThread> threads) {
		for (LockeThread thread : threads) {
			getRandomProcess().submit(thread);
		}

		startSemaphore.release(processes.size());
	}

	public <T> T invoke(LockeTask<T> task) {
		return getRandomProcess().invokeTask(task);
	}

	public static LockeProcess getRandomProcess() {
		return null;
	}
}