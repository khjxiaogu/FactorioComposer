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

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.zip.Deflater;

// TODO: Auto-generated Javadoc
/**
 * Class Utils.
 *
 * @author khjxiaogu
 * file: Utils.java
 * time: 2020年8月1日
 */
public final class Utils {
	private Utils() {}
	
	/**
	 * Encode entity to import string.<br>
	 *
	 * @param fs the entity
	 * @return return encoded fson
	 */
	public static String EncodeFson(FsonSerializable fs) {
		String org=fs.Serialize().toString();
		Deflater df=new Deflater();
		byte[] raw=org.getBytes(StandardCharsets.UTF_8);
		df.setInput(raw);
		df.finish();
		byte[] out=new byte[1024];
		ByteArrayOutputStream bao=new ByteArrayOutputStream();
		while(!df.finished()) {
			int read=df.deflate(out);
			bao.write(out,0,read);
		}
		return "0"+Base64.getEncoder().encodeToString(bao.toByteArray());
	}
}
