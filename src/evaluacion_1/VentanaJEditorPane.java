package evaluacion_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JEditorPane;

public class VentanaJEditorPane extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8992169592049054909L;
	private JPanel contentPane;
	private JButton btnNuevo;
	private JButton btnAbrir;
	private JButton btnGuardar;
	private JButton btnGuardarComo;
	private JButton btnSalir;
	private JButton btnCopiar;
	private JButton btnCortar;
	private JButton btnPegar;
	private JButton btnFuente;
	private JButton btnColor;
	private JButton btnAyuda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJEditorPane frame = new VentanaJEditorPane();
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
	public VentanaJEditorPane() {
		setBackground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1066, 343);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);

		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);

		JMenuItem mnNuevo = new JMenuItem("Nuevo");
		menuArchivo.add(mnNuevo);

		JMenuItem mnAbrir = new JMenuItem("Abrir");
		menuArchivo.add(mnAbrir);

		JMenuItem mnGuardar = new JMenuItem("Guardar");
		menuArchivo.add(mnGuardar);

		JMenuItem mnGuardarComo = new JMenuItem("Guardar Como");
		menuArchivo.add(mnGuardarComo);

		JMenuItem mnSalir = new JMenuItem("Salir");
		menuArchivo.add(mnSalir);

		JMenu menuEditar = new JMenu("Editar");
		menuBar.add(menuEditar);

		JMenuItem mnCortar = new JMenuItem("Cortar");
		menuEditar.add(mnCortar);

		JMenuItem mnCopiar = new JMenuItem("Copiar");
		menuEditar.add(mnCopiar);

		JMenuItem mnPegar = new JMenuItem("Pegar");
		menuEditar.add(mnPegar);

		JMenu menuFormato = new JMenu("Formato");
		menuBar.add(menuFormato);

		JMenuItem mnFuente = new JMenuItem("Fuente");
		menuFormato.add(mnFuente);

		JMenuItem mnColor = new JMenuItem("Color Texto");
		menuFormato.add(mnColor);

		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);

		JMenuItem mnAcercaDe = new JMenuItem("Acerca de");
		menuAyuda.add(mnAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);

		JMenuItem mnEditar = new JMenuItem("Editar");
		popupMenu.add(mnEditar);

		JMenuItem mnFormato = new JMenuItem("Formato");
		popupMenu.add(mnFormato);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(SystemColor.controlHighlight);
		contentPane.add(toolBar, BorderLayout.NORTH);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(SystemColor.controlHighlight);
		btnNuevo.setBorderPainted(false);
		btnNuevo.setIcon(new ImageIcon("E:\\PROG\\fotos\\NUEVO (1).gif"));
		toolBar.add(btnNuevo);

		btnAbrir = new JButton("Abrir");
		btnAbrir.setBackground(SystemColor.controlHighlight);
		btnAbrir.setBorderPainted(false);
		btnAbrir.setIcon(new ImageIcon("E:\\PROG\\fotos\\Abrir.gif"));
		toolBar.add(btnAbrir);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(SystemColor.controlHighlight);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setIcon(new ImageIcon("E:\\PROG\\fotos\\guardar.gif"));
		toolBar.add(btnGuardar);

		btnGuardarComo = new JButton("Guardar como");
		btnGuardarComo.setBackground(SystemColor.controlHighlight);
		btnGuardarComo.setBorderPainted(false);
		btnGuardarComo.setIcon(new ImageIcon("E:\\PROG\\fotos\\guadar como.gif"));
		toolBar.add(btnGuardarComo);

		btnSalir = new JButton("Salir");
		btnSalir.setBackground(SystemColor.controlHighlight);
		btnSalir.setBorderPainted(false);
		btnSalir.setIcon(new ImageIcon("E:\\PROG\\fotos\\salir.gif"));
		toolBar.add(btnSalir);

		btnCortar = new JButton("Cortar");
		btnCortar.setBackground(SystemColor.controlHighlight);
		btnCortar.setBorderPainted(false);
		btnCortar.setIcon(new ImageIcon("E:\\PROG\\fotos\\cortar.gif"));
		toolBar.add(btnCortar);

		btnCopiar = new JButton("Copiar");
		btnCopiar.setBackground(SystemColor.controlHighlight);
		btnCopiar.setBorderPainted(false);
		btnCopiar.setIcon(new ImageIcon("E:\\PROG\\fotos\\copiar.gif"));
		toolBar.add(btnCopiar);

		btnPegar = new JButton("Pegar");
		btnPegar.setBackground(SystemColor.controlHighlight);
		btnPegar.setBorderPainted(false);
		btnPegar.setIcon(new ImageIcon("E:\\PROG\\fotos\\pegar.gif"));
		toolBar.add(btnPegar);

		btnFuente = new JButton("Fuente");
		btnFuente.setBackground(SystemColor.controlHighlight);
		btnFuente.setBorderPainted(false);
		btnFuente.setIcon(new ImageIcon("E:\\PROG\\fotos\\fuente.gif"));
		toolBar.add(btnFuente);

		btnColor = new JButton("Color Texto");
		btnColor.setBackground(SystemColor.controlHighlight);
		btnColor.setBorderPainted(false);
		btnColor.setIcon(new ImageIcon("E:\\PROG\\fotos\\color.gif"));
		toolBar.add(btnColor);

		btnAyuda = new JButton("Acerca de");
		btnAyuda.setBackground(SystemColor.controlHighlight);
		btnAyuda.setBorderPainted(false);
		btnAyuda.setIcon(new ImageIcon("E:\\PROG\\fotos\\acerca de.jpg"));
		toolBar.add(btnAyuda);

		JPanel Estado = new JPanel();
		contentPane.add(Estado, BorderLayout.SOUTH);
		Estado.setLayout(new BorderLayout(0, 0));

		JLabel lblEstado = new JLabel("Estado: ");
		Estado.add(lblEstado);

		JLabel lblEstadoActual = new JLabel("");
		Estado.add(lblEstado, BorderLayout.WEST);
		Estado.add(lblEstadoActual, BorderLayout.CENTER);
		
		JEditorPane editorPane = new JEditorPane();
		contentPane.add(editorPane, BorderLayout.CENTER);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		Object o = ae.getSource();
		if (o == btnNuevo) {			
			try {
				File file = new File("E:\\PROG\\Archivos\\Nuevo.txt");
				file.createNewFile();
				file.setExecutable(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
