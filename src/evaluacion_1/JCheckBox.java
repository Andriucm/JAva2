package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class JCheckBox extends JFrame implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 400660562304325647L;
	private JPanel contentPane;
	private javax.swing.JCheckBox chbCursiva;
	private javax.swing.JCheckBox chbNegrita;
	private JLabel lblPrueba;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckBox frame = new JCheckBox();
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
	public JCheckBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{30, 0};
		gbl_panel.rowHeights = new int[]{30, 30, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		chbCursiva = new javax.swing.JCheckBox("Cursiva");
		GridBagConstraints gbc_chbCursiva = new GridBagConstraints();
		chbCursiva.addChangeListener(this);
		gbc_chbCursiva.fill = GridBagConstraints.BOTH;
		gbc_chbCursiva.insets = new Insets(0, 0, 5, 0);
		gbc_chbCursiva.gridx = 0;
		gbc_chbCursiva.gridy = 0;
		panel.add(chbCursiva, gbc_chbCursiva);
		
		chbNegrita = new javax.swing.JCheckBox("Negrita");
		GridBagConstraints gbc_chbNegrita = new GridBagConstraints();
		chbNegrita.addChangeListener(this);
		gbc_chbNegrita.fill = GridBagConstraints.BOTH;
		gbc_chbNegrita.gridx = 0;
		gbc_chbNegrita.gridy = 1;
		panel.add(chbNegrita, gbc_chbNegrita);
		
		lblPrueba = new JLabel("Texto de prueba");
		lblPrueba.setForeground(Color.MAGENTA);
		lblPrueba.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrueba.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPrueba, BorderLayout.NORTH);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		Font fuente = this.lblPrueba.getFont();
		int formato =0;
		if (this.chbCursiva.isSelected()) {
			formato = formato + Font.ITALIC;
		}
		if (this.chbNegrita.isSelected()) {
			formato = formato + Font.BOLD;
		}
		this.lblPrueba.setFont(new Font (fuente.getFamily(), formato, fuente.getSize()));
	}

}
