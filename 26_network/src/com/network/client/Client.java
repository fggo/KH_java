package com.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	public static void main(String[] args) {
		int port=8888;
		BufferedReader br=null;
		PrintWriter pw=null;
		try {
			String serverIp=InetAddress.getLocalHost().getHostAddress();
			
			Socket socket=new Socket(serverIp, port);
			
			if(socket!=null) {
				InputStream input=socket.getInputStream();
				OutputStream output=socket.getOutputStream();
				br=new BufferedReader(new InputStreamReader(input));
				pw=new PrintWriter(output);
				
				Scanner sc=new Scanner(System.in);

				//서버에 내용을 보내는 로직
				do {
					System.out.print("대화 입력 : ");
					String message=sc.nextLine();
					
					pw.println(message);
					pw.flush();
					
					if(message.equals("exit")) {
						System.out.println("프로그램을 종료합니다.");
						break;
					}
					
					//서버에서 전송한 내용을 클라이언트에 출력해주는 것
					System.out.println(br.readLine());
					
				}while(true);
				
			}
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
