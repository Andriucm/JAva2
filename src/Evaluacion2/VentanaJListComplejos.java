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
import javax.swing.SwingConstants;

public class VentanaJListComplejos extends JFrame
		implements ActionListener, ListSelectionListener, FocusListener, WindowListener {

	private static final long serialVersionUID = -972133618843126835L;
	/**
	 * 
	 */

	private JPanel contentPane;
	private JTextField txtReal;
	private JTextField txtImaginario;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<Complejo> lstComplejo;
	private DefaultListModel<Complejo> dlmComplejo;
	private Complejo c;
	private int posicion;
//	control de datos modificados
	private boolean modificado = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListComplejos frame = new VentanaJListComplejos();
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
	public VentanaJListComplejos() {
		setTitle("VentanaJListComplejos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(this);

		setBounds(100, 100, 505, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNumerador = new JLabel("Real:");
		panel.add(lblNumerador);

		txtReal = new JTextField();
		txtReal.setHorizontalAlignment(SwingConstants.RIGHT);
		txtReal.setText("0");
		panel.add(txtReal);
		txtReal.addFocusListener(this);
		txtReal.setColumns(10);

		JLabel lblImaginario = new JLabel("Imaginario:");
		panel.add(lblImaginario);

		txtImaginario = new JTextField();
		txtImaginario.setHorizontalAlignment(SwingConstants.RIGHT);
		txtImaginario.setText("0");
		panel.add(txtImaginario);
		txtImaginario.addFocusListener(this);
		txtImaginario.setColumns(10);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		panel.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.CENTER);

		dlmComplejo = new DefaultListModel<Complejo>();

		lstComplejo = new JList<Complejo>();
		lstComplejo.addListSelectionListener(this);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		lstComplejo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstComplejo.setModel(dlmComplejo);
		panel_1.add(lstComplejo);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		Object o = ae.getSource();

		if (o == btnInsertar) {
			double real = Double.parseDouble(txtReal.getText());
			double imag = Double.parseDouble(txtImaginario.getText());
//			creo nuevo racional
			c = new Complejo(real, imag);

			if (dlmComplejo.contains(c)) {
				JOptionPane.showMessageDialog(this, (String) "Error. El racional " + c + " ya esta en la lista", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				// si r NO esta en la lista
//				Inserto el elemento en la lista de forma ordenada
//				busco la posicioon al insertar
				posicion = 0;
				int numeroelementos = dlmComplejo.getSize();
				while (posicion < numeroelementos) {
					if (c.compareTo(dlmComplejo.get(posicion)) > 0) {
						break;
					}
					posicion = posicion++;
				}

				dlmComplejo.add(posicion, c);
//				indico que los datos han sido modificados
				modificado = true;
			}

		}

		else if (o == btnBorrar) {

			if (lstComplejo.isSelectionEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para borrar", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				int posicion = lstComplejo.getSelectedIndex();
				dlmComplejo.removeElementAt(posicion);

			}
//			indico que los datos han sido modificados correctamente
			modificado = true;

		} else if (o == btnLimpiar) {
			if (dlmComplejo.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
						null);
			} else {
				dlmComplejo.clear();
//			indico que los datos han sido modificados correctamente
				modificado = true;
			}

		}
	}

//	CONFIGURACION DE SALIDA DE LA VENTANA
	String[] opciones = { "Guardar", "No Guardar", "Cancelar" };

	private void close() {
//		Si han sido modificados
		if (modificado == true) {
			int opcion = JOptionPane.showOptionDialog(this, "¿Desea Guardar?", "Cuadro de Diálogo con OpcionesPersonalizadas",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

			switch (opcion) {
			case 0:
//			Si se pulsa guardar
//			ESCRITURA
					FileOutputStream fos;
					ObjectOutputStream oos;

					try {
//			guardo el complejo en complejos.dat
						fos = new FileOutputStream("alcomplejos.txt");
						oos = new ObjectOutputStream(fos);

//			lo grabo
						for (posicion = 0; posicion < dlmComplejo.size(); posicion++) {
							oos.writeObject(dlmComplejo.elementAt(posicion));
						}

//			cierro e lfichero
						oos.close();
						fos.close();

					} catch (FileNotFoundException e) {
						// TODO: handle exception
						e.printStackTrace();
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					}

//		LECTURA
					FileInputStream fis;
					ObjectInputStream ois;
					Complejo c = new Complejo();
					try {
//			Abro el fichero
						fis = new FileInputStream("alcomplejos.txt");
						ois = new ObjectInputStream(fis);

//		lo leo
						while (fis.available() > 0) {
							c = (Complejo) ois.readObject();

//			Lo muestro por pantalla
							System.out.println("Complejo leido: " + c); // Convierte los bytes leidos
						}
//		cierro el fichero
						ois.close();
						fis.close();

					} catch (FileNotFoundException e) {
						// TODO: handle exception
						e.printStackTrace();
					} catch (IOException e) {
						// TODO: handle exception
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					System.exit(0);
				
				break;

			case 1:
//			Si se pulsa No Guardar
				System.exit(0);
				break;

			case 2:
				return;
			}

		}
		System.exit(0);

	}

	@Override
	public void windowClosing(WindowEvent e) {
		close();
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		// TODO Auto-generated method stub
		Object o = lse.getSource();
		@SuppressWarnings("unchecked")
		int posicion = ((JList<String>) o).getSelectedIndex();
		lstComplejo.setSelectedIndex(posicion);

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		txtReal.select(0, txtReal.getText().length());
		txtImaginario.select(0, txtImaginario.getText().length());
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		txtReal.select(0, 0);
		txtImaginario.select(0, 0);

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

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
