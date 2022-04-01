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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class VentanaJComboBoxJListAlumnos extends JFrame implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8774197489170299432L;
	private JPanel contentPane;
	private JTextField txtAlumno;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JLabel lblGupo;
	private JComboBox<String> cmbGrupos;
	private DefaultListModel<String> dlm1AS3;
	private DefaultListModel<String> dlm2AS3;
	private DefaultListModel<String> dlm1DW3;
	private DefaultListModel<String> dlm2DW3;
	private JList<String> lstAlumnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJComboBoxJListAlumnos frame = new VentanaJComboBoxJListAlumnos();
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
	public VentanaJComboBoxJListAlumnos() {
		setTitle("VentanaJListVariosCamposComboBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblAlumno = new JLabel("Alumno");
		panel.add(lblAlumno);

		txtAlumno = new JTextField();
		panel.add(txtAlumno);
		txtAlumno.setColumns(10);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);

		lblGupo = new JLabel("Grupo");
		panel.add(lblGupo);

		cmbGrupos = new JComboBox<String>();
		cmbGrupos.addItem("1AS3");
		cmbGrupos.addItem("2AS3");
		cmbGrupos.addItem("1DW3");
		cmbGrupos.addItem("2DW3");
		panel.add(cmbGrupos);
		panel.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);

		dlm1AS3 = new DefaultListModel<String>();
		dlm1AS3.add(0, "1AS3");
		dlm2AS3 = new DefaultListModel<String>();
		dlm2AS3.add(0, "2AS3");
		dlm1DW3 = new DefaultListModel<String>();
		dlm1DW3.add(0, "1DW3");
		dlm2DW3 = new DefaultListModel<String>();
		dlm2DW3.add(0, "2DW3");

		lstAlumnos = new JList<String>();
		contentPane.add(lstAlumnos, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		Object o = ae.getSource();
		switch (cmbGrupos.getSelectedIndex()) {
		case 0:
			lstAlumnos.setModel(dlm1AS3);
			if (o == btnInsertar) {
				String Alumno = txtAlumno.getText();
				if (Alumno.equals("")) {
					JOptionPane.showMessageDialog(this, (String) "Error. No se ha añadido ningun DNI", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} else {

					if (dlm1AS3.contains(Alumno)) {
						JOptionPane.showMessageDialog(this, (String) "Error. El alumno " + Alumno + " ya esta en la lista", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					} else {
						int posicion = 0;
						int NumPos = dlm1AS3.getSize();
						while (posicion < NumPos) {
							if (Alumno.compareTo(dlm1AS3.get(posicion)) < 0) {
								break;
							}
							posicion++;
						}
						dlm1AS3.add(posicion, Alumno);
					}
				}
			}

			else if (o == btnBorrar) {

				if (lstAlumnos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(this, (String) "Error. No ningun alumno selccionado para borrar", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} else {
					int posicion = lstAlumnos.getSelectedIndex();
					dlm1AS3.removeElementAt(posicion);
				}

			} else if (o == btnLimpiar) {
				if (dlm1AS3.isEmpty()) {
					JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
							null);
				} else {
					dlm1AS3.clear();
				}
			}
			break;
		case 1:
			lstAlumnos.setModel(dlm2AS3);
			if (o == btnInsertar) {
				String Alumno = txtAlumno.getText();
				if (Alumno.equals("")) {
					JOptionPane.showMessageDialog(this, (String) "Error. No se ha añadido ningun DNI", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} else {

					if (dlm2AS3.contains(Alumno)) {
						JOptionPane.showMessageDialog(this, (String) "Error. El alumno " + Alumno + " ya esta en la lista", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					} else {
						int posicion = 0;
						int NumPos = dlm2AS3.getSize();
						while (posicion < NumPos) {
							if (Alumno.compareTo(dlm2AS3.get(posicion)) < 0) {
								break;
							}
							posicion++;
						}
						dlm2AS3.add(posicion, Alumno);
					}
				}
			}

			else if (o == btnBorrar) {

				if (lstAlumnos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(this, (String) "Error. No ningun alumno selccionado para borrar", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} else {
					int posicion = lstAlumnos.getSelectedIndex();
					dlm2AS3.removeElementAt(posicion);
				}

			} else if (o == btnLimpiar) {
				if (dlm2AS3.isEmpty()) {
					JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
							null);
				} else {
					dlm2AS3.clear();
				}
			}
			break;
		case 2:
			lstAlumnos.setModel(dlm1DW3);
			if (o == btnInsertar) {
				String Alumno = txtAlumno.getText();
				if (Alumno.equals("")) {
					JOptionPane.showMessageDialog(this, (String) "Error. No se ha añadido ningun DNI", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} else {

					if (dlm1DW3.contains(Alumno)) {
						JOptionPane.showMessageDialog(this, (String) "Error. El alumno " + Alumno + " ya esta en la lista", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					} else {
						int posicion = 0;
						int NumPos = dlm1DW3.getSize();
						while (posicion < NumPos) {
							if (Alumno.compareTo(dlm1DW3.get(posicion)) < 0) {
								break;
							}
							posicion++;
						}
						dlm1DW3.add(posicion, Alumno);
					}
				}
			}

			else if (o == btnBorrar) {

				if (lstAlumnos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(this, (String) "Error. No ningun alumno selccionado para borrar", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} else {
					int posicion = lstAlumnos.getSelectedIndex();
					dlm1DW3.removeElementAt(posicion);
				}

			} else if (o == btnLimpiar) {
				if (dlm1DW3.isEmpty()) {
					JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
							null);
				} else {
					dlm1DW3.clear();
				}
			}
			break;
		case 3:
			lstAlumnos.setModel(dlm2DW3);
			if (o == btnInsertar) {
				String Alumno = txtAlumno.getText();
				if (Alumno.equals("")) {
					JOptionPane.showMessageDialog(this, (String) "Error. No se ha añadido ningun Alumno", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} else {

					if (dlm2DW3.contains(Alumno)) {
						JOptionPane.showMessageDialog(this, (String) "Error. El alumno " + Alumno + " ya esta en la lista", "ERROR",
								JOptionPane.ERROR_MESSAGE, null);
					} else {
						int posicion = 0;
						int NumPos = dlm2DW3.getSize();
						while (posicion < NumPos) {
							if (Alumno.compareTo(dlm2DW3.get(posicion)) < 0) {
								break;
							}
							posicion++;
						}
						dlm2DW3.add(posicion, Alumno);
					}
				}
			}

			else if (o == btnBorrar) {

				if (lstAlumnos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(this, (String) "Error. No ningun alumno selccionado para borrar", "ERROR",
							JOptionPane.ERROR_MESSAGE, null);
				} else {
					int posicion = lstAlumnos.getSelectedIndex();
					dlm2DW3.removeElementAt(posicion);
				}

			} else if (o == btnLimpiar) {
				if (dlm2DW3.isEmpty()) {
					JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
							null);
				} else {
					dlm2DW3.clear();
				}
			}
			break;
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		// TODO Auto-generated method stub
		Object o = lse.getSource();
		@SuppressWarnings("unchecked")
		int posicion = ((JList<String>) o).getSelectedIndex();
		lstAlumnos.setSelectedIndex(posicion);

		txtAlumno.setText(lstAlumnos.getSelectedValue());
	}

}