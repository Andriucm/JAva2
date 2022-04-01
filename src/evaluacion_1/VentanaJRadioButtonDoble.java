package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJRadioButtonDoble extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private javax.swing.JRadioButton rbt14;
	private javax.swing.JRadioButton rbt16;
	private javax.swing.JRadioButton rbt12;
	private ButtonGroup btgColores;
	private JLabel lblPrueba;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJRadioButtonDoble frame = new VentanaJRadioButtonDoble();
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
	public VentanaJRadioButtonDoble() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		rbt12 = new javax.swing.JRadioButton("Letra tama\u00F1o 12");
		GridBagConstraints gbc_rbt12 = new GridBagConstraints();
		rbt12.addActionListener(this);
		gbc_rbt12.fill = GridBagConstraints.BOTH;
		gbc_rbt12.insets = new Insets(0, 0, 5, 0);
		gbc_rbt12.gridx = 0;
		gbc_rbt12.gridy = 0;
		panel.add(rbt12, gbc_rbt12);
		
		rbt14 = new javax.swing.JRadioButton("Letra tama\u00F1o 14");
		GridBagConstraints gbc_rbt14 = new GridBagConstraints();
		rbt14.addActionListener(this);
		gbc_rbt14.insets = new Insets(0, 0, 5, 0);
		gbc_rbt14.fill = GridBagConstraints.BOTH;
		gbc_rbt14.gridx = 0;
		gbc_rbt14.gridy = 1;
		panel.add(rbt14, gbc_rbt14);
		
		rbt16 = new javax.swing.JRadioButton("Letra tamaa\u00F1o 16");
		GridBagConstraints gbc_rbt16 = new GridBagConstraints();
		rbt16.addActionListener(this);
		gbc_rbt16.fill = GridBagConstraints.BOTH;
		gbc_rbt16.gridx = 0;
		gbc_rbt16.gridy = 2;
		panel.add(rbt16, gbc_rbt16);
		
		
		//AGRUPAR BOTONES
		btgColores = new ButtonGroup();
		btgColores.add(rbt16);
		btgColores.add(rbt12);
		btgColores.add(rbt14);
		
		
		lblPrueba = new JLabel("Texto de prueba");
		lblPrueba.setForeground(Color.MAGENTA);
		lblPrueba.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPrueba, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();
		if (o == this.rbt12) {
			lblPrueba.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		if (o == this.rbt16) {
			lblPrueba.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		if (o == this.rbt14) {
			lblPrueba.setFont(new Font("Tahoma", Font.BOLD, 14));
		}
	}

}
