package com.airwallex.rpm.operator;

public class NoramlOperatorFactory{
		public Operator getOperator(String operator) {
			if ("+".equals(operator)) {
				return new AddOperator();
			} else if ("-".equals(operator)) {
				return new SubtractOperator();
			} else if ("*".equals(operator)) {
				return new MultiplyOperator();
			} else if ("/".equals(operator)) {
				return new DivideOperator();
			}
			return null;
		}
}
