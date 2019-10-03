class BNode{
	
	private int val;
	private BNode left,right,parent;
	
	public BNode(int v,BNode parent){
		val = v;
		left = null;
		right = null;
		parent = null;
	}
	
	public String toString(){
		return "<"+val+">";
	}
	
	public int getVal(){
		return val;
	}
	
	public BNode getLeft(){
		return left;
	}
	
	public BNode getRight(){
		return right;
	}
	
	public BNode getParent(){
		return parent;
	}
	
	public void setVal(int v){
		val=v;
	}
	public void setLeft(BNode l){
		left = l;		
	}
	
	public void setRight(BNode r){
		right = r;
	}
	
	public void setParent(BNode P){
		left = P;		
	}

}