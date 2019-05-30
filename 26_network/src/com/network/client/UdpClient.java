package com.network.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class UdpClient {
	public static void main(String[] args) throws UnknownHostException {
		int port = 9999;
		InetAddress ip = InetAddress.getLocalHost().getLocalHost();
		DatagramSocket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			socket = new DatagramSocket(port);
			System.out.print("메시지 입력: ");
			String msg = sc.nextLine();
			DatagramPacket packet = 
					new DatagramPacket(msg.getBytes(), msg.getBytes().length, ip, 8889);
			socket.send(packet);
			
			byte[] data = new byte[512];
			packet = new DatagramPacket(data, data.length);
			socket.receive(packet);
			System.out.println(new String(packet.getData()));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
