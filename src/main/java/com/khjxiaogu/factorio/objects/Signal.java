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
package com.khjxiaogu.factorio.objects;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// TODO: Auto-generated Javadoc
/**
 * Class Signal.
 * Represents a type of signal with count.
 * @author khjxiaogu
 * file: Signal.java
 * time: 2020/8/1
 */
public class Signal implements FsonSerializable {
	
	/** The signal id. */
	public final SignalID id;
	
	/** The signal count. */
	public final int count;
	
	/**
	 * construct Signal object.<br>
	 *
	 * @param id the id<br>
	 * @param count the count<br>
	 */
	public Signal(SignalID id, int count) {
		this.id = id;
		this.count = count;
	}


	@Override
	public JsonElement Serialize() {
		JsonObject jo=new JsonObject();
		jo.add("signal", id.Serialize());
		jo.addProperty("count", count);
		return jo;
	}

}
