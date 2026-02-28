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
	/** The virtual-check. */
	V_CHECK(SignalType.V, makeSignal("check")),

	/** The virtual-deny. */
	V_DENY(SignalType.V, makeSignal("deny")),

	/** The virtual-no-entry. */
	V_NO_ENTRY(SignalType.V, makeSignal("no-entry")),

	/** The virtual-heart. */
	V_HEART(SignalType.V, makeSignal("heart")),

	/** The virtual-alert. */
	V_ALERT(SignalType.V, makeSignal("alert")),

	/** The virtual-star. */
	V_STAR(SignalType.V, makeSignal("star")),

	/** The virtual-info. */
	V_INFO(SignalType.V, makeSignal("info")),

	/** The virtual-dot. */
	V_DOT(SignalType.V, makeSignal("dot")),

	/** The virtual-comma. */
	V_COMMA(SignalType.V, makeSignal("comma")),

	/** The virtual-letter-dot. */
	V_LETTER_DOT(SignalType.V, makeSignal("letter-dot")),

	/** The virtual-exclamation-mark. */
	V_EXCLAMATION_MARK(SignalType.V, makeSignal("exclamation-mark")),

	/** The virtual-question-mark. */
	V_QUESTION_MARK(SignalType.V, makeSignal("question-mark")),

	/** The virtual-colon. */
	V_COLON(SignalType.V, makeSignal("colon")),

	/** The virtual-slash. */
	V_SLASH(SignalType.V, makeSignal("slash")),

	/** The virtual-apostrophe. */
	V_APOSTROPHE(SignalType.V, makeSignal("apostrophe")),

	/** The virtual-quotation-mark. */
	V_QUOTATION_MARK(SignalType.V, makeSignal("quotation-mark")),

	/** The virtual-ampersand. */
	V_AMPERSAND(SignalType.V, makeSignal("ampersand")),

	/** The virtual-circumflex-accent. */
	V_CIRCUMFLEX_ACCENT(SignalType.V, makeSignal("circumflex-accent")),

	/** The virtual-number-sign. */
	V_NUMBER_SIGN(SignalType.V, makeSignal("number-sign")),

	/** The virtual-percent. */
	V_PERCENT(SignalType.V, makeSignal("percent")),

	/** The virtual-plus. */
	V_PLUS(SignalType.V, makeSignal("plus")),

	/** The virtual-minus. */
	V_MINUS(SignalType.V, makeSignal("minus")),

	/** The virtual-multiplication. */
	V_MULTIPLICATION(SignalType.V, makeSignal("multiplication")),

	/** The virtual-division. */
	V_DIVISION(SignalType.V, makeSignal("division")),

	/** The virtual-equal. */
	V_EQUAL(SignalType.V, makeSignal("equal")),

	/** The virtual-not-equal. */
	V_NOT_EQUAL(SignalType.V, makeSignal("not-equal")),

	/** The virtual-less-than. */
	V_LESS_THAN(SignalType.V, makeSignal("less-than")),

	/** The virtual-greater-than. */
	V_GREATER_THAN(SignalType.V, makeSignal("greater-than")),

	/** The virtual-less-than-or-equal-to. */
	V_LESS_THAN_OR_EQUAL_TO(SignalType.V, makeSignal("less-than-or-equal-to")),

	/** The virtual-greater-than-or-equal-to. */
	V_GREATER_THAN_OR_EQUAL_TO(SignalType.V, makeSignal("greater-than-or-equal-to")),

	/** The virtual-left-parenthesis. */
	V_LEFT_PARENTHESIS(SignalType.V, makeSignal("left-parenthesis")),

	/** The virtual-right-parenthesis. */
	V_RIGHT_PARENTHESIS(SignalType.V, makeSignal("right-parenthesis")),

	/** The virtual-left-square-bracket. */
	V_LEFT_SQUARE_BRACKET(SignalType.V, makeSignal("left-square-bracket")),

	/** The virtual-right-square-bracket. */
	V_RIGHT_SQUARE_BRACKET(SignalType.V, makeSignal("right-square-bracket")),

	/** The virtual-shape-vertical. */
	V_SHAPE_VERTICAL(SignalType.V, ("shape-vertical")),

	/** The virtual-shape-horizontal. */
	V_SHAPE_HORIZONTAL(SignalType.V, ("shape-horizontal")),

	/** The virtual-shape-diagonal. */
	V_SHAPE_DIAGONAL(SignalType.V, ("shape-diagonal")),

	/** The virtual-shape-diagonal-2. */
	V_SHAPE_DIAGONAL_2(SignalType.V, ("shape-diagonal-2")),

	/** The virtual-shape-curve. */
	V_SHAPE_CURVE(SignalType.V, ("shape-curve")),

	/** The virtual-shape-curve-2. */
	V_SHAPE_CURVE_2(SignalType.V, ("shape-curve-2")),

	/** The virtual-shape-curve-3. */
	V_SHAPE_CURVE_3(SignalType.V, ("shape-curve-3")),

	/** The virtual-shape-curve-4. */
	V_SHAPE_CURVE_4(SignalType.V, ("shape-curve-4")),

	/** The virtual-shape-cross. */
	V_SHAPE_CROSS(SignalType.V, ("shape-cross")),

	/** The virtual-shape-diagonal-cross. */
	V_SHAPE_DIAGONAL_CROSS(SignalType.V, ("shape-diagonal-cross")),

	/** The virtual-shape-corner. */
	V_SHAPE_CORNER(SignalType.V, ("shape-corner")),

	/** The virtual-shape-corner-2. */
	V_SHAPE_CORNER_2(SignalType.V, ("shape-corner-2")),

	/** The virtual-shape-corner-3. */
	V_SHAPE_CORNER_3(SignalType.V, ("shape-corner-3")),

	/** The virtual-shape-corner-4. */
	V_SHAPE_CORNER_4(SignalType.V, ("shape-corner-4")),

	/** The virtual-shape-t. */
	V_SHAPE_T(SignalType.V, ("shape-t")),

	/** The virtual-shape-t-2. */
	V_SHAPE_T_2(SignalType.V, ("shape-t-2")),

	/** The virtual-shape-t-3. */
	V_SHAPE_T_3(SignalType.V, ("shape-t-3")),

	/** The virtual-shape-t-4. */
	V_SHAPE_T_4(SignalType.V, ("shape-t-4")),

	/** The virtual-shape-circle. */
	V_SHAPE_CIRCLE(SignalType.V, ("shape-circle")),

	/** The virtual-up-arrow. */
	V_UP_ARROW(SignalType.V, ("up-arrow")),

	/** The virtual-up-right-arrow. */
	V_UP_RIGHT_ARROW(SignalType.V, ("up-right-arrow")),

	/** The virtual-right-arrow. */
	V_RIGHT_ARROW(SignalType.V, ("right-arrow")),

	/** The virtual-down-right-arrow. */
	V_DOWN_RIGHT_ARROW(SignalType.V, ("down-right-arrow")),

	/** The virtual-down-arrow. */
	V_DOWN_ARROW(SignalType.V, ("down-arrow")),

	/** The virtual-down-left-arrow. */
	V_DOWN_LEFT_ARROW(SignalType.V, ("down-left-arrow")),

	/** The virtual-left-arrow. */
	V_LEFT_ARROW(SignalType.V, ("left-arrow")),

	/** The virtual-up-left-arrow. */
	V_UP_LEFT_ARROW(SignalType.V, ("up-left-arrow")),

	/** The virtual-rightwards-leftwards-arrow. */
	V_RIGHTWARDS_LEFTWARDS_ARROW(SignalType.V, makeSignal("rightwards-leftwards-arrow")),

	/** The virtual-upwards-downwards-arrow. */
	V_UPWARDS_DOWNWARDS_ARROW(SignalType.V, makeSignal("upwards-downwards-arrow")),

	/** The virtual-shuffle. */
	V_SHUFFLE(SignalType.V, makeSignal("shuffle")),

	/** The virtual-left-right-arrow. */
	V_LEFT_RIGHT_ARROW(SignalType.V, makeSignal("left-right-arrow")),

	/** The virtual-up-down-arrow. */
	V_UP_DOWN_ARROW(SignalType.V, makeSignal("up-down-arrow")),

	/** The virtual-clockwise-circle-arrow. */
	V_CLOCKWISE_CIRCLE_ARROW(SignalType.V, makeSignal("clockwise-circle-arrow")),

	/** The virtual-anticlockwise-circle-arrow. */
	V_ANTICLOCKWISE_CIRCLE_ARROW(SignalType.V, makeSignal("anticlockwise-circle-arrow")),

	/** The virtual-input. */
	V_INPUT(SignalType.V, makeSignal("input")),

	/** The virtual-output. */
	V_OUTPUT(SignalType.V, makeSignal("output")),

	/** The virtual-item-parameter. */
	V_ITEM_PARAMETER(SignalType.V, makeSignal("item-parameter")),

	/** The virtual-fuel-parameter. */
	V_FUEL_PARAMETER(SignalType.V, makeSignal("fuel-parameter")),

	/** The virtual-fluid-parameter. */
	V_FLUID_PARAMETER(SignalType.V, makeSignal("fluid-parameter")),

	/** The virtual-parameter. */
	V_PARAMETER(SignalType.V, makeSignal("signal-parameter")),

	/** The virtual-fuel. */
	V_FUEL(SignalType.V, makeSignal("fuel")),

	/** The virtual-lightning. */
	V_LIGHTNING(SignalType.V, makeSignal("lightning")),

	/** The virtual-battery-full. */
	V_BATTERY_FULL(SignalType.V, makeSignal("battery-full")),

	/** The virtual-battery-mid-level. */
	V_BATTERY_MID_LEVEL(SignalType.V, makeSignal("battery-mid-level")),

	/** The virtual-battery-low. */
	V_BATTERY_LOW(SignalType.V, makeSignal("battery-low")),

	/** The virtual-radioactivity. */
	V_RADIOACTIVITY(SignalType.V, makeSignal("radioactivity")),

	/** The virtual-thermometer-blue. */
	V_THERMOMETER_BLUE(SignalType.V, makeSignal("thermometer-blue")),

	/** The virtual-thermometer-red. */
	V_THERMOMETER_RED(SignalType.V, makeSignal("thermometer-red")),

	/** The virtual-fire. */
	V_FIRE(SignalType.V, makeSignal("fire")),

	/** The virtual-explosion. */
	V_EXPLOSION(SignalType.V, makeSignal("explosion")),

	/** The virtual-snowflake. */
	V_SNOWFLAKE(SignalType.V, makeSignal("snowflake")),

	/** The virtual-liquid. */
	V_LIQUID(SignalType.V, makeSignal("liquid")),

	/** The virtual-stack-size. */
	V_STACK_SIZE(SignalType.V, makeSignal("stack-size")),

	/** The virtual-recycle. */
	V_RECYCLE(SignalType.V, makeSignal("recycle")),

	/** The virtual-trash-bin. */
	V_TRASH_BIN(SignalType.V, makeSignal("trash-bin")),

	/** The virtual-science-pack. */
	V_SCIENCE_PACK(SignalType.V, makeSignal("science-pack")),

	/** The virtual-map-marker. */
	V_MAP_MARKER(SignalType.V, makeSignal("map-marker")),

	/** The virtual-white-flag. */
	V_WHITE_FLAG(SignalType.V, makeSignal("white-flag")),

	/** The virtual-lock. */
	V_LOCK(SignalType.V, makeSignal("lock")),

	/** The virtual-unlock. */
	V_UNLOCK(SignalType.V, makeSignal("unlock")),

	/** The virtual-mining. */
	V_MINING(SignalType.V, makeSignal("mining")),

	/** The virtual-clock. */
	V_CLOCK(SignalType.V, makeSignal("clock")),

	/** The virtual-hourglass. */
	V_HOURGLASS(SignalType.V, makeSignal("hourglass")),

	/** The virtual-alarm. */
	V_ALARM(SignalType.V, makeSignal("alarm")),

	/** The virtual-sun. */
	V_SUN(SignalType.V, makeSignal("sun")),

	/** The virtual-moon. */
	V_MOON(SignalType.V, makeSignal("moon")),

	/** The virtual-speed. */
	V_SPEED(SignalType.V, makeSignal("speed")),

	/** The virtual-skull. */
	V_SKULL(SignalType.V, makeSignal("skull")),

	/** The virtual-damage. */
	V_DAMAGE(SignalType.V, makeSignal("damage")),

	/** The virtual-weapon. */
	V_WEAPON(SignalType.V, makeSignal("weapon")),

	/** The virtual-ghost. */
	V_GHOST(SignalType.V, makeSignal("ghost")),
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
