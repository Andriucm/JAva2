package Evaluacion2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FicheroHola {

	public static void main(String[] args) {
		// escribe el mensaje hola mundo en un fichero de texto de nombre
		// prueba txt
		FileWriter fichero;
		PrintWriter pw;
		BufferedWriter bw;
		try {
//			abrir el fichero
			fichero = new FileWriter("prueba.txt");
			pw = new PrintWriter(fichero);
			bw = new BufferedWriter(pw);
//			Escribo unas lineas
			bw.write("Hola Mundo.");
			bw.newLine();
//			Cierro el fichero
		 bw.close();
		 pw.close();
		 fichero.close();
		} catch (IOException e) {
			System.out.println("Se ha producido un erro");
		}

	}

}
