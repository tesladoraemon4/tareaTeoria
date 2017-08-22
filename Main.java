/*
	Practica 1 teoria computacional 
	manejo de cadenas y lenguajes
*/

import java.util.*;
class Main{
	public static void main(String[] args) {
		Language l= new Language("A-F,t-z");
		Scanner keyboard = new Scanner(System.in);

		showMenu();

		int option=keyboard.nextInt();



		
		switch(option){
			case 0:
				System.exit(0);
			break;
			case 1:
				//in te languajes
				showFormatLanguajeUniversal();
				String languajeStr1 = keyboard.next();
				Language l1u = new Language(languajeStr1);
				String languajeStr2 = keyboard.next();
				Language l2u = new Language(languajeStr2); 


				System.out.println("Producto cartesiano");
				l1u.cartesianProduct(l2u).showValues();

				/*
				System.out.println("Cadena w1 del universo W*1");
				String w1=getStrPertainUniverse(l1u);
				System.out.println("Cadena w2 del universo W*1");
				String w2=getStrPertainUniverse(l1u);
				System.out.println("Introduce la potencia n para (w1w2)^n");
				System.out.println(powStr(w1+w2,keyboard.nextInt()));
				
				System.out.println("Introduce la cadena c para hacer la busqueda");
				char x=getStrPertainUniverse(l1u).charAt(0);
				System.out.println("|w1|c = "+getNumberOcurrus(w1,x));
				*/

				

			break;
			default:
				System.out.println("Opcion no valida =(");
			break;
		}
		


	}
	/*
		Potencia de una cadena 
	*/
	public static String powStr(String cad,int exp){
		String strFinal="";
		if(exp==0)
			return "";

		if(exp>0){
			for (int x =0;x < exp;x++) 
				strFinal=strFinal+cad;
		}else{
			for (int x =0;x < -1*exp;x++) {
				String aux="";
				for (int y =cad.length()-1;
					y>=0;
					y--){
					aux=aux+cad.charAt(y);
				}
				strFinal=strFinal+aux;
			}
		}
		return strFinal;
	}


	/*
		Get a String that pertain to universe 
	*/
	public static String getStrPertainUniverse(Language lx){
		Scanner keyboard = new Scanner(System.in);
		String w;
		while(true){
			System.out.println("Introduce la cadena");
			w = keyboard.next();
			if(!lx.pertain(w))
				System.out.println("La cadena no pertenece al lenguaje universal");
			else
				break;
		}
		return w;
	}



	public static void showMenu(){
		System.out.println("*******************************");
		System.out.println("1.- Introducir alfabetos");
		System.out.println("0.- Salir");
		System.out.println("*******************************");
	}
	public static int getNumberOcurrus(String cad,char c){
		int tam =cad.length(),cont=0;
		for (int x=0; x<tam;x++) 
			if(c==cad.charAt(x))
				cont++;
		return cont;
	}
	public static void showFormatLanguajeUniversal(){
		System.out.println("Introduce un lenguaje");
		System.out.println("Ejem: a-b para un intervalo");
		System.out.println("a-f,A-T para un par de intervalos");
	}
}