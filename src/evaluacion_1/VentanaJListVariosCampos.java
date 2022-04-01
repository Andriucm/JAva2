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
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;

public class VentanaJListVariosCampos extends JFrame implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6651218355838555498L;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListVariosCampos frame = new VentanaJListVariosCampos();
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
	public VentanaJListVariosCampos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 311);
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
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 213, 213, 0 };
		gbl_panel_1.rowHeights = new int[] { 222, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		dlmDNI = new DefaultListModel<String>();

		lstDNI = new JList<String>();
		lstDNI.addListSelectionListener(this);
		lstDNI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstDNI.setModel(dlmDNI);
		GridBagConstraints gbc_lstDNI = new GridBagConstraints();
		gbc_lstDNI.fill = GridBagConstraints.BOTH;
		gbc_lstDNI.insets = new Insets(0, 0, 0, 5);
		gbc_lstDNI.gridx = 0;
		gbc_lstDNI.gridy = 0;
		panel_1.add(lstDNI, gbc_lstDNI);

		dlmNombres = new DefaultListModel<String>();

		lstNombres = new JList<String>();
		lstNombres.addListSelectionListener(this);
		lstNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstNombres.setModel(dlmNombres);
		GridBagConstraints gbc_lstNombres = new GridBagConstraints();
		gbc_lstNombres.fill = GridBagConstraints.BOTH;
		gbc_lstNombres.gridx = 1;
		gbc_lstNombres.gridy = 0;
		panel_1.add(lstNombres, gbc_lstNombres);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		Object o = ae.getSource();

		if (o == btnInsertar) {
			String DNI = txtDNI.getText();
			String Nombre = txtNombre.getText();
			if (DNI.equals("")) {
				JOptionPane.showMessageDialog(this, (String) "Error. No se ha añaido ningun DNI", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				if (dlmDNI.contains(DNI)) {
					JOptionPane.showMessageDialog(this, (String) "Error. El numero " + DNI + " ya esta en la lista", "ERROR",
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
					JOptionPane.showMessageDialog(this, (String) "Posicion " + posicion + ". DNI " + DNI + " y nombre " + Nombre,
							"Informacionn", JOptionPane.INFORMATION_MESSAGE, null);
					if (Nombre.equals("")) {
						Nombre = " ";
					}
					dlmDNI.add(posicion, DNI);
					dlmNombres.add(posicion, Nombre);
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
			}

		} else if (o == btnLimpiar) {
			if (dlmDNI.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
						null);
			} else {
				dlmDNI.clear();
				dlmNombres.clear();
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

		txtDNI.setText(lstDNI.getSelectedValue());
		txtNombre.setText(lstNombres.getSelectedValue());
	}

}
