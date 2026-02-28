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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.BaseEntity;
import com.khjxiaogu.factorio.objects.FsonSerializable;
import com.khjxiaogu.factorio.objects.Signal;
import com.khjxiaogu.factorio.objects.SignalID;

// TODO: Auto-generated Javadoc
/**
 * Class ConstantCombinator.
 * represent constant combinator
 * @author khjxiaogu
 * file: ConstantCombinator.java
 * time: 2020年8月1日
 */
public class ConstantCombinator extends BaseEntity {
	private static class Section implements FsonSerializable {
		ArrayList<Signal> filters=new ArrayList<>();
		String group;
		
		public Section(String group) {
			super();
			this.group = group;
		}
		public void addFilter(SignalID id,int count) {
			//2.0:removed filter size 
			//if(filters.size()>=18)
			//	throw new IllegalArgumentException("constant boxes cannot hold more than 18 signals");
			filters.add(new Signal(id,count));
		}
		@Override
		public JsonElement Serialize() {
			JsonObject ot=new JsonObject();
			JsonArray filt=new JsonArray();
			ot.add("filters", filt);
			for(int i=0;i<filters.size();i++) {
				JsonObject sn=filters.get(i).Serialize().getAsJsonObject();
				sn.addProperty("index", i+1);
				filt.add(sn);
			}
			if(group!=null)
				ot.addProperty("group", group);
			return ot;
		}
	}
	
	private List<Section> sections=new ArrayList<>();
	private int defgroup=-1;
	/**
	 * Instantiates a new ConstantCombinator.<br>
	 *
	 * @param x the x<br>
	 * @param y the y<br>
	 */
	public ConstantCombinator(float x, float y) {
		super(x, y);
	}
	
	/**
	 * Adds signal to the filters.<br>
	 *
	 * @param id the signal id<br>
	 * @param count the count<br>
	 */
	public void addFilter(SignalID id,int count) {
		if(defgroup==-1) {
			defgroup=createSection(null);
		}
		sections.get(defgroup).addFilter(id, count);
	}
	public int createSection(String group) {
		int idx=sections.size();
		sections.add(new Section(group));
		return idx;
	}
	public void addFilter(String group,SignalID id,int count) {
		this.addFilter(group,-1,id,count);
	}
	/**
	 * Adds signal to the filters.<br>
	 *
	 * @param id the signal id<br>
	 * @param count the count<br>
	 */
	public void addFilter(String group,int idx,SignalID id,int count) {
		Section toadd=null;
		if(idx==-1) {
			for(Section s:sections) {
				if(Objects.equals(s.group, group)) {
					toadd=s;
					break;
				}
			}
			if(toadd==null) {
				toadd=new Section(group);
				sections.add(toadd);
			}
		}else
			toadd=sections.get(idx);
		toadd.addFilter(id, count);
	}
	
	/**
	 * filter count.<br>
	 *
	 * @return filter count.
	 */
	public int size() {
		return sections.size();
	}
	@Override
	public String getName() {
		return "constant-combinator";
	}

	@Override
	protected JsonElement Serialize(JsonObject basic) {
		
		
		JsonObject ot=new JsonObject();
		JsonArray filt=new JsonArray();
		
		for(int i=0;i<sections.size();i++) {
			JsonObject sn=sections.get(i).Serialize().getAsJsonObject();
			sn.addProperty("index", i+1);
			filt.add(sn);
		}
		ot.add("sections", filt);
		JsonObject ss=new JsonObject();
		ss.add("sections", ot);
		basic.add("control_behavior",ss);
		return basic;
	}
	@Override
	public int getPortCount() {
		return 1;
	}

}
