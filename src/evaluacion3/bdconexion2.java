package evaluacion3;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bdconexion2 {

	public static void main(String[] args) {
//		prueba de conexion de la base de datos
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos","root", "");
			Statement st = conexion.createStatement();
//		Selecciono los registros de la tabla alumnos mediante Resulset
			ResultSet rs = st.executeQuery("Select * from bdalumnos.alumnos;");
//		Genero
			while (rs.next()) {
				System.out.println("DNI: " +rs.getObject("dni") + ", nombre: "+ rs.getObject("nombre") +", Apellido: " +rs.getObject("apellidos"+", Grupo: " +rs.getObject("grupo")));
			}
//			Cierro statement
			st.close();
//		Cierro resultset
			rs.close();
//		Cierro la conexion
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error de Conexion");
		}

	}

}
