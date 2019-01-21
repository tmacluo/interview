package com.airwallex.rpm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.airwallex.rpm.operator.NoramlOperatorFactory;
import com.airwallex.rpm.operator.Operator;
import com.airwallex.rpm.util.CalculatorException;
import com.airwallex.rpm.util.CalculatorUtil;
import com.airwallex.rpm.util.Memento.Memento;
import com.airwallex.rpm.util.Memento.MementoCaretaker;

public class RPNCalculator {
	
	private Stack<String> calcStack = new Stack<String>();
	private List<String> inputList = new ArrayList<String>();
	private List<Memento> undoList = new ArrayList<Memento>();
	private MementoCaretaker mc = new MementoCaretaker();
	
	public BigDecimal calc(String inputStr){
		inputList.clear();
		parseInputData(inputStr);
		for(String str : inputList){
			if(CalculatorUtil.isDecimal(str)){
				calcStack.push(str);
				//createMemento(calcStack);
				mc.createMemento(calcStack);
			}else if(CalculatorUtil.isOperator(str)){
				// at least two numbers required to perform operations.
				//if(calcStack.size() <2){
				//	throw new CalculatorException("insucient parameters");
				//}
				if("clear".equals(str)){
					calcStack.clear();
					inputList.clear();
				}else if("undo".equals(str)){
					calcStack = mc.getMemento().getStack();
				}else if("sqrt".equals(str)){
					double result = Math.sqrt(Double.parseDouble(calcStack.pop()));
					calcStack.push(String.valueOf(result));
					mc.createMemento(calcStack);
				}
				else{
					Operator operator = new NoramlOperatorFactory().getOperator(str);
					BigDecimal result = operator.calc(BigDecimal.valueOf(Double.parseDouble(calcStack.pop())), BigDecimal.valueOf(Double.parseDouble(calcStack.pop())));
					calcStack.push(String.valueOf(result));
					mc.createMemento(calcStack);
				}
			}else{
				throw new IllegalArgumentException("Ilegal input parameter:" + str);
			}
		}
		
	/*	inputList.stream().forEach(str -> {
			if(CalculatorUtil.isDecimal(str)){
				calcStack.push(str);
			}else if(CalculatorUtil.isOperator(str)){
				if(calcStack.size() <2){
					throw new CalculatorException("insucient parameters");
				}
				Operator operator = new NoramlOperatorFactory().getOperator(str);
				BigDecimal result = operator.calc(BigDecimal.valueOf(Double.parseDouble(calcStack.pop())), BigDecimal.valueOf(Double.parseDouble(calcStack.pop())));
				calcStack.push(String.valueOf(result));
			}else{
				throw new IllegalArgumentException("Ilegal input parameter:" + str);
			}
			
		});*/
		System.out.println("Memento index: "+ mc.getMementoSize());
		System.out.print("Stack: ");
		calcStack.stream().forEach(result -> System.out.print(result + " "));
		//System.out.println(calcStack.pop());
		return null;
		
	}
	
	public void createMemento(Stack<String> stack){
		Stack mementoStack = new Stack<String>();
		mementoStack.addAll(stack);
		undoList.add(new Memento(mementoStack));
		
	}
	
	public void initStack(String value){
		
	}
	
	
	
	/*public boolean isOperator(String str) {//
		if (str.matches("[\\+\\-\\*\\/\\sqrt\\undo\\clear]")) {
			return true;
		}
		return false;
	}*/
	
	public void parseInputData(String inputStr){
		StringTokenizer stInput = new StringTokenizer(inputStr);
		while(stInput.hasMoreTokens()){
			inputList.add(stInput.nextToken());
		}
	}
	
	/*public static void main(String[] args) {
		RPNCalculator rpmCalculator = new RPNCalculator();
		
		System.out.println(rpmCalculator.isDecimal("123"));
		System.out.println(rpmCalculator.isDecimal("12.3"));
		System.out.println(rpmCalculator.isDecimal("12.33"));
		System.out.println(rpmCalculator.isDecimal("12.33333333333333"));
		
	}*/
	
	public static void main(String[] args) {
		RPNCalculator rpmCalculator = new RPNCalculator();
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()){
			String inputStr = input.nextLine();
			rpmCalculator.calc(inputStr);
			System.out.println();
			
		}
		
	}
}
