package Evaluacion2;

import java.util.Scanner;

public class LeerRealRobusto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		lee un string por teclado
//		lo muestra por pantalla
		String valor = "";
		double n = 0;
//		defino un objeto de la clase scanner
		Scanner teclado;
//		cre un nuevo eobjeto de la clase scanner
		teclado = new Scanner(System.in);
		char caracter;
		boolean separadordecimal = false;
		try {

//		leo valor
			System.out.println("introduce un numero entero: ");
			valor = teclado.nextLine();
//	lo convierto en entero
			n = Double.parseDouble(valor);
		} catch (NumberFormatException e) {
			String valorcorrecto = "";
			for (int i = 0; i < valor.length(); i++) {
//				comprobar si es un digito valido
				caracter = valor.charAt(i);

				if (Character.isDigit(caracter)) {
//					si es digito 
//					lo añado a valorcorrecto
					valorcorrecto = valorcorrecto + caracter;
				} else if (caracter == 'l') {
//				si es l
					valorcorrecto = valorcorrecto + 1;
				} else if (caracter == 'o' || caracter == 'O') {
//			si es o
					valorcorrecto = valorcorrecto + 0;
				} else if ((caracter == '.' || caracter == ',') && (separadordecimal = false)) {
					valorcorrecto = valorcorrecto + '.';
					separadordecimal = true;

				}
			}
			if (valorcorrecto.length() > 0) {
// 			sI valorcorrecto contiene algun caracter
//			Convierto a entero valorcorrectoo
				n = Double.parseDouble(valorcorrecto);
			}

		}
//		libero la memoria de taclado
		teclado.close();
		System.out.println("El valor de la variable es " + n);
	}

}
