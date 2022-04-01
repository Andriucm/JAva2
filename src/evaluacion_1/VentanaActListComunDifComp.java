package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class VentanaActListComunDifComp extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3520836037113938789L;
	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaActListComunDifComp frame = new VentanaActListComunDifComp();
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
	public VentanaActListComunDifComp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblMensaje.setForeground(Color.BLUE);
		contentPane.add(lblMensaje, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btn1 = new JButton("1");
		btn1.addActionListener(this);
		panel.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		panel.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(this);
		panel.add(btn3);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object o = ae.getSource();
		if (o==btn1) {
			lblMensaje.setText("Ha pulsado el boton 1");
		}
		else {
			if (o==btn2) {
				lblMensaje.setText("Ha pulsado el boton 2");
			}
			else {
				lblMensaje.setText("Ha pulsado el boton 3");
			}
		}
		
	}

}
