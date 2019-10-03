//Abdullah 
import java.util.*;
public class checktest{
	public static void main(String[]args){
		CheckersBoard a= new CheckersBoard();
		int x1,x2,y1,y2;
		while(true){
			Scanner kb = new Scanner(System.in);
			x1=kb.nextInt();
			y1=kb.nextInt();
			x2=kb.nextInt();
			y2=kb.nextInt();
			System.out.println(a.move(x1,y1,x2,y2));
			a.display();
		}
		
		
		
		/*
		GameWord a= new GameWord("Hello");
		a.permutations();
		System.out.println(a.pointValue(3,0,1));*/		
	}
}
			