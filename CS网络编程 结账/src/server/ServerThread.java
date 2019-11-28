package server;
/*
*
*@version 1.0
*@author zhangbizhe
*@date 2019Äê11ÔÂ18ÈÕ
*/
public class ServerThread extends Thread {
	
	
	public void run() {
		Server mys = new Server();
		int count = 0;
		while(count++<1){
			mys.connect();
		}
		mys.closeServer();
	}
}
