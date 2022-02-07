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

// TODO: Auto-generated Javadoc
/**
 * Class NoteInfo.
 *
 * @author khjxiaogu
 * file: NoteInfo.java
 * time: 2020年8月9日
 */
public class NoteInfo{
	
	/** The ticks.<br> 成员 ticks. */
	public final long ticks;
	
	/** The volume.<br> 成员 volume. */
	public int volume = 64;
	
	/** The key.<br> 成员 key. */
	public final int key;

	/**
	 * Instantiates a new NoteInfo with a long object.<br>
	 * 使用一个long新建一个NoteInfo类<br>
	 *
	 * @param ticks the ticks<br>
	 */
	public NoteInfo(long ticks) {
		this.ticks = ticks;
		key = 0;
	}

	/**
	 * Instantiates a new NoteInfo.<br>
	 * 新建一个NoteInfo类<br>
	 *
	 * @param key the key<br>
	 * @param tick the tick<br>
	 * @param vol the vol<br>
	 */
	public NoteInfo(int key, long tick, int vol) {
		volume = vol;
		ticks = tick;
		this.key = key;
	}

	/**
	 * Gets the note.<br>
	 * 获取 note.
	 *
	 * @param key the key<br>
	 * @param tick the tick<br>
	 * @param vol the vol<br>
	 * @return note<br>
	 */
	public static NoteInfo getNote(int key, long tick, int vol) {
		return new NoteInfo(key, tick, vol);
	}
}