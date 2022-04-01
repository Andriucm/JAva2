package evaluacion3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class BDAlumnosCampos extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtGrupo;
	
	private ArrayList<Alumno> datos = new ArrayList<Alumno>();
	private Alumno alumno;
	private Alumno alumnoActual;
	
	private int indice;
	private int registroActual;
	private int registroFinal;
	
	private JLabel lblRegistro;
	
	private JButton btnPrimero;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JButton btnSalir;
	private JButton btnUltimo;
	private JButton btnAtras;
	private JButton btnAdelante;
	
	private String originalDni;

	private String dni;
	private String nombre;
	private String apellidos;
	private String grupo;
	private 	Statement st;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BDAlumnosCampos frame = new BDAlumnosCampos();
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
	public BDAlumnosCampos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel1 = new JPanel();

		JPanel panel3 = new JPanel();

		JPanel panel2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel1, GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(74)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 493, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel2.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		panel2.add(btnBorrar);

		btnActualizar = new JButton("Actualizar");
		panel2.add(btnActualizar);

		btnSalir = new JButton("Salir");
		panel2.add(btnSalir);
		GridBagLayout gbl_panel3 = new GridBagLayout();
		gbl_panel3.columnWidths = new int[] { 53, 16, 96, 0 };
		gbl_panel3.rowHeights = new int[] { 19, 0, 0, 0, 0 };
		gbl_panel3.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel3.setLayout(gbl_panel3);

		JLabel lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.WEST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 0;
		panel3.add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		txtDni.setColumns(10);
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.anchor = GridBagConstraints.NORTH;
		gbc_txtDni.insets = new Insets(0, 0, 5, 0);
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 0;
		panel3.add(txtDni, gbc_txtDni);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		panel3.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.anchor = GridBagConstraints.NORTH;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 1;
		panel3.add(txtNombre, gbc_txtNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.WEST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 2;
		panel3.add(lblApellidos, gbc_lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.anchor = GridBagConstraints.NORTH;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellidos.gridx = 2;
		gbc_txtApellidos.gridy = 2;
		panel3.add(txtApellidos, gbc_txtApellidos);

		JLabel lblGrupo = new JLabel("Grupo");
		GridBagConstraints gbc_lblGrupo = new GridBagConstraints();
		gbc_lblGrupo.anchor = GridBagConstraints.WEST;
		gbc_lblGrupo.insets = new Insets(0, 0, 0, 5);
		gbc_lblGrupo.gridx = 1;
		gbc_lblGrupo.gridy = 3;
		panel3.add(lblGrupo, gbc_lblGrupo);

		txtGrupo = new JTextField();
		txtGrupo.setColumns(10);
		GridBagConstraints gbc_txtGrupo = new GridBagConstraints();
		gbc_txtGrupo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGrupo.anchor = GridBagConstraints.NORTH;
		gbc_txtGrupo.gridx = 2;
		gbc_txtGrupo.gridy = 3;
		panel3.add(txtGrupo, gbc_txtGrupo);

		btnPrimero = new JButton("<<");
	
		panel1.add(btnPrimero);

		btnAtras = new JButton("<");
		panel1.add(btnAtras);

		lblRegistro = new JLabel("");
		panel1.add(lblRegistro);

		btnAdelante = new JButton(">");
		panel1.add(btnAdelante);

		btnUltimo = new JButton(">>");
		panel1.add(btnUltimo);
		contentPane.setLayout(gl_contentPane);
		conectarDatos();
		btnPrimero.addActionListener(this);
		btnUltimo.addActionListener(this);
		btnAdelante.addActionListener(this);
		btnAtras.addActionListener(this);
		btnInsertar.addActionListener(this);
		btnActualizar.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnSalir.addActionListener(this);
	}

	public void conectarDatos() {
		// prueba de conexion de la base de datos
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// Selecciono los registros de la tabla alumnos mediante Resulset
			ResultSet rs = st.executeQuery("Select * from bdalumnos.alumnos;");
			// Comprobar registros
			if (rs.next()) {
				// Si hay registros
				rs.beforeFirst();
				while (rs.next()) {
					alumno = new Alumno();
					alumno.setDni(rs.getString("dni"));
					alumno.setNombre(rs.getString("nombre"));
					alumno.setApellido(rs.getString("apellidos"));
					alumno.setGrupo(rs.getString("grupo"));
					datos.add(alumno);
				}
				indice = 0;
				registroActual = 1;
				pasarDatos();
			} else {
				lblRegistro.setText("No hay registros");
				btnActualizar.setEnabled(false);
				btnBorrar.setEnabled(false);
				btnAdelante.setEnabled(false);
				btnAtras.setEnabled(false);
				btnInsertar.setEnabled(false);
				btnPrimero.setEnabled(false);
				btnUltimo.setEnabled(false);
			}
			// Cierro statement
			st.close();
			// Cierro resultset
			rs.close();
			// Cierro la conexion
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error de Conexion");

			// } catch (IOException ioe) {
			// System.out.println("Error: "+ioe.getMessage());
			// }

		}
	}

	public void pasarDatos() {
		alumnoActual = datos.get(indice);
		registroFinal = datos.size();
		txtDni.setText(alumnoActual.getDni());
		txtNombre.setText(alumnoActual.getNombre());
		txtApellidos.setText(alumnoActual.getApellido());
		txtGrupo.setText(alumnoActual.getGrupo());
		originalDni = txtDni.getText();
		if(indice >= datos.size()-1) {
			btnAdelante.setEnabled(false);  
			btnUltimo.setEnabled(false);  

		}else if (indice <=0) {
			btnPrimero.setEnabled(false);  
			btnAtras.setEnabled(false);  
		}else {
			btnPrimero.setEnabled(true);  
			btnAtras.setEnabled(true);  
			btnAdelante.setEnabled(true);  
			btnUltimo.setEnabled(true);  
		}
		lblRegistro.setText("registro: " + registroActual + " de " + registroFinal);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o == btnPrimero) {
			indice = 0;
			registroActual = 1;
			btnUltimo.setEnabled(true);
			btnAdelante.setEnabled(true);
			pasarDatos();
		}else if (o == btnAtras) {
			indice = indice-1;
			registroActual = registroActual -1 ;
			pasarDatos();
		} else if (o == btnUltimo) {
			indice = datos.size() -1;
			registroActual= datos.size();
			btnPrimero.setEnabled(true);
			btnAtras.setEnabled(true);
			pasarDatos();
			
	}else if (o == btnAdelante) {
		indice = indice+1;
		registroActual = registroActual +1 ;
		pasarDatos();
	} else if (o== btnInsertar) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		dni = txtDni.getText();
		nombre = txtNombre.getText();
		apellidos = txtApellidos.getText();
		grupo = txtGrupo.getText();
		
		String consulta = "INSERT INTO bdalumnos.alumnos VALUES ('"+dni+"','"+nombre+"','"+apellidos+"','"+grupo+"');";
		st.executeUpdate(consulta);
		JOptionPane.showMessageDialog(this,(String)"Se ha insertado","INFO",JOptionPane.INFORMATION_MESSAGE,null);
		// Cierro statement
		st.close();
	// Cierro la conexion
				conexion.close();
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			int errorcode = sqle.getErrorCode();
			if (errorcode == 1062) {
				JOptionPane.showMessageDialog(this,(String)"Este alumno ya existe en la base de datos","ERROR",JOptionPane.ERROR_MESSAGE,null);
				
			}else if (errorcode == 1329) {
				
			}
		}
	}
		
}
}
