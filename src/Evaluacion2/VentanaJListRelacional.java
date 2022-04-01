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

import javax.swing.ListSelectionModel;
import java.awt.SystemColor;
import java.awt.GridLayout;

public class VentanaJListRelacional extends JFrame implements ActionListener, ListSelectionListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6651218355838555498L;
	private JPanel contentPane;
	private JTextField txtNumerador;
	private JTextField txtDenominador;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<Racional> lstRacional;
	private DefaultListModel<Racional> dlmRacional;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListRelacional frame = new VentanaJListRelacional();
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
	public VentanaJListRelacional() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNumerador = new JLabel("Numerador:");
		panel.add(lblNumerador);

		txtNumerador = new JTextField();
		panel.add(txtNumerador);
		txtNumerador.addFocusListener(this);
		txtNumerador.setColumns(10);

		JLabel lblDenominador = new JLabel("Denominador:");
		panel.add(lblDenominador);

		txtDenominador = new JTextField();
		panel.add(txtDenominador);
		txtDenominador.addFocusListener(this);
		txtDenominador.setColumns(10);

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

		dlmRacional = new DefaultListModel<Racional>();

		lstRacional = new JList<Racional>();
		lstRacional.addListSelectionListener(this);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		lstRacional.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstRacional.setModel(dlmRacional);
		panel_1.add(lstRacional);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		Object o = ae.getSource();

		if (o == btnInsertar) {
			int numerador = Integer.parseInt(txtNumerador.getText());
			int denominador = Integer.parseInt(txtDenominador.getText());
//			creo nuevo racional
			Racional r = new Racional (numerador, denominador);
			
			if (dlmRacional.contains(r)) {
				JOptionPane.showMessageDialog(this, (String) "Error. El racional " +r+ " ya esta en la lista", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				// si r NO esta en la lista
//				Inserto el elemento en la lista de forma ordenada
//				busco la posicioon al insertar
				int posicion=0;
				int numeroelementos = dlmRacional.getSize();
				while (posicion <numeroelementos) {
					if (r.compareTo(dlmRacional.get(posicion))< 0) {
						break;
					}
					posicion = posicion++;
					}
			
				dlmRacional.add(posicion, r);
			}
			
		}

		else if (o == btnBorrar) {

			if (lstRacional.isSelectionEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para borrar", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				int posicion = lstRacional.getSelectedIndex();
				dlmRacional.removeElementAt(posicion);
			}

		} else if (o == btnLimpiar) {
			if (dlmRacional.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
						null);
			} else {
				dlmRacional.clear();
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		// TODO Auto-generated method stub
		Object o = lse.getSource();
		@SuppressWarnings("unchecked")
		int posicion = ((JList<String>) o).getSelectedIndex();
		lstRacional.setSelectedIndex(posicion);
	

		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		txtNumerador.select(0, txtNumerador.getText().length());
		txtDenominador.select(0, txtDenominador.getText().length());
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		txtNumerador.select(0, 0);
		txtDenominador.select(0, 0);
		
	}

}
