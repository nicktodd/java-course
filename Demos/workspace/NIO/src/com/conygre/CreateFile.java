package com.conygre;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CreateFile {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("stuff.txt");
		char[] data = {'h','e','l','l','o','!','\n'};

		Charset charSet = Charset.defaultCharset();//Charset.forName("US-ASCII");
		CharsetEncoder ce = charSet.newEncoder();

		CharBuffer cb = CharBuffer.wrap(data);
		ByteBuffer bb = ByteBuffer.allocateDirect(16);
		WritableByteChannel channel = Channels.newChannel(fos);

		//ce.encode(cb, bb, false);

		ce.encode(cb, bb, true);
		ce.flush(bb);

		channel.write(bb);
		channel.close();
		fos.close();
		
	}
}
