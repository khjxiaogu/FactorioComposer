package com.khjxiaogu.factorio;

import com.khjxiaogu.factorio.composer.FactorioComposer;
import com.khjxiaogu.factorio.objects.Entity;
import com.khjxiaogu.factorio.objects.SignalID;
import com.khjxiaogu.factorio.objects.Utils;
import com.khjxiaogu.factorio.objects.entities.CircuitCondition;
import com.khjxiaogu.factorio.objects.entities.DeciderCombinator;
import com.khjxiaogu.factorio.objects.items.BluePrint;

public class EncoderComposer {

	public EncoderComposer() {
	}

	public static void main(String[] args) {
		BluePrint bp=new BluePrint();
		bp.setName("Encoders");
		bp.addIcon(SignalID.V_E);
		bp.addIcon(SignalID.V_N);
		bp.addIcon(SignalID.V_C);
		int cx=0;
		float cy=-1.5F;
		DeciderCombinator last=null;
		for(int i=0;FactorioComposer.sids[i]!=SignalID.V_P;i++) {
			if(i%6==0) {
				cy+=2;
				cx=0;
			}
			DeciderCombinator enc=new DeciderCombinator(cx++,cy);
			enc.setOutput(FactorioComposer.sids[i]);
			enc.setCopycount(false);
			enc.setCond(new CircuitCondition(SignalID.V_S,i,"="));
			bp.addEntity(enc);
			if(cx==1&&cy>0.5) {
				Entity ll=bp.getEntityAt(0,cy-2);
				enc.connect(1,ll,1,true);
				enc.connect(1,ll,1,true);
				enc.connect(2,ll,2,true);
				enc.connect(2,ll,2,false);
			}else if(last!=null) {
				last.connect(1,enc,1,true);
				last.connect(1,enc,1,true);
				last.connect(2,enc,2,true);
				last.connect(2,enc,2,false);
			}
			last=enc;
		}
		System.out.println(Utils.EncodeFson(bp));
	}

}
