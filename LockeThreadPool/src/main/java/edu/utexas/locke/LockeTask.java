package main.java.edu.utexas.locke;

public abstract class LockeTask<T> extends LockeThread {
	private T value;

	protected abstract T compute();

	// Clients should not override this method!
	@Override
	public void run() {
		value = compute();
	}

	public T get() {
        join();
		return value;
	}
}