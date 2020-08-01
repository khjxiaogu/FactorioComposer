package com.khjxiaogu.factorio.objects.items;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
	private SignalID[] icons=new SignalID[4];
	private ArrayList<Entity> entities=new ArrayList<>();
	private String name=null;
	
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
			if(icons[i]!=null)
				icons[i]=id;
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
		objthis.addProperty("version", 77311508481L);
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
		if(name!=null)
			objthis.addProperty("label",name);
		return main;
	}
}
