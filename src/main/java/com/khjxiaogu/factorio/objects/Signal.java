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
