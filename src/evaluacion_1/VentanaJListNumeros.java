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

public class VentanaJListNumeros extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7319466074596025533L;
	private JPanel contentPane;
	private JTextField txtNumero;
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
					VentanaJListNumeros frame = new VentanaJListNumeros();
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
	public VentanaJListNumeros() {
		setTitle("VentanaJListNumeros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Numero:");
		panel.add(lblNewLabel);

		txtNumero = new JTextField();
		txtNumero.addActionListener(this);
		txtNumero.setText("0");
		txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(txtNumero);
		txtNumero.setColumns(10);

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

		if ((o == btnInsertar) || (o == txtNumero)) {
			String Valor = txtNumero.getText();
			int Num = Integer.parseInt(Valor);
			if (dlm.contains(Num)) {
				JOptionPane.showMessageDialog(this, (String) "Error. El numero " + Num + " ya esta en la lista", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			} else {
				dlm.addElement(Num);
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
				JOptionPane.showMessageDialog(this, (String) "Error. La lista esta vacía", "ERROR",
						JOptionPane.ERROR_MESSAGE, null);
			}
			else {
				dlm.clear();
			}
		}
		
	}

}
