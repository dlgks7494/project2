import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class MovieReservation extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public MovieReservation(String id,String point) {
		setTitle("\uC601\uD654\uC608\uB9E4");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnshop = new JButton("\uB9E4\uC810\uC774\uC6A9");
		btnshop.setBackground(Color.DARK_GRAY);
		btnshop.setForeground(Color.WHITE);
		btnshop.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 25));
		btnshop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shop dialog=new Shop(id,point);
				dialog.setModal(true);
				dialog.setVisible(true);
				
				
				
			}
		});
		btnshop.setBounds(25, 29, 150, 85);
		contentPanel.add(btnshop);
		
		JButton btnpointcheck = new JButton("\uD3EC\uC778\uD2B8\uD655\uC778");
		btnpointcheck.setBackground(Color.DARK_GRAY);
		btnpointcheck.setForeground(Color.WHITE);
		btnpointcheck.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 25));
		btnpointcheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckPoint checkpoint=new CheckPoint(id);
				checkpoint.setModal(true);
				checkpoint.setVisible(true);
			}
		});
		btnpointcheck.setBounds(254, 29, 150, 85);
		contentPanel.add(btnpointcheck);
		
		JButton btnReservation = new JButton("\uC608\uB9E4");
		btnReservation.setBackground(Color.DARK_GRAY);
		btnReservation.setForeground(Color.WHITE);
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieTicket ticket=new MovieTicket(id);
				ticket.setModal(true);
				ticket.setVisible(true);
			}
		});
		btnReservation.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 52));
		btnReservation.setBounds(25, 145, 379, 85);
		contentPanel.add(btnReservation);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(12, 4, 57, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblpoint = new JLabel(id+"님 환영합니다.");
		lblpoint.setForeground(Color.WHITE);
		lblpoint.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 14));
		lblpoint.setBounds(25, 4, 379, 15);
		contentPanel.add(lblpoint);
	}
}
