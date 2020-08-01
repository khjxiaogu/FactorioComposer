package com.khjxiaogu.factorio.objects.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.SignalID;

// TODO: Auto-generated Javadoc
/**
 * Class ArithmeticCondition.
 * Condition for ArithmeticCombinator
 * @author khjxiaogu
 * file: ArithmeticCondition.java
 * time: 2020年8月1日
 */
public class ArithmeticCondition extends CircuitCondition {
	
	/**
	 * Create condition with signal-constant operate
	 *
	 * @param signal the signal<br>
	 * @param constant the constant<br>
	 * @param operator the operator<br>
	 */
	public ArithmeticCondition(SignalID signal, int constant, String operator) {
		super(signal, constant, operator);
	}
	
	/**
	 * Create condition with constant-signal operate
	 * 
	 * @param constant the constant<br>
	 * @param signal the signal<br>
	 * @param operator the operator<br>
	 */
	public ArithmeticCondition(int constant, SignalID signal, String operator) {
		super(constant, signal, operator);
	}
	
	/**
	 * Create condition with signal-signal operate
	 *
	 * @param signal1 the first signal<br>
	 * @param signal2 the second signal<br>
	 * @param operator the operator<br>
	 */
	public ArithmeticCondition(SignalID signal1, SignalID signal2, String operator) {
		super(signal1, signal2, operator);
	}
	
	@Override
	public JsonElement Serialize() {
		JsonObject jo=new JsonObject();
		jo.addProperty("operation", comparator);
		if(signal1!=null) {
			jo.add("first_signal",signal1.Serialize());
		}else {
			jo.addProperty("constant",constant);
		}
		if(signal2!=null) {
			jo.add("second_signal",signal2.Serialize());
		}else {
			jo.addProperty("constant",constant);
		}
		return jo;
	}
}
