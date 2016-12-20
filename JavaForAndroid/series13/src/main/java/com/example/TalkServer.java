package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 聊天室的服务端
 * 
 * @author Administrator
 *
 */
public class TalkServer {
	private static List<ClientThread> clients = new ArrayList<ClientThread>();

	public static void main(String[] args) {

		try {

			ServerSocket server = new ServerSocket(2008);

			while (true) {
				Socket client = server.accept();// 开始接收客户端的连接
				if(clients.size()>0){
					new SendThread(client.getInetAddress().getHostAddress()+" 已进入房间")
						.start();
				}
				
				ClientThread ct = new ClientThread(client);
				clients.add(ct);
				ct.start();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//向所有已连接的客户端发送信息
	static class SendThread extends Thread{
		private String msg;
		public SendThread(String msg){
			this.msg=msg;
		}
		
		@Override
		public void run() {
			for(ClientThread ct: clients){
				ct.sendMsg(msg);
			}
		}
	}
	
 static	class ClientThread extends Thread {
		private Socket client;
		private DataInputStream dis;
		private DataOutputStream dos;
		
		private String ip;

		public ClientThread(Socket client) {
			this.client = client;
			ip=client.getInetAddress().getHostAddress();
			
			try {
				dis = new DataInputStream(client.getInputStream());
				dos = new DataOutputStream(client.getOutputStream());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			// 接收客户端发过来的数据
			while (true) {
				try {
					String msg = dis.readUTF();
					
					
					if (msg.equals("bye")) {
						msg=ip+ " 离开了房间";
						new SendThread(msg).start();
						
						clients.remove(client); //将当前要断开的连接的线程从列表中除去
						
						break;
					}
					
					msg=ip+"说："+msg;
					new SendThread(msg).start();

				} catch (IOException e) {
					e.printStackTrace();
				} // 读取数据
			}

		}

		public void sendMsg(String msg) { // 向当前连接的客户端发送信息
			try {
				dos.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

 
