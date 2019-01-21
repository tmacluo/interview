package com.airwallex.rpm.operator;

import java.math.BigDecimal;

public interface Operator {
	BigDecimal calc(BigDecimal a, BigDecimal b);
	
	default void operator(){
		
	}
	
	static void test(){
		
	}
}
