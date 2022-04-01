package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaReloj extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2801772231221068890L;
	private JPanel contentPane;
	private JTextField txtHoras;
	private JTextField txtMinutos;
	private JTextField txtSegundos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReloj frame = new VentanaReloj();
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
	public VentanaReloj() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		txtHoras = new JTextField();
		panel.add(txtHoras);
		txtHoras.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Horas");
		panel.add(lblNewLabel_1);
		
		txtMinutos = new JTextField();
		panel.add(txtMinutos);
		txtMinutos.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Minutos");
		panel.add(lblNewLabel_2);
		
		txtSegundos = new JTextField();
		panel.add(txtSegundos);
		txtSegundos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Segundos");
		panel.add(lblNewLabel_3);
		
	
		
		JLabel lblMensaje = new JLabel("Introduce una hora:");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Obtener valor horas
				String ValorH;
				ValorH = txtHoras.getText();
				//Convertir el valor en numero
				int Horas;
				Horas= Integer.parseInt(ValorH);
				
				//Obtener valor minutos
				String ValorM;
				ValorM = txtMinutos.getText();
				//Convertir el valor en numero
				int Minutos;
				Minutos= Integer.parseInt(ValorM);
				
				//Obtener valor segundos
				String ValorS;
				ValorS = txtSegundos.getText();
				//Convertir el valor en numero
				int Segundos;
				Segundos= Integer.parseInt(ValorS);
				
				Segundos = Segundos + 1;
				
				//Empezar condiciones
				if (Segundos > 59) {
					Minutos = Minutos +1;
					Segundos =  0;
					if (Minutos > 59) {
						Horas = Horas + 1;
						Minutos = 0;
						}
				
				
			}
				lblMensaje.setText("El reloj marca las " + Horas + "h"  + Minutos + "m" + Segundos + "s");
			}
		});
		panel.add(btnNewButton);
		
		
		
	}

}
