package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VentanaJListNumerosOrdenados extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4237892501090799353L;
	private JPanel contentPane;
	private JTextField txtRacional;
	private DefaultListModel<Integer> dlm;
	private JList<Integer> lstNumeros;
	private JButton btnBorrar;
	private JButton btnInsertar;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListNumerosOrdenados frame = new VentanaJListNumerosOrdenados();
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
	public VentanaJListNumerosOrdenados() {
		setTitle("VentanaJListNumerosOrdenados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblRacional = new JLabel("Numero:");
		panel.add(lblRacional);

		txtRacional = new JTextField();
		txtRacional.addActionListener(this);
		txtRacional.setText("0");
		txtRacional.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(txtRacional);
		txtRacional.setColumns(10);

		btnInsertar = new JButton("Insertar");
		btnInsertar.setBackground(new Color(255, 255, 255));
		btnInsertar.setForeground(new Color(135, 206, 235));
		btnInsertar.addActionListener(this);
		panel.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(255, 255, 255));
		btnBorrar.setForeground(new Color(135, 206, 235));
		btnBorrar.addActionListener(this);
		panel.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(255, 255, 255));
		btnLimpiar.setForeground(new Color(135, 206, 235));
		btnLimpiar.addActionListener(this);
		panel.add(btnLimpiar);

		dlm = new DefaultListModel<Integer>();

		lstNumeros = new JList<Integer>();
		lstNumeros.setModel(dlm);
		contentPane.add(lstNumeros, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		Object o = ae.getSource();

		if ((o == btnInsertar) || (o == txtRacional)) {
			String Valor = txtRacional.getText();
			int Num = Integer.parseInt(Valor);
			if (dlm.contains(Num)) {
				JOptionPane.showMessageDialog(this, (String) "Error. El numero " + Num + " ya esta en la lista", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				int posicion = 0;
				int NumPos = dlm.getSize();
				while (posicion < NumPos) {
					if (Num < dlm.get(posicion)) {
						break;
					}
					posicion++;
				}
				JOptionPane.showMessageDialog(this, (String) "Posicion " + posicion + ". Valor " + Num, "Informacionn",
						JOptionPane.INFORMATION_MESSAGE, null);
				dlm.add(posicion, Num);
			}
		}

		else if (o == btnBorrar) {
			int[] indices = this.lstNumeros.getSelectedIndices();
			int numeroOpciones = indices.length;
			if (numeroOpciones == 0) {
				JOptionPane.showMessageDialog(this, (String) "Error. No hay elementos selccionados para borrar", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				for (int posicion = numeroOpciones - 1; posicion >= 0; posicion--) {
					dlm.removeElementAt(indices[posicion]);
				}

			}
		} else if (o == btnLimpiar) {
			if (dlm.isEmpty()) {
				JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR", JOptionPane.ERROR_MESSAGE,
						null);
			} else {
				dlm.clear();
			}
		}

	}

}
