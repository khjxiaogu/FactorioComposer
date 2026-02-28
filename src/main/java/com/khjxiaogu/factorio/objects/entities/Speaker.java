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
import com.khjxiaogu.factorio.objects.SignalID;

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
	private boolean polyphony=true;
	private boolean showAlert=false;
	private boolean showMap=true;
	private boolean stopPlayingSounds=false;
	private SignalID volumeControlSignal;
	private String message="";
	private String mode;
	private boolean volumeControlBySignal;
	
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
	 * set globally.<br>
	 *
	 * @param globally value to set globally to.
	 */
	public void setGlobally() {
		this.mode = "global";
	}
	/**
	 * set globally.<br>
	 *
	 * @param globally value to set globally to.
	 */
	public void setSurface() {
		this.mode = "surface";
	}
	/**
	 * set globally.<br>
	 *
	 * @param globally value to set globally to.
	 */
	public void setLocal() {
		this.mode = "local";
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

	public boolean isStopPlayingSounds() {
		return stopPlayingSounds;
	}

	public void setStopPlayingSounds(boolean stopPlayingSounds) {
		this.stopPlayingSounds = stopPlayingSounds;
	}

	public SignalID getVolumeControlSignal() {
		return volumeControlSignal;
	}

	public void setVolumeControlSignal(SignalID volumeControlSignal) {
		this.volumeControlSignal = volumeControlSignal;
	}

	public boolean isVolumeControlBySignal() {
		return volumeControlBySignal;
	}

	public void setVolumeControlBySignal(boolean volumeControlBySignal) {
		this.volumeControlBySignal = volumeControlBySignal;
	}

	public String getMode() {
		return mode;
	}

	@Override
	protected JsonElement Serialize(JsonObject basic) {
		JsonObject cb=new JsonObject();
		if(cond!=null)
			cb.add("circuit_condition",cond.Serialize());
		JsonObject cparam=new JsonObject();
		cparam.addProperty("signal_value_is_pitch",is_pitch);
		cparam.addProperty("instrument_id",instrumentID);
		cparam.addProperty("stop_playing_sounds",stopPlayingSounds);
		
		cparam.addProperty("note_id",noteID);
		cb.add("circuit_parameters", cparam);
		basic.add("control_behavior", cb);
		JsonObject params=new JsonObject();
		params.addProperty("playback_volume", volume);
		params.addProperty("playback_mode",mode);
		params.addProperty("allow_polyphony",polyphony);
		params.addProperty("volume_controlled_by_signal", volumeControlBySignal);
		if(volumeControlSignal!=null)
			params.add("volume_signal_id", volumeControlSignal.Serialize());
		basic.add("parameters", params);
		JsonObject aparam=new JsonObject();
		aparam.addProperty("show_alert", showAlert);
		aparam.addProperty("show_on_map",showMap);
		aparam.addProperty("alert_message",message);
		basic.add("alert_parameters", aparam);
		return basic;
	}

}
