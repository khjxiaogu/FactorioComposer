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
package com.khjxiaogu.factorio.composer;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.sound.midi.InvalidMidiDataException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.khjxiaogu.factorio.composer.midi.MidiSheet;
import com.khjxiaogu.factorio.composer.midi.NoteInfo;
import com.khjxiaogu.factorio.composer.midi.NoteTrack;
import com.khjxiaogu.factorio.objects.BaseEntity;
import com.khjxiaogu.factorio.objects.Entity;
import com.khjxiaogu.factorio.objects.Position;
import com.khjxiaogu.factorio.objects.SignalID;
import com.khjxiaogu.factorio.objects.Utils;
import com.khjxiaogu.factorio.objects.entities.CircuitCondition;
import com.khjxiaogu.factorio.objects.entities.ConstantCombinator;
import com.khjxiaogu.factorio.objects.entities.DeciderCombinator;
import com.khjxiaogu.factorio.objects.entities.Light;
import com.khjxiaogu.factorio.objects.entities.MediumPole;
import com.khjxiaogu.factorio.objects.entities.Speaker;
import com.khjxiaogu.factorio.objects.entities.WoodenPole;
import com.khjxiaogu.factorio.objects.items.BluePrint;
import com.khjxiaogu.factorio.objects.items.BluePrintBook;

public class FactorioComposer {
	static JFrame f;
	public static SignalID[] sids=new SignalID[] 
			{SignalID.V_0,SignalID.V_1,SignalID.V_2,SignalID.V_3,SignalID.V_4,SignalID.V_5,
			 SignalID.V_6,SignalID.V_7,SignalID.V_8,SignalID.V_9,SignalID.V_A,SignalID.V_B,
			 SignalID.V_C,SignalID.V_D,SignalID.V_E,SignalID.V_F,SignalID.V_G,SignalID.V_H,
			 SignalID.V_I,SignalID.V_J,SignalID.V_K,SignalID.V_L,SignalID.V_M,SignalID.V_N,
			 SignalID.V_O,SignalID.V_P,SignalID.V_Q,SignalID.V_R,SignalID.V_S,SignalID.V_BLUE,
			 SignalID.V_U,SignalID.V_V,SignalID.V_W,SignalID.V_X,SignalID.V_Y,SignalID.V_Z,
			 SignalID.V_CHECK, SignalID.V_DENY, SignalID.V_NO_ENTRY, SignalID.V_HEART, SignalID.V_ALERT,
			 SignalID.V_STAR, SignalID.V_INFO, SignalID.V_DOT, SignalID.V_COMMA, SignalID.V_LETTER_DOT,
			 SignalID.V_EXCLAMATION_MARK, SignalID.V_QUESTION_MARK, SignalID.V_COLON, SignalID.V_SLASH, SignalID.V_APOSTROPHE,
			 SignalID.V_QUOTATION_MARK, SignalID.V_AMPERSAND, SignalID.V_CIRCUMFLEX_ACCENT, SignalID.V_NUMBER_SIGN, SignalID.V_PERCENT,
			 SignalID.V_PLUS, SignalID.V_MINUS, SignalID.V_MULTIPLICATION, SignalID.V_DIVISION, SignalID.V_EQUAL,
			 SignalID.V_NOT_EQUAL, SignalID.V_LESS_THAN, SignalID.V_GREATER_THAN, SignalID.V_LESS_THAN_OR_EQUAL_TO, SignalID.V_GREATER_THAN_OR_EQUAL_TO,
			 SignalID.V_LEFT_PARENTHESIS, SignalID.V_RIGHT_PARENTHESIS, SignalID.V_LEFT_SQUARE_BRACKET, SignalID.V_RIGHT_SQUARE_BRACKET, SignalID.V_SHAPE_VERTICAL,
			 SignalID.V_SHAPE_HORIZONTAL, SignalID.V_SHAPE_DIAGONAL, SignalID.V_SHAPE_DIAGONAL_2, SignalID.V_SHAPE_CURVE, SignalID.V_SHAPE_CURVE_2,
			 SignalID.V_SHAPE_CURVE_3, SignalID.V_SHAPE_CURVE_4, SignalID.V_SHAPE_CROSS, SignalID.V_SHAPE_DIAGONAL_CROSS, SignalID.V_SHAPE_CORNER,
			 SignalID.V_SHAPE_CORNER_2, SignalID.V_SHAPE_CORNER_3, SignalID.V_SHAPE_CORNER_4, SignalID.V_SHAPE_T, SignalID.V_SHAPE_T_2,
			 SignalID.V_SHAPE_T_3, SignalID.V_SHAPE_T_4, SignalID.V_SHAPE_CIRCLE, SignalID.V_UP_ARROW, SignalID.V_UP_RIGHT_ARROW,
			 SignalID.V_RIGHT_ARROW, SignalID.V_DOWN_RIGHT_ARROW, SignalID.V_DOWN_ARROW, SignalID.V_DOWN_LEFT_ARROW, SignalID.V_LEFT_ARROW,
			 SignalID.V_UP_LEFT_ARROW, SignalID.V_RIGHTWARDS_LEFTWARDS_ARROW, SignalID.V_UPWARDS_DOWNWARDS_ARROW, SignalID.V_SHUFFLE, SignalID.V_LEFT_RIGHT_ARROW,
			 SignalID.V_UP_DOWN_ARROW, SignalID.V_CLOCKWISE_CIRCLE_ARROW, SignalID.V_ANTICLOCKWISE_CIRCLE_ARROW, SignalID.V_INPUT, SignalID.V_OUTPUT,
			 SignalID.V_ITEM_PARAMETER, SignalID.V_FUEL_PARAMETER, SignalID.V_FLUID_PARAMETER, SignalID.V_PARAMETER, SignalID.V_FUEL,
			 SignalID.V_LIGHTNING, SignalID.V_BATTERY_FULL, SignalID.V_BATTERY_MID_LEVEL, SignalID.V_BATTERY_LOW, SignalID.V_RADIOACTIVITY,
			 SignalID.V_THERMOMETER_BLUE, SignalID.V_THERMOMETER_RED, SignalID.V_FIRE, SignalID.V_EXPLOSION, SignalID.V_SNOWFLAKE,
			 SignalID.V_LIQUID, SignalID.V_STACK_SIZE, SignalID.V_RECYCLE, SignalID.V_TRASH_BIN, SignalID.V_SCIENCE_PACK,
			 SignalID.V_MAP_MARKER, SignalID.V_WHITE_FLAG, SignalID.V_LOCK, SignalID.V_UNLOCK, SignalID.V_MINING,
			 SignalID.V_CLOCK, SignalID.V_HOURGLASS, SignalID.V_ALARM, SignalID.V_SUN, SignalID.V_MOON,
			 SignalID.V_SPEED, SignalID.V_SKULL, SignalID.V_DAMAGE, SignalID.V_WEAPON, SignalID.V_GHOST
			};
	final static float volorg=0.4f;
	public static void main(String[] args) throws Exception {
		
		f = new JFrame(Messages.getString("FactorioComposer.title")); //$NON-NLS-1$
		f.setLayout(new BoxLayout(f.getContentPane(), BoxLayout.Y_AXIS));
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setResizable(false);
		JButton button1 = new JButton(Messages.getString("FactorioComposer.fromfolder")); //$NON-NLS-1$
		JButton button2 = new JButton(Messages.getString("FactorioComposer.fromfile")); //$NON-NLS-1$
		button1.addActionListener(ev -> {
			try {
				exportBPB();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		button2.addActionListener(ev -> {
			try {
				exportBP();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		JLabel p3=new JLabel();
		p3.setText(Messages.getString("FactorioComposer.author")); //$NON-NLS-1$
		JLabel p4= new JLabel();
		p4.setText(Messages.getString("FactorioComposer.viewgithub")); //$NON-NLS-1$
		p4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		p4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/khjxiaogu/FactorioComposer")); //$NON-NLS-1$
                } catch (Exception ex) {
                    //It looks like there's a problem
                }
            }
        });
		p.add(button1);
		p.add(button2);
		f.add(p);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.pack();
		f.setVisible(true);
	}
	public static void exportBPB() throws InvalidMidiDataException, IOException {
		BluePrintBook bp=new BluePrintBook();
		File inputFolder=chooseFolder();
		if(inputFolder==null)return;
		File[] fs=inputFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mid")||name.toLowerCase().endsWith(".midi")||name.toLowerCase().endsWith(".smr")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		for(File f:fs) {
			bp.addBluePrint(makeBluePrint(f));
		}
		JTextArea area = new JTextArea(10, 40);
		JScrollPane pane = new JScrollPane(area);
		area.setText(Utils.EncodeFson(bp));
		JOptionPane.showOptionDialog(f,pane, Messages.getString("FactorioComposer.copy_bp"), JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, null, null); //$NON-NLS-1$
	}
	public static void exportBP() throws InvalidMidiDataException, IOException {
		File input=choose();
		if(input==null)return;
		JTextArea area = new JTextArea(10, 40);
		JScrollPane pane = new JScrollPane(area);
		String st=Utils.EncodeFson(makeBluePrint(input));
		area.setText(st);
		JOptionPane.showOptionDialog(f,pane, Messages.getString("FactorioComposer.copy_bp"), JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE, null, null, null); //$NON-NLS-1$
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
		bp.setName(input.getName().substring(0,input.getName().lastIndexOf('.'))+" - "+(ms.getTotalTicks()+20)+Messages.getString("FactorioComposer.tick")); //$NON-NLS-1$ //$NON-NLS-2$
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
		Entity lastpole=null;
		remp.addFilter(SignalID.V_T,-20000000);
		bp.addEntity(remp);
		ConstantCombinator cc=new ConstantCombinator(-2,1);
		cc.addFilter(SignalID.V_V, (int)ms.getTotalTicks()+20);
		bp.addEntity(cc);
		lastout=cc;
		Speaker lsp=null;
		int maxX=0;
		int maxY=0;
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
			
			
			TrackInfo tout1=makeTrack(bp,cx,Lower2);
			TrackInfo tout2=makeTrack(bp,cx-1,Lower1);
			maxY=Math.max(tout1.cy, maxY);
			maxY=Math.max(tout2.cy, maxY);
			BaseEntity out1=tout1.combinator;
			BaseEntity out2=tout2.combinator;
			if(lastout!=null)
				lastout.connect(1, out2, 1, false);
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
			sp.setVolume(volorg-0.3F);
			sp.setSurface();
			sp.setPolyphony(true);
			sp.setCond(new CircuitCondition(SignalID.V_ANY,0,">")); //$NON-NLS-1$
			if(addLights) {
				DeciderCombinator lc=new DeciderCombinator(cx,-2.5F);
				bp.addEntity(lc);
				lc.setOutput(SignalID.V_L);
				lc.setCopycount(false);
				lc.setDirection(0);
				lc.setCond(new CircuitCondition(SignalID.V_ANY,0,">")); //$NON-NLS-1$
				lc.connect(1,sp,1, true);
				lc.connect(1,sp,1, false);
				Light lit=new Light(cx,-5F);
				bp.addEntity(lit);
				lit.setUseColor(true);
				lit.setCond(new CircuitCondition(SignalID.V_L,0,">")); //$NON-NLS-1$
				lit.connect(1,lc,2,true);
				lit.connect(1,clr,1,false);
				last=lit;
			}
		}
		for(Map.Entry<Integer,Set<Integer>> ent:tracks.entrySet()) {
			if(ent.getKey()<41||ent.getKey()>112)continue;
			TrackInfo tout=makeTrack(bp,++cx,ent.getValue());
			maxY=Math.max(tout.cy, maxY);
			BaseEntity out=tout.combinator;
			if((cx+2)%7==3) {
				MediumPole pole=new MediumPole(cx,-4f);
				bp.addEntity(pole);
				if(lastpole!=null)
					bp.connectWire(lastpole, pole);
				lastpole=pole;
			}
			maxX=cx;
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
			sp.setVolume(volorg+0.1f);
			sp.setSurface();
			sp.setPolyphony(true);
			sp.setCond(new CircuitCondition(SignalID.V_ANY,0,">")); //$NON-NLS-1$
			if(addLights) {
				DeciderCombinator lc=new DeciderCombinator(cx,-2.5F);
				bp.addEntity(lc);
				lc.setOutput(SignalID.V_L);
				lc.setCopycount(false);
				lc.setDirection(0);
				lc.setCond(new CircuitCondition(SignalID.V_ANY,0,">")); //$NON-NLS-1$
				lc.connect(1,sp,1, true);
				lc.connect(1,sp,1, false);
				Light lit=new Light(cx,-5F);
				bp.addEntity(lit);
				lit.setUseColor(true);
				lit.setCond(new CircuitCondition(SignalID.V_L,0,">")); //$NON-NLS-1$
				lit.connect(1,lc,2,true);
				if(last!=null)
					last.connect(1,lit,1,false);
				else
					lit.connect(1,clr,1,false);
				last=lit;
			}
		}
		if(Higher.size()>0) {
			TrackInfo tout=makeTrack(bp,cx,Higher);
			maxY=Math.max(tout.cy, maxY);
			BaseEntity out=tout.combinator;
			if(lastout!=null) {
				out.connect(1,lastout,1,false);
			}
			lastout=out;
			Speaker sp=new Speaker(cx,-1);
			bp.addEntity(sp);
			out.connect(2,sp,1,true);
			sp.setInstrumentID(2);
			sp.setNoteID(16);
			sp.setVolume(volorg);
			sp.setSurface();
			sp.setPolyphony(true);
			sp.setCond(new CircuitCondition(SignalID.V_ANY,0,">")); //$NON-NLS-1$
			if(addLights) {
				DeciderCombinator lc=new DeciderCombinator(cx,-2.5F);
				bp.addEntity(lc);
				lc.setOutput(SignalID.V_L);
				lc.setCopycount(false);
				lc.setDirection(0);
				lc.setCond(new CircuitCondition(SignalID.V_ANY,0,">")); //$NON-NLS-1$
				lc.connect(1,sp,1, true);
				lc.connect(1,sp,1, false);
				Light lit=new Light(cx,-5F);
				bp.addEntity(lit);
				lit.setUseColor(true);
				lit.setCond(new CircuitCondition(SignalID.V_L,0,">")); //$NON-NLS-1$
				lit.connect(1,lc,2,true);
				if(last!=null)
					last.connect(1,lit,1,false);
				else
					lit.connect(1,clr,1,false);
				last=lit;
			}
		}
		for(int dx=0;dx<maxX;dx++) {
			for(int dy=0;dy<maxY;dy++) {
				if((dx+2)%7==3&&(dy)%7==3) {
					MediumPole pole=new MediumPole(dx,dy);
					bp.addEntity(pole);
					lastpole=bp.getEntityAt(dx, dy-7);
					if(lastpole!=null)
						bp.connectWire(pole, lastpole);
				}
				
			}
		}
	}
	private static class TrackInfo{
		int cy;
		BaseEntity combinator;
		public TrackInfo(int cy, BaseEntity combinator) {
			super();
			this.cy = cy;
			this.combinator = combinator;
		}
	}
	private static TrackInfo makeTrack(BluePrint bp,int cx,Set<Integer> track) {
		DeciderCombinator fd=new DeciderCombinator(cx,0.5F);
		fd.setDirection(0);
		bp.addEntity(fd);
		int cy=2;
		int num=0;
		ConstantCombinator current = null;
		DeciderCombinator last=fd;
		last.setCopycount(true);
		last.setOutput(SignalID.V_EACH);
		last.setCond(new CircuitCondition(SignalID.V_EACH,SignalID.V_T,"=")); //$NON-NLS-1$
		
		
		boolean isPowered=false;
		for(Integer tick:track) {
			if(num==sids.length) {
				DeciderCombinator cd=new DeciderCombinator(cx,cy+0.5F);
				cd.setDirection(0);
				cy+=2;
				cd.setCopycount(true);
				cd.setOutput(SignalID.V_EACH);
				cd.setCond(new CircuitCondition(SignalID.V_EACH,SignalID.V_T,"=")); //$NON-NLS-1$
				bp.addEntity(cd);
				cd.connect(1,last,1,false);
				cd.connect(2,last,2,true);
				num=0;
				last=cd;
				current=null;
			}
			if(current==null) {
				current=new ConstantCombinator(cx,cy);
				bp.addEntity(current);
				current.connect(1,last,1,true);
				cy+=1;
				if(!isPowered) {
					/*MediumPole pole=new MediumPole(cx,cy);
					bp.addEntity(pole);*/
					cy+=1;
					isPowered=true;
				}else
					isPowered=false;
			}
			current.addFilter(sids[num],tick+10);
			num++;
		}
		return new TrackInfo(cy,fd);
	}

	public static File choose() {
		JFileChooser jfc = new JFileChooser(new File("./")); //$NON-NLS-1$
		jfc.setDialogTitle(Messages.getString("FactorioComposer.selectfile")); //$NON-NLS-1$
		FileNameExtensionFilter restrict = new FileNameExtensionFilter(Messages.getString("FactorioComposer.file"),"mid", "midi","smr"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		jfc.setAcceptAllFileFilterUsed(false);
		jfc.addChoosableFileFilter(restrict);
		if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
			return null;
		return jfc.getSelectedFile();
	}
	public static File chooseFolder() {
		JFileChooser jfc = new JFileChooser(new File("./"));  //$NON-NLS-1$
		jfc.setDialogTitle(Messages.getString("FactorioComposer.selectfolder")); //$NON-NLS-1$
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		jfc.setAcceptAllFileFilterUsed(false);
	    if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) 
	    	return null;
	    return jfc.getSelectedFile();
	}
}
