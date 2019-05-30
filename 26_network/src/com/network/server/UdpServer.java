package com.network.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpServer {
	public static void main(String[] args) throws UnknownHostException {
		int port = 8889;
		InetAddress address = InetAddress.getLocalHost().getLocalHost();
		DatagramSocket server = null;
		Scanner sc = new Scanner(System.in);

		try {
			server = new DatagramSocket(port);
			System.out.print("보낼 문자 : ");
			String msg = sc.nextLine();
			DatagramPacket packet = 
					new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, 9999);

			server.send(packet);
			
			byte[] data = new byte[512];
			packet = new DatagramPacket(data, data.length);
			server.receive(packet);
			
			System.out.println(new String(packet.getData()));

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
