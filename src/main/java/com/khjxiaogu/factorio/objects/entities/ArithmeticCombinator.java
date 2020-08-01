package com.khjxiaogu.factorio.objects.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.BaseEntity;
import com.khjxiaogu.factorio.objects.SignalID;

// TODO: Auto-generated Javadoc
/**
 * Class ArithmeticCombinator.
 * represents an Arithmetic Combinator.
 * @author khjxiaogu
 * file: ArithmeticCombinator.java
 * time: 2020年8月1日
 */
public class ArithmeticCombinator extends BaseEntity {
	
	private ArithmeticCondition cond;
	private SignalID output;
	
	/**
	 * Instantiates a new ArithmeticCombinator.<br>
	 *
	 * @param x the location x<br>
	 * @param y the location y<br>
	 */
	public ArithmeticCombinator(float x, float y) {
		super(x, y);
	}
	
	@Override
	public String getName() {
		return "arithmetic-combinator";
	}

	/**
	 * Gets the output.<br>
	 *
	 * @return output<br>
	 */
	public SignalID getOutput() {
		return output;
	}

	/**
	 * set output signal.<br>
	 *
	 * @param output signal to set output to.
	 */
	public void setOutput(SignalID output) {
		this.output = output;
	}
	@Override
	public int getPortCount() {
		return 2;
	}

	@Override
	protected JsonElement Serialize(JsonObject basic) {
		JsonObject cont=new JsonObject();
		basic.add("control_behavior",cont);
		JsonObject dc=cond.Serialize().getAsJsonObject();
		if(output!=null)
		dc.add("output_signal", output.Serialize());
		cont.add("arithmetic_conditions",dc);
		return basic;
	}

	/**
	 * set condition.<br>
	 *
	 * @param cond value to set condition to.
	 */
	public void setCond(ArithmeticCondition cond) {
		this.cond = cond;
	}
}
