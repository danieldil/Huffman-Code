package huffmanCode;

public class Node {
	public HuffmanCode data;
	public Node left;
	public Node right;
	String label = "-1";
	public Node(){
		this.data = new HuffmanCode();
	}
	public Node(HuffmanCode d, Node l, Node r, String s){
		data = d;
		left = l;
		right = r;
		label = s;
	}
	public void set(HuffmanCode d, Node l, Node r){
		data = d;
		left = l;
		right =r;
	}
	public void printTree(int counter){
		counter++;
		//System.out.println(this.right + " is this.right");
//		System.out.println(this.left.data.prob);
//		System.out.println(this.right.data.prob);
		if(this.left.data.prob == -1 && this.right.data.prob == -1){
			if(counter > 1)
			return;
			
			this.left.printTree(counter);
			this.right.printTree(counter);
		}
		if(this.left.data.prob == -1.0 && this.right.data.prob != -1.0){
			System.out.println(this + "my left is -1");
			this.left.printTree(counter);
		}
		if(this.right.data.prob == -1.0 && this.left.data.prob != -1.0){
			System.out.println(this + "my right is -1");
			this.right.printTree(counter);
		}
		System.out.println("hello from printTree");
		//System.out.println(x.right.data.prob);	
	}
	public String toString(){
		String s;
		if(this.right != null){
			s = 
			String.valueOf((
					"   "+
					this.label+
					"\n"+
					this.left.data.prob+ 
					//this.left.data.letter+ 
					"   _   "+ 
					this.right.data.prob+
					"\n"
					//this.right.data.letter
					));
		}
		else{
			s = String.valueOf(this.left.data.prob);
		}
		return s;
	}
}
