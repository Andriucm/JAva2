package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaNumPrimo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1104017079766555312L;
	private JPanel contentPane;
	private JTextField txtDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNumPrimo frame = new VentanaNumPrimo();
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
	public VentanaNumPrimo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("Introduce un numero:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);

		txtDatos = new JTextField();
		panel.add(txtDatos);
		txtDatos.setColumns(10);

		JLabel lblMensaje = new JLabel("\u00BFSer\u00E1 primo?");
		lblMensaje.setForeground(Color.BLUE);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 27));
		contentPane.add(lblMensaje, BorderLayout.CENTER);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener valor TEXTO
				String valor;
				valor = txtDatos.getText();
				// Pasar valor texto a numero
				int n;
				n = Integer.parseInt(valor);
				// Resto de variables
				int cont;
				boolean esprimo;

				// CODIGO
				esprimo = true;
				if ((n % 2 == 0) && (n > 0)) {
					esprimo = false;
				} else {
					cont = 3;
					while ((cont < n) && (esprimo)) {
						if (n % 2 == 0) {
							esprimo = false;
						}
						cont = cont + 1;
					}
				}
					if (esprimo) {
						lblMensaje.setText("El numero " + n + " es primo");
					} else {
						lblMensaje.setText("El numero " + n + " NO es primo");
					}
				
			}
		});
		panel.add(btnAceptar);

	}
}
