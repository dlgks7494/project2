import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Cinema_Search extends JDialog {
	Vector records = new Vector();
	Vector <String> columnNames = new Vector<String>();
	Connection conn;
	Statement stmt;
	ResultSet rs;
	private final JPanel contentPanel = new JPanel();
	Vector record = new Vector<>();
	private static JTable table;
	
	public Cinema_Search() {
		setTitle("\uC601\uD654\uAD00 \uCC3E\uAE30");
		getContentPane().setBackground(Color.BLACK);		
		setBounds(100, 100, 760, 601);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBounds(0, 40, 744, 522);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setBounds(12, 10, 689, 480);
		contentPanel.add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.WHITE);
		comboBox.setBackground(Color.DARK_GRAY);
		comboBox.setFont(new Font("����ǹ��� ������ü TTF", Font.PLAIN, 16));
		comboBox.setBounds(0, 10, 152, 23);
		getContentPane().add(comboBox);
		
		
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String	city=comboBox.getSelectedItem().toString();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Connection conn = null;
				try {
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitDB","root","1234");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // JDBC ����
				Statement stmt = null;
				try {
					stmt = conn.createStatement();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						if(city.equals("����")) {

							String sql = "select name,address from cgvtbl  where city='����'";							
							try {
								rs = stmt.executeQuery(sql);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			
						}
						else if (city.equals("���")) {
							String sql = "select name,address from cgvtbl  where city='���'";
							try {
								rs = stmt.executeQuery(sql);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}				
							
						}
						else if (city.equals("��õ")) {
							String sql = "select name,address from cgvtbl  where city='��õ'";
							try {
								rs = stmt.executeQuery(sql);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			
						}
						else if (city.equals("����")) {		
							String sql = "select name,address from cgvtbl  where city='����'";
							try {
								rs = stmt.executeQuery(sql);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	
						}
						else if (city.equals("����/��û")) {		
							String sql = "select name,address from cgvtbl  where city='����/��û'";
							try {
								rs = stmt.executeQuery(sql);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}			
							
						}
						else if (city.equals("�뱸")) {
							String sql = "select name,address from cgvtbl  where city='�뱸'";
							try {
								rs = stmt.executeQuery(sql);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						}
						else if (city.equals("�λ�/���")) {
							String sql = "select name,address from cgvtbl  where city='�λ�/���'";
							try {
								rs = stmt.executeQuery(sql);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					
						}
						else if (city.equals("���")) {
							String sql = "select name,address from cgvtbl  where city='���'";
							try {
								rs = stmt.executeQuery(sql);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
			
						}
						else if (city.equals("����/����/����")) {
							String sql = "select name,address from cgvtbl  where city='����/����/����'";
							try {
								rs = stmt.executeQuery(sql);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
											
							
						}Vector <String> columnNames = new Vector<String>();
						columnNames.add("��ȭ�� �̸�");
						columnNames.add("�ּ�");
						
						Vector records = new Vector();
						try {
							while(rs.next()) {
								Vector<String> cols = new Vector<String>();
								for(int i=1;i<=2;i++)
									cols.add(rs.getString(i));			
								records.add(cols);
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							conn.close();
							stmt.close();
							rs.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		
						DefaultTableModel dtm = new DefaultTableModel(records, columnNames);
					
						table = new JTable(dtm);
						
						table.setFont(new Font("����ǹ��� ������ü TTF", Font.PLAIN, 15));
						table.setForeground(Color.WHITE);
						table.setBackground(Color.DARK_GRAY);
						scrollPane.setViewportView(table);
						table.getColumnModel().getColumn(0).setPreferredWidth(50);
						table.getColumnModel().getColumn(1).setPreferredWidth(250);
						}	
		});
		

		comboBox.setModel(new DefaultComboBoxModel(new String[] {"����", "���", "��õ", "����", "����/��û", "�뱸", "�λ�/���", "���", "����/����/����"}));
		comboBox.setSelectedIndex(0);
		
		
	}	

}
