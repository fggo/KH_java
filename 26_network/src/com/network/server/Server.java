package com.network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException{
		//포트설정
		int port=8888;
		//Serversocket을 생성
		ServerSocket server=new ServerSocket(port);
		//client가 접속하기를 기다림~~~ 
		//서버의 로직이 종료되지 않게 무한반복실행
		while(true) {
			Socket socket=server.accept();//client요청을 수락
			//요청에 대한 정보(data)를 확인하고(받아오고) 
			//서비스해야되는 정보(data)를 client에게(출력, 전송)
			//입출력 
			InputStream input=socket.getInputStream();
			OutputStream output=socket.getOutputStream();
			//클라이언트하고 연결!
			
			//데이터 전송을 원활하게 하기 위해 보조스트림을 이용
			BufferedReader br=new BufferedReader(new InputStreamReader(input));
			PrintWriter clientOutput=new PrintWriter(output);
			//상대방 모니터에 출력하기 위해 printWriter를 이용
			
			//읽어오고 보내기!
			
			while(true) {
				String message=br.readLine();
				
				if(!message.equals("exit")) {
					System.out.println(socket.getInetAddress().getHostName()+"가 보낸 메세지 : "+message);
					clientOutput.println("메세지 받기 성공");
					clientOutput.flush();
				}else {
					System.out.println("접속종료");
					break;
				}
			}
			
			br.close();
			clientOutput.close();
			socket.close();
		}
		
		
	}
	
	
}

