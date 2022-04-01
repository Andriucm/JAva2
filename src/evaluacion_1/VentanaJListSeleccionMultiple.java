package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import java.awt.Font;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;

public class VentanaJListSeleccionMultiple extends JFrame implements ListSelectionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6625313729873871484L;
	private JPanel contentPane;
	private JLabel lblMensaje;
	private JList<String> lstGrupos;
	private DefaultListModel<String> dlm;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJListSeleccionMultiple frame = new VentanaJListSeleccionMultiple();
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
	public VentanaJListSeleccionMultiple() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	  lblMensaje = new JLabel("No se ha seleccionado un grupo");
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
		lstGrupos.addListSelectionListener(this);
		contentPane.add(lstGrupos, BorderLayout.CENTER);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		String eleccion =  (String) this.lstGrupos.getSelectedValue();
		this.lblMensaje.setText(eleccion);
	}


		
	

}
