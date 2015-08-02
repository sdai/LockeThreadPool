package main.java.edu.utexas.locke;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SynchronizationOperation {
	enum Type {
		TERMINATE,
		BLOCK,
		FORK,
		JOIN
	};
	
	Type type;
	List<LockeThread> readyThreads;
	
	public SynchronizationOperation(Type type) {
		this.type = type;
		this.readyThreads = new ArrayList<LockeThread>();
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<LockeThread> getReadyThreads() {
		return readyThreads;
	}

	public void addReadyThread(LockeThread readyThread) {
		this.readyThreads.add(readyThread);
	}

	public void addReadyThreads(Collection<? extends LockeThread> readyThreads) {
		for (LockeThread readyThread : readyThreads) {
			addReadyThread(readyThread);
		}
	}
}
