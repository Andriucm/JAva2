package Evaluacion2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ComplejoMainSerializable {

	public static void main(String[] args) {
//		Crea la clase Java ComplejoMainSerializable que crea 
//		un objeto de la clase Complejo y lo guarda en el
//		fichero complejos.dat. Después lee los datos del 
//		complejo desde complejos.dat y muestra el valor del
//		complejo leído por pantalla.
		Complejo c1 = new Complejo(2, 4);
		Complejo c2 = new Complejo(1, 3);
		Complejo c3 = new Complejo(3, 5);

//		ESCRITURA
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
//		guardo el complejo en complejos.dat
			fos = new FileOutputStream("complejos.dat");
			oos = new ObjectOutputStream(fos);

//		lo grabo
			oos.writeObject(c1);
			oos.writeObject(c2);
			oos.writeObject(c3);

//		cierro e lfichero
			oos.close();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		LECTURA
		FileInputStream fis;
		ObjectInputStream ois;
		Complejo c = new Complejo();
		try {
//			Abro el fichero
			fis = new FileInputStream("complejos.dat");
			ois = new ObjectInputStream(fis);

//		lo leo
			while (fis.available() > 0) {
				c = (Complejo) ois.readObject();

//			Lo muestro por pantalla
				System.out.println("Complejo leido: " + c); // Convierte los bytes leidos
			}
//		cierro el fichero
			ois.close();
			fis.close();

		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
