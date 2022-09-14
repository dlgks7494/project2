import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

public class create extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtid;
	private JTextField txtpw;

	protected void insertrecord() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitdb", "root","1234"); 
		System.out.println("db연결완료");
		String id=txtid.getText();
		String pw=txtpw.getText();
		Statement stmt = (Statement) conn.createStatement();
		stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
		String sql="insert into cgvuser values('";
		sql=sql + id+"','"+pw+"',100000,null)";

		 if(stmt.executeUpdate(sql)>0) {
			 JOptionPane.showMessageDialog(null, "회원가입특전 10만포인트가 증정되었습니다.");// 레코드 추가
		 
		 								}

	
																				}
	public create() {
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setBounds(100, 100, 320, 164);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblid = new JLabel("ID");
			lblid.setForeground(Color.WHITE);
			lblid.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
			lblid.setBounds(12, 10, 57, 15);
			contentPanel.add(lblid);
		}
		{
			txtid = new JTextField();
			txtid.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
			txtid.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
						txtpw.requestFocus();
														  }
													}
												  });
			txtid.setBounds(81, 7, 116, 21);
			contentPanel.add(txtid);
			txtid.setColumns(10);
		}
		
		JLabel lblpw = new JLabel("password");
		lblpw.setForeground(Color.WHITE);
		lblpw.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblpw.setBounds(12, 38, 57, 15);
		contentPanel.add(lblpw);
		
		txtpw = new JTextField();
		txtpw.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		txtpw.setColumns(10);
		txtpw.setBounds(81, 35, 116, 21);
		contentPanel.add(txtpw);
		
		JButton btncreate = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btncreate.setBackground(Color.DARK_GRAY);
		btncreate.setForeground(Color.WHITE);
		btncreate.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 29));
		btncreate.setEnabled(false);
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insertrecord();
					} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
																   }
				clearText();
				
				
													   }
														 });
		btncreate.setBounds(12, 63, 266, 45);
		contentPanel.add(btncreate);
		
		JButton btndup = new JButton("\uC911\uBCF5\uD655\uC778");
		btndup.setBackground(Color.DARK_GRAY);
		btndup.setForeground(Color.WHITE);
		btndup.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		btndup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(checkid()) {
						JOptionPane.showMessageDialog(null, "사용가능");
						btncreate.setEnabled(true);
						txtpw.requestFocus();
								  }
					else
						JOptionPane.showMessageDialog(null, "사용불가");
				    } catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				    													}
													  }
													 });
		btndup.setBounds(209, 6, 81, 23);
		contentPanel.add(btndup);
							}





	protected boolean checkid() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitdb", "root","1234");
		Statement stmt=conn.createStatement();
		String sql="select * from cgvuser where id='"+txtid.getText()+"'";
		ResultSet rs=stmt.executeQuery(sql);
		if(!rs.next())
			return true;
		else		
			return false;
	}
	protected void clearText() {
		txtid.setText("");
		txtpw.setText("");
		txtid.requestFocus();
		
	}
														}
