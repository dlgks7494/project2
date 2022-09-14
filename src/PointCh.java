import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class PointCh extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCh;
	private JTextField txtBefore;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 * @param id 
	 */
	public PointCh(String id) {
		setTitle("\uD3EC\uC778\uD2B8\uCDA9\uC804");
		try {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitdb", "root","1234"); 
		System.out.println("db연결완료");
		Statement stmt = (Statement) conn.createStatement();
		
		
		
		String sqlpoint="select point from cgvuser where id='"+id+"'";
		ResultSet rs= stmt.executeQuery(sqlpoint);
		setBounds(100, 100, 238, 235);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		contentPanel.setLayout(null);
		txtBefore = new JTextField();
		txtBefore.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		while(rs.next()) {
			txtBefore.setText(rs.getInt(1)+"");}
		
		txtBefore.setColumns(10);
		txtBefore.setBounds(89, 42, 116, 21);
		contentPanel.add(txtBefore);
			
			
		{
			txtCh = new JTextField();
			txtCh.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
			txtCh.setBounds(89, 85, 116, 21);
			contentPanel.add(txtCh);
			txtCh.setColumns(10);
		}
		{
			JLabel lblCh = new JLabel("\uAD6C\uB9E4\uD3EC\uC778\uD2B8");
			lblCh.setForeground(Color.WHITE);
			lblCh.setBackground(Color.WHITE);
			lblCh.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
			lblCh.setBounds(12, 88, 107, 15);
			contentPanel.add(lblCh);
		}
		
			
		{
			
		}
		
		{
			JLabel lblBefore = new JLabel("\uD604\uC7AC\uD3EC\uC778\uD2B8");
			lblBefore.setForeground(Color.WHITE);
			lblBefore.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
			lblBefore.setBounds(12, 45, 107, 15);
			contentPanel.add(lblBefore);
		}
		
			
			
		
		{
			JButton btnNewButton = new JButton("\uCDA9\uC804\uD558\uAE30");
			btnNewButton.setBackground(Color.DARK_GRAY);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 30));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sql="update cgvuser set point=point+"+Integer.parseInt(txtCh.getText()) +" where id='"+id+"'";
					try {
						int pointadd=Integer.parseInt(txtBefore.getText())+Integer.parseInt(txtCh.getText());
						int yorn = JOptionPane.showConfirmDialog(btnNewButton, "충전전 포인트:"+txtBefore.getText()+" \n충전할포인트:"+txtCh.getText()+"\n충전후 포인트:"+pointadd,"확인", JOptionPane.YES_NO_OPTION);
						if(yorn == JOptionPane.YES_OPTION) {
							int rss= stmt.executeUpdate(sql);
			
							setVisible(false);
							
						}
						else if(yorn == JOptionPane.NO_OPTION) {
							setVisible(false);
							PointCh pointch=new PointCh(id);
							pointch.setModal(true);
							pointch.setVisible(true);
						}
						
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			btnNewButton.setBounds(12, 129, 189, 55);
			contentPanel.add(btnNewButton);
		}
} 
		
		catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		

}
