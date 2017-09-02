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
		this.forEach((k,v) -> System.out.println("Element " + k));
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
		Eval if the string pertain to the languaje
	*/
	public boolean pertain(String cad){
		int tam = cad.length();
		for (int x =0;x < tam;x++) 
			if(this.get(""+cad.charAt(x))!=null)
				return true;
		return false;
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
	


	
}