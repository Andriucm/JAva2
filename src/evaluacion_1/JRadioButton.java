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

public class JRadioButton extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8415089122635724191L;
	private JPanel contentPane;
	private javax.swing.JRadioButton rbtRojo;
	private javax.swing.JRadioButton rbtAzul;
	private javax.swing.JRadioButton rbtNegro;
	private ButtonGroup btgColores;
	private JLabel lblPrueba;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JRadioButton frame = new JRadioButton();
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
	public JRadioButton() {
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
		
		rbtNegro = new javax.swing.JRadioButton("Negro");
		GridBagConstraints gbc_rbtNegro = new GridBagConstraints();
		rbtNegro.addActionListener(this);
		gbc_rbtNegro.fill = GridBagConstraints.BOTH;
		gbc_rbtNegro.insets = new Insets(0, 0, 5, 0);
		gbc_rbtNegro.gridx = 0;
		gbc_rbtNegro.gridy = 0;
		panel.add(rbtNegro, gbc_rbtNegro);
		
		rbtRojo = new javax.swing.JRadioButton("Rojo");
		GridBagConstraints gbc_rbtRojo = new GridBagConstraints();
		rbtRojo.addActionListener(this);
		gbc_rbtRojo.insets = new Insets(0, 0, 5, 0);
		gbc_rbtRojo.fill = GridBagConstraints.BOTH;
		gbc_rbtRojo.gridx = 0;
		gbc_rbtRojo.gridy = 1;
		panel.add(rbtRojo, gbc_rbtRojo);
		
		rbtAzul = new javax.swing.JRadioButton("Azul");
		GridBagConstraints gbc_rbtAzul = new GridBagConstraints();
		rbtAzul.addActionListener(this);
		gbc_rbtAzul.fill = GridBagConstraints.BOTH;
		gbc_rbtAzul.gridx = 0;
		gbc_rbtAzul.gridy = 2;
		panel.add(rbtAzul, gbc_rbtAzul);
		
		
		//AGRUPAR BOTONES
		btgColores = new ButtonGroup();
		btgColores.add(rbtAzul);
		btgColores.add(rbtNegro);
		btgColores.add(rbtRojo);
		
		
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
		if (o == this.rbtNegro) {
			this.lblPrueba.setForeground(Color.black);
		}
		if (o == this.rbtAzul) {
			this.lblPrueba.setForeground(Color.blue);
		}
		if (o == this.rbtRojo) {
			this.lblPrueba.setForeground(Color.red);
		}
	}

}
