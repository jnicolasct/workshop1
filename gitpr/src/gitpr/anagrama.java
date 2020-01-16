package gitpr;

import java.util.ArrayList;
import java.util.Scanner;

public class anagrama {
	
	public static int contar (char letra, String cadena){
		int numero =0;
		for (int i=0; i < cadena.length();i++) {
			if (letra == cadena.charAt(i)) {
				numero ++;
			}
		}
		return numero;
	}
	
	public static void main (String[] args) {
		String entrada;
		String cadena1;
		String cadena2;
		int longitud;
		boolean flag = false;
		ArrayList<Character> letras1 = new ArrayList<>();
		ArrayList<Integer> cantidad1 = new ArrayList<>();
		ArrayList<Character> letras2 = new ArrayList<>();
		ArrayList<Integer> cantidad2 = new ArrayList<>();
		
		Scanner inicio = new Scanner (System.in);
		System.out.println("primera palabra");
		entrada = inicio.nextLine();
		cadena1 = entrada.toLowerCase();
		System.out.println("segunda palabra");
		entrada = inicio.nextLine();
		cadena2 = entrada.toLowerCase();
		longitud = cadena1.length();
		
		if (cadena1.length() == cadena2.length()) {
			
			for (int i=0; i < cadena1.length();i++) {
				if (!letras1.contains(cadena1.charAt(i))) {
					
					letras1.add(cadena1.charAt(i));
					int numero = contar(cadena1.charAt(i), cadena1);
					cantidad1.add(numero);			
					
				}
				
				if (!letras2.contains(cadena2.charAt(i))) {
					
					letras2.add(cadena2.charAt(i));
					int numero = contar(cadena2.charAt(i), cadena2);
					cantidad2.add(numero);			
					
				}
			}
			
			if (letras1.size() == letras2.size()) {
				for (int j=0; j < letras1.size();j++) {
					char lt = letras1.get(j);
					if (letras2.contains(lt)) {
						int pos = letras2.indexOf(lt);
						if (cantidad1.get(j) == cantidad2.get(pos)) {
							flag = true;
						}
						else {
							flag = false;
							j = letras1.size()+1;
						}
					}
					else {
						flag = false;
						j = letras1.size()+1;
					}
				}
			}
			
			if (flag == true) {
				System.out.println("anagramas");
			}
			else {
				System.out.println("No anagramas");
			}
		}
	}
}
