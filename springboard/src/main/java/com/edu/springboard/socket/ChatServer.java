package com.edu.springboard.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	ServerSocket server;
	
	public ChatServer() {
		try {
			server = new ServerSocket(9000);
			Socket socket = server.accept();
			
			System.out.println("접속자 발견");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ChatServer();

	}

}
