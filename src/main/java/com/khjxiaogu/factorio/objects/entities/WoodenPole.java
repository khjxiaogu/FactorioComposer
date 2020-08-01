package com.khjxiaogu.factorio.objects.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.BaseEntity;

// TODO: Auto-generated Javadoc
/**
 * Class WoodenPole.
 * represent small electric pole
 * @author khjxiaogu
 * file: WoodenPole.java
 * time: 2020年8月1日
 */
public class WoodenPole extends BaseEntity {

	/**
	 * Instantiates a new WoodenPole.<br>
	 *
	 * @param x the x<br>
	 * @param y the y<br>
	 */
	public WoodenPole(float x, float y) {
		super(x, y);
	}
	@Override
	public String getName() {
		return "small-electric-pole";
	}

	@Override
	public int getPortCount() {
		return 1;
	}

	@Override
	protected JsonElement Serialize(JsonObject basic) {
		return basic;
	}

}
