package Evaluacion2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import java.awt.GridLayout;

public class VentanaJListPersonasFicheros extends JFrame
		implements ActionListener, ListSelectionListener, FocusListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6651218355838555498L;
	private JPanel contentPane;
	private JTextField txtApellido;
	private JTextField txtDia;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<Persona> lstPersona;
	private DefaultListModel<Persona> dlmPersona;
	private JLabel lblApellidos;
	private JTextField txtNombre;
	private JTextField txtDni;
	private JLabel lblNombre;
	private JTextField txtMes;
	private JTextField txtAño;
	private JLabel lblFecha_1;
	private JLabel lblFecha_2;
	// Controlo si los datos han sido modificados
	private boolean modificado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListPersonasFicheros frame = new VentanaJListPersonasFicheros();
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
	public VentanaJListPersonasFicheros() {
		setTitle("VentanaJListComplejos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);
		setBounds(100, 100, 964, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel txtApellidos = new JPanel();
		contentPane.add(txtApellidos, BorderLayout.NORTH);

		JLabel lblDni = new JLabel("DNI:");
		txtApellidos.add(lblDni);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtApellidos.add(txtDni);

		lblNombre = new JLabel("Nombre:");
		txtApellidos.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtApellidos.add(txtNombre);

		lblApellidos = new JLabel("Apellidos:");
		txtApellidos.add(lblApellidos);

		txtApellido = new JTextField();
		txtApellidos.add(txtApellido);
		txtApellido.addFocusListener(this);
		txtApellido.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		txtApellidos.add(lblFecha);

		txtDia = new JTextField();
		txtApellidos.add(txtDia);
		txtDia.addFocusListener(this);
		txtDia.setColumns(2);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);

		lblFecha_1 = new JLabel("/");
		txtApellidos.add(lblFecha_1);

		txtMes = new JTextField();
		txtMes.setColumns(2);
		txtApellidos.add(txtMes);

		lblFecha_2 = new JLabel("/");
		txtApellidos.add(lblFecha_2);

		txtAño = new JTextField();
		txtAño.setColumns(2);
		txtApellidos.add(txtAño);
		txtApellidos.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		txtApellidos.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		txtApellidos.add(btnLimpiar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.CENTER);

		dlmPersona = new DefaultListModel<Persona>();

		lstPersona = new JList<Persona>();
		lstPersona.addListSelectionListener(this);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		lstPersona.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstPersona.setModel(dlmPersona);
		panel_1.add(lstPersona);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		Object o = ae.getSource();

		if (o == btnInsertar) {
			String dni = this.txtDni.getText();
			String nombre = this.txtNombre.getText();
			String apellido = txtDia.getText();
			int dia = Integer.parseInt(txtDia.getText());
			int mes = Integer.parseInt(txtMes.getText());
			int año = Integer.parseInt(txtAño.getText());

//			creo nueva persona
			Fecha fecha = new Fecha(dia, mes, año);
			Persona p = new Persona(dni, nombre, apellido, fecha);

			if (dlmPersona.contains(p)) {
				JOptionPane.showMessageDialog(this, (String) "Error. El racional " + p + " ya esta en la lista", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				// si r NO esta en la lista
//				Inserto el elemento en la lista de forma ordenada
//				busco la posicioon al insertar
				int posicion = 0;
				int numeroelementos = dlmPersona.getSize();
				while (posicion < numeroelementos) {
					if (p.compareTo(dlmPersona.get(posicion)) < 0) {
						break;
					}
					posicion = posicion++;
				}

				dlmPersona.add(posicion, p);
				modificado = true;
			}
				
		}

		else if (o == btnBorrar) {

			if (lstPersona.isSelectionEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para borrar", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				int posicion = lstPersona.getSelectedIndex();
				dlmPersona.removeElementAt(posicion);
				modificado = true;
			}
			
		} else if (o == btnLimpiar) {
			if (dlmPersona.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
						null);
			} else {
				dlmPersona.clear();
				modificado = true;
			}

		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		// TODO Auto-generated method stub
		Object o = lse.getSource();
		@SuppressWarnings("unchecked")
		int posicion = ((JList<String>) o).getSelectedIndex();
		lstPersona.setSelectedIndex(posicion);

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		txtApellido.select(0, txtApellido.getText().length());
		txtDia.select(0, txtDia.getText().length());
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		txtApellido.select(0, 0);
		txtDia.select(0, 0);

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// Controlo el cierre de la ventana

		// Controlo si los datos han sido modificados
		if (modificado = true) {

			int confirmado = JOptionPane.showConfirmDialog(this, (String) "Los datos han sido modificacos", "¿Desea guardar?",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			switch (confirmado) {
			case JOptionPane.YES_OPTION:
//		Si se ha pulsado SI
//			ESCRITURA
					FileOutputStream fos;
					ObjectOutputStream oos;

					try {

//			guardo el complejo EN ALPERSONAS.SER
						fos = new FileOutputStream("alpersonas.ser");
						oos = new ObjectOutputStream(fos);

//			lo grabo
						for (int posicion = 0; posicion < dlmPersona.size(); posicion++) {
							oos.writeObject(dlmPersona.elementAt(posicion));
						}

//			cierro e lfichero
						oos.close();
						fos.close();

					} catch (FileNotFoundException e1) {
						// TODO: handle exception
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO: handle exception
						e1.printStackTrace();
					}

//		LECTURA
					FileInputStream fis;
					ObjectInputStream ois;
					Persona a = new Persona();
					try {
//			Abro el fichero
						fis = new FileInputStream("alpersonas.ser");
						ois = new ObjectInputStream(fis);

//		lo leo
						while (fis.available() > 0) {
							a = (Persona) ois.readObject();

//			Lo muestro por pantalla
							System.out.println("Complejo leido: " + a); // Convierte los bytes leidos
						}
//		cierro el fichero
						ois.close();
						fis.close();

					} catch (FileNotFoundException e1) {
						// TODO: handle exception
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO: handle exception
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					System.exit(0);
//				Guardo los datos en un fichero
				break;

			case JOptionPane.CLOSED_OPTION:
//	    Si se ha pulsado NO
			case JOptionPane.CANCEL_OPTION:
//	    Si se ha pulsado CANCELAR

				return;
			}

		}
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
