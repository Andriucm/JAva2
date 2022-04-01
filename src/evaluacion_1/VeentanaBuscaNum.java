package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VeentanaBuscaNum extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -722915997432133622L;
	private JPanel contentPane;
	private JTextField txtDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeentanaBuscaNum frame = new VeentanaBuscaNum();
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
	public VeentanaBuscaNum() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblMensaje = new JLabel("Adivina mi numero secreto");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel_1 = new JLabel("Introduce un numero:");
		panel.add(lblNewLabel_1);

		txtDatos = new JTextField();
		panel.add(txtDatos);
		txtDatos.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Saco valor del texto
				String valor;
				valor = txtDatos.getText();
				// Pasar valor a int
				int n;
				n = Integer.parseInt(valor);
				// Resto de variables
				int nSec;
				int cont;

				// CODIGO
				nSec = 57;
				cont = 1;
				while (nSec != n) {
					if (nSec < n) {
						lblMensaje.setText("El numero " + n + " es mayor que el numero secreto");
					} else {
						lblMensaje.setText("El numero " + n + " es menor que el numero secreto");
					}
					cont = cont + 1;
					valor = txtDatos.getText();
					n = Integer.parseInt(valor);

				}
				lblMensaje.setText("ENHORABUENA! Has adivinado  el numero. Has necesitado " + cont + " intentos");
			}
		});
		panel.add(btnAceptar);
	}

}
