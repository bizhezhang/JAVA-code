package exceptions;

import javax.swing.JOptionPane;

/*
*
*@version 1.0
*@author zhangbizhe
*@date 2019��11��29��
*/
public class AmountNotExistsException extends Exception{
	String message;

	public AmountNotExistsException(String message) {
		super();
		this.message = message;
	}
	@Override
	public void printStackTrace() {
		JOptionPane.showMessageDialog(null, message, "�˺Ŵ���", JOptionPane.ERROR_MESSAGE);
	}
}
