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
package com.khjxiaogu.factorio;

import com.khjxiaogu.factorio.composer.FactorioComposer;
import com.khjxiaogu.factorio.objects.Entity;
import com.khjxiaogu.factorio.objects.SignalID;
import com.khjxiaogu.factorio.objects.Utils;
import com.khjxiaogu.factorio.objects.entities.ArithmeticCombinator;
import com.khjxiaogu.factorio.objects.entities.ArithmeticCondition;
import com.khjxiaogu.factorio.objects.entities.CircuitCondition;
import com.khjxiaogu.factorio.objects.entities.DeciderCombinator;
import com.khjxiaogu.factorio.objects.items.BluePrint;

public class TimerComposer {

	public TimerComposer() {
	}

	public static void main(String[] args) {
		BluePrint bp=new BluePrint();
		bp.setName("Timers");
		bp.addIcon(SignalID.V_E);
		bp.addIcon(SignalID.V_N);
		bp.addIcon(SignalID.V_C);
		int cx=0;
		float cy=-1.5F;
		ArithmeticCombinator last=null;
		for(int i=0;FactorioComposer.sids[i]!=SignalID.V_P;i++) {
			if(i%6==0) {
				cy+=2;
				cx=0;
			}
			ArithmeticCombinator enc=new ArithmeticCombinator(cx++,cy);
			enc.setOutput(SignalID.V_V);
			enc.setCond(new ArithmeticCondition(FactorioComposer.sids[i],0,"*"));
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
