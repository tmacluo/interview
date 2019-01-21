package com.airwallex.rpm.operator;

import java.math.BigDecimal;

public class AddOperator implements Operator{

	public BigDecimal calc(BigDecimal a, BigDecimal b) {
		return b.add(a);
	}

}
