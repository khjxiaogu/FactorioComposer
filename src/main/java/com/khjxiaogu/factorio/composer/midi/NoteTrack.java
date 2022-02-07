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
package com.khjxiaogu.factorio.composer.midi;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Class NoteTrack.
 *
 * @author khjxiaogu
 * file: NoteTrack.java
 * time: 2020年8月9日
 */
public class NoteTrack {
	
	/** The notes.<br> 成员 notes. */
	List<NoteInfo> notes = new ArrayList<>();

	/**
	 * Instantiates a new NoteTrack.<br>
	 * 新建一个NoteTrack类<br>
	 */
	public NoteTrack() {
	}
	
	/**
	 * Adds the.<br>
	 *
	 * @param key the key<br>
	 * @param tick the tick<br>
	 * @param vol the vol<br>
	 */
	public void add(int key, long tick, int vol) {
		NoteInfo ni = NoteInfo.getNote(key, tick, vol);
		if (ni != null) {
			notes.add(ni);
		}
	}
	
	/**
	 * Adds the all.<br>
	 *
	 * @param ref the ref<br>
	 */
	public void addAll(NoteTrack ref) {
		notes.addAll(ref.notes);
	}
	
	/**
	 * Gets the note.<br>
	 * 获取 note.
	 *
	 * @param i the i<br>
	 * @return note<br>
	 */
	public NoteInfo getNote(int i) {
		return notes.get(i);
	}
	
	/**
	 * Removes the.<br>
	 *
	 * @param i the i<br>
	 * @return return removes the <br>返回 note info
	 */
	public NoteInfo remove(int i) {
		return notes.remove(i);
	}
	
	/**
	 * Gets the size.<br>
	 * 获取 size.
	 *
	 * @return size<br>
	 */
	public int getSize() {
		return notes.size();
	}
	
	/**
	 * Sort.<br>
	 */
	public void sort() {
		notes.sort((c1,c2)->{return (int) (c1.ticks-c2.ticks);});
		
	}
	
	/**
	 * Info.<br>
	 *
	 * @return return info <br>返回 string
	 */
	public String info() {
		return "Number of notes:"+notes.size()+" ,lenth of track in music ticks:"+notes.get(notes.size()-1).ticks;
	}
}
