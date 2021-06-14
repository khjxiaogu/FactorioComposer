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
