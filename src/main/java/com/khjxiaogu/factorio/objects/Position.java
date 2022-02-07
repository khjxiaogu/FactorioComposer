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
 * Class Position.
 *
 * @author khjxiaogu
 * file: Position.java
 * time: 2020年8月1日
 */
public class Position implements FsonSerializable,Cloneable {
	private float x;
	private float y;
	
	/**
	 * Gets the x.<br>
	 * @return x<br>
	 */
	public float getX() {
		return x;
	}

	/**
	 * set x.<br>
	 * @param x value to set x to.
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * Gets the y.<br>
	 * @return y<br>
	 */
	public float getY() {
		return y;
	}

	/**
	 * set y.<br>
	 * @param y value to set y to.
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Sets the position.<br>
	 *
	 * @param x the x<br>
	 * @param y the y<br>
	 */
	public void setPosition(float x,float y) {
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Instantiates a new Position.<br>
	 * @param x the x<br>
	 * @param y the y<br>
	 */
	public Position(float x,float y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public JsonElement Serialize() {
		JsonObject jo=new JsonObject();
		jo.addProperty("x", x);
		jo.addProperty("y", y);
		return jo;
	}

}
