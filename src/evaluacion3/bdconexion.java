package evaluacion3;

import java.sql.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bdconexion {

	public static void main(String[] args) {
//		prueba de conexion de la base de datos
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			Statement st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//		Selecciono los registros de la tabla alumnos mediante Resulset
			ResultSet rs = st.executeQuery("Select * from bdalumnos.alumnos;");
			rs.setFetchDirection(ResultSet.FETCH_UNKNOWN);

//			Creo fichero
			FileWriter fichero;
			PrintWriter pw;
			BufferedWriter bw;

//				abro el fichero html
			fichero = new FileWriter("conexionBd.html");
			pw = new PrintWriter(fichero);
			bw = new BufferedWriter(pw);
//				escribo lo que tengas que escribir
			bw.write("<html>");
			bw.newLine();
			bw.write("<head>");
			bw.write("<title> Hola html </title>");
			bw.write("</head>");
//				contenido de body
			bw.write("<body>");
			bw.write("<h1>Listado de tabla </h1>");

//				Comprobar registros
			if (rs.next()) {
//					Si hay registros
//					vuelvo a la anterior

//				Creo la tabla
				bw.write("<table>");
//				Cabecera de la tabla
				bw.write("<thead>");
				bw.write("<tr>");
				bw.write("<th> DNI </th>");
				bw.write("<th> Nombre </th>");
				bw.write("<th> Apellidos </th>");
				bw.write("<th> Grupos</th>");
				bw.write("</tr>");
				bw.write("</thead>");
//				Cuerpo de la tabla
				bw.write("<tbody>");
//			muestro los registros de la base de datos en la tabla
				while (rs.next()) {
					bw.write("<tr>");
					bw.write("<td>" + rs.getObject("dni") + "</td>");
					bw.write("<td>" + rs.getObject("nombre") + "</td>");
					bw.write("<td>" + rs.getObject("apellidos") + "</td>");
					bw.write("<td>" + rs.getObject("grupo") + "</td>");
					bw.write("</tr>");
				}
				bw.write("</tbody>");
				bw.write("</table>");
//			si no hay registros
			} else {
				bw.write("<h3> La tabla no tiene registros </h3>");
			}
			bw.write("</body>");
			bw.write("</html>");

//		cierro el fichero
			bw.close();
			pw.close();
			fichero.close();
//	Cierro statement
			st.close();
//Cierro resultset
			rs.close();
//Cierro la conexion
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Error de Conexion");

		} catch (IOException ioe) {
			System.out.println("Error: "+ioe.getMessage());
		}

	}

}
