package com.khjxiaogu.factorio.objects;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// TODO: Auto-generated Javadoc
/**
 * Enum SignalID.
 *
 * @author khjxiaogu
 * file: SignalID.java
 * time: 2020年8月1日
 */
public enum SignalID implements FsonSerializable {

	/** The virtual-0.. */
	V_0(SignalType.V,makeSignal("0")),
	
	/** The virtual-1.*/
	V_1(SignalType.V,makeSignal("1")),
	
	/** The virtual-2.*/
	V_2(SignalType.V,makeSignal("2")),
	
	/** The virtual-3.*/
	V_3(SignalType.V,makeSignal("3")),
	
	/** The virtual-4.*/
	V_4(SignalType.V,makeSignal("4")),
	
	/** The virtual-5.*/
	V_5(SignalType.V,makeSignal("5")),
	
	/** The virtual-6.*/
	V_6(SignalType.V,makeSignal("6")),
	
	/** The virtual-7.*/
	V_7(SignalType.V,makeSignal("7")),
	
	/** The virtual-8.*/
	V_8(SignalType.V,makeSignal("8")),
	
	/** The virtual-9.*/
	V_9(SignalType.V,makeSignal("9")),
	
	/** The virtual-a.*/
	V_A(SignalType.V,makeSignal("A")),
	
	/** The virtual-b.*/
	V_B(SignalType.V,makeSignal("B")),
	
	/** The virtual-c.*/
	V_C(SignalType.V,makeSignal("C")),
	
	/** The virtual-d.*/
	V_D(SignalType.V,makeSignal("D")),
	
	/** The virtual-e.*/
	V_E(SignalType.V,makeSignal("E")),
	
	/** The virtual-f.*/
	V_F(SignalType.V,makeSignal("F")),
	
	/** The virtual-g.*/
	V_G(SignalType.V,makeSignal("G")),
	
	/** The virtual-h.*/
	V_H(SignalType.V,makeSignal("H")),
	
	/** The virtual-i.*/
	V_I(SignalType.V,makeSignal("I")),
	
	/** The virtual-j.*/
	V_J(SignalType.V,makeSignal("J")),
	
	/** The virtual-k.*/
	V_K(SignalType.V,makeSignal("K")),
	
	/** The virtual-l.*/
	V_L(SignalType.V,makeSignal("L")),
	
	/** The virtual-m.*/
	V_M(SignalType.V,makeSignal("M")),
	
	/** The virtual-n.*/
	V_N(SignalType.V,makeSignal("N")),
	
	/** The virtual-o.*/
	V_O(SignalType.V,makeSignal("O")),
	
	/** The virtual-p.*/
	V_P(SignalType.V,makeSignal("P")),
	
	/** The virtual-q.*/
	V_Q(SignalType.V,makeSignal("Q")),
	
	/** The virtual-r.*/
	V_R(SignalType.V,makeSignal("R")),
	
	/** The virtual-s.*/
	V_S(SignalType.V,makeSignal("S")),
	
	/** The virtual-t.*/
	V_T(SignalType.V,makeSignal("T")),
	
	/** The virtual-u.*/
	V_U(SignalType.V,makeSignal("U")),
	
	/** The virtual-v.*/
	V_V(SignalType.V,makeSignal("V")),
	
	/** The virtual-w.*/
	V_W(SignalType.V,makeSignal("W")),
	
	/** The virtual-x.*/
	V_X(SignalType.V,makeSignal("X")),
	
	/** The virtual-y.*/
	V_Y(SignalType.V,makeSignal("Y")),
	
	/** The virtual-z.*/
	V_Z(SignalType.V,makeSignal("Z")),
	
	/** The virtual-red.*/
	V_RED(SignalType.V,makeSignal("red")),
	
	/** The virtual-green.*/
	V_GREEN(SignalType.V,makeSignal("green")),
	
	/** The virtual-blue.*/
	V_BLUE(SignalType.V,makeSignal("blue")),
	
	/** The virtual-yellow.*/
	V_YELLOW(SignalType.V,makeSignal("yellow")),
	
	/** The virtual-pink.*/
	V_PINK(SignalType.V,makeSignal("pink")),
	
	/** The virtual-cyan.*/
	V_CYAN(SignalType.V,makeSignal("cyan")),
	
	/** The virtual-white.*/
	V_WHITE(SignalType.V,makeSignal("white")),
	
	/** The virtual-grey.*/
	V_GREY(SignalType.V,makeSignal("grey")),
	
	/** The virtual-black.*/
	V_BLACK(SignalType.V,makeSignal("black")),
	
	/** The virtual-every.*/
	V_EVERY(SignalType.V,makeSignal("everything")),
	
	/** The virtual-each.*/
	V_EACH(SignalType.V,makeSignal("each")),
	
	/** The virtual-any.*/
	V_ANY(SignalType.V,makeSignal("anything")),
	
	/** The item-programmable-speaker.*/
	I_PS(SignalType.I,"programmable-speaker"),
	;
	private final SignalType type;
	private final String name;
	
	/**
	 * Enum SignalType.
	 *
	 * @author khjxiaogu
	 * file: SignalID.java
	 * time: 2020年8月1日
	 */
	public enum SignalType{
		
		/** The virtual.*/
		V("virtual"),
		
		/** The item.*/
		I("item"),
		
		/** The fluid.*/
		F("fluid");
		private SignalType(String type) {
			this.type = type;
		}
		private final String type;
		
		/**
		 * Gets the String type.<br>
		 *
		 * @return type<br>
		 */
		public String getType() {
			return type;
		}
		
	}
	private SignalID(SignalType type, String name) {
		this.type = type;
		this.name = name;
	}
	private static String makeSignal(String rn) {
		return "signal-"+rn;
	}
	
	@Override
	public JsonElement Serialize() {
		JsonObject jo=new JsonObject();
		jo.addProperty("type", type.getType());
		jo.addProperty("name",name);
		return jo;
	}

}
