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
*@date 2019��11��18��
*/
public class Server {
	private ServerSocket scs;
	public Server() {
		try {
			scs = new ServerSocket(33332);
			
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public void connect() {
		try {
			System.out.println("���ڵȴ��ͻ�");
			Socket sc = scs.accept();
			System.out.println("�ͻ��ĵ�ַ"+sc.getInetAddress());
			System.out.println("���ڼ���");
			System.out.println("���ڵȴ��ͻ�");
			DataInputStream in = new DataInputStream(sc.getInputStream());
			String messages = in.readUTF();
			String message[] = messages.split(":");
			double num[] = new double[4];
			double sumMoney = 0;
			for(int i = 0; i<num.length; i++) {
				num[i] = Double.parseDouble((message[i+1].substring(0, message[i+1].indexOf("Ԫ"))));
				System.out.println(num[i]);
				sumMoney += num[i];
			}
			System.out.println("�����ܶ�:"+sumMoney);
			DataOutputStream out = new DataOutputStream(sc.getOutputStream());
			String StrForSend = "����:"+num[0]+"Ԫ ˮ��:"+num[1]+"Ԫ ���:"+num[2]+"Ԫ ��ҵ��:"+num[3]+"Ԫ"+"\n�ܼƣ�"+sumMoney+"Ԫ";
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
