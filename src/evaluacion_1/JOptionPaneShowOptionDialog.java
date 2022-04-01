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

public class JOptionPaneShowOptionDialog extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8073167306700138319L;
	private JPanel contentPane;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneShowOptionDialog frame = new JOptionPaneShowOptionDialog();
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
	public JOptionPaneShowOptionDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblMensaje = new JLabel("No se ha elegido una opcion");
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
		String[] opciones = {"1AS3", "2AS3", "1DW3", "2DW3", "1SM2", "2SM2"};
		int opcion = JOptionPane.showOptionDialog(this,"Prueba de Cuadros de Diálogo","Cuadro de Diálogo con OpcionesPersonalizadas",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,opciones,opciones[2]); // pone como opcion por defecto "1DW3"
		if ((opcion != JOptionPane.CLOSED_OPTION)) {
			lblMensaje.setText("Se ha pulsado la opcion " + opciones[opcion]);
		}
		else {
			lblMensaje.setText("Error no se ha inroducido un valor valido");
		}
		
		}
		
	
}