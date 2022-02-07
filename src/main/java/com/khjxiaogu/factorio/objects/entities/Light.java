/**
 * Factorio composer
 * Copyright (C) 2021  khjxiaogu
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
