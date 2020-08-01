package com.khjxiaogu.factorio.composer.midi;

public class NoteInfo{
	public final long ticks;
	public int volume = 64;
	public final int key;

	public NoteInfo(long ticks) {
		this.ticks = ticks;
		key = 0;
	}

	public NoteInfo(int key, long tick, int vol) {
		volume = vol;
		ticks = tick;
		this.key = key;
	}

	public static NoteInfo getNote(int key, long tick, int vol) {
		return new NoteInfo(key, tick, vol);
	}
}