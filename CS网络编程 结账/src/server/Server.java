package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
*
*@version 1.0
*@author zhangbizhe
*@date 2019年11月18日
*/
public class Server {
	private ServerSocket scs;
	public Server() {
		try {
			scs = new ServerSocket(33332);
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void connect() {
		try {
			System.out.println("正在等待客户");
			Socket sc = scs.accept();
			System.out.println("客户的地址"+sc.getInetAddress());
			System.out.println("正在监听");
			System.out.println("正在等待客户");
			DataInputStream in = new DataInputStream(sc.getInputStream());
			String messages = in.readUTF();
			String message[] = messages.split(":");
			double num[] = new double[4];
			double sumMoney = 0;
			for(int i = 0; i<num.length; i++) {
				num[i] = Double.parseDouble((message[i+1].substring(0, message[i+1].indexOf("元"))));
				System.out.println(num[i]);
				sumMoney += num[i];
			}
			System.out.println("本次总额:"+sumMoney);
			DataOutputStream out = new DataOutputStream(sc.getOutputStream());
			String StrForSend = "房租:"+num[0]+"元 水费:"+num[1]+"元 电费:"+num[2]+"元 物业费:"+num[3]+"元"+"\n总计："+sumMoney+"元";
			out.writeUTF(StrForSend);
			out.close();
			in.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void closeServer() {
		try {
			scs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
			new ServerThread().start();
	}
}
