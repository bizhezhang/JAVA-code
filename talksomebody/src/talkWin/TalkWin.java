package talkWin;

import javax.swing.JFrame;

/*
*
*@version 1.0
*@author zhangbizhe
*@date 2019��11��29��
*/
public class TalkWin extends JFrame{

	public TalkWin(String name) {
		setTitle(name);
		setBounds(200, 200, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
