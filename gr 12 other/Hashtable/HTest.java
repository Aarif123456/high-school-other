public class HTest{
	public static void main(String[]args){
		HashTable<Integer> table = new HashTable<Integer>();
		table.add(75);
		table.add(30);
		table.add(40);
		table.add(50);
		table.remove(50);
		System.out.println(table.toString());
		System.out.println(table.getLoad());
		table.setLoad(0.2);
		System.out.println(table.getLoad());
	}
}