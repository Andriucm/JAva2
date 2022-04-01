package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaUsuarioContFoco extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6186423116689001230L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pwfCont;
	private JLabel lblMensaje;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuarioContFoco frame = new VentanaUsuarioContFoco();
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
	public VentanaUsuarioContFoco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(Color.BLUE);
		panel.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//Coge el texto entero
				txtUsuario.select(0, txtUsuario.getText().length());
			}
			public void focusLost(FocusEvent e) {
			txtUsuario.select(0, 0);
			}
			});
			
		
		txtUsuario.addActionListener(this);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setForeground(Color.BLUE);
		panel.add(lblNewLabel_1);
		
		pwfCont = new JPasswordField();
		pwfCont.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pwfCont.setSelectionStart(0);
				String Cont = new String(pwfCont.getPassword()); 
				pwfCont.setSelectionEnd(Cont.length());
				}
				public void focusLost(FocusEvent e) {
				 pwfCont.select(0, 0);
			}
		});
		pwfCont.setColumns(10);
		pwfCont.addActionListener(this);
		panel.add(pwfCont);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		panel.add(btnAceptar);
		
	  lblMensaje = new JLabel("Anonimo.");
		lblMensaje.setBackground(new Color(240, 240, 240));
		lblMensaje.setForeground(Color.BLUE);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblMensaje, BorderLayout.NORTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//usuario
		String Usuario;
		Usuario = txtUsuario.getText();
		//contraseña
		String Cont;
		Cont = new String(pwfCont.getPassword());
		
		//Datos correctos
		String UsuarioCorr;
		UsuarioCorr = "1dw3";
		String ContCorr;
		ContCorr = "1dw3";
		
		//COMPARACION
		if (Usuario.equals(UsuarioCorr) && Cont.equals(ContCorr)) {
			//si son iguales
			lblMensaje.setText("Bienvenido " + Usuario);
			}
			//si no son correctos
			else {
			lblMensaje.setText("Datos incorrectos");
		}
		
	}

}
