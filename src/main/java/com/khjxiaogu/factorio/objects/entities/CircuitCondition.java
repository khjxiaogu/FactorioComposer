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
// TODO: Auto-generated Javadoc
import com.khjxiaogu.factorio.objects.FsonSerializable;
import com.khjxiaogu.factorio.objects.SignalID;

// TODO: Auto-generated Javadoc
/**
 * Class CircuitCondition.
 * represent circuit condition.
 * @author khjxiaogu
 * file: CircuitCondition.java
 * time: 2020年8月1日
 */
//{"first_signal":{"type":"virtual","name":"signal-T"},"constant":2,"comparator":"="}
public class CircuitCondition implements FsonSerializable {
	protected SignalID signal1=null;
	protected SignalID signal2=null;
	protected int constant=0;
	protected String comparator=">";

	/**
	 * Create condition with signal-constant compare
	 * @param signal the signal<br>
	 * @param constant the constant<br>
	 * @param comparator the comparator<br>
	 */
	public CircuitCondition(SignalID signal, int constant, String comparator) {
		this.signal1 = signal;
		this.constant = constant;
		this.comparator = comparator;
	}
	
	/**
	 * Create condition with constant-signal compare
	 * @param constant the constant<br>
	 * @param signal the signal<br>
	 * @param comparator the comparator<br>
	 */
	public CircuitCondition(int constant,SignalID signal,String comparator) {
		this.signal2 = signal;
		this.constant = constant;
		this.comparator = comparator;
	}
	
	/**
	 * Create condition with signal-signal compare
	 * @param signal1 the first signal<br>
	 * @param signal2 the second signal<br>
	 * @param comparator the comparator<br>
	 */
	public CircuitCondition(SignalID signal1, SignalID signal2, String comparator) {
		this.signal1 = signal1;
		this.signal2 = signal2;
		this.comparator = comparator;
	}

	@Override
	public JsonElement Serialize() {
		JsonObject jo=new JsonObject();
		jo.addProperty("comparator", comparator);
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
