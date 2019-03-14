import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClickFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtPleaseEnterYour;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClickFrame frame = new ClickFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClickFrame() {
		setTitle("Super Clicker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Rate for clicks:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		txtPleaseEnterYour = new JTextField();
		txtPleaseEnterYour.setToolTipText("Please enter your click rate...");
		GridBagConstraints gbc_txtPleaseEnterYour = new GridBagConstraints();
		gbc_txtPleaseEnterYour.insets = new Insets(0, 0, 5, 5);
		gbc_txtPleaseEnterYour.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPleaseEnterYour.gridx = 1;
		gbc_txtPleaseEnterYour.gridy = 2;
		contentPane.add(txtPleaseEnterYour, gbc_txtPleaseEnterYour);
		txtPleaseEnterYour.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String s = txtPleaseEnterYour.getText();
					int r = Integer.parseInt(s);
					Main.clicked.setclickRate(r);
					Main.clicked.autoclick();
					txtPleaseEnterYour.setText("");
				}catch(NumberFormatException ex){
					 JOptionPane.showMessageDialog (null, "Number format error: Please enter an integer.");
					 txtPleaseEnterYour.setText("");
				}
			}
		});
		GridBagConstraints gbc_btnGo = new GridBagConstraints();
		gbc_btnGo.gridx = 5;
		gbc_btnGo.gridy = 5;
		contentPane.add(btnGo, gbc_btnGo);
	}

}
