import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.awt.event.MouseAdapter;
import java.awt.Color;

public class MovieTicket extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	Vector record;
	
	public MovieTicket(String id) {
		setTitle("\uD2F0\uCF13\uC608\uB9E4");
		setBounds(100, 100, 1000, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 20, 924, 231);
		contentPanel.add(scrollPane);
		
		String url = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
		Document doc = null;
		try{
		doc = Jsoup.connect(url).get();
		Elements element = doc.select( "div.wrap-movie-chart");
		Iterator<Element> title = element.select("strong.title").iterator();
		Iterator<Element> info = element.select("span.txt-info").iterator();
		Iterator<Element> rank = element.select("strong.rank") .iterator();
		
		Iterator<Element> post = element.select("span.thumb-image").iterator();
		
		
		Vector<String> columnNames=new Vector<String>();
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("������");
		columnNames.add("��������");
		
		
		record=new Vector<>();
		
		
		while(rank.hasNext()){
			Vector<String> field=new Vector<String>();
			field.add(rank.next().text());
			field.add(title.next().text());
			field.add(info.next().text());
			field.add(post.next().text());	
			record.add(field);
		
		}
		
		DefaultTableModel dtm=new DefaultTableModel(record,columnNames);
		
		
		
		table = new JTable(dtm);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.BLACK);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(id);
				if(e.getClickCount() == 1) {  
					int row = table.getSelectedRow();
					int result = JOptionPane.showConfirmDialog(null, "�̿�ȭ�� �����Ͻðڽ��ϱ�?���Ž� 10000����Ʈ�� �����˴ϴ�.","���Ÿ������������̵��մϴ�",JOptionPane.YES_NO_OPTION);
					if(result == JOptionPane.YES_OPTION) {						
						String sql = "update cgvuser set movieselect='"  +table.getValueAt(row, 1)+"'  where id='"+id+"'";
						String sqls = "update cgvuser set point=point-10000  where id='"+id+"'";
						setVisible(false);
						try {
							Movieselect(sql);
							Movieselect(sqls);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				}
			}
		});
		table.setFont(new Font("����ǹ��� ������ü TTF", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		
	
		}
		
		
		 catch (IOException e){
		e.printStackTrace();}
		
		
	}
	protected void Movieselect(String sql) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hanbitDB",
				"root","1234"); // JDBC ����
		Statement stmt = conn.createStatement();
		if(stmt.executeUpdate(sql) > 0) {
			System.out.println("���ſϷ�Ǿ����ϴ�.");
		}
	}

	
	

}
