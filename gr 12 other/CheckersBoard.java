//Abdullah Arif
//CheckersBoard
import java.util.*;
public class CheckersBoard{
	public static final int empty=0,black=1,red=2;
	private int[][] board=new int[8][8];
	public CheckersBoard(){
		int[][] def={{2,0,2,0,2,0,2,0},//default
					 {0,2,0,2,0,2,0,2},
					 {2,0,2,0,2,0,2,0},
					 {0,0,0,0,0,0,0,0},
					 {0,0,0,0,0,0,0,0},
					 {0,1,0,1,0,1,0,1},
					 {1,0,1,0,1,0,1,0},
					 {0,1,0,1,0,1,0,1}};
		board=def;}
		
	public boolean move(int x1,int y1,int x2,int y2){
		int num=(board[y1][x1]==black)?-1:1;
		if(board[y2][x2]==empty &&board[y1][x1]!=empty &&y2==y1+num&& x2==x1+1||x2==x1-1){//basic move
			board[y2][x2]=board[y1][x1];//piece move to new position 
			board[y1][x1]=empty;//remove piece from original position			
			return true;}
		else {//capture move
		int[][]curboard= new int [8][8];
		for(int i=0; i<newboard.length; i++){
  				for(int j=0; j<newboard[i].length; j++){
    				curboard[i][j]=board[i][j];
			return move(curboard[y1][x1],num,x1,y1,x2,y2,board);
		}		
	}
	
	public boolean move(int color,int num,int cx,int cy,int fx,int fy,int[][]curboard){
		//currentx,y and final x and y
		if(cx==fx&&cy==fy){
			board=curboard;
			return true;}
		int enemy=(color==black?red:black);//the enemy pice is the opposite color 
		for (int i=-1;i<=1;i+=2){ //go left then right 
			if(i==-1&&cx>1 ||i==1&&cx<6|| color==black&&cy>1|| color=red&&cy<6
				board[cy+num][cx+i]==enemy&&curboard[cy+(num*2)][cx+(i*2)]==empty){
				//used <6, >1 because basics moves are already handled 
				curboard[cy+(num*2)][cx+(i*2)]=color;//target moves to new position
				curboard[cy][cx]=empty;//remove piece from original area
				curboard[cy+num][cx+i]=empty;//remove captured piece
				return move(color,num,cx+(i*2),cy+(num*2),fx,fy,curboard);}
		}
		return false;} 	
		 
	public int count (String color){
		int count=0,tar=(color.toUpperCase().equals("BLACK"))? black:red;
		for(int i=0;i<8;i++){//2 for loops to search board 
			for(int j=0;j<8;j++){
				count+=(board[i][j]==tar)?1:0;//when found add count
			}
		}
		return count;}
	
	public void display(){
		String disp;		
		for(int i=0;i<8;i++){
			System.out.println("+ - - - - - - - - - - - - - - - +");
			disp="| ";
			for(int j=0;j<8;j++){
				disp+=board[i][j]+" | ";}
			System.out.println(disp);}
	System.out.println("+ - - - - - - - - - - - - - - - +");
	}	
}