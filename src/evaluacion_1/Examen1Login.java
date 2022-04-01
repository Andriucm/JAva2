package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Examen1Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 201911191L;
	private JPanel contentPane;
	private JPanel panelDatos;
	private JTextField txtUsuario;
	private JLabel lblTexto;
	private JLabel lblNmero;
	private JPasswordField pwdPassword;
	private JLabel lblPassword;
	int i = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen1Login frame = new Examen1Login();
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
	public Examen1Login() {
		setResizable(false);
		setTitle("Examen Andrei Mihalahce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 120);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelDatos = new JPanel();
		contentPane.add(panelDatos, BorderLayout.NORTH);

		lblNmero = new JLabel("Usuario");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelDatos.add(lblNmero);

		lblTexto = new JLabel("Listo");
		lblTexto.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTexto, BorderLayout.SOUTH);

		txtUsuario = new JTextField();
		txtUsuario.setText("Usuario");
		txtUsuario.setColumns(10);
		txtUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsuario.addActionListener(this);
		panelDatos.add(txtUsuario);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelDatos.add(lblPassword);

		pwdPassword = new JPasswordField();
		pwdPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdPassword.setText("Password\u2026");
		pwdPassword.addActionListener(this);
		panelDatos.add(pwdPassword);

	} // Fin de constructor

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();
		if (o == txtUsuario || o == pwdPassword) {
			String usuariocorrecto = "andrei";
			String contrasenacorrecta = "mihalache";
			String usuario = txtUsuario.getText();
			String contrasena = new String(pwdPassword.getPassword());
			
			if(usuario.isEmpty() || contrasena.isEmpty() || usuario != usuariocorrecto || contrasena != contrasenacorrecta ) {
				i--;
				lblTexto.setText("Le quedan " +i+ " intentos");
				if (i==0) {
					System.exit(0);
				}
				
			}else {
				Examen1Menu vh = new Examen1Menu();
				this.dispose();
				vh.setVisible(true);
			}	

		}
		
	} 
}
