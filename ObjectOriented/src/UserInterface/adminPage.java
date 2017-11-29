package UserInterface;
import java.awt.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import InnerClass.DBmethod;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminPage extends JFrame {
	ImageIcon Icon_admin = new ImageIcon("src/lb_admin_page.png");
	ImageIcon Icon_tip = new ImageIcon("src/lb_admin_tip.png");
	ImageIcon Icon_link = new ImageIcon("src/lb_admin_link.png");
	private JPanel contentPane;
	private JTextField tf_tip;
	private JTextField tf_link;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public adminPage() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("src/Icon.png");
		setIconImage(img);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 580);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JComboBox cb_weather = new JComboBox();
		cb_weather.setBounds(89, 161, 122, 24);
		cb_weather.addItem("Clear");
		cb_weather.addItem("Rain, Drizzle");
		cb_weather.addItem("Mist, Haze, Fog");
		cb_weather.addItem("Clouds");
		cb_weather.addItem("Snow");
		contentPane.add(cb_weather);
		
		tf_tip = new JTextField();
		tf_tip.setBounds(325, 153, 520, 40);
		contentPane.add(tf_tip);
		tf_tip.setColumns(10);
		
		tf_link = new JTextField();
		tf_link.setColumns(10);
		tf_link.setBounds(325, 205, 520, 40);
		contentPane.add(tf_link);
		
		JLabel lb_tip = new JLabel(Icon_tip);
		lb_tip.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lb_tip.setForeground(Color.BLACK);
		lb_tip.setBounds(225, 152, 80, 40);
		contentPane.add(lb_tip);
		
		JLabel lb_link = new JLabel(Icon_link);
		lb_link.setFont(new Font("±¼¸²", Font.BOLD, 22));
		lb_link.setBounds(225, 204, 80, 40);
		contentPane.add(lb_link);
		
		JLabel lb_admin = new JLabel(Icon_admin);
		lb_admin.setFont(new Font("±¼¸²", Font.BOLD, 33));
		lb_admin.setBounds(325, 40, 318, 73);
		contentPane.add(lb_admin);
		
		JButton btn_addtip = new JButton(new ImageIcon("src/lb_admin_addtip.png"));
		btn_addtip.setBackground(Color.WHITE);
		btn_addtip.setBounds(725, 270, 120, 40);
		contentPane.add(btn_addtip);
		btn_addtip.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println((String)cb_weather.getSelectedItem());
					DBmethod.addtip((String)cb_weather.getSelectedItem(), tf_tip.getText(),tf_link.getText());
					tf_tip.setText("");
					tf_link.setText("");
					JOptionPane.showMessageDialog(null, "¿Ï·á", "ÆÁ Ãß°¡ ¿Ï·á", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	
		JButton btn_back = new JButton(new ImageIcon("src/lb_back.png"));
		btn_back.setBackground(Color.WHITE);
		btn_back.setBounds(33, 33, 51, 51);
		contentPane.add(btn_back);
		btn_back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				lg.setVisible(true);
				dispose();
				
			}
		});
		
		
	}
}
