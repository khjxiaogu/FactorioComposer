package com.khjxiaogu.factorio.objects;

import com.google.gson.JsonElement;

// TODO: Auto-generated Javadoc
/**
 * Interface FsonSerializable.
 * Objects that can be Serialized to json
 * @author khjxiaogu
 * file: FsonSerializable.java
 * time: 2020年8月1日
 */
public interface FsonSerializable {
	
	/**
	 * Serialize.<br>
	 *
	 * @return return serialized item
	 */
	JsonElement Serialize();
}
