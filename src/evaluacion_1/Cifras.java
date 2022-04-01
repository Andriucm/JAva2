package evaluacion_1;

import java.util.Scanner;

public class Cifras {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String Numero;
		Scanner teclado;
		teclado = new Scanner(System.in);
		System.out.println("Introduce un numero entero");
		Numero = teclado.nextLine();
		for (int cont = 0; cont <= Numero.length(); cont++) {
			char cifra = Numero.charAt(cont);
			System.out.println(cifra);
		}

	}
}
