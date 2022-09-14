import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;

public class WinMain extends JDialog {

	private final JPanel lblInfo = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			WinMain dialog = new WinMain();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public WinMain() {
		
		setTitle("\uC601\uD654\uAD00\uB828\uD504\uB85C\uADF8\uB7A8");
		setBounds(100, 100, 242, 171);
		getContentPane().setLayout(new BorderLayout());
		lblInfo.setBackground(Color.BLACK);
		lblInfo.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(lblInfo, BorderLayout.CENTER);
		lblInfo.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setForeground(Color.WHITE);
		menuBar.setBounds(0, 0, 240, 23);
		lblInfo.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		mnFile.addSeparator();  //구분선
		
		JMenuItem mnExit = new JMenuItem("종료");
		mnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		mnExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_DOWN_MASK));
		mnFile.add(mnExit);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);
		
		JMenuItem mnCreator = new JMenuItem("만든사람...");
		mnCreator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WinCreator wincreator = new WinCreator();
				wincreator.setModal(true);
				wincreator.setVisible(true);
				
			}
		});
		mnCreator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnHelp.add(mnCreator);
		
		JButton btnLive = new JButton("");
		btnLive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Movie_Chart moviechart=new Movie_Chart();
				moviechart.setModal(true);
				moviechart.setVisible(true);
			}
		});
		btnLive.setIcon(new ImageIcon(WinMain.class.getResource("/images/play.png")));
		btnLive.setBounds(10, 33, 57, 57);
		lblInfo.add(btnLive);
		
		JButton btnRese = new JButton("");
		btnRese.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login Login=new login();
				Login.setModal(true);
				Login.setVisible(true);
			}
		});
		btnRese.setIcon(new ImageIcon(WinMain.class.getResource("/images/ticket.png")));
		btnRese.setBounds(79, 33, 57, 57);
		lblInfo.add(btnRese);
		
		JButton btnCenemaSearch = new JButton("");
		btnCenemaSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cinema_Search cinemasearch=new Cinema_Search();
				cinemasearch.setModal(true);
				cinemasearch.setVisible(true);
			}
		});
		btnCenemaSearch.setIcon(new ImageIcon(WinMain.class.getResource("/images/Search.png")));
		btnCenemaSearch.setBounds(148, 33, 57, 57);
		lblInfo.add(btnCenemaSearch);
		
		JLabel lblLive = new JLabel("\uC0C1\uC601\uC911 \uC601\uD654");
		lblLive.setForeground(Color.WHITE);
		lblLive.setBounds(5, 97, 76, 15);
		lblInfo.add(lblLive);
		
		JLabel lblRese = new JLabel("\uC601\uD654\uC608\uB9E4");
		lblRese.setForeground(Color.WHITE);
		lblRese.setBounds(79, 97, 57, 15);
		lblInfo.add(lblRese);
		
		JLabel lblCinemaSearch = new JLabel("\uC601\uD654\uAD00 \uCC3E\uAE30");
		lblCinemaSearch.setForeground(Color.WHITE);
		lblCinemaSearch.setBounds(148, 100, 78, 15);
		lblInfo.add(lblCinemaSearch);
	}
}
