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

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.BaseEntity;
import com.khjxiaogu.factorio.objects.FsonSerializable;
import com.khjxiaogu.factorio.objects.Signal;
import com.khjxiaogu.factorio.objects.SignalID;

// TODO: Auto-generated Javadoc
/**
 * Class ConstantCombinator.
 * represent constant combinator
 * @author khjxiaogu
 * file: ConstantCombinator.java
 * time: 2020年8月1日
 */
public class ConstantCombinator extends BaseEntity {
	private static class ControlBehavior implements FsonSerializable {
		ArrayList<Signal> filters=new ArrayList<>();
		public ControlBehavior() {
		}
		public void addFilter(SignalID id,int count) {
			if(filters.size()>=18)
				throw new IllegalArgumentException("constant boxes cannot hold more than 18 signals");
			filters.add(new Signal(id,count));
		}
		public boolean remains() {
			return filters.size()<18;
		}
		@Override
		public JsonElement Serialize() {
			JsonObject ot=new JsonObject();
			JsonArray filt=new JsonArray();
			ot.add("filters", filt);
			for(int i=0;i<filters.size();i++) {
				JsonObject sn=filters.get(i).Serialize().getAsJsonObject();
				sn.addProperty("index", i+1);
				filt.add(sn);
			}
			return ot;
		}

	}
	
	private ControlBehavior cb=new ControlBehavior();
	
	/**
	 * Instantiates a new ConstantCombinator.<br>
	 *
	 * @param x the x<br>
	 * @param y the y<br>
	 */
	public ConstantCombinator(float x, float y) {
		super(x, y);
	}
	
	/**
	 * Adds signal to the filters.<br>
	 *
	 * @param id the signal id<br>
	 * @param count the count<br>
	 */
	public void addFilter(SignalID id,int count) {
		cb.addFilter(id, count);
	}
	
	/**
	 * Has empty slot.<br>
	 *
	 * @return true, if empty slot is present.
	 */
	public boolean remains() {
		return cb.remains();
	}
	/**
	 * filter count.<br>
	 *
	 * @return filter count.
	 */
	public int size() {
		return cb.filters.size();
	}
	@Override
	public String getName() {
		return "constant-combinator";
	}

	@Override
	protected JsonElement Serialize(JsonObject basic) {
		basic.add("control_behavior",cb.Serialize());
		return basic;
	}
	@Override
	public int getPortCount() {
		return 1;
	}

}
