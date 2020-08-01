package com.khjxiaogu.factorio.composer;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.sound.midi.InvalidMidiDataException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.khjxiaogu.factorio.composer.midi.MidiSheet;
import com.khjxiaogu.factorio.composer.midi.NoteInfo;
import com.khjxiaogu.factorio.composer.midi.NoteTrack;
import com.khjxiaogu.factorio.objects.BaseEntity;
import com.khjxiaogu.factorio.objects.Entity;
import com.khjxiaogu.factorio.objects.SignalID;
import com.khjxiaogu.factorio.objects.Utils;
import com.khjxiaogu.factorio.objects.entities.CircuitCondition;
import com.khjxiaogu.factorio.objects.entities.ConstantCombinator;
import com.khjxiaogu.factorio.objects.entities.DeciderCombinator;
import com.khjxiaogu.factorio.objects.entities.Light;
import com.khjxiaogu.factorio.objects.entities.Speaker;
import com.khjxiaogu.factorio.objects.entities.WoodenPole;
import com.khjxiaogu.factorio.objects.items.BluePrint;
import com.khjxiaogu.factorio.objects.items.BluePrintBook;

public class FactorioComposer {
	
	public static SignalID[] sids=new SignalID[] 
			{SignalID.V_0,SignalID.V_1,SignalID.V_2,SignalID.V_3,SignalID.V_4,SignalID.V_5,
			 SignalID.V_6,SignalID.V_7,SignalID.V_8,SignalID.V_9,SignalID.V_A,SignalID.V_B,
			 SignalID.V_C,SignalID.V_D,SignalID.V_E,SignalID.V_F,SignalID.V_G,SignalID.V_H,
			 SignalID.V_I,SignalID.V_J,SignalID.V_K,SignalID.V_L,SignalID.V_M,SignalID.V_N,
			 SignalID.V_O,SignalID.V_P,SignalID.V_Q,SignalID.V_R,SignalID.V_S,SignalID.V_BLUE,
			 SignalID.V_U,SignalID.V_V,SignalID.V_W,SignalID.V_X,SignalID.V_Y,SignalID.V_Z};
	public static void main(String[] args) throws Exception {
		JFrame f = new JFrame("Factorio Composer by khjxiaogu");
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		f.setSize(400, 400);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setResizable(false);
		JButton button1 = new JButton("Select Folder");
		JButton button2 = new JButton("Select File");

		button1.addActionListener(ev -> {
			try {
				ImageEncrypt.encrypt();
			} catch (IOException | NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		button2.addActionListener(ev -> {
			try {
				ImageEncrypt.decrypt();
			} catch (IOException | NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		JPanel text = new JPanel();
		p.add(button1);
		p.add(button2);
		p2.add(new JLabel(Messages.getString("ImageEncrypt.password"))); //$NON-NLS-1$
		p2.add(ImageEncrypt.je);
		p2.setSize(400, p2.getWidth());
		f.add(p);
		f.add(p2);
		ImageEncrypt.l.setMaximumSize(new Dimension(Integer.MAX_VALUE, ImageEncrypt.l.getMinimumSize().height));
		f.add(ImageEncrypt.l);
		f.add(Box.createVerticalGlue());
		text.add(new JLabel(Messages.getString("ImageEncrypt.hint"))); //$NON-NLS-1$
		text.add(new JLabel(Messages.getString("ImageEncrypt.warn"))); //$NON-NLS-1$
		text.add(new JLabel(Messages.getString("ImageEncrypt.author"))); //$NON-NLS-1$
		text.add(new JLabel("Copyright (C) 2020 khjxiaogu,all rights reserved.")); //$NON-NLS-1$
		text.setMaximumSize(new Dimension(Integer.MAX_VALUE, text.getMaximumSize().height));
		text.setMinimumSize(new Dimension(text.getMinimumSize().width, text.getMaximumSize().height));
		f.add(text);
		f.setVisible(true);
		
		File input=choose();
		BluePrintBook bp=new BluePrintBook();
		File inputFolder=input.getParentFile();
		File[] fs=inputFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mid")||name.toLowerCase().endsWith(".midi"));
		for(File f:fs) {
			bp.addBluePrint(makeBluePrint(f));
		}
		System.out.println(bp.size());
		JTextArea area = new JTextArea(10, 40);
		JScrollPane pane = new JScrollPane();
		area.setText(Utils.EncodeFson(bp));
		JOptionPane.showOptionDialog(null,pane, "Copy Blueprint code", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, null, null);
	}
	public static BluePrint makeBluePrint(File input) throws InvalidMidiDataException, IOException {
		MidiSheet ms=new MidiSheet(input,0,1);
		BluePrint bp=new BluePrint();
		bp.addIcon(SignalID.I_PS);
		bp.addIcon(SignalID.V_M);
		bp.addIcon(SignalID.V_I);
		bp.addIcon(SignalID.V_D);
		toCircuit(ms,bp);
		ms.Combine();
		bp.setName(input.getName().substring(0,input.getName().lastIndexOf('.'))+" - "+(ms.tracks.get(0).getNote(ms.tracks.get(0).getSize()-1).ticks+20)+"tick");
		return bp;
	}
	public static void toCircuit(MidiSheet ms,BluePrint bp) {
		boolean addLights=true;
		Map<Integer,Set<Integer>> tracks=ms.SplitAll();
		int cx=0;
		TreeSet<Integer> Lower=new TreeSet<>();
		Set<Integer> Higher=new TreeSet<>();
		for(Map.Entry<Integer,Set<Integer>> ent:tracks.entrySet()) {
			if(ent.getKey()<41) {
				Lower.addAll(ent.getValue());
			}else if(ent.getKey()>112) {
				Higher.addAll(ent.getValue());
			}
		}
		Light last=null;
		BaseEntity lastout=null;
		ConstantCombinator clr=new ConstantCombinator(-1,-5);
		if(addLights) {
			bp.addEntity(clr);
			clr.addFilter(SignalID.V_C,0);
			clr.addFilter(SignalID.V_L,0);
			clr.addFilter(SignalID.V_R,0);
			clr.addFilter(SignalID.V_PINK,0);
			clr.addFilter(SignalID.V_T,-20000000);
		}
		ConstantCombinator remp=new ConstantCombinator(-1,-1);
		remp.addFilter(SignalID.V_T,-20000000);
		bp.addEntity(remp);
		Speaker lsp=null;
		if(Lower.size()>0) {
			Set<Integer> Lower1=new TreeSet<>();
			Set<Integer> Lower2=new TreeSet<>();
			int i=0;
			for(Integer val:Lower) {
				if(++i>Lower.size()/2) 
					Lower1.add(val);
				else
					Lower2.add(val);
			}
			BaseEntity out1=makeTrack(bp,cx,Lower2);
			BaseEntity out2=makeTrack(bp,cx-1,Lower1);
			out2.connect(2,out1,2, true);
			out2.connect(1,out1,1,false);
			lastout=out1;
			Speaker sp=new Speaker(cx,-1);
			bp.addEntity(sp);
			sp.connect(1,remp,1,false);
			lsp=sp;
			out1.connect(2,sp,1,true);
			sp.setInstrumentID(2);
			sp.setNoteID(1);
			sp.setVolume(0.4F);
			sp.setGlobally(true);
			sp.setPolyphony(true);
			sp.setCond(new CircuitCondition(SignalID.V_ANY,0,">"));
			if(addLights) {
				DeciderCombinator lc=new DeciderCombinator(cx,-2.5F);
				bp.addEntity(lc);
				lc.setOutput(SignalID.V_L);
				lc.setCopycount(false);
				lc.setDirection(0);
				lc.setCond(new CircuitCondition(SignalID.V_ANY,0,">"));
				lc.connect(1,sp,1, true);
				lc.connect(1,sp,1, false);
				Light lit=new Light(cx,-5F);
				bp.addEntity(lit);
				lit.setUseColor(true);
				lit.setCond(new CircuitCondition(SignalID.V_L,0,">"));
				lit.connect(1,lc,2,true);
				lit.connect(1,clr,1,false);
				last=lit;
			}
		}
		for(Map.Entry<Integer,Set<Integer>> ent:tracks.entrySet()) {
			if(ent.getKey()<41||ent.getKey()>112)continue;
			BaseEntity out=makeTrack(bp,++cx,ent.getValue());
			if(lastout!=null) {
				out.connect(1,lastout,1,false);
			}
			lastout=out;
			Speaker sp=new Speaker(cx,-1);
			bp.addEntity(sp);
			if(lsp==null) {
				sp.connect(1,remp,1,false);
			}else {
				sp.connect(1,lsp,1,false);
			}
			lsp=sp;
			out.connect(2,sp,1,true);
			int nid=ent.getKey()-53;
			if(nid<0) {
				nid+=12;
				sp.setNoteID(nid);
				sp.setInstrumentID(4);
			}else if(nid>47) {
				nid-=24;
				sp.setInstrumentID(8);
				sp.setNoteID(nid);
			}else
				sp.setNoteID(nid);
			sp.setVolume(0.8F);
			sp.setGlobally(true);
			sp.setPolyphony(true);
			sp.setCond(new CircuitCondition(SignalID.V_ANY,0,">"));
			if(addLights) {
				DeciderCombinator lc=new DeciderCombinator(cx,-2.5F);
				bp.addEntity(lc);
				lc.setOutput(SignalID.V_L);
				lc.setCopycount(false);
				lc.setDirection(0);
				lc.setCond(new CircuitCondition(SignalID.V_ANY,0,">"));
				lc.connect(1,sp,1, true);
				lc.connect(1,sp,1, false);
				Light lit=new Light(cx,-5F);
				bp.addEntity(lit);
				lit.setUseColor(true);
				lit.setCond(new CircuitCondition(SignalID.V_L,0,">"));
				lit.connect(1,lc,2,true);
				if(last!=null)
					last.connect(1,lit,1,false);
				else
					lit.connect(1,clr,1,false);
				last=lit;
			}
		}
		if(Higher.size()>0) {
			BaseEntity out=makeTrack(bp,cx,Higher);
			if(lastout!=null) {
				out.connect(1,lastout,1,false);
			}
			lastout=out;
			Speaker sp=new Speaker(cx,-1);
			bp.addEntity(sp);
			out.connect(2,sp,1,true);
			sp.setInstrumentID(2);
			sp.setNoteID(16);
			sp.setVolume(0.7F);
			sp.setGlobally(true);
			sp.setPolyphony(true);
			sp.setCond(new CircuitCondition(SignalID.V_ANY,0,">"));
			if(addLights) {
				DeciderCombinator lc=new DeciderCombinator(cx,-2.5F);
				bp.addEntity(lc);
				lc.setOutput(SignalID.V_L);
				lc.setCopycount(false);
				lc.setDirection(0);
				lc.setCond(new CircuitCondition(SignalID.V_ANY,0,">"));
				lc.connect(1,sp,1, true);
				lc.connect(1,sp,1, false);
				Light lit=new Light(cx,-5F);
				bp.addEntity(lit);
				lit.setUseColor(true);
				lit.setCond(new CircuitCondition(SignalID.V_L,0,">"));
				lit.connect(1,lc,2,true);
				if(last!=null)
					last.connect(1,lit,1,false);
				else
					lit.connect(1,clr,1,false);
				last=lit;
			}
		}
	}
	private static BaseEntity makeTrack(BluePrint bp,int cx,Set<Integer> track) {
		DeciderCombinator fd=new DeciderCombinator(cx,0.5F);
		fd.setDirection(0);
		bp.addEntity(fd);
		int cy=2;
		int num=0;
		ConstantCombinator current = null;
		DeciderCombinator last=fd;
		last.setCopycount(true);
		last.setOutput(SignalID.V_EACH);
		last.setCond(new CircuitCondition(SignalID.V_EACH,SignalID.V_T,"="));
		for(Integer tick:track) {
			if(num==sids.length) {
				DeciderCombinator cd=new DeciderCombinator(cx,cy+0.5F);
				cd.setDirection(0);
				cy+=2;
				cd.setCopycount(true);
				cd.setOutput(SignalID.V_EACH);
				cd.setCond(new CircuitCondition(SignalID.V_EACH,SignalID.V_T,"="));
				bp.addEntity(cd);
				cd.connect(1,last,1,false);
				cd.connect(2,last,2,true);
				num=0;
				last=cd;
			}
			if(num%18==0) {
				current=new ConstantCombinator(cx,cy);
				bp.addEntity(current);
				current.connect(1,last,1,true);
				cy+=1;
			}
			current.addFilter(sids[num],tick+10);
			num++;
		}
		return fd;
	}
	public static void toSpeakers(MidiSheet ms,BluePrint bp) {
		ms.Combine();
		NoteTrack mainTrack=ms.tracks.get(0);
		int sqr=(int) Math.sqrt(mainTrack.getSize()*25/24);
		sqr/=5;
		sqr*=5;
		Speaker lsp=null;
		int lastmax=0;
		int lastmin=0;
		for(int i=0;i<mainTrack.getSize();i++) {
			int cx=i%sqr;
			int cy=i/sqr;
			NoteInfo note=mainTrack.getNote(i);
			if(cx%5-2==0&&cy%5-2==0) {
				bp.addEntity(new WoodenPole(cx,cy));
				continue;
			}
			if((note.key<41&&Math.abs(lastmin-note.ticks)<5)||(note.key>112&&Math.abs(lastmax-note.ticks)<5)) {
				System.out.println("repeat illegal notes found");
				mainTrack.remove(i);
				i--;
				continue;
			}
			Speaker sp=new Speaker(cx,cy);
			bp.addEntity(sp);
			if(i%sqr==0) {
				Entity ent=bp.getEntityAt(cx, cy-1);
				if(ent!=null) {
					sp.connect(1,ent,1,true);
				}
			}else if(lsp!=null) {
				sp.connect(1,lsp,1,true);
			}
			sp.setCond(new CircuitCondition(SignalID.V_T,(int)note.ticks+10,"="));
			sp.setGlobally(true);
			int nid=note.key-53;
			if(nid<0) {
				nid+=12;
				if(nid<0) {
					sp.setVolume(0.5F);
					sp.setInstrumentID(2);
					sp.setNoteID(1);
					lastmin=(int) note.ticks;
					System.out.println("too low,use drum instead");
				}else {
					sp.setNoteID(nid);
					sp.setInstrumentID(4);
				}
			}else if(nid>47) {
				nid-=24;
				if(nid>35) {
					sp.setVolume(0.7F);
					sp.setInstrumentID(2);
					sp.setNoteID(16);
					lastmax=(int) note.ticks;
					System.out.println("too high,use bell instead");
				}else {
					sp.setInstrumentID(8);
					sp.setNoteID(nid);
				}
			}else
				sp.setNoteID(nid);
			lsp=sp;
		}
		if((mainTrack.getSize()/sqr)%5<=2) {
			int cy=mainTrack.getSize()/sqr/5;
			cy+=1;
			cy*=5;
			cy-=3;
			for(int i=0;i<sqr/5;i++) {
				if(bp.getEntityAt(i*5+2, cy)==null)
					bp.addEntity(new WoodenPole(i*5+2,cy));
			}
		}
	}

	public static File choose() {
		JFileChooser jfc = new JFileChooser(new File("./"));
		jfc.setDialogTitle("Select midi file");
		FileNameExtensionFilter restrict = new FileNameExtensionFilter("midi file","mid", "midi");
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.addChoosableFileFilter(restrict);
		if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
			return null;
		return jfc.getSelectedFile();
	}
}
