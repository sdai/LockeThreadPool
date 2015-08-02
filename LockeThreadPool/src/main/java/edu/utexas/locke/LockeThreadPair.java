package main.java.edu.utexas.locke;

public class LockeThreadPair {
	
	private LockeThread firstChild;
	private LockeThread secondChild;

	public LockeThreadPair(LockeThread firstChild, LockeThread secondChild) {
		this.firstChild = firstChild;
		this.secondChild = secondChild;
	}

	public LockeThread getFirstChild() {
		return firstChild;
	}

	public LockeThread getSecondChild() {
		return secondChild;
	}

}