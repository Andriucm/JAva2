package evaluacion3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ficheroHolaHtml {

	public static void main(String[] args) {
		FileWriter fichero;
		PrintWriter pw;
		BufferedWriter bw;
		
		try {
//			abro el fichero html
			fichero = new FileWriter("hola.html");
			pw = new PrintWriter(fichero);
			bw = new BufferedWriter(pw);
//			escribo lo que tengas que escribir
			bw.write("<html>");
			bw.newLine();
			bw.write("<head>");
			bw.write("<title> Hola html </title>");
			bw.write("</head>");
			bw.write("<body>");
			bw.write("<p> Fichero hola html generado por codigo </p>");
			bw.write("</body>");
			bw.write("</html>");
//			cierro el fichero
			bw.close();
			pw.close();
			fichero.close();
			
		} catch (IOException e) {
			System.out.println("Se ha producido un error");

		}

	} 

}
