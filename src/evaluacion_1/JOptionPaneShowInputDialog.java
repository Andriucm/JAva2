package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JOptionPaneShowInputDialog extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 698256171685160156L;
	private JPanel contentPane;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneShowInputDialog frame = new JOptionPaneShowInputDialog();
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
	public JOptionPaneShowInputDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblMensaje = new JLabel("An\u00F3nimo");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblMensaje.setForeground(Color.BLUE);
		contentPane.add(lblMensaje, BorderLayout.NORTH);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		contentPane.add(btnAceptar, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String respuesta = (String) JOptionPane.showInputDialog(this, (String) "Introduzca su Nombre: ",
				"Cuadro de Diálogo de Introducción de Datos", JOptionPane.QUESTION_MESSAGE, null, null, "Sin Nombre");
		if (respuesta != null) {
			lblMensaje.setText("Hola " + respuesta);
		} else {
			lblMensaje.setText("Error no se ha introducido un valor valido");
		}
	}
}