package UserInterface;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import InnerClass.DBmethod;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
/**
 * �������� ������ DB���� ������ ���̵�� �н����带 ���Ͽ� �α��ν�Ű�� Ŭ����
 * @author Moon light
 * @see JFrame
 */
public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField tf_id_login;
	private JPasswordField tf_pass_login;
	boolean idcheck = false;
	boolean passcheck = false;
	ArrayList<String> idarr = new ArrayList<>();
	ArrayList<String> passarr = new ArrayList<>();

	public static void main(String[] args) {

		
		Login frame = new Login();
		frame.setVisible(true);
	

	}

	
	public Login() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("src/Icon.png");
		setIconImage(img);
		ImageIcon Icon_id = new ImageIcon("src/lb_id.png");
		ImageIcon Icon_pass = new ImageIcon("src/lb_pass.png");
		ImageIcon Icon_login = new ImageIcon("src/lb_login.png");
		ImageIcon Icon_logo = new ImageIcon("src/logo.png");
		
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 720, 480);
		setTitle("��������");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		
		JLabel lblNewLabel = new JLabel(Icon_login);
		lblNewLabel.setFont(new Font("�����ٸ����", Font.PLAIN, 40));
		lblNewLabel.setBounds(100, 100, 200, 100);
		lblNewLabel.setForeground(new Color(5, 97, 232));
		contentPane.add(lblNewLabel);

		JLabel lb_id = new JLabel(Icon_id);
		lb_id.setFont(new Font("�����ٸ����", Font.PLAIN, 18));
		lb_id.setBounds(206, 195, 54, 30);
		lb_id.setForeground(new Color(5, 97, 232));
		contentPane.add(lb_id);

		JLabel label = new JLabel(Icon_pass);
		label.setFont(new Font("�����ٸ����", Font.PLAIN, 18));
		label.setBounds(150, 235, 110, 30);
		label.setForeground(new Color(5, 97, 232));
		contentPane.add(label);

		tf_id_login = new JTextField();
		tf_id_login.setBounds(290, 195, 284, 30);
		contentPane.add(tf_id_login);
		tf_id_login.setColumns(10);

		tf_pass_login = new JPasswordField();
		tf_pass_login.setColumns(10);
		tf_pass_login.setBounds(290, 235, 284, 30);
		contentPane.add(tf_pass_login);

		JButton btn_login = new JButton("Login");
		btn_login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					idarr = DBmethod.getUserId();
					passarr = DBmethod.getUserPass();

					if (idarr.contains(tf_id_login.getText())) {
						idcheck = true;
					} else {
						idcheck = false;
					}

					if (passarr.contains(tf_pass_login.getText())) {
						passcheck = true;
					} else {
						passcheck = false;
					}

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!idcheck) {
					JOptionPane.showMessageDialog(null, "���̵� ���� ���� �ʽ��ϴ�.", "���̵� ���� ���� �ʽ��ϴ�.",
							JOptionPane.ERROR_MESSAGE);
				} else if (!passcheck) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� ��ġ ���� �ʽ��ϴ�.", "��й�ȣ�� ��ġ ���� �ʽ��ϴ�.",
							JOptionPane.ERROR_MESSAGE);
				} else if (idcheck && passcheck) {
					JOptionPane.showMessageDialog(null, "�α��� �Ϸ�", "�α��� �Ϸ�", JOptionPane.INFORMATION_MESSAGE);
					if(tf_id_login.getText().equals("admin")) {
						adminPage ap = new adminPage();
						ap.setVisible(true);
						dispose();
					}
					else {
					Main main = new Main(tf_id_login.getText());
					main.setVisible(true);
					dispose();
					}
				}

			}
		});
		btn_login.setFont(new Font("����", Font.BOLD, 20));
		btn_login.setForeground(new Color(5, 97, 232));

		btn_login.setBounds(150, 300, 200, 30);
		contentPane.add(btn_login);

		JButton btn_join_login = new JButton("ȸ �� �� ��");
		btn_join_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				join join = new join();
				dispose();
				join.setVisible(true);

			}
		});
		btn_join_login.setFont(new Font("����", Font.PLAIN, 19));
		btn_join_login.setBounds(364, 300, 210, 30);
		btn_join_login.setForeground(new Color(5, 97, 232));
		contentPane.add(btn_join_login);
		
		JLabel label_1 = new JLabel(Icon_logo);
		label_1.setBounds(284, 16, 198, 169);
		contentPane.add(label_1);

	}

}