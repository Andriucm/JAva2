package evaluacion3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BdUpdateAlumno {

	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
//			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			Statement st = conexion.createStatement();
//			Creo la consulta
			String consulta = "Update bdalumnos.alumnos set grupo='1DW3'  WHERE dni='11111111A'";
//			Ejecuto la sentencia
			int registrosmodificados;
			registrosmodificados = st.executeUpdate(consulta);
//			compruebo si hay algin registro afectado
			if (registrosmodificados >0) {
//				si se ha modificado
				System.out.println("El registro se ha modificado");
			} else {
//			si NO se ha modificado
				System.out.println("No se ha modificado ningun registro");
			}
			
			st.close();
			conexion.close();
	}catch (SQLException sqle) {
	// si se produce una excepción SQL

		 System.out.println("Error SQL Numero "+sqle.getErrorCode()+":"+sqle.getMessage());
	}

}
}

