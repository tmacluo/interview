package com.airwallex.rpm.util.Memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MementoCaretaker {
	private int i = -1;
	private List<Memento> undoList = new ArrayList<Memento>();
	
	public int getMementoSize(){
		return i;
	}
	public void createMemento(Stack<String> stack){
		Stack mementoStack = new Stack<String>();
		mementoStack.addAll(stack);
		undoList.add(new Memento(mementoStack));
		i++;
	}
	
	public Memento getMemento(){
		undoList.remove(i);
		i--;
		if(i <= -1){
			return new Memento(new Stack<String>());
		}
		return undoList.get(i);
	}
	
	
	
}
