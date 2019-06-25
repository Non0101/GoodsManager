package Action;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import entity.User;
import service.UserService;
import serviceimpl.UserServiceImpl;

public class login_Swing extends JFrame {

	private JPanel contentPane;
	private JTextField user_name;
	private JPasswordField user_password;
	UserService us = new UserServiceImpl();
	static private User u;
	static  boolean isloginok=false;
	static JFrame frame = new JFrame();
	
	/**
	 * Create the frame.
	 */

	public login_Swing() {
		
		System.out.println("进入login()");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(500, 250, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel zhanghao = new JLabel("账号");
		zhanghao.setFont(new Font("黑体", Font.BOLD, 16));
		zhanghao.setBounds(133, 96, 56, 30);
		contentPane.add(zhanghao);
		
		user_name = new JTextField();
		user_name.setBounds(175, 102, 118, 21);
		contentPane.add(user_name);
		user_name.setColumns(10);
		
		JLabel mima = new JLabel("密码");
		mima.setFont(new Font("黑体", Font.BOLD, 16));
		mima.setBounds(133, 130, 56, 30);
		contentPane.add(mima);
		
		user_password = new JPasswordField();
		user_password.setBounds(175, 136, 118, 21);
		contentPane.add(user_password);
		
		JButton ResetButton = new JButton("重置");
		
		ResetButton.setBounds(155, 186, 56, 23);
		contentPane.add(ResetButton);
		
		JButton LoginButton = new JButton("登陆");
		
		LoginButton.setBounds(233, 186, 56, 23);
		contentPane.add(LoginButton);
		
		JLabel picture = new JLabel("New label");
		picture.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\000.png"));
		picture.setBounds(33, 10, 380, 76);
		contentPane.add(picture);
		frame.add(contentPane);
		frame.setVisible(true);
		frame.setResizable(false);
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=user_name.getText();
				String npwd=new String(user_password.getPassword());
				System.out.println(uname+npwd);
				u=us.login(uname, npwd);
				if (u!=null){
					//当输入的账号密码正确时，允许登陆
					System.out.println("登陆成功");
					frame.dispose();
					JFrame main_frame=new Mainframe();
					main_frame.setVisible(true);
					main_frame.setResizable(false);
				    isloginok=true;	
				}else if(u==null){
					//当输入的账号密码错误时，提示警告
					JOptionPane.showMessageDialog(frame, "登陆失败");
				}
			}
		});
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try {
					frame.setVisible(true);
					frame.setResizable(false);
					System.out.println("进入login中TRY块");
				 
				} catch (Exception e) {
					System.out.println("进入login中catch块");
					e.printStackTrace();
				}
			}
		});
	}
}
