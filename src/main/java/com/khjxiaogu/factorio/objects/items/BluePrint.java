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
package com.khjxiaogu.factorio.objects.items;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.BaseEntity;
import com.khjxiaogu.factorio.objects.Entity;
import com.khjxiaogu.factorio.objects.FsonSerializable;
import com.khjxiaogu.factorio.objects.Position;
import com.khjxiaogu.factorio.objects.SignalID;

// TODO: Auto-generated Javadoc
/**
 * Class BluePrint.
 *
 * @author khjxiaogu
 * file: BluePrint.java
 * time: 2020年8月1日
 */
public class BluePrint implements FsonSerializable {
	private static class WireConnection implements FsonSerializable {
		private float x1;
		private float y1;
		private float x2;
		private float y2;
		public WireConnection(float x1, float y1, float x2, float y2) {
			super();
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
		@Override
		public JsonElement Serialize() {
			JsonArray ja=new JsonArray();
			ja.add(x1);
			ja.add(y1);
			ja.add(x2);
			ja.add(y2);
			return ja;
		}
		
	}
	private SignalID[] icons=new SignalID[4];
	private ArrayList<Entity> entities=new ArrayList<>();
	private ArrayList<WireConnection> wire=new ArrayList<>();
	private String name=null;
	public void connectWire(Entity e1,Entity e2) {
		wire.add(new WireConnection(e1.getEntityID(),5,e2.getEntityID(),5));
	}

	/**
	 * Gets the blueprint name.<br>
	 *
	 * @return name<br>
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set blueprint name.<br>
	 *
	 * @param name value to set name to.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Instantiates a new BluePrint.<br>
	 */
	public BluePrint() {
	}
	
	/**
	 * Add icon.<br>
	 *
	 * @param id the icon signal id<br>
	 */
	public void addIcon(SignalID id) {
		if(icons[3]!=null)
			throw new IllegalArgumentException("BluePrints can not have more than 4 icons");
		for(int i=0;i<4;i++) {
			if(icons[i]==null) {
				icons[i]=id;
				break;
			}
		}
	}
	
	/**
	 * Gets the entity at position.<br>
	 * only check if exactly at position.
	 * @param x the position x<br>
	 * @param y the position y<br>
	 * @return entity at position<br>
	 */
	public Entity getEntityAt(float x,float y) {
		for(Entity ent:entities) {
			Position pos=ent.getPosition();
			if(pos.getX()==x&&pos.getY()==y)
				return ent;
		}
		return null;
	}
	
	/**
	 * Add an entity to blueprint.<br>
	 *
	 * @param ent the entity to add<br>
	 */
	public void addEntity(Entity ent) {
		entities.add(ent);
		ent.setEntityID(entities.size());
	}
	@Override
	public JsonElement Serialize() {
		JsonObject main=new JsonObject();
		JsonObject objthis=new JsonObject();
		main.add("blueprint",objthis);
		objthis.addProperty("item", "blueprint");
		objthis.addProperty("version", 562949958205441L);
		JsonArray icon=new JsonArray();
		objthis.add("icons", icon);
		for(int i=0;i<4;i++) {
			if(icons[i]==null)break;
			JsonObject sn=new JsonObject();
			sn.add("signal",icons[i].Serialize());
			sn.addProperty("index", i+1);
			icon.add(sn);
		}
		JsonArray entity=new JsonArray();
		objthis.add("entities", entity);
		for(int i=0;i<entities.size();i++) {
			entity.add(entities.get(i).Serialize());
		}
		JsonArray wires=new JsonArray();
		objthis.add("wires", wires);
		for(int i=0;i<wire.size();i++) {
			wires.add(wire.get(i).Serialize());
		}
		
		
		if(name!=null)
			objthis.addProperty("label",name);
		return main;
	}
}
