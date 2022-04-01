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

public class JOptionPaneShowConfirmDialog extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8871560908236426914L;
	private JPanel contentPane;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneShowConfirmDialog frame = new JOptionPaneShowConfirmDialog();
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
	public JOptionPaneShowConfirmDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblMensaje = new JLabel("No se ha pulsado un boton");
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
		int opcion = JOptionPane.showConfirmDialog(this, (String) "Prueba de Cuadros de Diálogo",
				"Cuadro de Diálogo de Confirmación", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
		switch (opcion) {
		case JOptionPane.YES_OPTION:
			// HA PULSADO SI
			lblMensaje.setText("Ha pulsado si");
			break;
		case JOptionPane.NO_OPTION:
			// HA PULSADO NO
			lblMensaje.setText("Ha pulsado no");
			break;
		case JOptionPane.CANCEL_OPTION:
			// HA PULSADO CANCELAR
			lblMensaje.setText("Ha pulsado cancelar");
			break;
		case JOptionPane.CLOSED_OPTION:
			// HA CERRADO LA VENTANA
			lblMensaje.setText("Ha cerrado la ventana");
			break;

		}
	}
}