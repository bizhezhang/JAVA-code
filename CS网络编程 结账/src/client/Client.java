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
 *@date 2019��11��18��
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
			System.out.println("�����˵���");
			System.out.println(recieve);
			out.close();
			sc.close();
		} catch (UnknownHostException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		System.out.println("�����˵���");
		Scanner in = new Scanner(System.in);
		message = in.nextLine();
		in.close();
		
		new Client();
		
	}
}
