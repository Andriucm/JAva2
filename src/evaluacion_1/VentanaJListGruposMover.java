package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;

class VentanaJListGruposMover extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1401706130046745937L;
	private JPanel contentPane;
	private JLabel lblMensaje;
	private JList<String> lstGruposCopia;
	private DefaultListModel<String> dlm;
	private DefaultListModel<String> dlmCopia;
	private JPanel panel;
	private JButton btnMoverIzq;
	private JButton btnMoverDch;
	private JList<String> lstGrupos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListGruposMover frame = new VentanaJListGruposMover();
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
	public VentanaJListGruposMover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		lblMensaje = new JLabel("Seleccionar y mover");
		lblMensaje.setBackground(new Color(240, 240, 240));
		lblMensaje.setForeground(Color.BLUE);
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblMensaje, BorderLayout.NORTH);

		// Modelo lista de Opciones
		dlm = new DefaultListModel<String>();
		dlm.addElement("1AS3");
		dlm.addElement("2AS3");
		dlm.addElement("1DW3");
		dlm.addElement("2DW3");
		// Lista Opciones
		lstGrupos = new JList<String>();
		// Lo asocio
		lstGrupos.setModel(dlm);
		contentPane.add(lstGrupos, BorderLayout.WEST);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		btnMoverIzq = new JButton("Mover a Izquierda");
		btnMoverIzq.addActionListener(this);
		panel.add(btnMoverIzq);

		btnMoverDch = new JButton("Mover a Derecha");
		btnMoverDch.addActionListener(this);
		panel.add(btnMoverDch);

		dlmCopia = new DefaultListModel<String>();
		lstGruposCopia = new JList<String>();
		lstGruposCopia.setModel(dlmCopia);
		contentPane.add(lstGruposCopia, BorderLayout.EAST);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();

		if (o == btnMoverDch) {
			// si quiero copiar de la lista izquierda a la derecha
			int[] indices = this.lstGrupos.getSelectedIndices();
			int numeroOpciones = indices.length;
			String opcion = null;
			for (int posicion = numeroOpciones-1; posicion >= 0; posicion--) {
				opcion = dlm.getElementAt(indices[posicion]);
				this.dlmCopia.addElement(opcion);
				this.dlm.removeElement(opcion);
			}
		} else if (o == btnMoverIzq) {
			// si quiero copiar de la lista derecha a la izquierda
			int[] indices = this.lstGruposCopia.getSelectedIndices();
			int numeroOpciones = indices.length;
			String opcion = null;
			for (int posicion = numeroOpciones-1; posicion >= 0; posicion--) {
				opcion = dlmCopia.getElementAt(indices[posicion]);
				this.dlm.addElement(opcion);
				this.dlmCopia.removeElement(opcion);
			}
		}
	}

}
