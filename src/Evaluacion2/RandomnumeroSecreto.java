package Evaluacion2;

import java.util.Random;
import java.util.Scanner;

public class RandomnumeroSecreto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rnd = new Random();
		int numero;
		numero = ((int) (rnd.nextDouble() * 100000)) % 10 + 1;
		Scanner teclado;
		int n;
		teclado = new Scanner(System.in);
		System.out.println("introduce un numero entero: ");
		n = teclado.nextInt();

		while (numero != n) {
			if (numero > n) {
				System.out.println("El " + n + " es menor");
			} else if (numero < n) {
				System.out.println("El " + n + " es mayor");
			}
			n = teclado.nextInt();

		}
		System.out.println("Felicidades has acertado");
	}
}
