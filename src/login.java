import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;

public class login extends JDialog {
	private JTextField txtID;
	private JPasswordField txtPW;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public login() {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		setTitle("\uB85C\uADF8\uC778");
		setBounds(100, 100, 264, 237);
		getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("\uC544\uC774\uB514");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblID.setBounds(27, 38, 57, 15);
		getContentPane().add(lblID);
		
		JLabel lblPW = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblPW.setForeground(Color.WHITE);
		lblPW.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		lblPW.setBounds(27, 80, 57, 15);
		getContentPane().add(lblPW);
		
		txtID = new JTextField();
		txtID.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		txtID.setBounds(107, 35, 105, 21);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtPW = new JPasswordField();
		txtPW.setFont(new Font("Dialog", Font.ITALIC, 12));
		txtPW.setBounds(107, 77, 105, 21);
		getContentPane().add(txtPW);
		txtPW.setColumns(10);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778");
		btnLogin.setBackground(Color.DARK_GRAY);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitdb", "root","1234"); 
						System.out.println("db연결완료");
						Statement stmt = (Statement) conn.createStatement();
						String id=txtID.getText();
						String pw=txtPW.getText();
						String sql="select * from cgvuser where id='"; 
						sql= sql+id+ "'and pw='"+pw+"'" ;
						ResultSet rs= stmt.executeQuery(sql);
						if(rs.next()) {
							String point=rs.getString("point");
							MovieReservation dialog=new MovieReservation(id,point);
							
							dialog.setModal(true);
							dialog.setVisible(true);
							
						}
						else {
							JOptionPane.showMessageDialog(null, "로그인 실패");
							
							lblPW.getFocusListeners();}
						stmt.close();
						conn.close();
						rs.close();
								
					}
					
					catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					 // MySQL 드라이버 로드
					 
				}
			}
		});
		btnLogin.setBounds(12, 123, 97, 56);
		getContentPane().add(btnLogin);
		
		JButton btnCreate = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBackground(Color.DARK_GRAY);
		btnCreate.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 20));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create dialog=new create();
				dialog.setModal(true);
				dialog.setVisible(true);
				dialog.setVisible(rootPaneCheckingEnabled);
			}
		});
		btnCreate.setBounds(121, 123, 97, 56);
		getContentPane().add(btnCreate);

	}
}
