import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

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

public class CheckPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();

	
	public CheckPoint(String id) {
		setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		setTitle("\uD3EC\uC778\uD2B8 \uD655\uC778/\uCDA9\uC804");
		setBounds(100, 100, 540, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitdb", "root","1234"); 
			System.out.println("db연결완료");
			Statement stmt = (Statement) conn.createStatement();
			String sqlpoint="select point,movieselect from cgvuser where id='"+id+"'";
			ResultSet rs= stmt.executeQuery(sqlpoint);
			
			
			JLabel lblCheckPoint = new JLabel("New label");
			lblCheckPoint.setForeground(Color.WHITE);
			lblCheckPoint.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 52));
			JLabel lblmovie = new JLabel("New label");
			lblmovie.setForeground(Color.WHITE);
			lblmovie.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 33));	
			while(rs.next()) {
			lblCheckPoint.setText(rs.getInt(1)+"");
			if(rs.getString(2)==null) {
			lblmovie.setText("예매된영화가 존재하지않습니다.");}
			else {
				lblmovie.setText(rs.getString(2)+"");}
			}
			
			
			lblCheckPoint.setBounds(22, 28, 384, 110);
			contentPanel.add(lblCheckPoint);
			lblmovie.setBounds(22, 150, 490, 84);
			contentPanel.add(lblmovie);
			
			JButton btnPointCh = new JButton("\uD3EC\uC778\uD2B8 \uCDA9\uC804");
			btnPointCh.setBackground(Color.DARK_GRAY);
			btnPointCh.setForeground(Color.WHITE);
			btnPointCh.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 18));
			btnPointCh.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PointCh dialog=new PointCh(id);
					
					dialog.setModal(true);
					dialog.setVisible(true);
					setVisible(false); 
					
					
				}
			});
			JButton btnBack = new JButton("\uB4A4\uB85C\uAC00\uAE30");
			btnBack.setBackground(Color.DARK_GRAY);
			btnBack.setForeground(Color.WHITE);
			btnBack.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 18));
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MovieReservation dialog=new MovieReservation(id, sqlpoint);
					
					setVisible(false);
					
				}
			});
			btnBack.setBounds(194, 250, 153, 50);
			contentPanel.add(btnBack);
			btnPointCh.setBounds(12, 250, 153, 50);
			contentPanel.add(btnPointCh);
			
			JButton btnmoviecancle = new JButton("\uC608\uB9E4\uCDE8\uC18C");
			btnmoviecancle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(btnmoviecancle, lblmovie.getText()+"를취소하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
					
					if(result==JOptionPane.YES_OPTION) {JOptionPane.showMessageDialog(btnmoviecancle, "영화"+lblmovie.getText()+"취소되었습니다.");}
					try {
						
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitdb", "root","1234"); 
						System.out.println("db연결완료");
						Statement stmt = (Statement) conn.createStatement();
						
						String sql="update cgvuser set movieselect=null where id='"+id+"'";
						
						
						int rs= stmt.executeUpdate(sql);
						
						
						stmt.close();
						conn.close();
						setVisible(false);
						} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		
				
					
					
				
		
			btnmoviecancle.setForeground(Color.WHITE);
			btnmoviecancle.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 18));
			btnmoviecancle.setBackground(Color.DARK_GRAY);
			btnmoviecancle.setBounds(359, 250, 153, 50);
			contentPanel.add(btnmoviecancle);}
			
			
			
			
		 
		
		catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
