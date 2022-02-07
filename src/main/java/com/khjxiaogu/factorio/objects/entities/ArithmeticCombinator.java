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
