package com.conygre;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestCharSet {

	public static void main(String[] args) {
		String path = "stuff.txt";
		try (FileInputStream fis = new FileInputStream(path);) {
			// get the channel for the input stream
			FileChannel fileChannel = fis.getChannel();
			// create a buffer to read into from the channel
			ByteBuffer buffer = ByteBuffer.allocate(64);
			// begin reading data into the buffer
			int bytesRead = fileChannel.read(buffer);
			while (bytesRead != -1) {
				// write out the number of bytes read into the buffer
				System.out.println("Read: " + bytesRead);
				// flip() sets the limit to the current position (where you have
				// got to)
				// and sets the start to the beginning
				// if you don't do this, then the limit remains where it is and
				// you will
				// miss content and the start is also set to the beginning.
				// so in the first read, the data is missing
				buffer.flip();
				while (buffer.hasRemaining()) {
					System.out.print((char) buffer.get());
				}
				buffer.clear();
				bytesRead = fileChannel.read(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}