//Abdullah Arif
//GameWord
import java.util.*;
public class GameWord{
	private String contents;
	public static final int right=1;
	private int[][] board=new int[][] 
		{{4,0,0,1,0,0,0,4,0,0,0,1,0,0,4},
		{0,3,0,0,0,2,0,0,0,2,0,0,0,3,0},
		{0,0,3,0,0,0,1,0,1,0,0,0,3,0,0},
		{1,0,0,3,0,0,0,1,0,0,0,3,0,0,1},
		{0,0,0,0,3,0,0,0,0,0,3,0,0,0,0},
        {0,2,0,0,0,2,0,0,0,2,0,0,0,2,0},
        {0,0,1,0,0,0,1,0,1,0,0,0,1,0,0},
        {4,0,0,1,0,0,0,0,0,0,0,1,0,0,4},
        {0,0,1,0,0,0,1,0,1,0,0,0,1,0,0},
        {0,2,0,0,0,2,0,0,0,2,0,0,0,2,0},
        {0,0,0,0,3,0,0,0,0,0,3,0,0,0,0},
        {1,0,0,3,0,0,0,1,0,0,0,3,0,0,1},
        {0,0,3,0,0,0,1,0,1,0,0,0,3,0,0},
        {0,3,0,0,0,2,0,0,0,2,0,0,0,3,0},
        {4,0,0,1,0,0,0,4,0,0,0,1,0,0,4}};

	/*0 regular 
	 *1 double letter
	 *2 triple letter
	 *3 double word
	 *4 triple word */
	 private String[] letterpoint = new String[] 
	 	{"","EAIOUNRTLS","DG","BCMP","FHVWY","K","","","JX","","QZ"};
	 	
	public GameWord(String letters){
		contents=letters.toUpperCase();}
		
	public String reverse(){
		String rev="";
		for(int i=contents.length()-1;i>-1;i--){
			rev+=contents.charAt(i);}
		return rev;}
		
	public boolean anagram(String otherWord){
		char [] other=otherWord.toUpperCase().toCharArray(),
				word=contents.toUpperCase().toCharArray();
		Arrays.sort(other);
		Arrays.sort(word);
		return Arrays.equals(word,other);}
	
	public int pointValue(int x, int y, int dir){
		int multiplier=1,points=0,sppoint;//specialpoint variable holds any thing that adds point 
		for (int i=0;i<contents.length();i++){//word length
			sppoint=(dir==right)?board[y][x+i]:board[y+i][x];//gets what variable impact point from board 
			for (int j=1;j<11;j++){//point 
				if (letterpoint[j].contains(""+contents.charAt(i))){
					points+=(sppoint<3)?j*(sppoint+1):j;//handles double or triple letter					
					multiplier*=(sppoint>2)?(sppoint-1):1;//handles double or triple word 
				}	
			}
		}
		return points*multiplier;}		
	
	public void permutations(){//recursion anagram program in class 
		permutations(contents,"");}//call recursive version of function
		
	public static void permutations (String left,String sofar){
		if("".equals(left)){//base case when there is nothing left 
			System.out.println(sofar);}//when at base case print the current anagram
		else{
			for(int i=0;i<left.length();i++){
				permutations(left.substring(0,i)+left.substring(i+1),sofar+left.charAt(i));
			}
		}
	}
	public String toString(){
		return contents;} //return content 
}