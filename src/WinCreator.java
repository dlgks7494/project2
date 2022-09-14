import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class WinCreator extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinCreator dialog = new WinCreator();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinCreator() {
		setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
		setBackground(Color.WHITE);
		setTitle("\uB3C4\uC6C0\uB9D0");

		setBounds(100, 100, 389, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(WinCreator.class.getResource("/images/logo.png")));
		lblLogo.setBounds(12, 10, 110, 110);
		contentPanel.add(lblLogo);
		
		JLabel lblNewLabel = new JLabel("제작자:이한");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 14));
		lblNewLabel.setBounds(157, 34, 128, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호: 010-7376-7494");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(157, 71, 173, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("이메일: 123dlgks@naver.com");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(157, 114, 149, 15);
		contentPanel.add(lblNewLabel_1_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setForeground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uB2EB\uAE30");
				okButton.setBackground(Color.DARK_GRAY);
				okButton.setForeground(Color.WHITE);
				okButton.setFont(new Font("배달의민족 을지로체 TTF", Font.PLAIN, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}