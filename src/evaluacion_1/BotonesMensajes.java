package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class BotonesMensajes extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6060323426690584671L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JButton btnHola;
	private JButton btnKaixo;
	private JButton btnAgur;
	private JButton btnAdios;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotonesMensajes frame = new BotonesMensajes();
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
	public BotonesMensajes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblMensaje = new JLabel("No hay mensaje");
		contentPane.add(lblMensaje, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		btnHola = new JButton("Hola");
		btnHola.addActionListener(this);
		panel.add(btnHola);
		
		btnAdios = new JButton("Adios");
		btnAdios.addActionListener(this);
		panel.add(btnAdios);
		
		btnKaixo = new JButton("Kaixo");
		btnKaixo.addActionListener(this);
		panel.add(btnKaixo);
		
		btnAgur = new JButton("Agur");
		btnAgur.addActionListener(this);
		panel.add(btnAgur);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(this);
		contentPane.add(txtNombre, BorderLayout.NORTH);
		txtNombre.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String Nombre;
		Nombre = txtNombre.getText();
		Object o = ae.getSource();
		if (o==btnHola) {
			lblMensaje.setText("Hola " + Nombre);
		}
		else {
			if (o==btnKaixo) {
				lblMensaje.setText("Kaixo " + Nombre);
			}
			else {
				if (o==btnAgur) {
					lblMensaje.setText("Agur " + Nombre);
				}
				else {
					if (o==btnAdios) {
						lblMensaje.setText("Adios " + Nombre);
					}
					else {
						lblMensaje.setText(Nombre);
					}
				}
			}
			
		}
		
	}

}
