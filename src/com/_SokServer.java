package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _SokServer {

	public static void main(String args[]){
		try {
			ServerSocket server = new ServerSocket(10086);
			boolean f = true;
			while(f){
				Socket client = server.accept();
				System.out.println("客户端连接服务端成功");
				//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8"));
				//从客户端取值
				BufferedReader bufread = new BufferedReader(new InputStreamReader(client.getInputStream(),"UTF-8"));
				//向客户端传值
				PrintStream out = new PrintStream(client.getOutputStream());
				boolean flag = true;
				while(flag){
					String message = bufread.readLine();
					if(message==null||"".equals(message)||"bye".equals(message)){
						System.out.println("与客户端断开连接");
						flag = false;
					}else{
						System.out.println("从客户端读取 : "+message);
						out.println(message);
					}
				}
				client.close();
			}
			server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
