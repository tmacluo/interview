package com.airwallex.rpm.operator;

import java.math.BigDecimal;

public class DivideOperator implements Operator{

	public BigDecimal calc(BigDecimal a, BigDecimal b) {
		return b.divide(a);
	}

}
