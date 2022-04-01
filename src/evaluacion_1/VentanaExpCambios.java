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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaExpCambios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3790861674651466176L;
	private JPanel contentPane;
	private JTextField txtOpcion;
	private JTextField txtSaldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaExpCambios frame = new VentanaExpCambios();
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
	public VentanaExpCambios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("Opci\u00F3n:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel);

		txtOpcion = new JTextField();
		txtOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		txtOpcion.setText("0");
		panel.add(txtOpcion);
		txtOpcion.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Saldo: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel.add(lblNewLabel_1);

		txtSaldo = new JTextField();
		txtSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		txtSaldo.setText("0.0");
		panel.add(txtSaldo);
		txtSaldo.setColumns(10);

		JPanel panelOpciones = new JPanel();
		panelOpciones.setForeground(Color.BLACK);
		contentPane.add(panelOpciones, BorderLayout.CENTER);
		GridBagLayout gbl_panelOpciones = new GridBagLayout();
		gbl_panelOpciones.columnWidths = new int[] { 128, 169, 0 };
		gbl_panelOpciones.rowHeights = new int[] { 26, 0, 0, 0 };
		gbl_panelOpciones.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelOpciones.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelOpciones.setLayout(gbl_panelOpciones);

		JLabel lblNewLabel_2 = new JLabel("1-> CAFE (0.43 \u20AC)");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panelOpciones.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("2-> REFRESOS (1.11 \u20AC)");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 21));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 1;
		panelOpciones.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("3-> AGUA (0.36 \u20AC)");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 2;
		panelOpciones.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 60, 306, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 31, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblMensaje = new JLabel("SELECCIONA UNA OPCION:");
		GridBagConstraints gbc_lblMensaje = new GridBagConstraints();
		gbc_lblMensaje.insets = new Insets(0, 0, 5, 5);
		gbc_lblMensaje.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMensaje.gridx = 1;
		gbc_lblMensaje.gridy = 0;
		panel_1.add(lblMensaje, gbc_lblMensaje);
		lblMensaje.setForeground(Color.BLUE);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 25));

		JLabel lblCambios = new JLabel("CAMBIOS:");
		lblCambios.setFont(new Font("Tahoma", Font.PLAIN, 23));
		GridBagConstraints gbc_lblCambios = new GridBagConstraints();
		gbc_lblCambios.insets = new Insets(0, 0, 0, 5);
		gbc_lblCambios.gridx = 1;
		gbc_lblCambios.gridy = 1;
		panel_1.add(lblCambios, gbc_lblCambios);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener valor opcion
				String valorOp;
				valorOp = txtOpcion.getText();
				// Pasar valor opcion a numero
				int Opcion;
				Opcion = Integer.parseInt(valorOp);
				// Obtener valor saldo
				String ValorSaldo;
				ValorSaldo = txtSaldo.getText();
				// Pasar valor saldo a numero
				double Saldo;
				Saldo = Double.parseDouble(ValorSaldo);

				// Resto de variables
				double Vueltas;
				int VueltasEntero, e2, e1, c50, c20, c10, c5, c2, c1;

				// CONDICIONES MENU
				if ((Opcion < 1) || (Opcion > 3)) {
					lblMensaje.setText("Opcioin incorrecta.");
					lblCambios.setText("Cambios: " + Saldo);
				} else {
					double Precio = 0.0;
					switch (Opcion) {
					case 1:
						Precio = 0.43;
						break;
					case 2:
						Precio = 1.11;
						break;
					case 3:
						Precio = 0.36;
						break;
					}

					// CONDICIONES SALDO
					if (Saldo >= Precio) {
						lblMensaje.setText("Su producto, gracias.");
						Vueltas = Saldo - Precio;
						Vueltas = Vueltas * 100;
						VueltasEntero = (int) Vueltas;
						e2 = VueltasEntero / 200;
						VueltasEntero = VueltasEntero % 200;
						e1 = VueltasEntero / 100;
						VueltasEntero = VueltasEntero % 100;
						c50 = VueltasEntero / 50;
						VueltasEntero = VueltasEntero % 50;
						c20 = VueltasEntero / 20;
						VueltasEntero = VueltasEntero % 20;
						c10 = VueltasEntero / 10;
						VueltasEntero = VueltasEntero % 10;
						c5 = VueltasEntero / 5;
						VueltasEntero = VueltasEntero % 5;
						c2 = VueltasEntero / 2;
						VueltasEntero = VueltasEntero % 2;
						c1 = VueltasEntero;
						lblCambios.setText("Cambios:   2€: " + e2 + " 1€: " + e1 + " 50c: " + c50 + " 20c: " + c20 + " 10c: " + c10
								+ " 5c: " + c5 + " 2c: " + c2 + " 1c: " + c1);
					} else {
						lblMensaje.setText("Saldo insuficiente.");
						lblCambios.setText("Cambios: " + Saldo);
					}
				}
			}
		});
		panel.add(btnAceptar);

	}

}
