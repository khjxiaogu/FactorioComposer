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

// TODO: Auto-generated Javadoc
/**
 * Class MidiSheet.
 *
 * @author khjxiaogu
 * file: MidiSheet.java
 * time: 2020年8月9日
 */
public class MidiSheet {
	
	/** The tracks.<br> 成员 tracks. */
	public List<NoteTrack> tracks = new ArrayList<>();
	
	/** Constant MsPerGameTick.<br> 常量 MsPerGameTick. */
	public final static int MsPerGameTick=32;
	
	/**
	 * Instantiates a new MidiSheet.<br>
	 * 新建一个MidiSheet类<br>
	 *
	 * @param f the f<br>
	 * @param offset the offset<br>
	 * @param speed the speed<br>
	 * @throws InvalidMidiDataException if an invalid midi data exception occurred.<br>如果invalid midi data exception发生了
	 * @throws IOException Signals that an I/O exception has occurred.<br>发生IO错误
	 */
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
			double beatsPerMinute = 120;
			//int b = 0;
			long lastOffset=0;
			long lastTick=0;
			if (track.size() > 0) {
				for (int i = 0; i < track.size(); i++) {
					double millisPerMidiTick;
					if (framesPerSecond == 0F) {// PPQ mode
						millisPerMidiTick = 60000 / beatsPerMinute / resolution / speed;
					} else {
						millisPerMidiTick = 1000 / resolution / framesPerSecond / speed;
					}
					
					MidiEvent event = track.get(i);
					MidiMessage message = event.getMessage();
					if (message instanceof ShortMessage) {
						ShortMessage sm = (ShortMessage) message;
						if ((sm.getCommand() & ShortMessage.NOTE_ON) > 0) {// Detect KEY_ON message
							long delta=event.getTick()-lastTick;
							lastTick=event.getTick();
							lastOffset+=Math.round(delta * millisPerMidiTick / MsPerGameTick);
							currentTrack.add(sm.getData1() + offset * 12,lastOffset, sm.getData2());
							System.out.println(lastOffset);
						}
					} else if (message instanceof MetaMessage) {
						MetaMessage metaMessage = (MetaMessage) message;
						if (metaMessage.getStatus() == 0xff ) {
							if(metaMessage.getType() == 0x51) {// Detect tempo change
								long microsPerBeat = 0;
								
								byte[] byteData = metaMessage.getData();
								for (int j = 0; j <byteData.length ; j++) {
									microsPerBeat *= 0x100;
									microsPerBeat += Byte.toUnsignedInt(byteData[j]);
								}
								if (microsPerBeat != 0) {
									beatsPerMinute = 60000000 / microsPerBeat;
								}
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
	
	/**
	 * Info.<br>
	 *
	 * @return return info <br>返回 string
	 */
	public String info() {
		StringBuilder infobuilder=new StringBuilder("midi info:").append("\n");
		int i=1;
		for(NoteTrack nt:tracks) {
			infobuilder.append("Track").append(i++).append(" : ").append(nt.info()).append("\n");
		}
		return infobuilder.toString();
	}
	
	/**
	 * Split.<br>
	 *
	 * @return true, if <br>如果，返回true。
	 */
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
	
	/**
	 * Split all.<br>
	 *
	 * @return return split all <br>返回 map
	 */
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
	
	/**
	 * Combine.<br>
	 *
	 * @return true, if <br>如果，返回true。
	 */
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
