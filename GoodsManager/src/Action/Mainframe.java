package Action;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import service.GoodsService;
import serviceimpl.GoodsServiceImpl;
import entity.Goods;

import javax.swing.SwingConstants;


//������̬ʱ����ʾ������ʱ�ػ�ʱ��
class Time extends TimerTask {
	
	@Override
	public void run() {
		JLabel newtimeLabel= new JLabel();
		SimpleDateFormat ndf = new SimpleDateFormat("yyyy - MM - dd  HH : mm : ss");
		newtimeLabel = new JLabel(
				"                                                       ����ʱ����: "
						+ ndf.format(new Date()));
		
		newtimeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        
		Mainframe.timepanel.removeAll();
		Mainframe.timepanel.add(newtimeLabel);
		Mainframe.timepanel.revalidate();
		Mainframe.timepanel.repaint();;
		Mainframe.timepanel.setVisible(true);
	}

}
public class Mainframe extends JFrame {
    private Robot robot;
	private JPanel contentPane;
	private static JFrame main_frame= new JFrame();;
	private static String searchMessage;
	private JTextField message;

	private static GoodsService gdse = new GoodsServiceImpl();
	private static List<Goods> gd = new ArrayList();
	private JTable table;
	private String head[] = null;
	private Object[][] data = null;
	private static Goods good = new Goods();
	static JLabel timeLabel;
	static JMenuBar menuBar = new JMenuBar();
	static JPanel timepanel = new JPanel();


	public Mainframe() {
		//������
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C://Users//Administrator//Desktop//01.png"));
		setType(Type.UTILITY);
		setTitle("��Ʒ����ϵͳ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);

	    setForeground(Color.LIGHT_GRAY);
	    setJMenuBar(menuBar);

		//
		final JMenu menu = new JMenu("��ѯ");
		menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// ������ҳ���²�����
				final JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setVgap(100);
				flowLayout.setHgap(50);
				panel_1.setToolTipText("");
				panel_1.setBackground(Color.GRAY);
				panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

				message = new JTextField();
/*				try {
					robot = new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //����һ��robot����
		        initComponents();
				message.requestFocus(); 
				this.keyPress(java.awt.event.KeyEvent.VK_ENTER);*/
				panel_1.add(message);

				message.setColumns(30);
				message.setVisible(true);

				JButton jbu = new JButton();

				jbu.setText("��ѯ");
				panel_1.add(message);

				panel_1.add(jbu);

				main_frame.getContentPane().add(panel_1);
				main_frame.setVisible(true);
				panel_1.setVisible(true);

				jbu.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						searchMessage = message.getText();
						System.out.println(searchMessage);
						gd = gdse.searchone(searchMessage);

						// ����ѯ�����ʾ���µ������
						if (gd == null){
							JOptionPane.showMessageDialog(main_frame, "�޴���Ʒ��Ϣ");
						} else {
							JPanel resultpanel = new JPanel();
							resultpanel.setBackground(Color.green);
							FlowLayout flowLayout = (FlowLayout) resultpanel
									.getLayout();
							flowLayout.setVgap(150);
							flowLayout.setHgap(100);
							resultpanel.setBorder(UIManager
									.getBorder("TextArea.border"));

							JScrollPane scrollPane = new JScrollPane();
							scrollPane.setBounds(0, 0, 100, 30);
							table = new JTable();
							table.setBounds(0, 0, 200, 50);

							table.setBorder(new LineBorder(new Color(0, 0, 0)));
							head = new String[] { "ͼƬ", "Ʒ��", "����", "���", "����",
									"����", "�۸�" };

							DefaultTableModel tableModel = new DefaultTableModel(
									queryData(), head) {
								public boolean isCellEditable(int row,
										int column) {
									return false;
								}
							};
							table.setModel(tableModel);

							scrollPane.setViewportView(table);

							resultpanel.add(scrollPane);

							getContentPane().add(resultpanel,
									BorderLayout.CENTER);
							main_frame.getContentPane().add(resultpanel);
							resultpanel.setVisible(true);
							panel_1.removeAll();
							panel_1.add(resultpanel);
							panel_1.revalidate();
							panel_1.repaint();
							System.out.println(gd.toString());
						}

					}

				});
			}

			/*public void keyPress(int key) { 
				robot.delay(50); 
				robot.keyPress(key);
				robot.keyRelease(key);
				}
			  private void initComponents() {
			        //��
			    }*/
		});
		menu.setBackground(Color.WHITE);
		menu.setFont(new Font("����", Font.BOLD, 26));
		menuBar.add(menu);

		JMenu menu_1 = new JMenu("������Ϣ��");
		menu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// �Ƴ����Ԫ��

				// ������ҳ���²�����
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setVgap(100);
				flowLayout.setHgap(50);
				panel_1.setToolTipText("");
				panel_1.setBackground(Color.white);
				panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

				// ������Ʒ��Ϣ�����
				// ��ȡƷ��
				JLabel label_PinMing = new JLabel();
				label_PinMing.setText("Ʒ��");
				JTextField jt_PinMing = new JTextField();
				jt_PinMing.setColumns(20);
				good.setGoods_name(jt_PinMing.getText());
				// ��ȡ����
				JLabel label_ChangJia = new JLabel();
				label_ChangJia.setText("����");
				JTextField jt_ChangJia = new JTextField();
				jt_ChangJia.setColumns(20);
				good.setGoods_name(jt_ChangJia.getText());
				// ��ȡ���
				JLabel label_GuiGe = new JLabel();
				label_GuiGe.setText("���");
				JTextField jt_GuiGe = new JTextField();
				jt_GuiGe.setColumns(20);
				good.setGoods_name(jt_GuiGe.getText());
				// ��ȡ�۸�
				JLabel label_Price = new JLabel();
				label_Price.setText("�۸�");
				JTextField jt_Price = new JTextField();
				jt_Price.setColumns(20);
				good.setGoods_name(jt_Price.getText());
				// ��ȡ����
				JLabel label_PiHao = new JLabel();
				label_PiHao.setText("����");
				JTextField jt_PiHao = new JTextField();
				jt_PiHao.setColumns(20);
				good.setGoods_name(jt_PiHao.getText());
				// ��ȡͼƬ
				JLabel label_Picture = new JLabel();
				label_Picture.setText("ͼƬ");
				JTextField jt_Picture = new JTextField();
				jt_Picture.setColumns(20);
				good.setGoods_name(jt_Picture.getText());
				// ��ȡ����
				JLabel label_TiaoMa = new JLabel();
				label_TiaoMa.setText("����");
				JTextField jt_TiaoMa = new JTextField();
				jt_TiaoMa.setColumns(20);
				good.setGoods_name(jt_TiaoMa.getText());

				panel_1.add(label_PinMing);
				panel_1.add(jt_PinMing);

				panel_1.add(label_ChangJia);
				panel_1.add(jt_ChangJia);

				panel_1.add(label_GuiGe);
				panel_1.add(jt_GuiGe);

				panel_1.add(label_Price);
				panel_1.add(jt_Price);

				panel_1.add(jt_PiHao);
				panel_1.add(jt_PiHao);

				panel_1.add(label_Picture);
				panel_1.add(jt_Picture);

				panel_1.add(label_TiaoMa);
				panel_1.add(jt_TiaoMa);

				main_frame.getContentPane().add(panel_1);
				main_frame.setVisible(true);
				panel_1.setVisible(true);
			}
		});
		menu_1.setBackground(Color.WHITE);
		menu_1.setFont(new Font("����", Font.BOLD, 28));
		menuBar.add(menu_1);

		// �����浱ǰʱ����ʾ
		menuBar.add(timepanel);
		menuBar.setVisible(true);
		Timer timer = new Timer();
		timer.schedule(new Time(), new Date(), 1000);

		//
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	public Object[][] queryData() {
		List<Goods> list = gd;
		data = new Object[list.size()][head.length];
		System.out.println("����queryData()");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getGoods_id());
			for (int j = 0; j < head.length; j++) {
				data[i][0] = list.get(i).getGoods_picture();
				data[i][1] = list.get(i).getGoods_name();
				data[i][2] = list.get(i).getGoods_changjia();
				data[i][3] = list.get(i).getGoods_guige();
				data[i][4] = list.get(i).getGoods_pihao();
				data[i][5] = list.get(i).getGoods_tiaoma();
				data[i][6] = list.get(i).getGoods_price();
			}
		}
		return data;
	}
}

