/*
	Practica 1 teoria computacional 
	manejo de cadenas y lenguajes
*/

import java.util.*;
class Main{
	public static void main(String[] args) {
		Language l= new Language("A-F,t-z");
		Scanner keyboard = new keyboard(System.in);

		showMenu();

		int option=keyboard.nextInt();
		switch(option){
			case 0:
				System.exit(0);
			break;
			case 1:

			break;
			default:
				System.out.println("Opcion no valida =(");
			break;
		}


	}

	public static void showMenu(){
		System.out.println("*******************************");
		System.out.println("1.- Introducir alfabetos");
		System.out.println("0.- Salir");
		System.out.println("*******************************");
	}
	public static void showFormatLanguaje(){
		System.out.println("Introduce un lenguaje");
		System.out.println("Ejem: a-b para un intervalo");
		System.out.println("a-f,A-T para un par de intervalos");
	}
}