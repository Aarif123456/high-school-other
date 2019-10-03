//Abdullah Arif
//Binary Tree
public class BTree{
	private BNode root;
	public static final int IN=1, PRE=2, POST=3;
	private int height;
	
	public BTree(){
		root = null;
	}
	
	public void add(int n){
		if(root == null){
			root = new BNode(n,null);
		}
		else{
			add(n,root);
		}
	}
	
	public void add(int n, BNode branch){
		if(n > branch.getVal()){
			if(branch.getRight()==null){
				branch.setRight(new BNode(n,branch));
			}
			else{
				add(n, branch.getRight());
			}
		}
		else if(n < branch.getVal()){
			if(branch.getLeft()==null){
				branch.setLeft(new BNode(n,branch));
			}
			else{
				add(n, branch.getLeft());
			}
		}
	}
	
	public void add(BTree tree){
		add(tree.root);
	}
	
	public void add(BNode node){
		if (node!=null){ 
			add(node.getVal());
			add(node.getLeft());
			add(node.getRight());
		}

	}
	public BNode find(int n){
		return find(n,root);	
	}
	
	public BNode find(int n, BNode branch){
		if(branch == null || branch.getVal() == n){
			return branch;
		}
		if(n > branch.getVal()){
			return find(n,branch.getRight());
		}
		else{
			return find(n,branch.getLeft());
		}
	}
	
	public String toString(){
		return "{"+stringify(root)+"}";
	}
	
	public String stringify(BNode branch){
		if(branch==null){
			return "";
		}
		else{
			return stringify(branch.getLeft())+branch+stringify(branch.getRight());// left, root,right
		}
	}
	
	public int depth(int num){
		return depth(num,root,0);
	}
	
	public int depth(int val, BNode branch, int deep){
		if(val==branch.getVal()){
			return deep;
		}
		else if(val > branch.getVal()){
			return depth(val,branch.getRight(),deep+1); 
		}
		else{
			return depth(val,branch.getLeft(),deep+1);
		}
	}
	
	public void display(){
		System.out.println("{"+stringify(root)+"}");
	}
	
	public void display(int num){
		if (num==IN){
			System.out.println("{"+stringify(root)+"}");
		}
		else if(num==PRE){
			System.out.println("{"+preOrder(root)+"}");
		}
		else if(num==POST){
			System.out.println("{"+postOrder(root)+"}");
		}
		else{
			System.out.println("Invalid int\nEnter one of the following\n1.In-order\n2.Pre-order\n3.Post-order");
		}
	}
	
	public String preOrder (BNode branch){
		if(branch==null){
			return "";
		}
		else{
			return branch+preOrder(branch.getLeft())+preOrder(branch.getRight()); // root,left,right
		}
	}
	
	public String postOrder (BNode branch){
		if(branch==null){
			return "";
		}
		else{
			return postOrder(branch.getLeft())+postOrder(branch.getRight())+branch;//left,right,root
		}
	}
	
	public int countLeaves(){
		return countLeaves(root);
	}	 
	
	public int countLeaves(BNode branch){
		if (branch==null){
			return 0;
		}
		if(branch.getLeft()==null && branch.getRight()==null ){
			return 1;
		}
		else{
			return countLeaves(branch.getLeft()) + countLeaves(branch.getRight());
		}
	}
	
	public int height(){
		if(root==null){
			return -1;
		}
		
		return height;
	}
	
	public void height(int depth,BNode branch){
		if(branch==null&&depth-1>height){
			height=depth;
		}
		else if(branch!=null){
			height(depth+1,branch.getLeft());
			height(depth+1,branch.getRight());
		}
	}
	
	public boolean isAncestor(int num1, int num2){
		return find(num2,find(num1))!=null;
	}
	
	public void delete(BNode node){ 
		if(node==null){
			System.out.println("That node does not exist");
		}
		else if(node.getParent().getRight()==node){
			Rdeleter(node);
		}
		else if(node.getParent().getLeft()==node){
			Ldeleter(node);
		} 		
	}
	
	public void Rdeleter(BNode node){ 
		if(node.getRight()==null && node.getLeft()==null){
			node.getParent().setRight(null);
		}
		else if(node.getRight()==null ){ //one child on left
			node.getLeft().setParent(node.getParent());
			node.getParent().setRight(node.getLeft());
	}
		else if(node.getLeft()==null){ //one child on right
			node.getRight().setParent(node.getParent());
			node.getParent().setRight(node.getRight());
		}
		else{ //two child
			BNode tmp=node.getLeft();
			while(tmp.getRight()!=null){ //biggest from left branch
				tmp=tmp.getRight();
			}
			//swap
			node.setVal(tmp.getVal());
			delete(tmp); 
		}
	}
	
	public void Ldeleter(BNode node){ 
		if(node.getRight()==null && node.getLeft()==null){
			node.getParent().setLeft(null);
		}
		else if(node.getRight()==null ){ //one child on left
			node.getLeft().setParent(node.getParent());
			node.getParent().setLeft(node.getLeft());
	}
		else if(node.getLeft()==null){ //one child on right
			node.getRight().setParent(node.getParent());
			node.getParent().setLeft(node.getRight());
		}
		else{ //two child
			BNode tmp=node.getRight(); 
			while(tmp.getLeft()!=null){ //smallest from right branch
				tmp=tmp.getLeft();
			}
			//swap
			node.setVal(tmp.getVal());
			delete(tmp); 
		}
	}
	
	public void delete(int num){
		delete(find(num));
	}
	
	
	public boolean isBalanced(){
		if(isBalanced(root) ==-1){
			return false;
		}
		return true;
	}
	
	private int isBalanced(BNode branch){
	    if(branch == null){
	        return 0;
	    }
        int lefth = isBalanced(branch.getLeft());
        
        if(lefth ==-1){
        	return -1;}
        	
        int righth = isBalanced(branch.getRight());
        
        if(righth ==-1){
        	return -1;}
        	
        if(Math.abs(lefth - righth)> 1){
            return -1;
        }
  
	    return Math.max(lefth,righth)+1;
	}
}