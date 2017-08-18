import java.util.HashMap;
class Language extends HashMap<String,Integer> {

	public String ranges[];
	Language(){}
	/*
		Contruct for init a conjunt of elements
	*/
	Language(String elements[]){
		this.addRanges(elements);
	}
	/*
		Contruct for init a range of values 
		the range will be element,element
		element = a-o|1-2
	*/
	Language(String rangeStr){
		this.addRanges(rangeStr.split(","));
	}
	//add ranges of values 
	private void addRanges(String ranges[]){
		for (int y=0;y<ranges.length; y++) {
			String rangeStr = ranges[y];
			for (int x=(int)rangeStr.charAt(0); 
				x<=(int)rangeStr.charAt(rangeStr.length()-1);
				 x++) 
				this.put(""+((char)x),0);
		}
	}
	//				System.out.println(this.containsKey(""+(char)x));

	



	
}