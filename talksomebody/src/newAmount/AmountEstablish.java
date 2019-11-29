package newAmount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
*
*@version 1.0
*@author zhangbizhe
*@date 2019Äê11ÔÂ29ÈÕ
*/
public class AmountEstablish {
	private static File data;
	private static File keyword;
	private static FileWriter fw;
	private static String datapath = "src/data.txt";
	private static String datakeypath = "src/key.txt";
	public static void signUp(String Aname, String password) {
		data = new File(datapath);
		keyword = new File(datakeypath);
		try {
			if(!data.exists()) {
				fw = new FileWriter(data);
			}else {
				fw = new FileWriter(data, true);
			}
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(Aname+"\n");
			bw.close();
			fw.close();
			
			if(!keyword.exists()) {
				fw = new FileWriter(keyword);
			}else {
				fw = new FileWriter(keyword , true );
			}
			BufferedWriter bw1 = new BufferedWriter(fw);
			fw.write(Aname+","+password+"\n");
			fw.close();
			bw1.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public static boolean AmountExists(String AmountName){
		boolean existAmount = false;
		data = new File(datapath);
		try {
			if(!data.exists()) {
				return existAmount;
			}else {
				String Aname;
				FileReader fr = new FileReader(data);
				BufferedReader br = new BufferedReader(fr);
				while((Aname = br.readLine())!= null) {
					if(Aname.trim().equals(AmountName)) {
						existAmount = true;
						break;
					}
				}
				br.close();
				fr.close();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return existAmount;
	}
	public static boolean KeyTrue(String AmountName, String password) {
		boolean keytrue = false;
		keyword = new File(datakeypath);
		try {
			if(!data.exists()) {
				return keytrue;
			}else {
				String messages;
				String msg[];
				FileReader fr = new FileReader(keyword);
				BufferedReader br = new BufferedReader(fr);
				while((messages = br.readLine())!= null) {
					msg = messages.split(",");
					if(msg[0].trim().equals(AmountName)&& msg[1].equals(password)) {
						keytrue = true;
						break;
					}
				}
				br.close();
				fr.close();
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return keytrue;
	}
}
