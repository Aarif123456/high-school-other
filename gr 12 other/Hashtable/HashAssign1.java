import java.util.*;
import java.awt.*;
import java.io.*;
public class HashAssign1{
	
	public static HashTable <String> words_dic;
	
		public static void main(String[]args) throws IOException{
			
		words_dic = new HashTable<String>();
		Scanner inFile =  new Scanner(new BufferedReader(new FileReader("dictionary.txt")));
		
		while(inFile.hasNextLine()){
			String word = inFile.nextLine(); 
			words_dic.add(word);
		}
		Scanner kb = new Scanner(System.in);
		String words = "";
		System.out.println("enter your word");
		words = kb.nextLine();
		anagram(words);
		}
		
	
		public static void anagram(String word){
			anagram(word,"");
		}
		
		public static void anagram(String word, String anag){
			if ("".equals(word)){
				if (words_dic.has(anag)){
					System.out.println(anag);
				}	
			}
			else{
				for (int i = 0; i< word.length();i++){
					anagram((word.substring(0, i) + word.substring(i + 1)),anag + word.charAt(i));
				}
	
			}
		}
}


	
	
