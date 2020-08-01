package com.khjxiaogu.factorio.composer.midi;

import java.util.ArrayList;
import java.util.List;

public class NoteTrack {
	List<NoteInfo> notes = new ArrayList<>();

	public NoteTrack() {
	}
	public void add(int key, long tick, int vol) {
		NoteInfo ni = NoteInfo.getNote(key, tick, vol);
		if (ni != null) {
			notes.add(ni);
		}
	}
	public void addAll(NoteTrack ref) {
		notes.addAll(ref.notes);
	}
	public NoteInfo getNote(int i) {
		return notes.get(i);
	}
	public NoteInfo remove(int i) {
		return notes.remove(i);
	}
	public int getSize() {
		return notes.size();
	}
	public void sort() {
		notes.sort((c1,c2)->{return (int) (c1.ticks-c2.ticks);});
		
	}
	public String info() {
		return "Number of notes:"+notes.size()+" ,lenth of track in music ticks:"+notes.get(notes.size()-1).ticks;
	}
}
