package Evaluacion2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Comparator;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class VentanaJListPersonasOrdenarSinRadioButtons extends JFrame
		implements ActionListener, ListSelectionListener, FocusListener {

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
	private JButton btnOrdenar;
	private JComboBox<String> cmbOrdenar;
	private ArrayList<Persona> listado;
	private Persona p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListPersonasOrdenarSinRadioButtons frame = new VentanaJListPersonasOrdenarSinRadioButtons();
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
	public VentanaJListPersonasOrdenarSinRadioButtons() {
		setTitle("VentanaJListComplejos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblDni = new JLabel("DNI:");
		panel.add(lblDni);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		panel.add(txtDni);

		lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		panel.add(txtNombre);

		lblApellidos = new JLabel("Apellidos:");
		panel.add(lblApellidos);

		txtApellido = new JTextField();
		panel.add(txtApellido);
		txtApellido.addFocusListener(this);
		txtApellido.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		panel.add(lblFecha);

		txtDia = new JTextField();
		panel.add(txtDia);
		txtDia.addFocusListener(this);
		txtDia.setColumns(2);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);

		lblFecha_1 = new JLabel("/");
		panel.add(lblFecha_1);

		txtMes = new JTextField();
		txtMes.setColumns(2);
		panel.add(txtMes);

		lblFecha_2 = new JLabel("/");
		panel.add(lblFecha_2);

		txtAño = new JTextField();
		txtAño.setColumns(2);
		panel.add(txtAño);
		panel.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);

		btnOrdenar = new JButton("Ordenar");
		btnOrdenar.addActionListener(this);
		panel.add(btnOrdenar);

		cmbOrdenar = new JComboBox<String>();
		cmbOrdenar.setModel(
				new DefaultComboBoxModel<String>(new String[] { "Ascendente", "Descendente", "Nombre", "Apellidos", "Fecha" }));
		cmbOrdenar.setSelectedIndex(0);
		panel.add(cmbOrdenar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		contentPane.add(panel_1, BorderLayout.CENTER);
		listado = new ArrayList<Persona>();
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
			String apellido = txtApellido.getText();
			int dia = Integer.parseInt(txtDia.getText());
			int mes = Integer.parseInt(txtMes.getText());
			int año = Integer.parseInt(txtAño.getText());

//			creo nueva persona
			Fecha fecha = new Fecha(dia, mes, año);

			p = new Persona(dni, nombre, apellido, fecha);

			if (dlmPersona.contains(p)) {
				JOptionPane.showMessageDialog(this, (String) "Error. El racional " + p + " ya esta en la lista", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				// si r NO esta en la lista
//				Inserto el elemento en la lista 
				dlmPersona.addElement(p);

			}

		}

		else if (o == btnBorrar) {

			if (lstPersona.isSelectionEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para borrar", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				int posicion = lstPersona.getSelectedIndex();
				dlmPersona.removeElementAt(posicion);
			}

		} else if (o == btnLimpiar) {
			if (dlmPersona.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
						null);
			} else {
				dlmPersona.clear();
			}
		} else if (o == btnOrdenar) {
//		si se ha pulsado btnOrdenar
			listado = new ArrayList<Persona>();
//		paso los datos del dlm a un arraylist
			int i;
			for (i = 0; i < dlmPersona.size(); i++) {
				listado.add(dlmPersona.get(i));
			}
			String seleccion = (String) this.cmbOrdenar.getSelectedItem();
			switch (seleccion) {
//		ordeno el arraylis por defecto en Ascendente
			case "Ascendente":
				Collections.sort(listado);
				break;
//			ordeno el arraylis en Descendente
			case "Descendente":
				Comparator<Persona> comparador = Collections.reverseOrder();
				Collections.sort(listado, comparador);
//			Ordeno el arraylist de manera Personalizada por Nombre
			case "Nombre":
				Collections.sort(listado, new Comparator<Persona>() {
					@Override
					public int compare(Persona p1, Persona p2) {
					 return (p1.getNombre().compareTo(p2.getNombre()));
					}
					});
				break;
//			Ordeno el arraylist de manera Personalizada Por apellido
			case "Apellidos":
				Collections.sort(listado, new Comparator<Persona>() {
					@Override
					public int compare(Persona p1, Persona p2) {
					 return (p1.getApellido().compareTo(p2.getApellido()));
					}
					});
				break;
//			Ordeno el arraylist de manera Personalizada Por apellido
			case "Fecha":
				Collections.sort(listado, new Comparator<Persona>() {
					@Override
					public int compare(Persona p1, Persona p2) {
					 return (p1.getFechanacimiento().compareTo(p2.getFechanacimiento()));
					}
					});
				break;
			}
			dlmPersona.clear();
			for (Persona p : listado) {
				dlmPersona.addElement(p);
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
		txtDni.select(0, txtDni.getText().length());
		txtMes.select(0, txtMes.getText().length());
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		txtApellido.select(0, 0);
		txtDia.select(0, 0);

	}

}
