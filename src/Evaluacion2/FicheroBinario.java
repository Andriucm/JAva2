package Evaluacion2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroBinario {

	public static void main(String[] args) {
		// ejercicio 6
		// prueba txt
//		Variables
		FileOutputStream fos;
		BufferedOutputStream bos;
		FileInputStream fis;
		BufferedInputStream bis;
		try {
//			abro el fichero de origen
			fis = new FileInputStream("txurdi.png");
			bis = new BufferedInputStream(fis);

// 		Abro fichero de destino
			fos = new FileOutputStream("txurdiCopia.png");
			bos = new BufferedOutputStream(fos);

//			Leo contenido del fichero origen
			int size = 512;
			byte[] datos = new byte[size];
			bis.read(datos);
			while (size != -1) {

//				mientras queden datos en el fichero origen
//				Escribir bytes mientras lee los byte para hacer la copia
				bos.write(datos, 0, size);

//				volvemos a leer
				size = bis.read(datos);
			}

// 				cierro el fichero origen
			bis.close();
			fis.close();

//				cierro el fichero destino
			bos.close();
			fis.close();
			
		} catch (IOException e) {
			System.out.println("Se ha producido un error");
		}

	}

}
