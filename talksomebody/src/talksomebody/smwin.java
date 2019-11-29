package talksomebody;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import exceptions.AmountNotExistsException;
import exceptions.PasswordErrorException;
import newAmount.AmountEstablish;
import newAmount.SignUpwin;
import talkWin.TalkWin;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
*
*@version 1.0
*@author zhangbizhe
*@date 2019年11月29日
*/
public class smwin {

	private JFrame frmTalktalk;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					smwin window = new smwin();
					window.frmTalktalk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public smwin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTalktalk = new JFrame();
		frmTalktalk.setTitle("TalkTalk");
		frmTalktalk.setBounds(100, 100, 463, 315);
		frmTalktalk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmTalktalk.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel label_2 = new JLabel("\u767B\u5F55\u754C\u9762");
		panel.add(label_2);
		
		JPanel panel_1 = new JPanel();
		frmTalktalk.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u8D26\u53F7");
		label.setBounds(77, 80, 58, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(77, 115, 58, 15);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(123, 77, 66, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 112, 66, 21);
		panel_1.add(passwordField);
		
		JButton button = new JButton("\u6CE8\u518C\u8D26\u53F7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpwin dialog = new SignUpwin();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		button.setBounds(217, 76, 97, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		button_1.setBounds(217, 111, 97, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u767B\u5F55");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Aname = textField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				if(AmountEstablish.AmountExists(Aname)) {
					if(AmountEstablish.KeyTrue(Aname, password)) {
						new TalkWin(Aname);
						frmTalktalk.dispose();
					}else {
						try {
							throw new PasswordErrorException("密码与该账号不匹配！");
						} catch (PasswordErrorException e1) {
							e1.printStackTrace();
						}
					}
				}else {
					try {
						throw new AmountNotExistsException("账号不存在！");
					} catch (AmountNotExistsException e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		button_2.setBounds(178, 189, 97, 23);
		panel_1.add(button_2);
	}
}
