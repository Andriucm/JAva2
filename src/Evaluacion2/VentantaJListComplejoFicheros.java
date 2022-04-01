package Evaluacion2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

//5.-Definir a nivel de clase (botones)
public class VentantaJListComplejoFicheros extends JFrame implements ActionListener, FocusListener {

	/* 1.-Declarar componentes */
	private static final long serialVersionUID = 1401357178715246978L;
	private JPanel contentPane;
	private JTextField txtReal;
	private JTextField txtImaginaria;
	private JPanel panel;
	private JLabel lblReal;

	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;

	/* 3.-Cambiar tipo JList a INT (para números) */
	private JList<Complejo> lstComplejos;

	// 4.-Modelo de datos de la lista de Opciones
	private DefaultListModel<Complejo> dlm;
	private JLabel lblImaginaria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentantaJListComplejoFicheros frame = new VentantaJListComplejoFicheros();
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
	public VentantaJListComplejoFicheros() {
		setTitle("VentanaJListNumerosOrdenados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		lblReal = new JLabel("Real");
		panel.add(lblReal);

		txtReal = new JTextField();
		// 6.-Controlar accion en texto
		txtReal.addActionListener(this);
		txtReal.addFocusListener(this);
		txtReal.setText("0.0");
		panel.add(txtReal);
		txtReal.setColumns(10);

		btnInsertar = new JButton("Insertar");
		// 6.-Controlar accion en boton
		btnInsertar.addActionListener(this);

		lblImaginaria = new JLabel("Imaginaria");
		panel.add(lblImaginaria);

		txtImaginaria = new JTextField();
		txtImaginaria.setText("0.0");
		panel.add(txtImaginaria);
		txtImaginaria.setColumns(10);
		panel.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		// 6.-Controlar accion en boton
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		// 6.-Controlar accion en boton
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);

		// 4.-Modelo de datos de la lista de Opciones
		dlm = new DefaultListModel<Complejo>();

		/* 3.-Cambiar tipo JList a INT (para números) */
		lstComplejos = new JList<Complejo>();

		// 4.-Modelo de datos de la lista de Opciones
		lstComplejos.setModel(dlm);

		contentPane.add(lstComplejos, BorderLayout.CENTER);
	}

	// 5.-Definir a nivel de clase (botones)

	@Override
	public void actionPerformed(ActionEvent ae) {

		// 7.- Describir accion de cada boton
		Object o = ae.getSource();
		if (o == btnInsertar) {
			
			double real;
			real = Double.parseDouble(txtReal.getText());

			double imaginaria;
			imaginaria = Double.parseDouble(txtImaginaria.getText());

			// creo un nuevo Complejo
			Complejo r;
			
			r = new Complejo(real, imaginaria);

			// Compruebo si r está en la lista antes de insertar

			if (dlm.contains(r)) {
				// si n está en la lista
				// Saca mensaje de error
				JOptionPane.showMessageDialog(this, (String) "Error. El Complejo " +r+ " ya está en la lista", "Error",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				// r no está en la lista
				// Insertar numero en dlm, de forma ordenada de menor a mayor

				// Posicion inicial
				int posicion = 0;

				// Número de posiciones
				int numeroelementos = dlm.getSize();

				// Mientras la posicion
				while (posicion < numeroelementos) {
					if (r.compareTo(dlm.get(posicion)) < 0) {
						// Si encuentra la posición, sale del bucle
						break;
					}

					posicion = posicion + 1;

				}

			
				dlm.add(posicion, r);

			}

		} else if (o == btnBorrar) {
			// Compruebo si hay numeros seleccionados
			int[] indices = this.lstComplejos.getSelectedIndices();
			int numeroOpciones = indices.length;

			if (numeroOpciones == 0) {
				// Si no hay ningun numero seleccionado
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos seleccionados", "Error",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				// Si hay elementos seleccionados
				// Borrar los elementos seleccionados
				Complejo opcion = new Complejo();
				for (int posicion = numeroOpciones - 1; posicion >= 0; posicion--) {
					// Obtengo el valor del elemento de la posicion a borrar
					opcion = dlm.getElementAt(indices[posicion]);

					// Borro el elemento de la posicion a borrar
					dlm.removeElement(opcion);
					// 2º Opcion de hacerlo:
					// Solo esa linea
					// dlm.removeElementAt(indices[posicion]);

				}
			}

		} else if (o == btnLimpiar) {
			// Comprobar si la lista está vacia
			if (dlm.isEmpty()) {
				// Si la lista está vacia
				JOptionPane.showMessageDialog(this, (String) "Error al limpiar. La lista está vacia.", "Error",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				// Si la lista no está vacia
				// La vacio
				dlm.clear();
			}

		}

		
	}

	@Override
	public void focusGained(FocusEvent e) {
		txtReal.select(0, txtReal.getText().length());
		txtImaginaria.select(0, txtImaginaria.getText().length());

	}

	@Override
	public void focusLost(FocusEvent e) {
		txtReal.select(0, 0);
		txtImaginaria.select(0, 0);

	}
}
