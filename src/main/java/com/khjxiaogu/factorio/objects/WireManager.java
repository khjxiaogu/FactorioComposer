package com.khjxiaogu.factorio.objects;

import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// TODO: Auto-generated Javadoc
/**
 * Class WireManager.
 * Manager to manage wire on entity
 * @author khjxiaogu
 * file: WireManager.java
 * time: 2020年8月1日
 */
class WireManager implements FsonSerializable{
	private class Port implements FsonSerializable{
		class Connection implements FsonSerializable{
			final int circuitID;
			final int entityID;
			Connection(int entityID,int circuitID) {
				this.circuitID = circuitID;
				this.entityID = entityID;
			}
			@Override
			public JsonElement Serialize() {
				JsonObject jo=new JsonObject();
				jo.addProperty("entity_id",entityID);
				if(circuitID>0)
					jo.addProperty("circuit_id",circuitID);
				return jo;
			}
		}
		int portID;
		int entityID;
		public Port(int entityID, int portID) {
			this.portID = portID;
			this.entityID = entityID;
		}
		ArrayList<Connection> redConnections=new ArrayList<>();
		ArrayList<Connection> greenConnections=new ArrayList<>();
		void connectRed(Port another,boolean assignSrcPortID,boolean assignDstPortID){
			another.redConnections.add(new Connection(entityID,assignSrcPortID?portID:0));
			redConnections.add(new Connection(another.entityID,assignDstPortID?another.portID:0));
		}
		void connectGreen(Port another,boolean assignSrcPortID,boolean assignDstPortID){
			another.greenConnections.add(new Connection(entityID,assignSrcPortID?portID:0));
			greenConnections.add(new Connection(another.entityID,assignDstPortID?another.portID:0));
		}
		@Override
		public JsonElement Serialize() {
			JsonObject jo=new JsonObject();
			if(redConnections.size()>0) {
				JsonArray red=new JsonArray();
				for(Connection rc:redConnections) {
					red.add(rc.Serialize());
				}
				jo.add("red",red);
			}
			if(greenConnections.size()>0) {
				JsonArray green=new JsonArray();
				for(Connection gc:greenConnections) {
					green.add(gc.Serialize());
				}
				jo.add("green",green);
			}
			return jo;
		}
	}
	Port[] ports=null;
	int portcount;
	boolean connected=false;
	
	/**
	 * Instantiates a new WireManager.<br>
	 * 新建一个WireManager类<br>
	 *
	 * @param cport the cport<br>
	 * @param entityID the entity ID<br>
	 */
	public WireManager(int cport,int entityID) {
		portcount=cport;
		if(portcount>0) {
			ports=new Port[portcount];
			for(int i=0;i<portcount;i++) {
				ports[i]=new Port(entityID,i+1);
			}
		}
	}
	
	/**
	 * Connect.<br>
	 *
	 * @param srcport the srcport<br>
	 * @param dst the dst<br>
	 * @param dstport the dstport<br>
	 * @param isRed the is red<br>
	 */
	public void connect(int srcport,WireManager dst,int dstport,boolean isRed) {
		if(srcport>portcount||srcport<=0||dstport>dst.portcount||dstport<=0) {
			throw new IllegalArgumentException("Port number invalid");
		}
		connected=true;
		if(isRed)
			ports[srcport-1].connectRed(dst.ports[dstport-1],portcount!=1,dst.portcount!=1);
		else
			ports[srcport-1].connectGreen(dst.ports[dstport-1],portcount!=1,dst.portcount!=1);
	}
	
	/**
	 * Checks if is connected.<br>
	 * 是否 connected.
	 *
	 * @return 如果是connected，返回true<br>if is connected,true.
	 */
	public boolean isConnected() {
		return connected;
	}
	@Override
	public JsonElement Serialize() {
		JsonObject conns=new JsonObject();
		for(int i=0;i<ports.length;i++) {
			conns.add(Integer.toString(i+1),ports[i].Serialize());
		}
		return conns;
	}

}

