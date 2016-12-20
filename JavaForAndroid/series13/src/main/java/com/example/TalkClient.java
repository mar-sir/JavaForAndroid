package com.example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class TalkClient {

	private static ConnThread connThread;

	public static void main(String[] args) {

		try {
			Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 2008);

			connThread = new ConnThread(socket);
			connThread.start();
			
			//读取键盘的输入的数据
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			String line=null;
			while(true){
				line=reader.readLine();
				
				new SendThread(line).start();
				
				if(line.equals("bye")){
					
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class ConnThread extends Thread {
		private Socket socket;
		private DataInputStream dis;
		private DataOutputStream dos;

		public ConnThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {

			try {
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());

				while (true) {
					String msg = dis.readUTF();// 读取服务端发送过来的数据
					System.out.println(msg);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void sendMsg(String msg) {
			try {
				dos.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 向所有已连接的客户端发送信息
	static class SendThread extends Thread {
		private String msg;

		public SendThread(String msg) {
			this.msg = msg;
		}

		@Override
		public void run() {
			connThread.sendMsg(msg);
		}
	}
}
