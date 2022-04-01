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

public class JOptionPaneShowMessageDialog extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4866867102237269152L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPaneShowMessageDialog frame = new JOptionPaneShowMessageDialog();
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
	public JOptionPaneShowMessageDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblMensaje = new JLabel("No se ha pulsado nada");
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
		JOptionPane.showMessageDialog(this,(String)"Prueba de Cuadros de Diálogo","Cuadro de Diálogo Mensaje",JOptionPane.INFORMATION_MESSAGE,null);	
	}

}