package exceptions;

import javax.swing.JOptionPane;

/*
*
*@version 1.0
*@author zhangbizhe
*@date 2019��11��29��
*/
public class PasswordErrorException extends Exception{

	private static final long serialVersionUID = 1L;
	String message;

	public PasswordErrorException(String message) {
		super();
		this.message = message;
	}
	@Override
	public void printStackTrace() {
		JOptionPane.showMessageDialog(null, message, "�������", JOptionPane.ERROR_MESSAGE);
	}
}