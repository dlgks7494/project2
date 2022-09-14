import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.remote.http.Contents;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class Movie_Chart extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	Vector record;
	
	
	

	/**
	 * Launch the application.
	 */

		
	

	/**
	 * Create the dialog.
	 */
	public Movie_Chart() {
		setTitle("\uC0C1\uC601\uC911 \uC601\uD654");
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
		columnNames.add("순위");
		columnNames.add("제목");
		columnNames.add("개봉일");
		columnNames.add("연령제한");
		
		
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
		table.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 15));
		scrollPane.setViewportView(table);
	
		}
		
		 catch (IOException e){
		e.printStackTrace();}
	}
}
