package com.khjxiaogu.factorio.composer.midi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MidiSheet {
	public List<NoteTrack> tracks = new ArrayList<>();
	public final static int MsPerGameTick=32;
	public MidiSheet(File f, int offset, float speed) throws InvalidMidiDataException, IOException {
		Sequence sequence;
		sequence = MidiSystem.getSequence(f);
		float framesPerSecond;
		if (sequence.getDivisionType() == Sequence.PPQ) {
			framesPerSecond = 0F;
		} else {
			framesPerSecond = sequence.getDivisionType();
		}
		int resolution = sequence.getResolution();
		for (Track track : sequence.getTracks()) {
			NoteTrack currentTrack = new NoteTrack();
			float beatsPerMinute = 120;
			if (track.size() > 0) {
				for (int i = 0; i < track.size(); i++) {
					float millisPerMidiTick;
					if (framesPerSecond == 0F) {// PPQ mode
						millisPerMidiTick = 60000 / beatsPerMinute / resolution / speed;
					} else {
						millisPerMidiTick = 1000 / resolution / framesPerSecond / speed;
					}
					MidiEvent event = track.get(i);
					MidiMessage message = event.getMessage();
					if (message instanceof ShortMessage) {
						ShortMessage sm = (ShortMessage) message;
						if (sm.getCommand() == 144) {// Detect KEY_ON message
							currentTrack.add(sm.getData1() + offset * 12,
									Math.round(event.getTick() * millisPerMidiTick / MsPerGameTick), sm.getData2());
						}
					} else if (message instanceof MetaMessage) {
						MetaMessage metaMessage = (MetaMessage) message;
						if (metaMessage.getStatus() == 0xff && metaMessage.getType() == 0x51) {// Detect Speed change
																								// message
							long microsPerBeat = 0;
							byte[] byteData = metaMessage.getData();
							for (int j = 0; j < byteData.length; j++) {
								microsPerBeat *= 0x100;
								microsPerBeat += byteData[j];
							}
							if (microsPerBeat != 0) {
								beatsPerMinute = 60000000 / microsPerBeat;
							}
						}
					}
				}
			}
			if (currentTrack.getSize() != 0) {
				tracks.add(currentTrack);
			}
		}
	}
	public String info() {
		StringBuilder infobuilder=new StringBuilder("midi info:").append("\n");
		int i=1;
		for(NoteTrack nt:tracks) {
			infobuilder.append("Track").append(i++).append(" : ").append(nt.info()).append("\n");
		}
		return infobuilder.toString();
	}
	public boolean Split() {
		Map<Integer,NoteTrack> splited=new HashMap<>();
		for(NoteTrack t:tracks) {
			for(NoteInfo ni:t.notes) {
				int k=ni.key;
				NoteTrack nc=splited.get(k);
				if(nc==null) {
					nc=new NoteTrack();
					splited.put(k,nc);
				}
				nc.add(k,ni.ticks,ni.volume);
			}
		}
		tracks.clear();
		tracks.addAll(splited.values());
		return true;
	}
	public Map<Integer,Set<Integer>> SplitAll() {
		Map<Integer,Set<Integer>> splited=new TreeMap<>();
		for(NoteTrack t:tracks) {
			for(NoteInfo ni:t.notes) {
				int k=ni.key;
				Set<Integer> nc=splited.get(k);
				if(nc==null) {
					nc=new TreeSet<Integer>();
					splited.put(k,nc);
				}
				nc.add((int) ni.ticks);
			}
		}
		return splited;
	}
	public boolean Combine() {
		if(tracks.size()==1)
			return false;
		NoteTrack Combined=new NoteTrack();;
		for(NoteTrack t:tracks) {
			Combined.addAll(t);
		}
		Combined.sort();
		tracks.clear();
		tracks.add(Combined);
		return true;
	}
}
