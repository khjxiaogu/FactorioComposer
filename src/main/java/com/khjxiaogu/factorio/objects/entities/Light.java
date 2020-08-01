package com.khjxiaogu.factorio.objects.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.BaseEntity;

// TODO: Auto-generated Javadoc
/**
 * Class Light.
 * represent small lamp
 * @author khjxiaogu
 * file: Light.java
 * time: 2020年8月1日
 */
public class Light extends BaseEntity {
	private CircuitCondition cond;
	private boolean useColor=false;
	
	/**
	 * Instantiates a new Light.<br>
	 *
	 * @param x the x<br>
	 * @param y the y<br>
	 */
	public Light(float x, float y) {
		super(x, y);
	}
	@Override
	public String getName() {
		return "small-lamp";
	}

	@Override
	public int getPortCount() {
		return 1;
	}

	@Override
	protected JsonElement Serialize(JsonObject basic) {
		JsonObject co=new JsonObject();
		if(cond!=null)
			co.add("circuit_condition",cond.Serialize());
		co.addProperty("use_colors",useColor);
		basic.add("control_behavior", co);
		return basic;
	}

	/**
	 * Checks if use color.<br>
	 *
	 * @return if use color,true.
	 */
	public boolean isUseColor() {
		return useColor;
	}

	/**
	 * set use color flag.<br>
	 *
	 * @param useColor value to set use color to.
	 */
	public void setUseColor(boolean useColor) {
		this.useColor = useColor;
	}

	/**
	 * set activate condition.<br>
	 *
	 * @param cond condition to set
	 */
	public void setCond(CircuitCondition cond) {
		this.cond = cond;
	}

}
