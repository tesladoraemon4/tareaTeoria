import java.util.HashMap;
class Language extends HashMap<String,Integer> {

	public String ranges[];
	public int numChar=1;
	Language(){
		this.put("\u03BB",1);
	}
	/*
		Contruct for init a conjunt of elements
	*/
	Language(String elements[]){
		this.put("\u03BB",1);
		this.addRanges(elements);
	}
	/*
		Contruct for init a range of values 
		the range will be element,element
		element = a-o|1-2
	*/
	Language(String rangeStr){
		this.put("\u03BB",1);
		this.addRanges(rangeStr.split(","));
	}
	//add ranges of values 
	//set the numberChar
	private void addRanges(String ranges[]){
		for (int y=0;y<ranges.length; y++) {
			String rangeStr = ranges[y];
			if(rangeStr.contains("-")){
				for (int x=(int)rangeStr.charAt(0); 
					x<=(int)rangeStr.charAt(rangeStr.length()-1);
					 x++) 
					this.put(""+((char)x),1);
			}else{
				this.numChar=(rangeStr.length()>this.numChar)?rangeStr.length():this.numChar;
				this.put(rangeStr,1);
			}
		}
	}
	//				System.out.println(this.containsKey(""+(char)x));

	public void showValues(){
	  System.out.println("{");
		this.forEach((k,v) -> System.out.print(k+","));
		
	  System.out.println("}");
	}
	/*
		get te product cartesian
	*/

	public Language cartesianProduct(Language ly,Language lx){
		Language result = new Language();
		lx.remove("\u03BB");
		ly.remove("\u03BB");
		ly.forEach((k1,v1) -> {
			lx.forEach((k2,v2) -> {
				result.put(k1+k2,1);
			});
		});
		result.put("\u03BB",1);
		return result;
	}
	/*
		get te product cartesian lenguaje de cadenas 
	*/
	public Language cartesianProduct(Language ly,Language lx,int pow){
		Language result = new Language();
		lx.remove("\u03BB");
		ly.remove("\u03BB");
		ly.forEach((k1,v1) -> {
			lx.forEach((k2,v2) -> {
				result.put(this.powStr(k1+k2,pow),1);
			});
		});
		result.put("\u03BB",1);
		return result;
	}
	/*
		Eval if the string pertain to the languaje
	*/
	public boolean pertain(String cad){
		int tam = cad.length();
		for (int x =0;x < tam;x++) 
			if(this.get(""+cad.charAt(x))==null)
				return false;
		return true;
	}

  private Language deleteLastDigit(){
    
    return null;
  }


	/*
		Pow for the languaje
	*/
	public Language powLanguaje(int n){
		Language res = new Language();
		res = this;
		for(int x =0 ;x<n-1;x++)
			res = this.cartesianProduct(this,res);
		return res;
	}
	
	/*
		Union of languajes
	*/
	public Language union(Language l1,Language l2){
		Language res = new Language();
		l1.remove("\u03BB");
		l2.remove("\u03BB");
		l1.forEach((k,v)->{
			res.put(k,v);
		});
		l2.forEach((k,v)->{
			res.put(k,v);
		});
		l1.put("\u03BB",1);
		l2.put("\u03BB",1);

		return res;
	}
	/*
		Concat of languajes
	*/
	public Language concat(Language l1,Language l2){
		Language res = new Language();
		l1.remove("\u03BB");
		l2.remove("\u03BB");

		this.cartesianProduct(l1,l2);
		
		l1.put("\u03BB",1);
		l2.put("\u03BB",1);

		return res;
	}

	/*
		Diference of languajes
	*/
	public Language diference(Language l1,Language l2){
		l1.remove("\u03BB");
		l2.remove("\u03BB");
		l2.forEach((k,v)->{
			if(l1.get(k)==1)
				l1.remove(k);
		});
		l1.put("\u03BB",1);
		return l1;
	}

	/*
		Potencia de una cadena 
	*/
	private String powStr(String cad,int exp){
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


	
}
