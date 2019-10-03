//Abdullah Arif
//recursion assignment
//restaurant order 
import java.util.*;
public class foodOrder{
	static String[] menu = {"Bandera Pizza Bread", "Boston's Pizza Bread", "Garlic Twist Bread", "Milkshake",
						"Sun-Dried Tomato Bruschetta", "Three Cheese Toast", "Three Cheese Toast and Bolognese Dip", "Double Order wings",
						"Starter Size wings", "Cactus Nachos", "Cactus Nachos and spicy chicken", "Baked Ravioli Bites", "Southwest Quesadilla"};
	static double[] cost = {6.49, 5.35, 7.49, 5.35, 6.99, 6.35, 8.34, 16.49, 8.99, 10.29, 12.29, 8.49, 9.25};
	static double best = 0; //the best price so far
	static String items= "";//current items ordered
	
	public static void main(String[]args){
		
		System.out.println("Enter money you wish to spend:\n");
		double money = kb.nextDouble();
		rest(money);		
	}
	public static void order(double money){
		order(money-money*0.15,"",0,0);
		System.out.println("Your tip is "+ best*0.15);
		System.out.println("Your order is:"+"\n"+items);
		System.out.println("Your total comes to $"+best+"");
	}
	public static void order(double money, String foodsofar, int counter, double price){
		if(money<price+cost[counter]){
			if(money> price & price > best{
				best= price;
				items = foodsofar;
			}
		}
		else{
			if(counter == 5 | counter == 9){
				order(money,foodsofar+menu[counter]+"\n",counter+2,price+cost[counter]);
				order(money,foodsofar,counter+1,price);
			}
			else{
				order(money,foodsofar+menu[counter]+"\n",counter+1,price+cost[counter]);
				order(money,foodsofar,counter+1,price);
			}
		}
	}
}