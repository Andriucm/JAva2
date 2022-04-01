package evaluacion_1;

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
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

public class VentanaJListVariosCamposComboBox extends JFrame implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7499282393278579697L;
	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<String> lstDNI;
	private DefaultListModel<String> dlmDNI;
	private JList<String> lstNombres;
	private DefaultListModel<String> dlmNombres;
	private JLabel lblGupo;
	private JComboBox<String> cmbGrupos;
	private JList<String> lstGrupos;
	private DefaultListModel<String> dlmGrupos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListVariosCamposComboBox frame = new VentanaJListVariosCamposComboBox();
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
	public VentanaJListVariosCamposComboBox() {
		setTitle("VentanaJListVariosCamposComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblDNI = new JLabel("DNI");
		panel.add(lblDNI);

		txtDNI = new JTextField();
		panel.add(txtDNI);
		txtDNI.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		panel.add(lblNombre);

		txtNombre = new JTextField();
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);

		lblGupo = new JLabel("Grupo");
		panel.add(lblGupo);

		cmbGrupos = new JComboBox<String>();
		cmbGrupos.addItem("1DW3");
		cmbGrupos.addItem("2DW3");
		cmbGrupos.addItem("1AS3");
		cmbGrupos.addItem("2AS3");
		panel.add(cmbGrupos);
		panel.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);

		dlmDNI = new DefaultListModel<String>();

		lstDNI = new JList<String>();
		lstDNI.addListSelectionListener(this);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		lstDNI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstDNI.setModel(dlmDNI);
		panel_1.add(lstDNI);

		dlmNombres = new DefaultListModel<String>();

		lstNombres = new JList<String>();
		lstNombres.addListSelectionListener(this);
		lstNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstNombres.setModel(dlmNombres);
		panel_1.add(lstNombres);

		dlmGrupos = new DefaultListModel<String>();

		lstGrupos = new JList<String>();
		lstGrupos.addListSelectionListener(this);
		lstGrupos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstGrupos.setModel(dlmGrupos);
		panel_1.add(lstGrupos);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		Object o = ae.getSource();

		if (o == btnInsertar) {
			String DNI = txtDNI.getText();
			String Nombre = txtNombre.getText();
			String Grupo = (String) cmbGrupos.getSelectedItem();
			if (DNI.equals("")) {
				JOptionPane.showMessageDialog(this, (String) "Error. No se ha añadido ningun DNI", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				if (dlmDNI.contains(DNI)) {
					JOptionPane.showMessageDialog(this, (String) "Error. El número " + DNI + " ya esta en la lista", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} else {
					int posicion = 0;
					int NumPos = dlmDNI.getSize();
					while (posicion < NumPos) {
						if (DNI.compareTo(dlmDNI.get(posicion)) < 0) {
							break;
						}
						posicion++;
					}
					JOptionPane.showMessageDialog(this, (String) "Posición " + posicion + ". DNI " + DNI + " y nombre " + Nombre,
							"Informacionn", JOptionPane.INFORMATION_MESSAGE, null);
					if (Nombre.equals("")) {
						Nombre = " ";
					}
					dlmDNI.add(posicion, DNI);
					dlmNombres.add(posicion, Nombre);
					dlmGrupos.add(posicion, Grupo);
				}
			}
		}

		else if (o == btnBorrar) {

			if (lstDNI.isSelectionEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para borrar", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				int posicion = lstDNI.getSelectedIndex();
				dlmDNI.removeElementAt(posicion);
				dlmNombres.removeElementAt(posicion);
				dlmGrupos.removeElementAt(posicion);
			}

		} else if (o == btnLimpiar) {
			if (dlmDNI.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
						null);
			} else {
				dlmDNI.clear();
				dlmNombres.clear();
				dlmGrupos.clear();
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		// TODO Auto-generated method stub
		Object o = lse.getSource();
		@SuppressWarnings("unchecked")
		int posicion = ((JList<String>) o).getSelectedIndex();
		lstDNI.setSelectedIndex(posicion);
		lstNombres.setSelectedIndex(posicion);
		lstGrupos.setSelectedIndex(posicion);

		txtDNI.setText(lstDNI.getSelectedValue());
		txtNombre.setText(lstNombres.getSelectedValue());
		cmbGrupos.setSelectedItem(lstGrupos.getSelectedValue());
	}

}
