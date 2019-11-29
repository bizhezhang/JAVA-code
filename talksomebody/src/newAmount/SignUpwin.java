package newAmount;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/*
*
*@version 1.0
*@author zhangbizhe
*@date 2019Äê11ÔÂ29ÈÕ
*/
public class SignUpwin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the dialog.
	 */
	public SignUpwin() {
		setBounds(100, 100, 460, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextArea textArea = new JTextArea();
			textArea.setBounds(190, 10, 56, 24);
			textArea.setText("\u6CE8\u518C\u8D26\u53F7");
			contentPanel.add(textArea);
		}
		{
			JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
			label.setBounds(38, 56, 58, 15);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("\u5BC6\u7801\uFF1A");
			label.setBounds(38, 113, 58, 15);
			contentPanel.add(label);
		}
		{
			textField = new JTextField();
			textField.setBounds(112, 53, 160, 21);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel label = new JLabel("12\u4F4D\u4EE5\u5185\u7EAF\u6570\u5B57");
			label.setBounds(305, 56, 93, 15);
			contentPanel.add(label);
		}
		{
			JLabel label = new JLabel("12\u4F4D\u6570\u5B57\u6216\u5B57\u6BCD");
			label.setBounds(305, 113, 93, 15);
			contentPanel.add(label);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(112, 110, 160, 21);
			contentPanel.add(passwordField);
		}
		{
			JTextArea textArea = new JTextArea();
			textArea.setBounds(190, 152, 56, 24);
			contentPanel.add(textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u6CE8\u518C");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String Aname = textField.getText();
						@SuppressWarnings("deprecation")
						String password = passwordField.getText();
						AmountEstablish.signUp(Aname, password);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u8FD4\u56DE");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
