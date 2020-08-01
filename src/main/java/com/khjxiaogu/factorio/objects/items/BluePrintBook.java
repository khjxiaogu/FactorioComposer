package com.khjxiaogu.factorio.objects.items;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.FsonSerializable;

// TODO: Auto-generated Javadoc
/**
 * Class BluePrintBook.
 *
 * @author khjxiaogu
 * file: BluePrintBook.java
 * time: 2020年8月1日
 */
public class BluePrintBook implements FsonSerializable {

	/**
	 * Instantiates a new BluePrintBook.<br>
	 */
	public BluePrintBook() {
	}

	private ArrayList<BluePrint> bps=new ArrayList<>();
	private String name=null;
	
	/**
	 * Gets the name.<br>
	 *
	 * @return name<br>
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set name.<br>
	 *
	 * @param name value to set name to.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Add blueprint to this book.<br>
	 *
	 * @param bp the blueprint to add<br>
	 */
	public void addBluePrint(BluePrint bp) {
		bps.add(bp);
	}
	
	/**
	 * Count of blueprint in this book.<br>
	 *
	 * @return return count of blueprint
	 */
	public int size() {
		return bps.size();
	}
	@Override
	public JsonElement Serialize() {
		JsonObject main=new JsonObject();
		JsonObject objthis=new JsonObject();
		main.add("blueprint_book",objthis);
		objthis.addProperty("item", "blueprint-book");
		objthis.addProperty("version", 77311508481L);
		objthis.addProperty("active_index",0);
		JsonArray bp=new JsonArray();
		objthis.add("blueprints",bp);
		for(int i=0;i<bps.size();i++) {
			JsonObject jo=bps.get(i).Serialize().getAsJsonObject();
			jo.addProperty("index", i);
			bp.add(jo);
		}
		if(name!=null)
			objthis.addProperty("label",name);
		return main;
	}

}
