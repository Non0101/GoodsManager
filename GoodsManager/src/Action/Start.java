package Action;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Start {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("进入main方法");
		//创建登陆对象窗体，并进行登陆验证
		JFrame login_frame = new login_Swing();
		
	}
}
