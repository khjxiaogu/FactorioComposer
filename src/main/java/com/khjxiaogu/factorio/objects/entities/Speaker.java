package com.khjxiaogu.factorio.objects.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.khjxiaogu.factorio.objects.BaseEntity;

// TODO: Auto-generated Javadoc
/**
 * Class Speaker.
 * represent programmable speaker
 * @author khjxiaogu
 * file: Speaker.java
 * time: 2020年8月1日
 */
public class Speaker extends BaseEntity {
	private CircuitCondition cond;
	private boolean is_pitch=false;
	private int instrumentID=3;
	private int noteID=0;
	private float volume=0.8F;
	private boolean globally=false;
	private boolean polyphony=true;
	private boolean showAlert=false;
	private boolean showMap=true;
	private String message="";
	
	/**
	 * Checks if signal is pitch.<br>
	 *
	 * @return if is checks if is pitch,true.
	 */
	public boolean isIs_pitch() {
		return is_pitch;
	}

	/**
	 * set if signal is pitch.<br>
	 *
	 * @param is_pitch value to set signal is pitch to.
	 */
	public void setIs_pitch(boolean is_pitch) {
		this.is_pitch = is_pitch;
	}

	/**
	 * Gets the instrument ID.<br>
	 *
	 * @return instrument ID<br>
	 */
	public int getInstrumentID() {
		return instrumentID;
	}

	/**
	 * set instrument ID.<br>
	 *
	 * @param instrumentID value to set instrument ID to.
	 */
	public void setInstrumentID(int instrumentID) {
		this.instrumentID = instrumentID;
	}

	/**
	 * Gets the note ID.<br>
	 *
	 * @return note ID<br>
	 */
	public int getNoteID() {
		return noteID;
	}

	/**
	 * set note ID.<br>
	 *
	 * @param noteID value to set note ID to.
	 */
	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	/**
	 * Gets the volume.<br>
	 *
	 * @return volume<br>
	 */
	public float getVolume() {
		return volume;
	}

	/**
	 * set volume.<br>
	 *
	 * @param volume value to set volume to.
	 */
	public void setVolume(float volume) {
		this.volume = volume;
	}

	/**
	 * Checks if is globally.<br>
	 *
	 * @return if is globally,true.
	 */
	public boolean isGlobally() {
		return globally;
	}

	/**
	 * set globally.<br>
	 *
	 * @param globally value to set globally to.
	 */
	public void setGlobally(boolean globally) {
		this.globally = globally;
	}

	/**
	 * Checks if is polyphony.<br>
	 *
	 * @return if is polyphony,true.
	 */
	public boolean isPolyphony() {
		return polyphony;
	}

	/**
	 * set is polyphony.<br>
	 *
	 * @param polyphony value to set polyphony to.
	 */
	public void setPolyphony(boolean polyphony) {
		this.polyphony = polyphony;
	}

	/**
	 * Checks if is show alert.<br>
	 *
	 * @return if is show alert,true.
	 */
	public boolean isShowAlert() {
		return showAlert;
	}

	/**
	 * set show alert.<br>
	 * 
	 * @param showAlert value to set show alert to.
	 */
	public void setShowAlert(boolean showAlert) {
		this.showAlert = showAlert;
	}

	/**
	 * Checks if is show om map.<br>
	 *
	 * @return if is show on map,true.
	 */
	public boolean isShowMap() {
		return showMap;
	}

	/**
	 * set show on map.<br>
	 * if show alert is false, this is ignored
	 * @param showMap set show on map.
	 */
	public void setShowMap(boolean showMap) {
		this.showMap = showMap;
	}

	/**
	 * Gets the message.<br>
	 *
	 * @return message<br>
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * set alert message.<br>
	 * if show alert is false, this is ignored
	 * @param message value to set message to.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * set activate condition.<br>
	 *
	 * @param cond condition to set
	 */
	public void setCond(CircuitCondition cond) {
		this.cond = cond;
	}

	/**
	 * Instantiates a new Speaker.<br>
	 *
	 * @param x the x<br>
	 * @param y the y<br>
	 */
	public Speaker(float x, float y) {
		super(x, y);
	}
	@Override
	public String getName() {
		return "programmable-speaker";
	}
	@Override
	public int getPortCount() {
		return 1;
	}

	@Override
	protected JsonElement Serialize(JsonObject basic) {
		JsonObject cb=new JsonObject();
		if(cond!=null)
			cb.add("circuit_condition",cond.Serialize());
		JsonObject cparam=new JsonObject();
		cparam.addProperty("signal_value_is_pitch",is_pitch);
		cparam.addProperty("instrument_id",instrumentID);
		cparam.addProperty("note_id",noteID);
		cb.add("circuit_parameters", cparam);
		basic.add("control_behavior", cb);
		JsonObject params=new JsonObject();
		params.addProperty("playback_volume", volume);
		params.addProperty("playback_globally",globally);
		params.addProperty("allow_polyphony",polyphony);
		basic.add("parameters", params);
		JsonObject aparam=new JsonObject();
		aparam.addProperty("show_alert", showAlert);
		aparam.addProperty("show_on_map",showMap);
		aparam.addProperty("alert_message",message);
		basic.add("alert_parameters", aparam);
		return basic;
	}

}
