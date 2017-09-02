/*
	Practica 1 teoria computacional 
	manejo de cadenas y lenguajes
*/

import java.util.*;
class Main{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		
		//input the alpabeth
		showFormatLanguajeUniversal();
		System.out.println("\u03A3 ");
		Language alpabeth = new Language(getStrLanguaje());
		showSeparBar();

		//Generate random languaje
		System.out.println("Tamaño del lenguaje");
		int len =keyboard.nextInt();
		System.out.println("Numero de elementos");
		int numElem =keyboard.nextInt();
		Language l1 = generateLanguaje(alpabeth,len,numElem);
		Language l2 = generateLanguaje(alpabeth,len,numElem);
		System.out.println("Lenguaje l1");
		l1.showValues();
		showSeparBar();
		System.out.println("Lenguaje l2");
		l2.showValues();
		showSeparBar();

		System.out.println("Diference of languajes");
		Language laux = l1.diference(l1,l2);
		laux.showValues();
		showSeparBar();
		laux.clear();
		System.out.println("Concat of languajes");
		laux = l1.concat(l1,l2);
		laux.showValues();
		showSeparBar();
		laux.clear();
		System.out.println("union of languajes");
		laux = l1.union(l1,l2);
		laux.showValues();
		showSeparBar();
		laux.clear();

		boolean repetir=false;

		System.out.println("1 para potencia L1");
		System.out.println("2 para potencia L2");
		do{
			int opt = keyboard.nextInt();
			switch(opt){
				case 1:
					laux=l1.powLanguaje(keyboard.nextInt());
				break;
				case 2:
					laux=l2.powLanguaje(keyboard.nextInt());
				break;
				default:
					System.out.println("Seleccionaste una opcion no valida");
					repetir=true;
				break;
			}
		}while(repetir);
		laux.showValues();
		showSeparBar();
		laux.clear();
		/*
		//input Strings w1 and w2
		System.out.println("Cadena w1 del universo W*1");
		String w1=getStrPertainUniverse(l1u);
		showSeparBar();
		System.out.println("Cadena w2 del universo W*2");
		String w2=getStrPertainUniverse(l2u);
		showSeparBar();
		
		
		prefSufSub(w1,w2);
		
		showSeparBar();
		//input pow string
		System.out.println("Introduce la potencia n para (w1w2)^n");
		System.out.println(powStr(w1+w2,keyboard.nextInt()));
		
		showSeparBar();
		//search ocurrs
		System.out.println("Introduce el caracter x para hacer la busqueda de ocurrencias en w1");
		char x=getStrPertainUniverse(l1u).charAt(0);
		System.out.println("|w1|"+x+" = "+getNumberOcurrus(w1,x));

		//pow for sigma^
		System.out.println("Introduce la potencia n para (\u03A3 1)^n");
		Language pow=l1u.powLanguaje(keyboard.nextInt());
		pow.showValues();
		
		showSeparBar();
		/*
		System.out.println("Enter para continuar");
   		keyboard.nextLine();
    
		System.out.println("\u03A3 1 . \u03A3 2");
		Language prod=l1u.cartesianProduct(l1u,l2u);
		prod.showValues();
		
		
		showSeparBar();
		
		System.out.println("Enter para continuar");
    	keyboard.nextLine();
		System.out.println("\u03A3 1 . \u03A3 2 . \u03A3 1");
		Language prod1=l1u.cartesianProduct(prod,l1u);
		prod1.showValues();
		*/
	  
	}

	/*
		Generar lenguaje 
		Mejorar generacion de lenguaje
	*/
	public static Language generateLanguaje
	(Language alpabeth,int tam,int numeElem){
		//creamos la potencia de x lenguaje
		alpabeth=alpabeth.powLanguaje(tam);
		alpabeth.remove("\u03BB");
		ArrayList<String> a = new ArrayList<String>();
		int cont=0;
		Iterator iterador = alpabeth.entrySet().iterator();
		Map.Entry producto;
		while (iterador.hasNext()) {
			producto = (Map.Entry) iterador.next();
			if(cont <= numeElem)
				a.add((String)producto.getKey());
			cont++;
		} 
		for (int x=0; x < a.size(); x++) {
			alpabeth.remove(a.get(x));
		}
		alpabeth.put("\u03BB",1);
		return alpabeth;
	}


	/*
		Ver sufijos y prefijos
	*/
	public static void prefSufSub(String w1, String w2){
		if(w2.endsWith(w1))
			System.out.println("w1 es un sufijo de w2");
		if(w2.startsWith(w1,0))
			System.out.println("w1 es un prefijo de w2");
		if(w2.lastIndexOf(w1)!=-1)
			System.out.println("w1 es una subcadena de w2");

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
				System.out.println("La cadena no pertenece al lenguaje \u03A3");
			else
				break;
		}
		return w;
	}

	/*
		Get String languaje interval whith validation
	*/
	public static String getStrLanguaje(){
		Scanner keyboard = new Scanner(System.in);
		String w="";
		boolean band=true;
		while(band){
			System.out.println("Introduce el lenguaje ");
			w = keyboard.next();
			String a[] = w.split(",");
			for (int x=0; x<a.length;x++) {
				String cad = a[x];
				if(cad.length()==1){
					band=false;
				}else if(cad.length()!=3){
					System.out.println("El lenguaje solo debe ser de la forma");
					System.out.println("x-y [char-char]");
					System.out.println("x-y,r-y,... [char-char,char-char,...]");
					System.out.println("x,y,z,... [char,char,char,...]");
					band=true;
					break;
				}else if(!cad.contains("-")){
					System.out.println("El lenguaje debe contener -");
					band=true;
					break;
				}else if(cad.charAt(0)>cad.charAt(2)){
					System.out.println("Los caracteres deben ir en orden alfabetico ascendente");
					band=true;
					break;
				}else{
					band = false;
				}
			}
		}
		return w;
	}
  public static void showSeparBar(){
		System.out.println("***************************************");
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
		System.out.println("a,b,c,... para caracteres individuales");
	}
}
