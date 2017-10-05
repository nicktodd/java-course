package com.conygre;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class TestBuffer {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("stuff.txt");

		ReadableByteChannel source = Channels.newChannel(fis);
		WritableByteChannel output = Channels.newChannel(System.out);

		ByteBuffer buffer = ByteBuffer.allocateDirect(16);
		int x = 0;
		while ((x = source.read(buffer)) != -1) {
			System.out.println("\n\nNew line(" + x + "):");
			buffer.flip();
			output.write(buffer);
			buffer.compact();
		}		

		source.close();
		output.close();
		fis.close();
		

	}
}
