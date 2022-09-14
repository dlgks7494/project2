import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Shop extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField buytxt;
	int buy = 0;

	int popcorncount = 0;
	int squidcount = 0;
	int hotdogcount = 0;
	int colacount = 0;
	int watercount = 0;
	int churroscount = 0;

	private JTextField txtpopcorn;
	private JTextField txtwater;
	private JTextField txtChurros;
	private JTextField txtsquid;
	private JTextField txthotdog;
	private JTextField txtcola;
	private JTextField txtmypoint;
	ResultSet rss;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Shop(String id,String point) {
		
		setTitle("\uB9E4\uC810");
		setBounds(100, 100, 301, 586);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		int mypoint = Integer.parseInt(point);
		
		
		{
			JButton btnpopcorn = new JButton("");
			btnpopcorn.setIcon(new ImageIcon(Shop.class.getResource("/images/popcorn.jpg")));
			btnpopcorn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				popcorncount=popcorncount+1;	
				txtpopcorn.setText(""+popcorncount);

	
				
					
				}
			});
			btnpopcorn.setBounds(16, 10, 103, 104);
			contentPanel.add(btnpopcorn);
		}
		{
			JButton btnChurros = new JButton("");
			btnChurros.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
					churroscount=churroscount+1;	
					txtChurros.setText(""+churroscount);
				}
			});
			btnChurros.setIcon(new ImageIcon(Shop.class.getResource("/images/churros.jpg")));
			btnChurros.setBounds(16, 275, 103, 104);
			contentPanel.add(btnChurros);
		}
		{
			JButton btnwater = new JButton("");
			btnwater.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					watercount=watercount+1;	
					txtwater.setText(""+watercount);
				}
			});
			btnwater.setIcon(new ImageIcon(Shop.class.getResource("/images/water.jpg")));
			btnwater.setBounds(16, 140, 103, 104);
			contentPanel.add(btnwater);
		}
		
		JLabel lblpopcorn = new JLabel("8000\uC6D0");
		lblpopcorn.setForeground(Color.WHITE);
		lblpopcorn.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblpopcorn.setBounds(16, 124, 42, 15);
		contentPanel.add(lblpopcorn);
		
		JLabel lblwater = new JLabel("2000\uC6D0");
		lblwater.setForeground(Color.WHITE);
		lblwater.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblwater.setBounds(16, 258, 42, 15);
		contentPanel.add(lblwater);
		
		JLabel lblChurros = new JLabel("5000\uC6D0");
		lblChurros.setForeground(Color.WHITE);
		lblChurros.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblChurros.setBounds(16, 389, 42, 15);
		contentPanel.add(lblChurros);
		
		JButton btnbuy = new JButton("\uAD6C\uB9E4\uD558\uAE30");
		btnbuy.setBackground(Color.DARK_GRAY);
		btnbuy.setForeground(Color.WHITE);
		btnbuy.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitdb", "root","1234"); 
					System.out.println("db연결완료");
					Statement stmt = (Statement) conn.createStatement();
					
					String sql="update cgvuser set point=point-"+buy+" where id='"+id+"'";
					
					
					int rs= stmt.executeUpdate(sql);
					String sqlpoint="select point from cgvuser where id='"+id+"'";
					rss= stmt.executeQuery(sqlpoint);
					

					String abc = "";
					if(!txtcola.getText().equals("0")) {
						abc = abc + "콜라" + txtcola.getText()+"개,";
					}
					if(!txtpopcorn.getText().equals("0")) {
						abc = abc + "팝콘" + txtpopcorn.getText()+"개,";
					}
					if(!txtwater.getText().equals("0")) {
						abc = abc + "물" + txtwater.getText()+"개,";
					}
					if(!txtChurros.getText().equals("0")) {
						abc = abc + "츄러스" + txtChurros.getText()+"개,";
					}
					if(!txthotdog.getText().equals("0")) {
						abc = abc + "핫도그" + txthotdog.getText()+"개,";
					}
					if(!txtsquid.getText().equals("0")) {
						abc = abc + "버터오징어" + txtsquid.getText()+"개,";
					}
					
					if(abc.length()>3)
			               abc = abc.substring(0, abc.length()-1);
					int result = JOptionPane.showConfirmDialog(btnbuy, "주문한 음식이 "+abc+"이(가) 맞나요?"+"\n 총금액은"+buytxt.getText()+"원입니다.", "확인", JOptionPane.YES_NO_OPTION);
					while (rss.next()) {
						if(result==JOptionPane.YES_OPTION) {JOptionPane.showMessageDialog(btnbuy, "남은포인트는"+rss.getInt(1)+"입니다");
					}
					
							
					}
					stmt.close();
					conn.close();
					rss.close();
					} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
					setVisible(false);
				

				
			
				
				buy=0;
				

				
				
				
			}

	
		
		});
		btnbuy.setBounds(133, 495, 140, 42);
		contentPanel.add(btnbuy);
		
		buytxt = new JTextField();
		buytxt.setHorizontalAlignment(SwingConstants.RIGHT);
		buytxt.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		buytxt.setText(buy+"");
		buytxt.setEditable(false);
		buytxt.setBounds(133, 456, 140, 21);
		contentPanel.add(buytxt);
		buytxt.setColumns(10);
		
		txtpopcorn = new JTextField();
		txtpopcorn.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		txtpopcorn.setText(""+popcorncount);
		txtpopcorn.setBounds(55, 121, 18, 21);
		contentPanel.add(txtpopcorn);
		txtpopcorn.setColumns(10);
		
		txtwater = new JTextField();
		txtwater.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		txtwater.setText("0");
		txtwater.setColumns(10);
		txtwater.setBounds(55, 254, 18, 21);
		contentPanel.add(txtwater);
		
		txtChurros = new JTextField();
		txtChurros.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		txtChurros.setText("0");
		txtChurros.setColumns(10);
		txtChurros.setBounds(55, 386, 18, 21);
		contentPanel.add(txtChurros);
		
		JButton btngetpop = new JButton("\uB2F4\uAE30");
		btngetpop.setForeground(Color.WHITE);
		btngetpop.setBackground(Color.DARK_GRAY);
		btngetpop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy=buy+8000*Integer.parseInt(txtpopcorn.getText());
				System.out.println(buy);
				buytxt.setText(buy+"");
			}
		});
		btngetpop.setBounds(70, 121, 57, 21);
		contentPanel.add(btngetpop);
		
		JButton btnHotdog = new JButton("");
		btnHotdog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hotdogcount=hotdogcount+1;	
				txthotdog.setText(""+hotdogcount);
			}
		});
		btnHotdog.setIcon(new ImageIcon(Shop.class.getResource("/images/hotdog.jpg")));
		btnHotdog.setBounds(157, 140, 103, 104);
		contentPanel.add(btnHotdog);
		
		JButton btnsquid = new JButton("");
		btnsquid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				squidcount=squidcount+1;	
				txtsquid.setText(""+squidcount);
			}
		});
		btnsquid.setIcon(new ImageIcon(Shop.class.getResource("/images/squid.png")));
		btnsquid.setBounds(157, 10, 103, 104);
		contentPanel.add(btnsquid);
		
		JLabel lblsquid = new JLabel("6000\uC6D0");
		lblsquid.setForeground(Color.WHITE);
		lblsquid.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblsquid.setBounds(157, 124, 42, 15);
		contentPanel.add(lblsquid);
		
		txtsquid = new JTextField();
		txtsquid.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		txtsquid.setText("0");
		txtsquid.setColumns(10);
		txtsquid.setBounds(196, 121, 18, 21);
		contentPanel.add(txtsquid);
		
		JLabel lblhotdog = new JLabel("5000\uC6D0");
		lblhotdog.setForeground(Color.WHITE);
		lblhotdog.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblhotdog.setBounds(157, 257, 42, 15);
		contentPanel.add(lblhotdog);
		
		txthotdog = new JTextField();
		txthotdog.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		txthotdog.setText("0");
		txthotdog.setColumns(10);
		txthotdog.setBounds(192, 254, 18, 21);
		contentPanel.add(txthotdog);
		
		JButton btncola = new JButton("");
		btncola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colacount=colacount+1;	
				txtcola.setText(""+colacount);
			}
		});
		btncola.setIcon(new ImageIcon(Shop.class.getResource("/images/cola.jpg")));
		btncola.setBounds(157, 275, 103, 104);
		contentPanel.add(btncola);
		
		JLabel lblCola = new JLabel("3000\uC6D0");
		lblCola.setForeground(Color.WHITE);
		lblCola.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblCola.setBounds(157, 389, 42, 15);
		contentPanel.add(lblCola);
		
		txtcola = new JTextField();
		txtcola.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		txtcola.setText("0");
		txtcola.setColumns(10);
		txtcola.setBounds(196, 386, 18, 21);
		contentPanel.add(txtcola);
		
		JButton btngetsquid = new JButton("\uB2F4\uAE30");
		btngetsquid.setBackground(Color.BLACK);
		btngetsquid.setForeground(Color.WHITE);
		btngetsquid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy=buy+6000*Integer.parseInt(txtsquid.getText());
				System.out.println(buy);
				buytxt.setText(buy+"");
			}
		});
		btngetsquid.setBounds(211, 121, 57, 21);
		contentPanel.add(btngetsquid);
		
		JButton btngethotdog = new JButton("\uB2F4\uAE30");
		btngethotdog.setBackground(Color.DARK_GRAY);
		btngethotdog.setForeground(Color.WHITE);
		btngethotdog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy=buy+5000*Integer.parseInt(txthotdog.getText());
				System.out.println(buy);
				buytxt.setText(buy+"");
			}
		});
		btngethotdog.setBounds(211, 254, 57, 21);
		contentPanel.add(btngethotdog);
		
		JButton btngetwater = new JButton("\uB2F4\uAE30");
		btngetwater.setBackground(Color.DARK_GRAY);
		btngetwater.setForeground(Color.WHITE);
		btngetwater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy=buy+2000*Integer.parseInt(txtwater.getText());
				System.out.println(buy);
				buytxt.setText(buy+"");
			}
		});
		btngetwater.setBounds(70, 254, 57, 21);
		contentPanel.add(btngetwater);
		
		JButton btngetcola = new JButton("\uB2F4\uAE30");
		btngetcola.setBackground(Color.DARK_GRAY);
		btngetcola.setForeground(Color.WHITE);
		btngetcola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy=buy+3000*Integer.parseInt(txtcola.getText());
				System.out.println(buy);
				buytxt.setText(buy+"");
			}
		});
		btngetcola.setBounds(211, 386, 57, 21);
		contentPanel.add(btngetcola);
		
		JButton btngetchu = new JButton("\uB2F4\uAE30");
		btngetchu.setBackground(Color.DARK_GRAY);
		btngetchu.setForeground(Color.WHITE);
		btngetchu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy=buy+5000*Integer.parseInt(txtChurros.getText());
				System.out.println(buy);
				buytxt.setText(buy+"");
				
			}
		});
		btngetchu.setBounds(70, 386, 57, 21);
		contentPanel.add(btngetchu);
		
		JButton btnallremove = new JButton("\uC804\uCCB4\uCDE8\uC18C");
		btnallremove.setBackground(Color.DARK_GRAY);
		btnallremove.setForeground(Color.WHITE);
		btnallremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buy=0;
				buytxt.setText("0");
				popcorncount=0;
				squidcount=0;
				watercount=0;
				colacount=0;
				hotdogcount=0;
				churroscount=0;
				
				txtChurros.setText("0");
				txtcola.setText("0");
				txtwater.setText("0");
				txtsquid.setText("0");
				txtpopcorn.setText("0");
				txthotdog.setText("0");
				
				
				
				
			}
		});
		btnallremove.setBounds(16, 495, 97, 42);
		contentPanel.add(btnallremove);
		
		JLabel lblNewLabel = new JLabel("\uAE08\uC561");
		lblNewLabel.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblNewLabel.setBounds(95, 459, 34, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblmypoint = new JLabel("\uB0B4\uD3EC\uC778\uD2B8");
		lblmypoint.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblmypoint.setBounds(78, 431, 49, 15);
		contentPanel.add(lblmypoint);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitdb", "root","1234"); 
			System.out.println("db연결완료");
			Statement stmt = (Statement) conn.createStatement();
			String sqlpoint="select point from cgvuser where id='"+id+"'";
			rss= stmt.executeQuery(sqlpoint);
			txtmypoint = new JTextField();
			txtmypoint.setHorizontalAlignment(SwingConstants.RIGHT);
			txtmypoint.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
			while(rss.next()) {
			txtmypoint.setText(rss.getInt(1)+"");}
			txtmypoint.setBounds(133, 427, 140, 21);
			contentPanel.add(txtmypoint);
			txtmypoint.setColumns(10);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

}
