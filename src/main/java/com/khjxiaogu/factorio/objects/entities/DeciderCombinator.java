package com.khjxiaogu.factorio.objects.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.BaseEntity;
import com.khjxiaogu.factorio.objects.SignalID;

// TODO: Auto-generated Javadoc
/**
 * Class DeciderCombinator.
 * represent decider combinator
 * @author khjxiaogu
 * file: DeciderCombinator.java
 * time: 2020年8月1日
 */
public class DeciderCombinator extends BaseEntity {
	private CircuitCondition cond;
	private SignalID output;
	private boolean copycount=true;
	
	/**
	 * Instantiates a new DeciderCombinator.<br>
	 *
	 * @param x the x<br>
	 * @param y the y<br>
	 */
	public DeciderCombinator(float x, float y) {
		super(x, y);
	}

	@Override
	public String getName() {
		return "decider-combinator";
	}

	/**
	 * Gets the output signal type.<br>
	 * @return output<br>
	 */
	public SignalID getOutput() {
		return output;
	}

	/**
	 * Set output signal type.<br>
	 *
	 * @param output signal to set output signal to.
	 */
	public void setOutput(SignalID output) {
		this.output = output;
	}

	/**
	 * Checks if copy count.<br>
	 *
	 * @return if is copy count,true.
	 */
	public boolean isCopycount() {
		return copycount;
	}

	/**
	 * set is copy count.
	 * when set to false, decider output constant 1
	 * else decider output count of input
	 *
	 * @param copycount if is copycount.
	 */
	public void setCopycount(boolean copycount) {
		this.copycount = copycount;
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
		dc.addProperty("copy_count_from_input",copycount);
		cont.add("decider_conditions",dc);
		return basic;
	}

	/**
	 * set decider condition.<br>
	 *
	 * @param cond condition to set
	 */
	public void setCond(CircuitCondition cond) {
		this.cond = cond;
	}

}
