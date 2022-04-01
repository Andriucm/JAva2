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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBisiestos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2696990882770488630L;
	private JPanel contentPane;
	private JTextField txtDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBisiestos frame = new VentanaBisiestos();
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
	public VentanaBisiestos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblMensaje = new JLabel("0");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 30));
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce un a\u00F1o: ");
		panel.add(lblNewLabel_1);
		
		txtDatos = new JTextField();
		txtDatos.setText("0");
		panel.add(txtDatos);
		txtDatos.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Obtengo el año.
				String Valor;
				Valor = txtDatos.getText();
				//Convierto el vallor en numero
				int Año;
				Año = Integer.parseInt(Valor);
				if (Año % 4 == 0) {
					if (Año % 100 == 0) {
						if (Año % 400 == 0) {
							lblMensaje.setText(Año + " Es bisiesto");
							}
						else {
							lblMensaje.setText(Año + " No es bisiesto");
							}
						}
					else {
						lblMensaje.setText(Año +  " Es bisisesto");
					}
				}
				else {
					lblMensaje.setText(Año +  " No es bisisesto");
				}
			}	
		});
		panel.add(btnAceptar);
	}

}
