package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Examen1Menu extends JFrame {

	private static final long serialVersionUID = 201911192L;
	private JPanel contentPane;
	private JPanel panelBotones;
	private JTextField txtNumero;
	private JLabel lblMensaje;
	private JButton btnEsPrimo;
	private JButton btnCircunferencia;
	private JButton btn10Multiplos;
	private JButton btnParImpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen1Menu frame = new Examen1Menu();
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
	public Examen1Menu() {
		setTitle("Bienvenido anonimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtNumero = new JTextField();
		txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNumero.setText("0");
		contentPane.add(txtNumero, BorderLayout.NORTH);
		txtNumero.setColumns(10);
		
		lblMensaje = new JLabel("Listo");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblMensaje, BorderLayout.SOUTH);
		
		panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.CENTER);
		panelBotones.setLayout(new GridLayout(2, 2, 0, 0));
		
		btnEsPrimo = new JButton("EsPrimo");
		btnEsPrimo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelBotones.add(btnEsPrimo);
		
		btnCircunferencia = new JButton("Circunferencia");
		btnCircunferencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelBotones.add(btnCircunferencia);
		
		btn10Multiplos = new JButton("10 Multiplos");
		btn10Multiplos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelBotones.add(btn10Multiplos);
		
		btnParImpar = new JButton("Par o Impar");
		btnParImpar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelBotones.add(btnParImpar);
	}
}
