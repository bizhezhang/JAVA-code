package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 *
 *@version 1.0
 *@author zhangbizhe
 *@date 2019年11月18日
 */
public class Client {
	private static String message;
	public Client() {
		try {
			Socket sc = new Socket(InetAddress.getLocalHost(), 33332);
			DataOutputStream out = new DataOutputStream(sc.getOutputStream());
			out.writeUTF(message);
			DataInputStream in = new DataInputStream(sc.getInputStream());
			String recieve = in.readUTF();
			System.out.println("您的账单：");
			System.out.println(recieve);
			out.close();
			sc.close();
		} catch (UnknownHostException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		System.out.println("输入账单：");
		Scanner in = new Scanner(System.in);
		message = in.nextLine();
		in.close();
		
		new Client();
		
	}
}
