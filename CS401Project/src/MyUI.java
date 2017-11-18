import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;

public class MyUI extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTextArea textArea;
	private JTextField textField;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyUI frame = new MyUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MyUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		CardLayout cl = new CardLayout(0, 0);
		contentPane.setLayout(cl);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "name_514835487587292");
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Purchase Coupon ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(0, 231, 130, 30);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search coupon");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.next(contentPane);
			}
		});
		btnNewButton_1.setBounds(150, 231, 130, 30);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_8 = new JButton("List coupons ");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.next(contentPane);
				cl.next(contentPane);
			}
		});
		btnNewButton_8.setBounds(300, 231, 130, 30);
		panel_1.add(btnNewButton_8);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 25, 100, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 60, 100, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 95, 100, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 130, 54, 21);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(150, 165, 100, 21);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Coupon ");
		lblNewLabel_1.setBounds(76, 27, 54, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Product ");
		lblNewLabel_2.setBounds(76, 62, 54, 15);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(76, 97, 54, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Discount");
		lblNewLabel_4.setBounds(76, 132, 54, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Expiration ");
		lblNewLabel_5.setBounds(76, 167, 75, 15);
		panel_1.add(lblNewLabel_5);
		
		JButton btnNewButton_9 = new JButton("add");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CouponSys cs = new CouponSys();
				System.out.println(textField_1.getText()+textField_2.getText()+Integer.parseInt(textField_3.getText())+Integer.parseInt(textField_4.getText())+Integer.parseInt(textField_5.getText()));
				
				Coupon c = new Coupon(textField_1.getText(),textField_2.getText(),Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_4.getText()),Integer.parseInt(textField_5.getText()));
				try {
					cs.write(c);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_9.setBounds(86, 196, 93, 23);
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("cancel");
		btnNewButton_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}
		});
		btnNewButton_10.setBounds(273, 198, 93, 23);
		panel_1.add(btnNewButton_10);
		
		JLabel label = new JLabel("%");
		label.setFont(new Font("SimSun-ExtB", Font.PLAIN, 15));
		label.setBounds(209, 133, 21, 15);
		panel_1.add(label);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, "name_514839563395305");
		panel_2.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Purchase Coupon");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.first(contentPane);
			}
		});
		btnNewButton_2.setBounds(0, 230, 130, 30);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Search coupon");
		btnNewButton_3.setBounds(150, 231, 130, 30);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_7 = new JButton("List coupons");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.next(contentPane);
			}
		});
		btnNewButton_7.setBounds(300, 231, 130, 30);
		panel_2.add(btnNewButton_7);
		textField = new JTextField();
		JButton btnNewButton_11 = new JButton("Search");
		btnNewButton_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String s = textField.getText().toString();
				Coupon cp = new Coupon(null,s,0,0,0);
				System.out.println(textField.getText().toString());
				CouponSys cs = new CouponSys();
				textArea_1.setText(cs.search(cp));
			}
		});
		btnNewButton_11.setBounds(309, 10, 93, 23);
		panel_2.add(btnNewButton_11);
		
		textField.setBounds(45, 11, 235, 21);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textArea_1 = new JTextArea();
		textArea_1.setBounds(45, 43, 357, 152);
		panel_2.add(textArea_1);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, "name_515418238359771");
		panel_3.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Purchase Coupon");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.first(contentPane);
			}
		});
		btnNewButton_4.setBounds(0, 230, 130, 30);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Search coupon");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.previous(contentPane);
			}
		});
		btnNewButton_5.setBounds(150, 231, 130, 30);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("List coupons ");
		btnNewButton_6.setBounds(300, 231, 130, 30);
		panel_3.add(btnNewButton_6);
		
		JButton btnList = new JButton("list");
		btnList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CouponSys cs = new CouponSys();
				try {
					textArea.setText("");
					LinkedList<Coupon> ul = cs.readFile();
					SortedList sl = new SortedList(ul,comboBox.getSelectedItem().toString(),30);
					sl.addToSL();
					LLNode<Coupon> coupon = sl.getHead();
					while(coupon != null) 
					{
						System.out.println(coupon.getInfo());
						//textPane.se
						textArea.append(coupon.getInfo().toString()+"\r\n");;
						coupon = coupon.getLink();
					}
					//cs.write();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnList.setBounds(237, 198, 93, 23);
		panel_3.add(btnList);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Provider", "Product", "Price", "Discount", "Expiration", "Status", "FinalPrice"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(85, 199, 122, 21);
		panel_3.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 10, 332, 164);
		panel_3.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
	}
}
