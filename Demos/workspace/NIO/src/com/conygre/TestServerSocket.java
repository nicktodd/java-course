package com.conygre;

import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class TestServerSocket {

	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Usage: java com.conygre.TestServerSocket <filename>");
			System.exit(0);
		}

		FileInputStream fis = new FileInputStream(args[0]);
		ReadableByteChannel source = Channels.newChannel(fis);
		ByteBuffer buffer = ByteBuffer.allocateDirect(256);
		source.read(buffer);

		ServerSocketChannel server = ServerSocketChannel.open();
		server.socket().bind(new InetSocketAddress(4444));
		server.configureBlocking(true);
		
		while (true) {
			System.out.println("Waiting...");
			SocketChannel channel = server.accept();
			if (channel == null) {
				Thread.sleep(1000);
			} else {
				buffer.rewind();
				channel.write(buffer);
				channel.close();
			}
		}

		

	}
}
