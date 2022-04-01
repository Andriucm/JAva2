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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAbs extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8791486878554891923L;
	private JPanel contentPane;
	private JTextField txtDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAbs frame = new VentanaAbs();
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
	public VentanaAbs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce un numero:");
		panel.add(lblNewLabel_1);
		
		txtDatos = new JTextField();
		panel.add(txtDatos);
		txtDatos.setColumns(10);
		
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 32));
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Leer valor
				String Valor;
				Valor= txtDatos.getText();
				//Pasar valor a numero
				int N;
				N=Integer.parseInt(Valor);
				//Condiciones
				if (N % 2 == 0) {
					lblMensaje.setText("El numero " +N+ " es par");
				}
				else 
					lblMensaje.setText("El numero " +N+ " es impar");
			}
		});
		panel.add(btnAceptar);
	}

}
