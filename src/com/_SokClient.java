package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class _SokClient {

	public static void main(String args[]){
		final String host = "192.168.131.129";
		final int port = 10086;
		try {
			System.out.println("连接服务端");
			Socket client = new Socket(host, port);
			//键盘输入
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			//向服务器端传值
			PrintStream out = new PrintStream(client.getOutputStream());
			//从服务器端获取值
			BufferedReader bufread = new BufferedReader(new InputStreamReader(client.getInputStream())); 
			boolean flag = true;
			while(flag){
				System.out.print("请输入信息:");
				String message = input.readLine();
				out.println(message);
				if("bye".equals(message)){
					System.out.println("与服务器端断开连接");
					flag= false;
				}else{
					try{
						System.out.println("服务端返回："+bufread.readLine());
					}catch(SocketTimeoutException e){
						System.out.println("响应超时");
					}
				}
			}
			input.close();
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
