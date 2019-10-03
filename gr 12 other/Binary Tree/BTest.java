public class BTest{
	public static void main(String[]args){
		BTree oak = new BTree();
		BTree cipher = new BTree();
		/*for(int i = 0; i < 20; i++){
			oak.add((int)(Math.random()*100));
		}*/
		oak.add(50);
		oak.add(30);
		oak.add(70);
		oak.add(20);
		oak.add(40);
		oak.add(21);
		oak.add(34);
		oak.add(70);
		oak.add(90);
		
		cipher.add(78);
		cipher.add(45);
		cipher.add(55);
		cipher.add(85);
		cipher.add(76);
		cipher.add(88);
		cipher.add(16);
		oak.display(1);
		oak.add(cipher);

		System.out.println(oak.isBalanced());
		oak.display(1);
	}
}