package com.khjxiaogu.factorio.objects;

// TODO: Auto-generated Javadoc
/**
 * Interface Entity.
 *
 * @author khjxiaogu
 * file: Entity.java
 * time: 2020年8月1日
 */
public interface Entity extends FsonSerializable{
	
	/**
	 * Gets the name.<br>
	 *
	 * @return name<br>
	 */
	String getName();
	
	/**
	 * Gets the position.<br>
	 *
	 * @return position<br>
	 */
	Position getPosition();
	
	/**
	 * Sets the position.<br>
	 *
	 * @param x the x<br>
	 * @param y the y<br>
	 */
	void setPosition(float x,float y);
	
	/**
	 * Sets position.<br>
	 *
	 * @param p value to set position to.
	 */
	default void setPosition(Position p) {
		setPosition(p.getX(),p.getY());
	}
	
	/**
	 * Sets entity ID.<br>
	 *
	 * @param id value to set entity ID to.
	 */
	void setEntityID(int id);
	
	/**
	 * Gets the entity ID.<br>
	 * should not be set by hand.
	 * @return entity ID
	 */
	int getEntityID();
	
	/**
	 * Gets the count of wire ports.<br>
	 *
	 * @return port count<br>
	 */
	int getPortCount();
	
	/**
	 * Connect to another entity.<br>
	 * ports:
	 * 1:input
	 * 2:output
	 * @param srcport the port of current entity<br>
	 * @param another another entity<br>
	 * @param dstport the port of another entity<br>
	 * @param isRed is red wire or green<br>
	 */
	default void connect(int srcport, Entity other, int dstport, boolean isRed) {
		throw new IllegalArgumentException("This entity cannot be connected to another entity");
	}
}
