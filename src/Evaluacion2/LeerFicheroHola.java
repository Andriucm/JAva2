package Evaluacion2;

import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LeerFicheroHola {

	public static void main(String[] args) {
		// escribe el mensaje hola mundo en un fichero de texto de nombre
		// prueba txt
		File archivo;
		FileReader fr;
		BufferedReader br;
		try {
			archivo = new File("prueba.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
//			Leo el contenido linea a linea
			String linea;
			while((linea= br.readLine())!=null) {
				System.out.println(linea);
			}
//			Cierro el fichero
		 br.close();
		 fr.close();
		} catch (IOException e) {
			System.out.println("Se ha producido un erro");
		}

	}

}
