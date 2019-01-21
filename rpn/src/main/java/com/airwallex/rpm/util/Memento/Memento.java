package com.airwallex.rpm.util.Memento;

import java.util.Stack;

public class Memento {
	private Stack<String> stack;

	public Memento(Stack<String> stack) {
		this.stack = stack;
	}

	public Stack<String> getStack() {
		return stack;
	}

	public void setStack(Stack<String> stack) {
		this.stack = stack;
	}
	
	
	
}
