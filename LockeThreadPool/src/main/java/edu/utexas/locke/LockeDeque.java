package main.java.edu.utexas.locke;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

// Sierra
public class LockeDeque {
	
	private int size;
	private volatile Bottom bottom;
	private AtomicReference<Top> top;

	
	public LockeDeque() {
		bottom = new Bottom(new Node(size), size);
		top = new AtomicReference<Top>(new Top(0, bottom.node, 0));
	}
	
	
	public LockeThread popBottom() {

	}




	//Steal from the top
	public LockeThread popTop() {

	}
	
	private static class Node {
		final AtomicReferenceArray<Object> array;
		volatile Node pre, next;

		Node(final int arraySize) {
			array = new AtomicReferenceArray<Object>(arraySize);
		}
	}
	
	private static class Bottom {
		final Node node;
		final int index;

		Bottom (final Node node, final int index) {
			this.node = node;
			this.index = index;
		}
	}

	private static class Top {
		final int tag;
		final Node node;
		final int index;

		Top (final int tag, final Node node, final int index) {
			this.tag = tag;
			this.node = node;
			this.index = index;
		}
	}
	


}
	