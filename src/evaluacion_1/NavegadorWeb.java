package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.border.BevelBorder;

public class NavegadorWeb extends JFrame implements HyperlinkListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1471084616724994109L;
	private JPanel contentPane;
	private JTextField txtURL;
	private JEditorPane editorPane;
	private JButton btnSiguiente;
	private JButton btnAnterior;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NavegadorWeb frame = new NavegadorWeb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public NavegadorWeb() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 18, 96, 47, 47, 0 };
		gbl_panel.rowHeights = new int[] { 21, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblURL = new JLabel("URL");
		GridBagConstraints gbc_lblURL = new GridBagConstraints();
		gbc_lblURL.anchor = GridBagConstraints.WEST;
		gbc_lblURL.insets = new Insets(0, 0, 0, 5);
		gbc_lblURL.gridx = 0;
		gbc_lblURL.gridy = 0;
		panel.add(lblURL, gbc_lblURL);

		txtURL = new JTextField();
		txtURL.setText("http://www.google.es");
		GridBagConstraints gbc_txtURL = new GridBagConstraints();
		gbc_txtURL.fill = GridBagConstraints.BOTH;
		gbc_txtURL.insets = new Insets(0, 0, 0, 5);
		gbc_txtURL.gridx = 1;
		gbc_txtURL.gridy = 0;
		panel.add(txtURL, gbc_txtURL);
		txtURL.setColumns(10);

		btnAnterior = new JButton("<<");
		GridBagConstraints gbc_btnAnterior = new GridBagConstraints();
		gbc_btnAnterior.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAnterior.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnterior.gridx = 2;
		gbc_btnAnterior.gridy = 0;
		panel.add(btnAnterior, gbc_btnAnterior);

		btnSiguiente = new JButton(">>");
		GridBagConstraints gbc_btnSiguiente = new GridBagConstraints();
		gbc_btnSiguiente.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSiguiente.gridx = 3;
		gbc_btnSiguiente.gridy = 0;
		panel.add(btnSiguiente, gbc_btnSiguiente);

		editorPane = new JEditorPane("http://www.fptxurdinaga.com");
		editorPane.setEditable(false);
		editorPane.addHyperlinkListener(this);
		contentPane.add(editorPane, BorderLayout.CENTER);

		JLabel lblURLActual = new JLabel("URL Actual");
		lblURLActual.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(lblURLActual, BorderLayout.SOUTH);
	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		// TODO Auto-generated method stub
		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			// Do something with e.getURL();
		}
		}
	}


