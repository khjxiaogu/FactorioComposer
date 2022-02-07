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
 * Class BaseEntity.
 *
 * @author khjxiaogu
 * file: BaseEntity.java
 * time: 2020年8月1日
 */
public abstract class BaseEntity implements Entity {
	
	private Position p;
	private int dir=4;
	private WireManager wm;
	
	/**
	 * Instantiates a new BaseEntity.<br>
	 *
	 * @param x the location x<br>
	 * @param y the location y<br>
	 */
	public BaseEntity(float x,float y) {
		p=new Position(x,y);
	}
	
	private int eid;
	@Override
	public void setEntityID(int id) {
		if(eid!=0)
			throw new IllegalArgumentException("entityID already assigned");
		
		eid=id;
		wm=new WireManager(this.getPortCount(), eid);
	}
	@Override
	public int getEntityID() {
		return eid;
	}
	
	@Override
	public JsonElement Serialize() {
		JsonObject jo=new JsonObject();
		jo.add("position", p.Serialize());
		jo.addProperty("name",getName());
		jo.addProperty("entity_number",eid);
		jo.addProperty("direction", dir);
		if(wm!=null&&wm.isConnected()) {
			jo.add("connections",wm.Serialize());
		}
		return Serialize(jo);
	}
	
	/**
	 * Gets the direction.<br>
	 *
	 * @return direction<br>
	 */
	public int getDirection() {
		return dir;
	}
	
	/**
	 * Sets direction.<br>
	 *
	 * @param dir value to set direction to.
	 */
	public void setDirection(int dir) {
		this.dir = dir;
	}
	protected abstract JsonElement Serialize(JsonObject basic);

	@Override
	public Position getPosition() {
		return p;
	}
	
	@Override
	public void connect(int srcport,Entity another,int dstport,boolean isRed) {
		if(!(another instanceof BaseEntity)) {
			throw new IllegalArgumentException("Entity is not a block");
		}
		BaseEntity oth=(BaseEntity) another;
		if(wm==null||oth.wm==null)
			throw new IllegalArgumentException("Entities should be added to blueprint before connect");
		wm.connect(srcport,oth.wm,dstport,isRed);
	}

	@Override
	public void setPosition(float x, float y) {
		p.setPosition(x, y);
	}

}
