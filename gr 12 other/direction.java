//direction
public class direction{
	static int bestTime = 1000;
	static String directions = "";
	public static void main(String[]args){
		int[][] grid = new int[][] {{0,12,7,43,32,12,30,15},
									{21,26,18,34,41,9,17,21},
									{20,43,23,35,23,20,17,37},
									{5,29,28,18,9,42,35,24},
									{25,15,36,25,21,9,14,19},
									{25,26,32,18,17,19,25,15},
									{35,15,12,21,24,26,14,35},
									{15,12,18,25,14,22,21,15}};
		direction(grid);
	}
	public static void direction(int[][] grid){
		direction(grid,0,0,0,"");
		System.out.println("Shortest time "+bestTime);
		System.out.println("Directions: "+directions);
	}
	public static void direction(int[][] grid, int x, int y, int time, String sofar){
		if(x == 7 & y == 7){
			if(time < bestTime){
				bestTime = time;
				directions = sofar;}
		}
		else{
			if(x < 7){
				direction(grid,x+1,y,time+grid[y][x+1],sofar+"R");
			}
			if(y < 7){
				direction(grid,x,y+1,time+grid[y+1][x],sofar+"D");
			}
		}
	}
}

