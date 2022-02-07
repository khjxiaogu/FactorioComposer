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
