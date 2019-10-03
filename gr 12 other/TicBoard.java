//Abdullah Arif
//TicBoard
import java.util.*;
public class TicBoard{
	public static final int X=1,O=2;
	public TicBoard(){
		board=new[3][3];}
	public boolean open(int x, int y){ // checks if the spot has no X or O in it
		return board[x][y]==0;}
	public void move(int x,int y,int turn){// sets the spot to whomevers turn it is
		board[x][y]=turn;}
	public int get (int x,int y){//position at point
		return board[x][y];}
	public boolean gameover(){
		int [] tar= new int[3]
	}
	private int search (int turn,int[] tar,int num,int x, int y){
		if(turn==tar[0]==tar[1]==tar[2]){
			return turn;}
		if(num<2){ 
			return search(turn,tar[num+1]=board[x][y],x+1,y);
			return search(turn,tar[num+1]=board[x][y],x,y+1); }
	}
	return 0;
	public String winner()
		// If someone won display winner in the title
		// If all spots are full with no winner put Cats Wins
}
